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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCustomerCuit(String customerCuit) {
        this.customerCuit = customerCuit;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public void setArrivalDate(Instant arrivalDate) {
        this.arrivalDate = arrivalDate.truncatedTo(ChronoUnit.DAYS);
    }

    public void setState(PackageState state) {
        this.state = state;
    }
}
