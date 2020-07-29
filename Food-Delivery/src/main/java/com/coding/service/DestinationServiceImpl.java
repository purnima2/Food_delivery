package com.coding.service;

import com.coding.model.DestinationLocation;
import com.coding.repository.DestinationRespository;
import org.springframework.beans.factory.annotation.Autowired;

public class DestinationServiceImpl implements DestinationService {

    @Autowired
    DestinationRespository destinationRespository;
    @Override
    public DestinationLocation getbyId(Long id) {
        if(id != null)
            return destinationRespository.getOne(id);
        return null;
    }
}
