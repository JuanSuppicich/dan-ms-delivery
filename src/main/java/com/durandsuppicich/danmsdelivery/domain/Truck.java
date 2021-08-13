package com.durandsuppicich.danmsdelivery.domain;

import javax.persistence.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name="truck", schema = "ms_delivery")
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "truck_id")
    private Integer id;

    @Column(length = 32, nullable = false)
    private String description;

    @Column(length = 12, nullable = false)
    private String license;

    @Column(nullable = false)
    private Double tare;

    @Column(name = "max_weight", nullable = false)
    private Double maxWeight;

    @Column(name = "max_volume", nullable = false)
    private Double maxVolume;

    @Column(name = "post_date", nullable = false)
    private Instant postDate;

    @Column(name = "delete_date")
    private Instant deleteDate;

    @Enumerated(value = EnumType.STRING)
    private TruckState truckState;

    public Truck() {
        postDate = Instant.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Double getTare() {
        return tare;
    }

    public void setTare(Double tare) {
        this.tare = tare;
    }

    public Double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Double getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(Double maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Instant getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate() {
        this.deleteDate = Instant.now().truncatedTo(ChronoUnit.SECONDS);
    }
    
}
