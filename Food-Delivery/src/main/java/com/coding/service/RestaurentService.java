package com.coding.service;

import com.coding.model.DestinationLocation;
import com.coding.model.Origin;
import com.coding.model.Restaurent;

import java.util.List;

public interface RestaurentService {
    public Restaurent addRestaurent(Restaurent restaurent);
    public Restaurent getRestaurent(Long id);
    public List<Restaurent> getRestaurentByRatingAndPrice(Integer rating,Double price);
    public Restaurent updateRestaurent(Restaurent restaurent);
    public Restaurent removeRestaurent(Restaurent restaurent);
    public String removeRestaurent(Origin origin);
    public String removeRestaurent(DestinationLocation destLocation);
    public List<Restaurent> getRastaurentByRating(Integer rating);
}
