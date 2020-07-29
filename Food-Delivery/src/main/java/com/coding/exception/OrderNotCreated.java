package com.coding.exception;

public class OrderNotCreated extends RuntimeException {
    public OrderNotCreated() {

        super("Unable to create order");
    }
    public OrderNotCreated(String message) {

        super(message);
    }
}
