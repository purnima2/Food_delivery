package com.coding.service;

import com.coding.model.Origin;
import com.coding.repository.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OriginServiceImpl implements OriginService {
    @Autowired
    OriginRepository originRepository;
    @Override
    public Origin addOrigin(Origin origin) {
        if(origin != null && origin.getId() != null){
            originRepository.save(origin);
            return origin;
        }
        return null;
    }

    @Override
    public Origin getOrigin(Long id) {
        if(id != null){
            return originRepository.getOne(id);
        }
        return null;
    }

    @Override
    public Origin updateOrigin(Origin origin) {
        if(origin != null && origin.getId() != null){
            Origin oldOrigin = originRepository.getOne(origin.getId());
            oldOrigin.setOrigin(origin.getOrigin());
            oldOrigin.setDestList(origin.getDestList());
            return originRepository.save(oldOrigin);

        }
        return null;
    }

    @Override
    public Origin removeOrigin(Long id) {
        if(id != null){
            return originRepository.getOne(id);
        }
        return null;
    }
}
