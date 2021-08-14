package com.durandsuppicich.danmsdelivery.dto;

import com.durandsuppicich.danmsdelivery.domain.TruckState;

public class TruckResponseDto {

    private Integer id;

    private String description;

    private String license;

    private Double tare;

    private Double maxWeight;

    private Double volume;

    private TruckState state;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public void setState(TruckState state) {
        this.state = state;
    }

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

    public Double getVolume() {
        return volume;
    }

    public TruckState getState() {
        return state;
    }
}
