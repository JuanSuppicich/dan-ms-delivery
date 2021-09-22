package com.durandsuppicich.danmsdelivery.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "delivery", schema = "ms_delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Integer id;

    @Column(nullable = false)
    private Instant departure;

    @Column(name = "total_weight", nullable = false)
    private Double totalWeight;

    @Column(name = "total_volume", nullable = false)
    private Double totalVolume;

    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @OneToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Package> packages = new ArrayList<>();

    public Delivery() {
        this.departure = Instant.now().truncatedTo(ChronoUnit.MINUTES);
    }

    public Integer getId() {
        return id;
    }

    public Instant getDeparture() {
        return departure.truncatedTo(ChronoUnit.MINUTES);
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }

    public void addPackage(Package p) {
        this.packages.add(p);
        p.setDelivery(this);
    }
}
