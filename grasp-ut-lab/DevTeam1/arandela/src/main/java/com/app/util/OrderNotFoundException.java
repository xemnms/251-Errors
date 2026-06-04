package com.app.util;

// GRASP: Protected Variations - isolates how errors propagate through the system
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Order not found with id: " + id);
    }
}
