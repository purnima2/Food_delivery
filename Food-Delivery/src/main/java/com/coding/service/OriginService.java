package com.coding.service;

import com.coding.model.Origin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OriginService {
    public Origin addOrigin(Origin origin);
    public Origin getOrigin(Long id);
    public Origin updateOrigin(Origin origin);
    public Origin removeOrigin(Long id);
}
