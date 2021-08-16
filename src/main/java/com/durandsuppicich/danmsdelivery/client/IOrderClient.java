package com.durandsuppicich.danmsdelivery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("orders")
public interface IOrderClient {

    @GetMapping(value = "/api/orders/{orderId}/items")
    List<OrderItemDto> getByOrderId(@PathVariable Integer orderId);

}
