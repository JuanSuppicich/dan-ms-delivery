package com.durandsuppicich.danmsdelivery.repository;

import com.durandsuppicich.danmsdelivery.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDeliveryJpaRepository extends JpaRepository<Delivery, Integer> {

    @Query(value = "SELECT DISTINCT * " +
            "FROM ms_delivery.delivery d " +
            "LEFT JOIN ms_delivery.package p ON d.delivery_id = p.delivery_id " +
            "WHERE p.customer_cuit = :cuit",
            nativeQuery = true)
    List<Delivery> findByCustomerCuit(String cuit);

}
