package com.rodenas.grasp.demo.exception;

// GRASP: Protected Variations - shields service from generic errors
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Order #" + id + " not found in Kaydonalds system!");
    }
}