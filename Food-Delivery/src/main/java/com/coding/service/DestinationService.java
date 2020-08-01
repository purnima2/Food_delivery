package com.coding.service;

import com.coding.model.DestinationLocation;

public interface DestinationService {
    public DestinationLocation getbyId(Long id);
    public DestinationLocation getbyName(String name);
}
