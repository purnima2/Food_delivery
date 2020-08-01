package com.coding.service;

import com.coding.model.DestinationLocation;
import com.coding.repository.DestinationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    DestinationRespository destinationRespository;
    @Override
    public DestinationLocation getbyId(Long id) {
        if(id != null)
            return destinationRespository.getOne(id);
        return null;
    }

    @Override
    public DestinationLocation getbyName(String name) {
        try {
            if (name != null)
                return destinationRespository.getByName(name);
        }catch (Exception e){
            e.printStackTrace();
            new Exception(e.getLocalizedMessage());
        }
        return null;
    }
}
