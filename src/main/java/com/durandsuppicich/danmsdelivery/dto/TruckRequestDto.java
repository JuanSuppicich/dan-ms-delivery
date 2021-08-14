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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setTare(Double tare) {
        this.tare = tare;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setMaxVolume(Double maxVolume) {
        this.maxVolume = maxVolume;
    }
}
