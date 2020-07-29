package com.coding.controller;

import com.coding.model.Order;
import com.coding.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/save")
    public ResponseEntity<?> createOrder(@Valid @RequestBody Order order){
        if(order != null){
            if(order.getDishList().size() > 0){
                try {
                    order = orderService.createOrder(order);
                    return ResponseEntity.status(HttpStatus.CREATED).body(order);
                }catch(Exception e){
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong");
                }
            }
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please add food item in order");
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order can not be null");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id){
        if(id != null){
            try {
                Order order = orderService.readOrder(id);
                return ResponseEntity.status(HttpStatus.OK).body(order);
            }catch(Exception e){
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong");
            }
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order id can not be null");
    }
    @PutMapping("/save")
    public ResponseEntity<?> updateOrder(@Valid @RequestBody Order order){
        if(order != null){
            if(order.getDishList().size() > 0){
                try {
                    order = orderService.updateOrder(order);
                    return ResponseEntity.status(HttpStatus.OK).body(order);
                }catch(Exception e){
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong");
                }
            }
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please add food item in order");
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order can not be null");
    }
    @DeleteMapping("/remove")
    public ResponseEntity<?> deleteOrder(@Valid @RequestBody Order order){
        if(order != null){
            if(order.getOrderId() != null){
                try{
                    order = orderService.deleteOrder(order);
                    return ResponseEntity.status(HttpStatus.OK).body(order);
                }catch(Exception e) {
                    e.printStackTrace();
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something is wrong");
                }
            }
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order id can't be blank");
        }
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order can not be null");
    }

}
