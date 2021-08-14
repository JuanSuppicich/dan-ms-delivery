package com.durandsuppicich.danmsdelivery.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("orders")
public interface IOrderClient {
}
