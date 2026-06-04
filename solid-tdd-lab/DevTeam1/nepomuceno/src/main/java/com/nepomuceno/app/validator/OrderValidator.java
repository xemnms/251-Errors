package com.nepomuceno.app.validator;

import com.nepomuceno.app.dto.ItemDto;
import com.nepomuceno.app.dto.OrderRequest;

// SOLID: SRP - validation is its own concern, separate from business logic
// SOLID: DIP - OrderService depends on this abstraction, not on a concrete validator
// SOLID: ISP - small focused interface; callers only see what they need
//
// BEFORE (validation was inline inside OrderService.createOrder()):
//   if (request.getItems() == null || request.getItems().isEmpty()) {
//       throw new IllegalArgumentException("Order must have at least one item.");
//   }
//   for (ItemDto item : request.getItems()) {
//       if (item.getPrice() < 0 || item.getQuantity() <= 0) { ... }
//   }
//
// AFTER (extracted to a dedicated validator abstraction):
//   orderValidator.validateRequest(request);
//   orderValidator.validateItem(item);
//
// WHY: Separating validation means OrderService has one fewer reason to change.
// It also makes validation rules independently testable and swappable.
public interface OrderValidator {

    // Validates the overall request (e.g. non-null, non-empty items list)
    void validateRequest(OrderRequest request);

    // Validates a single item (e.g. positive price, positive quantity)
    void validateItem(ItemDto item);
}
