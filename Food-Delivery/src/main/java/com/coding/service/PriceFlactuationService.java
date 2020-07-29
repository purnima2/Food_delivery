package com.coding.service;

import com.coding.model.PriceFlactuation;
import com.coding.repository.PriceFlactuationRepository;

import java.time.LocalTime;
import java.util.List;

public interface PriceFlactuationService {
    public PriceFlactuation addFlactuation(PriceFlactuation priceFlactuation);
    public PriceFlactuation getFlactuation(Long id);
    public List<PriceFlactuation> getAllFlactuation();
    public PriceFlactuation getFlactuationByTime(LocalTime localTime);
    public PriceFlactuation updateFlactuation(PriceFlactuation priceFlactuation);
    public PriceFlactuation removeFlactuation(PriceFlactuation priceFlactuation);
}
