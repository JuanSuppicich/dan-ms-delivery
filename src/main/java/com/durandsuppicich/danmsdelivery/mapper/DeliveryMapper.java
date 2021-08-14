package com.durandsuppicich.danmsdelivery.mapper;

import com.durandsuppicich.danmsdelivery.domain.Delivery;
import com.durandsuppicich.danmsdelivery.domain.Truck;
import com.durandsuppicich.danmsdelivery.dto.DeliveryRequestDto;
import com.durandsuppicich.danmsdelivery.dto.DeliveryResponseDto;

import java.util.ArrayList;
import java.util.List;

public class DeliveryMapper implements IDeliveryMapper {

    @Override
    public Delivery map(DeliveryRequestDto deliveryDto) {

        Delivery delivery = new Delivery();
        Truck truck = new Truck();

        truck.setId(deliveryDto.getTruckId());
        delivery.setEmployeeId(deliveryDto.getEmployeeId());
        delivery.setTruck(truck);

        return delivery;
    }

    @Override
    public DeliveryResponseDto mapToDto(Delivery delivery) {

        DeliveryResponseDto deliveryDto = new DeliveryResponseDto();

        deliveryDto.setId(delivery.getId());
        deliveryDto.setDeparture(delivery.getDeparture());
        deliveryDto.setWeight(delivery.getTotalWeight());
        deliveryDto.setVolume(delivery.getTotalVolume());
        deliveryDto.setTruckDescription(delivery.getTruck().getDescription());
        // TODO set employee name

        return deliveryDto;
}

    @Override
    public List<DeliveryResponseDto> mapToDto(List<Delivery> deliveries) {

        List<DeliveryResponseDto> deliveryDtos = new ArrayList<>();

        for (Delivery delivery : deliveries) {

            DeliveryResponseDto deliveryDto = mapToDto(delivery);
            deliveryDtos.add(deliveryDto);
        }
        return deliveryDtos;
    }
}
