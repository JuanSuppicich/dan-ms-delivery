package com.durandsuppicich.danmsdelivery.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rel_packages_orders", schema = "ms_delivery")
public class PackageOrder {

    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "package_id")
    private Integer packageId;

    public PackageOrder() {
    }

    public PackageOrder(Integer orderId, Integer packageId) {
        this.orderId = orderId;
        this.packageId = packageId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }
}
