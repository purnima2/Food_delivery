package com.coding.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "origin")
public class Origin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String origin;
    @OneToMany(cascade = CascadeType.ALL)
    private List<DestinationLocation> destList;

    public Origin() {

    }
    public Origin(Long id, String origin, List<DestinationLocation> destList) {
        this.id = id;
        this.origin = origin;
        this.destList = destList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<DestinationLocation> getDestList() {
        return destList;
    }

    public void setDestList(List<DestinationLocation> destList) {
        this.destList = destList;
    }
}
