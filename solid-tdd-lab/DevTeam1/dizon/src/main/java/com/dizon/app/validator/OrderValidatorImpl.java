package com.dizon.app.validator;

import com.dizon.app.dto.OrderItemRequest;
import com.dizon.app.dto.OrderRequest;
import com.dizon.app.exception.InvalidOrderException;
import org.springframework.stereotype.Component;

// SOLID: SRP - this class has ONE reason to change: the order validation rules.
//        BEFORE, these checks were inline `if` statements buried inside OrderService.
@Component
public class OrderValidatorImpl implements OrderValidator {

    @Override
    public void validate(OrderRequest request) {
        if (request == null) {
            throw new InvalidOrderException("Order request must not be null");
        }
        // DRY: a single private helper expresses the "required text" rule once.
        requireText(request.customerName(), "Customer name must not be empty");

        for (OrderItemRequest item : request.items()) {
            requireText(item.productName(), "Product name must not be empty");
            if (item.price() < 0) {
                throw new InvalidOrderException("Price must not be negative: " + item.productName());
            }
            if (item.quantity() <= 0) {
                throw new InvalidOrderException("Quantity must be greater than zero: " + item.productName());
            }
        }
    }

    // DRY: shared reusable validation method (KISS - small and obvious).
    private void requireText(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new InvalidOrderException(message);
        }
    }
}
