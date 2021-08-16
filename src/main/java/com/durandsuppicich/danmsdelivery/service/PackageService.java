package com.durandsuppicich.danmsdelivery.service;

import com.durandsuppicich.danmsdelivery.client.IOrderClient;
import com.durandsuppicich.danmsdelivery.client.IProductClient;
import com.durandsuppicich.danmsdelivery.client.OrderItemDto;
import com.durandsuppicich.danmsdelivery.client.ProductDto;
import com.durandsuppicich.danmsdelivery.domain.Package;
import com.durandsuppicich.danmsdelivery.domain.PackageOrder;
import com.durandsuppicich.danmsdelivery.domain.PackageState;
import com.durandsuppicich.danmsdelivery.exception.packages.PackageIdNotFoundException;
import com.durandsuppicich.danmsdelivery.repository.IPackageJpaRepository;
import com.durandsuppicich.danmsdelivery.repository.IPackageOrderRepository;
import com.durandsuppicich.danmsdelivery.service.util.IPackageCalculator;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackageService implements IPackageService {

    private final IPackageJpaRepository packageRepository;

    private final IPackageOrderRepository packageOrderRepository;

    private final IOrderClient orderClient;

    private final IProductClient productClient;

    private final CircuitBreakerFactory circuitBreakerFactory;

    private final IPackageCalculator packageCalculator;

    public PackageService(IPackageJpaRepository packageRepository,
                          IPackageOrderRepository packageOrderRepository,
                          IOrderClient orderClient,
                          IProductClient productClient,
                          CircuitBreakerFactory circuitBreakerFactory,
                          IPackageCalculator packageCalculator) {
        this.packageRepository = packageRepository;
        this.packageOrderRepository = packageOrderRepository;
        this.orderClient = orderClient;
        this.productClient = productClient;
        this.circuitBreakerFactory = circuitBreakerFactory;
        this.packageCalculator = packageCalculator;
    }

    @Override
    public Package post(Package p, List<Integer> ordersIds) {

        List<OrderItemDto> orderItems = getOrderItems(ordersIds);

        List<Integer> productIds = new ArrayList<>();

        for(OrderItemDto orderItem : orderItems) {
            productIds.add(orderItem.getProductId());
        }

        List<ProductDto> products = getProducts(productIds);

        Double packageWeight = packageCalculator.calcWeight(products, orderItems);
        Double packageVolume = packageCalculator.calcVolume(products, orderItems);

        p.setWeight(packageWeight);
        p.setVolume(packageVolume);

        Package result = packageRepository.save(p);

        savePackageOrderRelationships(result.getId(), ordersIds);

        return result;
    }

    private void savePackageOrderRelationships(Integer packageId, List<Integer> ordersIds) {

        List<PackageOrder> relationships = new ArrayList<>();

        for(Integer orderId : ordersIds) {
            PackageOrder relationship = new PackageOrder(orderId, packageId);
            relationships.add(relationship);
        }
        packageOrderRepository.saveAll(relationships);
    }

    @Override
    public List<Package> getAll() {
        return packageRepository.getAll();
    }

    @Override
    public List<Package> getByCustomerCuit(String cuit) {
        return packageRepository.findAllByCustomerCuitAndDeleteDateIsNull(cuit);
    }

    @Override
    public void delete(Integer id) {

        packageRepository.findByIdAndDeleteDateIsNull(id)
                .map( p -> {
                    p.setDeleteDate();
                    p.setState(PackageState.CANCELADO);
                    return packageRepository.save(p);
                })
                .orElseThrow(() -> new PackageIdNotFoundException(id));
    }

    private List<OrderItemDto> getOrderItems(List<Integer> orderIds) {

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuit-breaker");

        List<OrderItemDto> result = new ArrayList<>();

        for (Integer id : orderIds) {
            List<OrderItemDto> response = circuitBreaker.run(
                    () -> orderClient.getByOrderId(id),
                    throwable -> defaultOrderItemsList()
            );
            result.addAll(response);
        }
        return result;
    }

    private List<OrderItemDto> defaultOrderItemsList() {
        return new ArrayList<>();
    }

    private List<ProductDto> getProducts(List<Integer> productIds) {

        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuit-breaker");

        return circuitBreaker.run(
                () -> productClient.getAllByIds(productIds),
                throwable -> defaultProductList()
        );
    }

    private List<ProductDto> defaultProductList() {
        return new ArrayList<>();
    }
}
