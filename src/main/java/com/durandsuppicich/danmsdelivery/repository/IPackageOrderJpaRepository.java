package com.durandsuppicich.danmsdelivery.repository;

import com.durandsuppicich.danmsdelivery.domain.PackageOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPackageOrderJpaRepository extends JpaRepository<PackageOrder, Integer> {

    @Query("SELECT po.orderId " +
            "FROM PackageOrder po " +
            "WHERE po.packageId = :packageId")
    List<Integer> getOrderIds(Integer packageId);
}
