package com.durandsuppicich.danmsdelivery.mapper;

import com.durandsuppicich.danmsdelivery.domain.Delivery;
import com.durandsuppicich.danmsdelivery.dto.DeliveryRequestDto;
import com.durandsuppicich.danmsdelivery.dto.DeliveryResponseDto;

import java.util.List;

public interface IDeliveryMapper {

    Delivery map(DeliveryRequestDto deliveryDto);

    DeliveryResponseDto mapToDto(Delivery delivery);

    List<DeliveryResponseDto> mapToDto(List<Delivery> deliveries);

}
