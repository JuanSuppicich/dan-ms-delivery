package com.durandsuppicich.danmsdelivery.service;

import com.durandsuppicich.danmsdelivery.client.EmployeeDto;
import com.durandsuppicich.danmsdelivery.client.IOrderClient;
import com.durandsuppicich.danmsdelivery.client.IUserClient;
import com.durandsuppicich.danmsdelivery.client.OrderPatchDto;
import com.durandsuppicich.danmsdelivery.domain.*;
import com.durandsuppicich.danmsdelivery.domain.Package;
import com.durandsuppicich.danmsdelivery.exception.validation.EmployeeIdNotValidException;
import com.durandsuppicich.danmsdelivery.exception.validation.NoPendingPackagesException;
import com.durandsuppicich.danmsdelivery.exception.validation.TruckIdNotValidException;
import com.durandsuppicich.danmsdelivery.repository.IDeliveryJpaRepository;
import com.durandsuppicich.danmsdelivery.repository.IPackageJpaRepository;
import com.durandsuppicich.danmsdelivery.repository.IPackageOrderJpaRepository;
import com.durandsuppicich.danmsdelivery.repository.ITruckJpaRepository;
import com.durandsuppicich.danmsdelivery.service.util.TruckLoader;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryService implements IDeliveryService {

    private final IDeliveryJpaRepository deliveryRepository;

    private final IPackageJpaRepository packageRepository;

    private final ITruckJpaRepository truckRepository;

    private final IPackageOrderJpaRepository packageOrderRepository;

    private final IUserClient userClient;

    private final IOrderClient orderClient;

    private final CircuitBreakerFactory circuitBreakerFactory;

    private EmployeeDto employeeDto;

    public DeliveryService(IDeliveryJpaRepository deliveryRepository,
                           IPackageJpaRepository packageRepository,
                           ITruckJpaRepository truckRepository,
                           IPackageOrderJpaRepository packageOrderRepository,
                           IUserClient userClient,
                           IOrderClient orderClient,
                           CircuitBreakerFactory circuitBreakerFactory) {
        this.deliveryRepository = deliveryRepository;
        this.packageRepository = packageRepository;
        this.truckRepository = truckRepository;
        this.packageOrderRepository = packageOrderRepository;
        this.userClient = userClient;
        this.orderClient = orderClient;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }

    @Override
    public Delivery post(Delivery delivery) {

        Truck truck = truckRepository.findByIdAvailable(delivery.getTruck().getId())
                .orElseThrow(() -> new TruckIdNotValidException(delivery.getTruck().getId()));

        employeeDto = getEmployee(delivery.getEmployeeId());
        if (employeeDto == null) throw new EmployeeIdNotValidException(delivery.getEmployeeId());

        List<Package> packages = packageRepository.findAllPending();
        if (packages.isEmpty()) throw new NoPendingPackagesException();

        TruckLoader.load(truck, packages, delivery);

        truck.setState(TruckState.EN_VIAJE);

        List<Integer> orderIds = new ArrayList<>();

        for(Package p : delivery.getPackages()) {

            p.setState(PackageState.EN_CAMINO);
            p.setArrivalDate();

            orderIds.addAll(packageOrderRepository.getOrderIds(p.getId()));
        }

        updateOrdersState(orderIds);

        delivery.setTruck(truck);

        return deliveryRepository.save(delivery);
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public List<Delivery> getByCustomerCuit(String cuit) {
        return deliveryRepository.findByCustomerCuit(cuit);
    }

    @Override
    public Integer getEmployeeName() {
        return this.employeeDto.getName();
    }

    private EmployeeDto getEmployee(Integer id) {

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuit-breaker");

        return circuitBreaker.run(
                () -> userClient.getById(id),
                throwable -> defaultEmployee()
        );
    }

    private EmployeeDto defaultEmployee() {
        return null;
    }

    private void updateOrdersState(List<Integer> orderIds) {

        for (Integer orderId : orderIds) {

            OrderPatchDto orderPatchDto = new OrderPatchDto(orderId, 7); // 7 = En preparacion
            orderClient.patch(orderPatchDto, orderId);
        }
    }
}
