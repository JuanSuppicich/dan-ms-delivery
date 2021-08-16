package com.durandsuppicich.danmsdelivery.dto;

import com.durandsuppicich.danmsdelivery.domain.PackageState;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class PackageResponseDto {

    private Integer id;

    private String customerCuit;

    private Double weight;

    private Double volume;

    private Instant arrivalDate;

    private PackageState state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCustomerCuit(String customerCuit) {
        this.customerCuit = customerCuit;
    }

    public String getCustomerCuit() {
        return customerCuit;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getVolume() {
        return volume;
    }

    public void setArrivalDate(Instant arrivalDate) {
        if (arrivalDate != null) this.arrivalDate = arrivalDate.truncatedTo(ChronoUnit.DAYS);
    }

    public Instant getArrivalDate() {
        if (this.arrivalDate != null) return this.arrivalDate.truncatedTo(ChronoUnit.DAYS);
        else return null;
    }

    public void setState(PackageState state) {
        this.state = state;
    }

    public PackageState getState() {
        return state;
    }
}
