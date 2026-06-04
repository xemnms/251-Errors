package com.dizon.app.exception;

// BONUS: custom exception handling. Carries domain meaning ("order not found")
// instead of leaking a raw NoSuchElementException to callers.
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(Long id) {
        super("Order not found with id: " + id);
    }
}
