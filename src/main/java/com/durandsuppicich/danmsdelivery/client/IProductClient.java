package com.durandsuppicich.danmsdelivery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("products")
public interface IProductClient {

    @GetMapping(value = "/api/products/all-in")
    List<ProductDto> getAllByIds(List<Integer> ids);

}
