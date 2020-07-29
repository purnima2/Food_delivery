package com.coding.model;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderSummary {
    private Long orderid;
    private String restaurentName;
    private List<Dish> itemList;
    private Double totalPrice;

    public OrderSummary() {

    }

    public OrderSummary(Long orderid, String restaurentName, List<Dish> itemPrice, Double totalPrice) {
        this.orderid = orderid;
        this.restaurentName = restaurentName;
        this.itemList = itemPrice;
        this.totalPrice = totalPrice;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public String getRestaurentName() {
        return restaurentName;
    }

    public void setRestaurentName(String restaurentName) {
        this.restaurentName = restaurentName;
    }

    public List<Dish> getItemList() {
        return itemList;
    }

    public void setItemList(List<Dish> itemPrice) {
        this.itemList = itemPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
