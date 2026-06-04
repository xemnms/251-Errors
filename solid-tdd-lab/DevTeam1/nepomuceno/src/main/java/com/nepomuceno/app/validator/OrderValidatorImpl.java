package com.nepomuceno.app.validator;

import com.nepomuceno.app.dto.ItemDto;
import com.nepomuceno.app.dto.OrderRequest;
import org.springframework.stereotype.Component;

// SOLID: SRP - only responsible for validating order input data
// SOLID: OCP - new rules can be added here without touching OrderService
// DRY: All validation rules are centralised here, not duplicated across the codebase
//
// BEFORE (rules scattered inline inside OrderService):
//   if (request.getItems() == null || request.getItems().isEmpty()) {
//       throw new IllegalArgumentException("Order must have at least one item.");
//   }
//   if (item.getPrice() < 0 || item.getQuantity() <= 0) {
//       throw new IllegalArgumentException("Invalid item: " + item.getName());
//   }
//
// AFTER (all rules in one place, OrderService stays clean):
//   orderValidator.validateRequest(request);
//   orderValidator.validateItem(item);
@Component
public class OrderValidatorImpl implements OrderValidator {

    @Override
    public void validateRequest(OrderRequest request) {
        if (request.getItems() == null) {          // ← must be first
            throw new IllegalArgumentException("Item list must not be null");
        }
        if (request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Item list must not be empty");
        }
        for (ItemDto item : request.getItems()) {
            validateItem(item);
        }
    }

    @Override
    public void validateItem(ItemDto item) {
        if (item.getPrice() <= 0) {
            throw new IllegalArgumentException(
                    "Item price must be greater than zero: " + item.getName());
        }
        if (item.getQuantity() <= 0) {
            throw new IllegalArgumentException(
                    "Item quantity must be greater than zero: " + item.getName());
        }
    }

}