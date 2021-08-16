package com.durandsuppicich.danmsdelivery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("orders")
public interface IOrderClient {

    @GetMapping(value = "/api/orders/{orderId}/items")
    List<OrderItemDto> getByOrderId(@PathVariable Integer orderId);

    @PatchMapping(path = "/{id}")
    void patch(@RequestBody OrderPatchDto orderPatchDto, @PathVariable Integer id);

}
