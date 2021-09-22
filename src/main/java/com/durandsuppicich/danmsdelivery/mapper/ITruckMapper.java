package com.durandsuppicich.danmsdelivery.mapper;

import com.durandsuppicich.danmsdelivery.domain.Truck;
import com.durandsuppicich.danmsdelivery.dto.TruckRequestDto;
import com.durandsuppicich.danmsdelivery.dto.TruckResponseDto;

import java.util.List;

public interface ITruckMapper {

    Truck map(TruckRequestDto truckDto);

    TruckResponseDto mapToDto(Truck truck);

    List<TruckResponseDto> mapToDto(List<Truck> trucks);

}
