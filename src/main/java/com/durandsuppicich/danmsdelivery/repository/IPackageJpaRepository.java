package com.durandsuppicich.danmsdelivery.repository;

import com.durandsuppicich.danmsdelivery.domain.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPackageJpaRepository extends JpaRepository<Package, Integer> {

    Optional<Package> findByIdAndDeleteDateIsNull(Integer id);

    @Query("SELECT p " +
            "FROM Package p " +
            "WHERE p.deleteDate IS NULL")
    List<Package> getAll();

    List<Package> findAllByCustomerCuitAndDeleteDateIsNull(String cuit);

    @Query("SELECT p " +
            "FROM Package p " +
            "WHERE p.state = com.durandsuppicich.danmsdelivery.domain.PackageState.PENDIENTE " +
            "ORDER BY p.postDate ASC")
    List<Package> findAllPending();
}
