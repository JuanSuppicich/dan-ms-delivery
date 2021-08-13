package com.durandsuppicich.danmsdelivery.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rel_packages_orders", schema = "ms-delivery")
public class PackageOrders {

    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "package_id")
    private Integer packageId;

}
