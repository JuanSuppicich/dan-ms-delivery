package com.durandsuppicich.danmsdelivery.service;

import com.durandsuppicich.danmsdelivery.domain.Delivery;

import java.util.List;

public interface IDeliveryService {

    Delivery post(Delivery delivery);

    List<Delivery> getAll();

    List<Delivery> getByCustomerCuit(String cuit);

}
