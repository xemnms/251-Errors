package com.app.util;

import com.app.dto.CreateOrderRequest;
import com.app.dto.OrderItemRequest;
import com.app.exception.InvalidOrderException;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator implements OrderValidation {

    // GRASP: High Cohesion - validation rules live in one focused validation component.
    @Override
    public void validate(CreateOrderRequest request) {
        if (request == null) {
            throw new InvalidOrderException("Order request is required");
        }
        if (isBlank(request.customerName())) {
            throw new InvalidOrderException("Customer name is required");
        }
        if (isBlank(request.paymentMethod())) {
            throw new InvalidOrderException("Payment method is required");
        }
        if (request.items() == null || request.items().isEmpty()) {
            throw new InvalidOrderException("Order must contain at least one item");
        }
        request.items().forEach(this::validateItem);
    }

    private void validateItem(OrderItemRequest item) {
        if (item == null) {
            throw new InvalidOrderException("Order item is required");
        }
        if (isBlank(item.productName())) {
            throw new InvalidOrderException("Product name is required");
        }
        if (item.quantity() <= 0) {
            throw new InvalidOrderException("Quantity must be greater than zero");
        }
        if (item.unitPrice() <= 0) {
            throw new InvalidOrderException("Unit price must be greater than zero");
        }
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}
