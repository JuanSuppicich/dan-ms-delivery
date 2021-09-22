package com.durandsuppicich.danmsdelivery.config;

import com.durandsuppicich.danmsdelivery.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ITruckMapper truckMapper() {
        return new TruckMapper();
    }

    @Bean
    public IPackageMapper packageMapper() {
        return new PackageMapper();
    }

    @Bean
    public IDeliveryMapper deliveryMapper() {
        return new DeliveryMapper();
    }
}
