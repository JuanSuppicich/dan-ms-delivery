package com.durandsuppicich.danmsdelivery.service;

import com.durandsuppicich.danmsdelivery.domain.Package;
import com.durandsuppicich.danmsdelivery.domain.PackageOrder;

import java.util.List;

public interface IPackageService {

    Package post(Package p, List<Integer> ordersIds);

    List<Package> getAll();

    List<Package> getByCustomerCuit(String cuit);

    void delete(Integer id);

}
