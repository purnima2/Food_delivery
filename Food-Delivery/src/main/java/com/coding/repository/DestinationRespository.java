package com.coding.repository;

import com.coding.model.DestinationLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRespository extends JpaRepository<DestinationLocation,Long> {
}
