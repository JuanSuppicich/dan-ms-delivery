package com.durandsuppicich.danmsdelivery.dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class TruckRequestDto {

    @NotBlank
    @Size(max = 32)
    private String description;

    @NotBlank
    @Size(max = 12)
    private String license;

    @NotNull
    @Range(min = 1500, max = 30000)
    @Digits(integer = 5, fraction = 2)
    private Double tare;

    @NotNull
    @Range(min = 500, max = 50000)
    @Digits(integer = 5, fraction = 2)
    private Double maxWeight;

    @NotNull
    @Range(min = 0, max = 105)
    @Digits(integer = 5, fraction = 2)
    private Double maxVolume;

    public String getDescription() {
        return description;
    }

    public String getLicense() {
        return license;
    }

    public Double getTare() {
        return tare;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public Double getMaxVolume() {
        return maxVolume;
    }

}
