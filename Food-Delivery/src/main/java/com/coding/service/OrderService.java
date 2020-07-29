package com.coding.service;

import com.coding.model.Customer;
import com.coding.model.Order;

public interface OrderService {
    public Order createOrder(Order order);
    public Order readOrder(Long orderId);
    public Order updateOrder(Order order);
    public Order deleteOrder(Order order);

}
