package com.app.alvarez.service;

import com.app.alvarez.dto.CreateOrderRequest;
import com.app.alvarez.dto.OrderItemRequest;
import com.app.alvarez.exception.InvalidOrderException;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestValidator {

    // GRASP: High Cohesion - validation rules live together instead of being scattered across controller/service code.
    public void validate(CreateOrderRequest request) {
        if (request == null) {
            throw new InvalidOrderException("Order request is required");
        }
        if (isBlank(request.customerName())) {
            throw new InvalidOrderException("Customer name is required");
        }
        validateItems(request.items());
    }

    private void validateItems(List<OrderItemRequest> items) {
        if (items == null || items.isEmpty()) {
            throw new InvalidOrderException("Order must contain at least one item");
        }
        for (OrderItemRequest item : items) {
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
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}