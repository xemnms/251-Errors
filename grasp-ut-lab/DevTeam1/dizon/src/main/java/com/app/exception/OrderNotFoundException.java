package com.app.exception;

// GRASP: Protected Variations - custom exception shields callers from internal error details
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Order not found with id: " + id);
    }
}
