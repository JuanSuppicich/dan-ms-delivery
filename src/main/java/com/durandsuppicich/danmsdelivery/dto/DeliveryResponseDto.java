package com.durandsuppicich.danmsdelivery.dto;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DeliveryResponseDto {

    private Integer id;

    private Instant departure;

    private Double weight;

    private Double volume;

    private String truckDescription;

    private Integer employeeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDeparture() {
        return departure;
    }

    public void setDeparture(Instant departure) {
        this.departure = departure.truncatedTo(ChronoUnit.MINUTES);
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getTruckDescription() {
        return truckDescription;
    }

    public void setTruckDescription(String truckDescription) {
        this.truckDescription = truckDescription;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
