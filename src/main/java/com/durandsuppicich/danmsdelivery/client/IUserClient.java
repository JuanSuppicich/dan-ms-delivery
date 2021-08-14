package com.durandsuppicich.danmsdelivery.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("users")
public interface IUserClient {
}
