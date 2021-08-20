package com.durandsuppicich.danmsdelivery.client;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("products")
public interface IProductClient {

    @PostMapping(value = "/api/products/all-in")
    @Headers(value = "Content-Type: application/json")
    List<ProductDto> getAllByIds(@RequestBody List<Integer> ids);

}
