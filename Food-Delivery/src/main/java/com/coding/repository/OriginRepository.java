package com.coding.repository;

import com.coding.model.Origin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OriginRepository extends JpaRepository<Origin, Long> {
    public Origin getOriginByOrigin(String origin);
}
