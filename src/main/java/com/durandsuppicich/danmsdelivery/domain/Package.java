package com.durandsuppicich.danmsdelivery.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

@Entity
@Table(name = "package", schema = "ms_delivery")
public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "package_id")
    private Integer id;

    @Column(name = "customer_cuit", length = 11, nullable = false)
    private String customerCuit;

    @Column(nullable = false)
    private Double weight;

    @Column(nullable = false)
    private Double volume;

    @Column(name = "package_state")
    @Enumerated(value = EnumType.STRING)
    private PackageState state;

    @Column(name = "post_date", nullable = false)
    private Instant postDate;

    @Column(name = "delete_date")
    private Instant deleteDate;

    @Column(name = "arrival_date")
    private Instant arrivalDate;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    @JsonBackReference
    private Delivery delivery;

    public Package() {
        this.postDate = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        this.state = PackageState.PENDIENTE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerCuit() {
        return customerCuit;
    }

    public void setCustomerCuit(String customerCuit) {
        this.customerCuit = customerCuit;
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

    public PackageState getState() {
        return state;
    }

    public void setState(PackageState state) {
        this.state = state;
    }

    public Instant getDeleteDate() {
        return deleteDate.truncatedTo(ChronoUnit.SECONDS);
    }

    public void setDeleteDate() {
        this.deleteDate = Instant.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public Instant getArrivalDate() {
        if (this.arrivalDate != null) return arrivalDate.truncatedTo(ChronoUnit.DAYS);
        else return null;
    }

    public void setArrivalDate(Instant arrivalDate) {
        this.arrivalDate = arrivalDate.truncatedTo(ChronoUnit.DAYS);
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
