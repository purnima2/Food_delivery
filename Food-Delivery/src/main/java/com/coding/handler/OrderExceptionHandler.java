package com.coding.handler;

import com.coding.exception.OrderNotCreated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderExceptionHandler {

        @ExceptionHandler(OrderNotCreated.class)
    public ResponseEntity<?> fieldMissing(OrderNotCreated ex) {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order Not created");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> fieldMissing(Exception ex) {
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
    }


}
