package com.durandsuppicich.danmsdelivery.service.util;

import com.durandsuppicich.danmsdelivery.client.OrderItemDto;
import com.durandsuppicich.danmsdelivery.client.ProductDto;

import java.util.List;

public class PackageCalculator implements IPackageCalculator {

    @Override
    public Double calcWeight(List<ProductDto> products, List<OrderItemDto> orderItems) {

        double result = 0.0;

        for(OrderItemDto orderItem : orderItems) {

            result += orderItem.getQuantity() * products.stream().filter(
                    p -> p.getId().equals(orderItem.getProductId())
            )
                    .findFirst()
                    .orElse(new ProductDto())
                    .getWeight();
        }
        return result;
    }

    @Override
    public Double calcVolume(List<ProductDto> products, List<OrderItemDto> orderItems) {

        double result = 0.0;

        for(OrderItemDto orderItem : orderItems) {

            result += orderItem.getQuantity() * products.stream().filter(
                    p -> p.getId().equals(orderItem.getProductId())
            )
                    .findFirst()
                    .orElse(new ProductDto())
                    .getVolume();
        }
        return result;
    }
}
