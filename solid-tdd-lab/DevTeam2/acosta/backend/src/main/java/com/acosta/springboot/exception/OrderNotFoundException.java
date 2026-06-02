package com.acosta.springboot.exception;

// SOLID: SRP - This class only represents one specific error case
// OOP: Custom exception gives meaningful context over generic RuntimeException
// KISS: Simple, clean, no unnecessary complexity
public class OrderNotFoundException extends RuntimeException {

    private final Long orderId;

    public OrderNotFoundException(Long orderId) {
        super("Order not found: " + orderId);
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }
}