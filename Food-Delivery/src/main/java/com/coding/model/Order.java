package com.coding.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long orderId;
    Double price;
    @OneToOne
     Restaurent restaurent;
    @OneToMany
    List<Dish> dishList;

    public Order() {
    }

    public Order(Long orderId, Double price, List<Dish> dishList) {
        this.orderId = orderId;
        this.price = price;
        this.dishList = dishList;
    }

    public Restaurent getRestaurent() {
        return restaurent;
    }

    public void setRestaurent(Restaurent restaurent) {
        this.restaurent = restaurent;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
