package com.durandsuppicich.danmsdelivery.controller;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/delivery")
@Api(value = "TruckController")
public class TruckController {

    @GetMapping
    public ResponseEntity<String> isAlive() {
        return ResponseEntity.ok("I'm alive!");
    }
}

