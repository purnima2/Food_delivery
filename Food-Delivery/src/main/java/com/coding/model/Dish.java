package com.coding.model;

import javax.persistence.*;

@Entity
@Table(name = "dises")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String ItemName;
    Double price;


    public Dish() {
    }

    public Dish(String itemName, Double price, Long id) {
        ItemName = itemName;
        this.price = price;
        this.id = id;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
