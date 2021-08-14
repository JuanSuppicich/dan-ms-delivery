package com.durandsuppicich.danmsdelivery.service;

import java.util.List;

import com.durandsuppicich.danmsdelivery.domain.Truck;
import com.durandsuppicich.danmsdelivery.domain.TruckState;
import com.durandsuppicich.danmsdelivery.repository.ITruckJpaRepository;

import org.springframework.stereotype.Service;


@Service
public class TruckService implements ITruckService {

    private final ITruckJpaRepository truckRepository;

    public TruckService(ITruckJpaRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    @Override
    public Truck post(Truck truck) {
        truck.setTruckState(TruckState.DISPONIBLE);
        return truckRepository.save(truck);
    }

    @Override
    public List<Truck> getAll() {
        return truckRepository.findAll();
    }

    @Override
    public List<Truck> getAvailable() {
        return null;
    }

    @Override
    public void delete(Integer id) {
        truckRepository.deleteById(id);
    }
}
