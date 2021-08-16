package com.durandsuppicich.danmsdelivery.mapper;

import com.durandsuppicich.danmsdelivery.domain.Truck;
import com.durandsuppicich.danmsdelivery.dto.TruckRequestDto;
import com.durandsuppicich.danmsdelivery.dto.TruckResponseDto;

import java.util.ArrayList;
import java.util.List;

public class TruckMapper implements ITruckMapper {

    @Override
    public Truck map(TruckRequestDto truckDto) {

        Truck truck = new Truck();

        truck.setDescription(truckDto.getDescription());
        truck.setLicense(truckDto.getLicense());
        truck.setTare(truckDto.getTare());
        truck.setMaxWeight(truckDto.getMaxWeight());
        truck.setMaxVolume(truckDto.getMaxVolume());

        return truck;
    }

    @Override
    public TruckResponseDto mapToDto(Truck truck) {

        TruckResponseDto truckDto = new TruckResponseDto();

        truckDto.setId(truck.getId());
        truckDto.setDescription(truck.getDescription());
        truckDto.setLicense(truck.getLicense());
        truckDto.setTare(truck.getTare());
        truckDto.setMaxWeight(truck.getMaxWeight());
        truckDto.setMaxVolume(truck.getMaxVolume());
        truckDto.setState(truck.getState());

        return truckDto;
    }

    @Override
    public List<TruckResponseDto> mapToDto(List<Truck> trucks) {

        List<TruckResponseDto> truckDtos = new ArrayList<>();

        for(Truck truck : trucks) {

            TruckResponseDto truckDto = mapToDto(truck);
            truckDtos.add(truckDto);
        }
        return truckDtos;
    }
}
