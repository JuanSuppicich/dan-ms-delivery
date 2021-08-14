package com.durandsuppicich.danmsdelivery.service;

import com.durandsuppicich.danmsdelivery.domain.Truck;

import java.util.List;

public interface ITruckService {

    Truck post(Truck truck);

    List<Truck> getAll();

    List<Truck> getAvailable();

    void delete(Integer id);

}
