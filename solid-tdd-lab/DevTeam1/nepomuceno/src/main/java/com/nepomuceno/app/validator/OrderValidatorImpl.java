package com.nepomuceno.app.validator;

import com.nepomuceno.app.dto.ItemDto;
import com.nepomuceno.app.dto.OrderRequest;
import org.springframework.stereotype.Component;

// SOLID: SRP - only responsible for validating order input data
// SOLID: OCP - new rules can be added here without touching OrderService
// DRY: All validation rules centralised here; not duplicated across codebase
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
@Component
public class OrderValidatorImpl implements OrderValidator {

    // DRY: error messages defined once as constants — never duplicated
    private static final String NULL_ITEMS       = "Item list must not be null";
    private static final String EMPTY_ITEMS      = "Item list must not be empty";
    private static final String INVALID_PRICE    = "Item price must be greater than zero: ";
    private static final String INVALID_QUANTITY = "Item quantity must be greater than zero: ";

    @Override
    public void validateRequest(OrderRequest request) {
        // null check MUST come before isEmpty() to avoid NullPointerException
        if (request.getItems() == null) {
            throw new IllegalArgumentException(NULL_ITEMS);
        }
        if (request.getItems().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ITEMS);
        }
        // DRY: reuse validateItem — no duplicate price/quantity checks here
        for (ItemDto item : request.getItems()) {
            validateItem(item);
        }
    }

    @Override
    public void validateItem(ItemDto item) {
        if (item.getPrice() <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE + item.getName());
        }
        if (item.getQuantity() <= 0) {
            throw new IllegalArgumentException(INVALID_QUANTITY + item.getName());
        }
    }
}
