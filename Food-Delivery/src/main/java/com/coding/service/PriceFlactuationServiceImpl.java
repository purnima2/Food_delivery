package com.coding.service;

import com.coding.model.PriceFlactuation;
import com.coding.repository.PriceFlactuationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class PriceFlactuationServiceImpl implements PriceFlactuationService {
@Autowired
    PriceFlactuationRepository priceFlactuationRepository;

    @Override
    public PriceFlactuation addFlactuation(PriceFlactuation priceFlactuation) {
        if(priceFlactuation != null && priceFlactuation.getFromTime()!=null && priceFlactuation.getToTime() != null){
            return priceFlactuationRepository.save(priceFlactuation);
        }
        return null;
    }

    @Override
    public PriceFlactuation getFlactuation(Long id) {
        if(id != null){
            return priceFlactuationRepository.getOne(id);
        }
        return null;
    }

    @Override
    public List<PriceFlactuation> getAllFlactuation() {

        return priceFlactuationRepository.findAll();
    }

    @Override
    public PriceFlactuation getFlactuationByTime(LocalTime localTime) {
        if(localTime != null)
            return priceFlactuationRepository.getByFromTimeGreaterThanAndToTimeLessThan(localTime,localTime);
        else
            return null;
    }

    @Override
    public PriceFlactuation updateFlactuation(PriceFlactuation priceFlactuation) {
        if(priceFlactuation.getId() != null && priceFlactuation.getFromTime() !=null && priceFlactuation.getToTime() != null){
            PriceFlactuation oldPriceFlactuation = priceFlactuationRepository.getOne(priceFlactuation.getId());
            oldPriceFlactuation.setPercentangeChange(priceFlactuation.getPercentangeChange());
            return priceFlactuationRepository.save(oldPriceFlactuation);
        }
        return null;
    }

    @Override
    public PriceFlactuation removeFlactuation(PriceFlactuation priceFlactuation) {
        if(priceFlactuation != null){
            priceFlactuationRepository.delete(priceFlactuation.getId());
            return priceFlactuation;
        }
        return null;
    }
}
