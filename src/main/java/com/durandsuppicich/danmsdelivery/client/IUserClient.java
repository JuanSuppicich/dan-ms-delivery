package com.durandsuppicich.danmsdelivery.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("users")
public interface IUserClient {

    @GetMapping(value = "/api/employees/{id}")
    EmployeeDto getById(@PathVariable Integer id);
}
