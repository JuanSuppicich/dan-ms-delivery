package com.durandsuppicich.danmsdelivery.dto;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DeliveryResponseDto {

    private Integer id;

    private Instant departure;

    private Double weight;

    private Double volume;

    private String truckDescription;

    private String employeeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDeparture(Instant departure) {
        this.departure = departure.truncatedTo(ChronoUnit.MINUTES);
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
