package com.durandsuppicich.danmsdelivery.dto;

public class TruckRequestDto {

    private String description;

    private String license;

    private Double tare;

    private Double maxWeight;

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
