package com.durandsuppicich.danmsdelivery.repository;

import com.durandsuppicich.danmsdelivery.domain.PackageOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPackageOrderRepository extends JpaRepository<PackageOrder, Integer> {
}
