package com.coding.controller;

import com.coding.model.DestinationLocation;
import com.coding.model.Origin;
import com.coding.model.Restaurent;
import com.coding.service.OriginService;
import com.coding.service.RestaurentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/location")
public class OriginController {

    @Autowired
    OriginService originService;
    @Autowired
    RestaurentService restaurentService;


    @GetMapping("/origin")
    public ResponseEntity<?> getRestaurentList(@PathVariable Long originId){

        if(originId != null){
            Origin origin = originService.getOrigin(originId);
            List<DestinationLocation> locationList = origin.getDestList();
            List<Restaurent> restList = new ArrayList<>();
            for(DestinationLocation loc:locationList){
                restList.addAll(loc.getRestaurentList());
            }
            return ResponseEntity.status(HttpStatus.OK).body(restList);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Origin can not be null");
    }
}
