package com.durandsuppicich.danmsdelivery.mapper;

import com.durandsuppicich.danmsdelivery.domain.Package;
import com.durandsuppicich.danmsdelivery.domain.PackageOrder;
import com.durandsuppicich.danmsdelivery.dto.PackageRequestDto;
import com.durandsuppicich.danmsdelivery.dto.PackageResponseDto;

import java.util.ArrayList;
import java.util.List;

public class PackageMapper implements IPackageMapper {

    @Override
    public Package map(PackageRequestDto packageDto) {

        Package p = new Package();

        p.setCustomerCuit(packageDto.getCustomerCuit());

        return p;
    }

    @Override
    public PackageResponseDto mapToDto(Package p) {

        PackageResponseDto packageDto = new PackageResponseDto();

        packageDto.setId(p.getId());
        packageDto.setCustomerCuit(p.getCustomerCuit());
        packageDto.setWeight(p.getWeight());
        packageDto.setVolume(p.getVolume());
        packageDto.setArrivalDate(p.getArrivalDate());
        packageDto.setState(p.getState());

        return packageDto;
    }

    @Override
    public List<PackageResponseDto> mapToDto(List<Package> packages) {

        List<PackageResponseDto> packageDtos = new ArrayList<>();

        for(Package p : packages) {

            PackageResponseDto packageDto = mapToDto(p);
            packageDtos.add(packageDto);
        }
        return packageDtos;
    }
}
