package com.bautista.grasp.service;

import com.bautista.grasp.dto.OrderRequestDTO;
import org.springframework.stereotype.Component;

// SRP: Only responsible for validating order input - no business logic, no persistence
// DIP: Implements OrderValidator abstraction so it can be swapped or mocked in tests
@Component
public class OrderValidatorImpl implements OrderValidator {

    @Override
    public void validate(OrderRequestDTO request) {
        if (request == null) {
            throw new IllegalArgumentException("Order request cannot be null");
        }

        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }

        // DRY: single place where quantity rules are enforced
        request.getItems().forEach(item -> {
            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Item quantity must be greater than zero");
            }
        });
    }
}
