package com.coding.util;

import com.coding.model.Dish;
import com.coding.model.Order;
import com.coding.model.PriceFlactuation;
import com.coding.model.Restaurent;
import com.coding.service.PriceFlactuationService;
import com.coding.service.PriceFlactuationServiceImpl;
import com.coding.service.RestaurentService;
import com.coding.service.RestaurentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.temporal.TemporalQueries;
import java.util.ArrayList;
import java.util.List;

@Component
public class PriceUtil {
    @Autowired
    PriceFlactuationService priceFlactuationService;
    @Autowired
    RestaurentService restaurentService;

    public Restaurent calFlactuatinPrice(Restaurent restaurent){
        if(restaurent!=null&&restaurent.getId()!=null) {
            PriceFlactuation priceobj = priceFlactuationService.getFlactuationByTime(LocalTime.now());
           List<Dish> dishList = new ArrayList<>();
            for(Dish dish:restaurent.getDishes()){
                Double newprice = dish.getPrice()+((dish.getPrice()*priceobj.getPercentangeChange())/100);
                dish.setPrice(newprice);
                dishList.add(dish);
            }
            restaurent.setDishes(dishList);

            return restaurent;
        }

        return null;
    }
    public Restaurent calFlactuationPriceById(Long restaurentId){
            if(restaurentId!=null) {
                Restaurent restaurent = restaurentService.getRestaurent(restaurentId);
                PriceFlactuation priceobj = priceFlactuationService.getFlactuationByTime(LocalTime.now());
                List<Dish> dishList = new ArrayList<>();
                for(Dish dish:restaurent.getDishes()){
                    Double newprice = dish.getPrice()+((dish.getPrice()*priceobj.getPercentangeChange())/100);
                    dish.setPrice(newprice);
                    dishList.add(dish);
                }
                restaurent.setDishes(dishList);
                return restaurent;
            }
            return null;
    }
    public Order calPrice(Order order){
        List<Dish> dishlist;
        if(order != null){
            dishlist= order.getDishList();
            Double totalPrice =0D;
            for(Dish dish:dishlist){
                totalPrice +=dish.getPrice();
            }
            order.setPrice(totalPrice);
        }

        return order;
    }


}
