package com.durandsuppicich.danmsdelivery.service.util;

import com.durandsuppicich.danmsdelivery.client.OrderItemDto;
import com.durandsuppicich.danmsdelivery.client.ProductDto;

import java.util.List;

public interface IPackageCalculator {

    Double calcWeight(List<ProductDto> products, List<OrderItemDto> orderItems);

    Double calcVolume(List<ProductDto> products, List<OrderItemDto> orderItems);
}
