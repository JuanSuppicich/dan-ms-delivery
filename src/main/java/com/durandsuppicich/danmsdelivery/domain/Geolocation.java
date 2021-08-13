package com.durandsuppicich.danmsdelivery.domain;

import javax.persistence.*;

@Entity
@Table(name = "geolocation", schema = "ms_delivery")
public class Geolocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "geolocation_id")
    private Integer id;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    public Geolocation() {
    }

    public Geolocation(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
