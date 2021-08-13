package com.durandsuppicich.danmsdelivery.repository;

import com.durandsuppicich.danmsdelivery.domain.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITruckJpaRepository extends JpaRepository<Truck, Integer> {
}
