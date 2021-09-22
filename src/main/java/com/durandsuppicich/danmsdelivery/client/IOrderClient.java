package com.durandsuppicich.danmsdelivery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("orders")
public interface IOrderClient {

    @GetMapping(path = "/api/orders/{orderId}/items")
    List<OrderItemDto> getByOrderId(@PathVariable Integer orderId);

    @RequestMapping(value = "api/orders/{id}/update-state", method = RequestMethod.PUT)
    void patch(@RequestBody OrderPatchDto orderPatchDto, @PathVariable Integer id);

}
