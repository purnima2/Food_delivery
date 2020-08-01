package com.coding.model;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.*;
import java.time.LocalTime;
@Entity
@Table(name = "priceflactuation")
public class PriceFlactuation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalTime fromTime;
    private LocalTime toTime;
    private int percentangeChange;

    public PriceFlactuation() {

    }

    public PriceFlactuation(Long id, LocalTime fromTime, LocalTime toTime, int percentangeChange) {
        this.id = id;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.percentangeChange = percentangeChange;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalTime toTime) {
        this.toTime = toTime;
    }

    public int getPercentangeChange() {
        return percentangeChange;
    }

    public void setPercentangeChange(int percentangeChange) {
        this.percentangeChange = percentangeChange;
    }
}
