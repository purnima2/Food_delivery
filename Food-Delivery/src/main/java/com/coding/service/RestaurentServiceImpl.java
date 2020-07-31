package com.coding.service;

import com.coding.model.DestinationLocation;
import com.coding.model.Dish;
import com.coding.model.Origin;
import com.coding.model.Restaurent;
import com.coding.repository.RestaurentReposotory;
import com.coding.util.PriceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestaurentServiceImpl implements RestaurentService {

    @Autowired
    RestaurentReposotory restaurentReposotory;
    @Autowired
    RestaurentService restaurentService;
    @Autowired
    PriceUtil util;


    @Override
    public Restaurent addRestaurent(Restaurent restaurent) {
        if(restaurent != null && restaurent.getId() != null){
            return restaurentReposotory.save(restaurent);
        }
        return null;
    }

    @Override
    public Restaurent getRestaurent(Long id) {
        if(id != null){
            Restaurent restaurent = restaurentReposotory.getOne(id);
            return util.calFlactuatinPrice(restaurent);
        }
        return null;
    }

    @Override
    public List<Restaurent> getRestaurentByRatingAndPrice(Integer rating, Double price) {
        if(rating != null && price != null){
          List<Restaurent> restaurentList =   restaurentService.getRastaurentByRating(rating);
            List<Restaurent> restaurentListUpdate = new ArrayList<>();
          for(Restaurent restaurent: restaurentList){
              restaurent = util.calFlactuatinPrice(restaurent);
              List<Dish> dishes = restaurent.getDishes();
              List<Dish> updatedDish = new ArrayList<>();
              for(Dish dish:dishes){
                  if(dish.getPrice() <= price){
                      updatedDish.add(dish);
                  }
              }
              restaurent.setDishes(updatedDish);
              restaurentListUpdate.add(restaurent);
          }
            return restaurentListUpdate;
        }
        return null;
    }

    @Override
    public Restaurent updateRestaurent(Restaurent restaurent) {
        if(restaurent != null && restaurent.getId() != null){
            Restaurent oldRestaurent = restaurentReposotory.getOne(restaurent.getId());
            oldRestaurent.setDestinationLocation(restaurent.getDestinationLocation());
            oldRestaurent.setDishes(restaurent.getDishes());
            oldRestaurent.setName(restaurent.getName());
            oldRestaurent.setRating(restaurent.getRating());
            return restaurentReposotory.save(oldRestaurent);
        }
        return null;
    }

    @Override
    public Restaurent removeRestaurent(Restaurent restaurent) {
        if(restaurent != null && restaurent.getId() != null){
            restaurentReposotory.delete(restaurent.getId());
            return restaurent;
        }
        return null;
    }

    @Override
    public String removeRestaurent(Origin origin) {
        if(origin != null && origin.getDestList().size()>0){
            for(DestinationLocation location :origin.getDestList())
            restaurentReposotory.delete(location.getId());
            return "Success";
        }
        return "Failed";
    }

    @Override
    public String removeRestaurent(DestinationLocation destLocation) {
        if(destLocation != null){
            restaurentReposotory.delete(destLocation.getId());
            return "Success";
        }
        return "Failed";
    }

    @Override
    public List<Restaurent> getRastaurentByRating(Integer rating) {
        if(rating != null){
            List<Restaurent> restaurent = restaurentReposotory.getByRating(rating);
            List<Restaurent> restaurentUpdate = new ArrayList<>();
            for(Restaurent res:restaurent){
                restaurentUpdate.add(util.calFlactuatinPrice(res));
            }
            return restaurentUpdate;
        }
        return null;
    }
}
