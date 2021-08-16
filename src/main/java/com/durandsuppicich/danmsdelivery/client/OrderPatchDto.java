package com.durandsuppicich.danmsdelivery.client;

public class OrderPatchDto {

    private Integer id;

    private Integer orderStateId;

    public OrderPatchDto(Integer id, Integer orderStateId) {
        this.id = id;
        this.orderStateId = orderStateId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(Integer orderStateId) {
        this.orderStateId = orderStateId;
    }
}
