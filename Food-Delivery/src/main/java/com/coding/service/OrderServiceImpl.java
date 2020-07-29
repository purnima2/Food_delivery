package com.coding.service;

import com.coding.model.Order;
import com.coding.repository.OrderRepository;
import com.coding.util.PriceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PriceUtil util;

    @Override
    public Order createOrder(Order order) {
        if(order!=null && order.getDishList().size() > 0 &&order.getRestaurent()!=null){
            order = orderRepository.save(order);
            return order;
        }
        return null;
    }

    @Override
    public Order readOrder(Long orderId) {
        Order order;
        if(orderId != null){
            order = orderRepository.getOne(orderId);
            return order;
        }
        return null;
    }

    @Override
    public Order updateOrder(Order order) {
        if(order !=null && order.getOrderId() != null){
            Order oldOrder = orderRepository.getOne(order.getOrderId());
            oldOrder.setPrice(order.getPrice());
            oldOrder.setDishList(order.getDishList());
            oldOrder.setRestaurent(order.getRestaurent());
            return orderRepository.save(oldOrder);
        }
        return null;
    }

    @Override
    public Order deleteOrder(Order order) {
        if(order != null && order.getOrderId() != null){
            orderRepository.delete(order);
            return order;
        }
        return null;
    }
}
