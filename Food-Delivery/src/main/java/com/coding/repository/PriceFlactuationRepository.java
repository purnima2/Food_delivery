package com.coding.repository;

import com.coding.model.PriceFlactuation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;

public interface PriceFlactuationRepository extends JpaRepository<PriceFlactuation,Long> {
    public PriceFlactuation getByFromTimeGreaterThanAndToTimeLessThan(LocalTime fromTime,LocalTime toTime);
}
