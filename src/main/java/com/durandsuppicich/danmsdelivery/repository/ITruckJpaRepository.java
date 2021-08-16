package com.durandsuppicich.danmsdelivery.repository;

import com.durandsuppicich.danmsdelivery.domain.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ITruckJpaRepository extends JpaRepository<Truck, Integer> {

    @Query("SELECT t " +
            "FROM Truck t " +
            "WHERE t.deleteDate IS NULL" )
    List<Truck> getAll();

    @Query("SELECT t " +
            "FROM Truck t " +
            "WHERE t.state = com.durandsuppicich.danmsdelivery.domain.TruckState.DISPONIBLE " +
            "AND t.deleteDate IS NULL")
    List<Truck> findAllAvailable();

    Optional<Truck> findByIdAndDeleteDateIsNull(Integer id);
}
