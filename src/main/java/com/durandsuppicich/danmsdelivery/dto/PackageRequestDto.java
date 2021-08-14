package com.durandsuppicich.danmsdelivery.dto;

import java.util.List;

public class PackageRequestDto {

    private String customerCuit;

    private List<Integer> ordersIds;

    public String getCustomerCuit() {
        return customerCuit;
    }

    public List<Integer> getOrdersIds() {
        return ordersIds;
    }
}
