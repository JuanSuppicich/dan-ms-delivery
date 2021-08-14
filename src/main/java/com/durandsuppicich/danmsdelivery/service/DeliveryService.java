package com.durandsuppicich.danmsdelivery.service;

import com.durandsuppicich.danmsdelivery.domain.Delivery;
import com.durandsuppicich.danmsdelivery.repository.IDeliveryJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService implements IDeliveryService {

    private final IDeliveryJpaRepository deliveryRepository;

    public DeliveryService(IDeliveryJpaRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Delivery post(Delivery delivery) {
        return null;
    }

    @Override
    public List<Delivery> getAll() {
        return null;
    }

    @Override
    public List<Delivery> getByCustomerCuit(String cuit) {
        return null;
    }
}
