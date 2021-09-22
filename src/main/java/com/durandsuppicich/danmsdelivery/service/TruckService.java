package com.durandsuppicich.danmsdelivery.service;

import java.util.List;

import com.durandsuppicich.danmsdelivery.domain.Truck;
import com.durandsuppicich.danmsdelivery.domain.TruckState;
import com.durandsuppicich.danmsdelivery.exception.truck.TruckIdNotFoundException;
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
        return truckRepository.save(truck);
    }

    @Override
    public List<Truck> getAll() {
        return truckRepository.getAll();
    }

    @Override
    public List<Truck> getAvailable() {
        return truckRepository.findAllAvailable();
    }

    @Override
    public void patch(Integer id) {

        truckRepository.findByIdAndDeleteDateIsNull(id)
                .map(c -> {
                    c.setState(TruckState.EN_MANTENIMIENTO);
                    return truckRepository.save(c);
                })
                .orElseThrow(() -> new TruckIdNotFoundException(id));
    }

    @Override
    public void delete(Integer id) {

        truckRepository.findByIdAndDeleteDateIsNull(id)
                .map(c -> {
                    c.setDeleteDate();
                    return truckRepository.save(c);
                })
                .orElseThrow(() -> new TruckIdNotFoundException(id));
    }
}
