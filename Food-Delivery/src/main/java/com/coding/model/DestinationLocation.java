package com.coding.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "destinationLocation")
public class DestinationLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String fullAddress;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Restaurent> restaurentList;

    public DestinationLocation() {

    }

    public DestinationLocation(Long id, String name, String fullAddress, List<Restaurent> restaurentList) {
        this.id = id;
        this.name = name;
        this.fullAddress = fullAddress;
        this.restaurentList = restaurentList;
    }

    public List<Restaurent> getRestaurentList() {
        return restaurentList;
    }

    public void setRestaurentList(List<Restaurent> restaurentList) {
        this.restaurentList = restaurentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }
}
