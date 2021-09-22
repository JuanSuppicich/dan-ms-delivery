package com.durandsuppicich.danmsdelivery.config;

import com.durandsuppicich.danmsdelivery.service.util.IPackageCalculator;
import com.durandsuppicich.danmsdelivery.service.util.PackageCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PackageCalculatorConfig {

    @Bean
    public IPackageCalculator packageWeightCalculator() {
        return new PackageCalculator();
    }

}
