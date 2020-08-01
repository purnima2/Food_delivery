package com.coding.controller;

import com.coding.model.DestinationLocation;
import com.coding.model.Dish;
import com.coding.model.Order;
import com.coding.model.Restaurent;
import com.coding.service.DestinationService;
import com.coding.service.OrderService;
import com.coding.service.RestaurentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/restaurent")
public class RestaurentController {

    @Autowired
    RestaurentService restaurentService;

    @Autowired
    DestinationService destinationService;


    @PostMapping("/save")
    public ResponseEntity<?> addRestaurent(@Valid @RequestBody Restaurent restaurent){
        if(restaurent != null){
            if(restaurent.getDishes().size()>0){
                try {
                    restaurent = restaurentService.addRestaurent(restaurent);
                    return ResponseEntity.status(HttpStatus.CREATED).body(restaurent);
                }catch(Exception e){
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong");
                }
            }
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please add food item available in restaurent");
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("restaurent can not be null");
    }

//    @GetMapping("/get/{id}")
//    public ResponseEntity<?> getRestaurent(@PathVariable Long id){
//        if(id != null){
//            try {
//                Restaurent restaurent = restaurentService.getRestaurent(id);
//                return ResponseEntity.status(HttpStatus.OK).body(restaurent);
//            }catch(Exception e){
//                e.printStackTrace();
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong");
//            }
//        }
//        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id can not be null");
//    }


    @PutMapping("/save")
    public ResponseEntity<?> updateRestaurent(@Valid @RequestBody Restaurent restaurent){
        if(restaurent != null){
            if(restaurent.getDishes().size()>0){
                try {
                    restaurent = restaurentService.updateRestaurent(restaurent);
                    return ResponseEntity.status(HttpStatus.OK).body(restaurent);
                }catch(Exception e){
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong");
                }
            }
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please add food item for Restaurent");
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Restaurent can not be null");
    }
    @DeleteMapping("/remove")
    public ResponseEntity<?> deleteOrder(@Valid @RequestBody Restaurent restaurent){
        if(restaurent != null){
            if(restaurent.getId() != null){
                try{
                    restaurent = restaurentService.removeRestaurent(restaurent);
                    return ResponseEntity.status(HttpStatus.OK).body(restaurent);
                }catch(Exception e) {
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong");
                }
            }
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Restaurent id can't be blank");
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Restaurent can not be null");
    }

    @GetMapping("/get/{price}/{rating}")
    public ResponseEntity<?> getRestaurentByRatingAndPrice(@PathVariable(name = "price") Double price,@PathVariable(name = "rating") Integer rating){
        if(price != null || rating !=null){
            try {
                List<Restaurent> restaurent = restaurentService.getRestaurentByRatingAndPrice(rating,price);

                return ResponseEntity.status(HttpStatus.OK).body(restaurent);
            }catch(Exception e){
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong");
            }
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id can not be null");
    }

    @GetMapping("/get/{destination}")
    public ResponseEntity<?> getRestaurentByDest(@PathVariable(name = "destination") String destName){
        if(destName !=null){
            try {
                DestinationLocation destination = destinationService.getbyName(destName);

                return ResponseEntity.status(HttpStatus.OK).body(destination.getRestaurentList());
            }catch(Exception e){
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong");
            }
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("destId can not be null");
    }


}
