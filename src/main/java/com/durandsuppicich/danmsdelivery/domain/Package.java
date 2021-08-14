package com.durandsuppicich.danmsdelivery.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

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

    @Enumerated(value = EnumType.STRING)
    private PackageState packageState;

    @Column(name = "post_date", nullable = false)
    private Instant postDate;

    @Column(name = "delete_date")
    private Instant deleteDate;

    @Column(name = "arrival_date", nullable = false)
    private Instant arrivalDate;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    @JsonBackReference
    private Delivery delivery;

    public Package() {
        postDate = Instant.now().truncatedTo(ChronoUnit.SECONDS);
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

    public PackageState getPackageState() {
        return packageState;
    }

    public void setPackageState(PackageState packageState) {
        this.packageState = packageState;
    }

    public Instant getDeleteDate() {
        return deleteDate.truncatedTo(ChronoUnit.SECONDS);
    }

    public void setDeleteDate() {
        this.deleteDate = Instant.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public Instant getArrivalDate() {
        return arrivalDate.truncatedTo(ChronoUnit.DAYS);
    }

    public void setArrivalDate() {
        this.arrivalDate = Instant.now().truncatedTo(ChronoUnit.DAYS);
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
