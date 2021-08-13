package com.durandsuppicich.danmsdelivery.repository;

import com.durandsuppicich.danmsdelivery.domain.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPackageJpaRepository extends JpaRepository<Package, Integer> {
}
