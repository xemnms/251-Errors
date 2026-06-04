package com.acosta.springboot.service;

import com.acosta.springboot.dto.OrderRequest;
import org.springframework.stereotype.Component;

// SOLID: SRP - Only job is to validate incoming order requests
// DRY: Validation logic centralized here, not scattered across the service
@Component
public class OrderValidatorImpl implements OrderValidator {

    @Override
    public void validate(OrderRequest request) {
        if (request.getCustomerName() == null || request.getCustomerName().isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have at least one item");
        }
    }
}