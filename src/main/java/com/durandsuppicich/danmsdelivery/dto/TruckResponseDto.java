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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
