package com.durandsuppicich.danmsdelivery.repository;

import com.durandsuppicich.danmsdelivery.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeliveryJpaRepository extends JpaRepository<Delivery, Integer> {
}
