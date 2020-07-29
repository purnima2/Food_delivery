package com.coding.controller;

import com.coding.model.Order;
import com.coding.model.OrderSummary;
import com.coding.service.OrderService;
import com.coding.util.PriceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/summary")
public class OrderSummaryController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderSummary orderSummary;
    @Autowired
    PriceUtil util;

    @GetMapping("/order/{orderid}")
    public ResponseEntity<?> getOrderSummary(@PathVariable Long orderId){
        if(orderId != null){
            Order order = orderService.readOrder(orderId);
            orderSummary.setOrderid(order.getOrderId());
            orderSummary.setRestaurentName(order.getRestaurent().getName());
            orderSummary.setTotalPrice(order.getPrice());
            orderSummary.setItemList(order.getDishList());
            return ResponseEntity.status(HttpStatus.OK).body(orderSummary);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("orderId can not be null");
    }
}
