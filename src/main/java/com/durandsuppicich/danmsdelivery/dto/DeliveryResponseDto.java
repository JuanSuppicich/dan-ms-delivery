package com.durandsuppicich.danmsdelivery.dto;

import java.time.Instant;

public class DeliveryResponseDto {

    private Integer id;

    private Instant departure;

    private Double weight;

    private Double volume;

    private String truckDescription;

    private String employeeName;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setDeparture(Instant departure) {
        this.departure = departure;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public void setTruckDescription(String truckDescription) {
        this.truckDescription = truckDescription;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
