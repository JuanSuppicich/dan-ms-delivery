package com.durandsuppicich.danmsdelivery.service;

import com.durandsuppicich.danmsdelivery.domain.Package;
import com.durandsuppicich.danmsdelivery.repository.IPackageJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService implements IPackageService {

    private final IPackageJpaRepository packageRepository;

    public PackageService(IPackageJpaRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    @Override
    public Package post(Package p) {
        return packageRepository.save(p);
    }

    @Override
    public List<Package> getAll() {
        return packageRepository.findAll();
    }

    @Override
    public List<Package> getByCustomerCuit(String cuit) {
        return packageRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        packageRepository.deleteById(id);
    }
}
