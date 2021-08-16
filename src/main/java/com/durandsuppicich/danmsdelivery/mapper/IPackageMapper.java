package com.durandsuppicich.danmsdelivery.mapper;

import com.durandsuppicich.danmsdelivery.domain.Package;
import com.durandsuppicich.danmsdelivery.domain.PackageOrder;
import com.durandsuppicich.danmsdelivery.dto.PackageRequestDto;
import com.durandsuppicich.danmsdelivery.dto.PackageResponseDto;

import java.util.List;

public interface IPackageMapper {

    Package map(PackageRequestDto packageDto);

    PackageResponseDto mapToDto(Package p);

    List<PackageResponseDto> mapToDto(List<Package> packages);

}
