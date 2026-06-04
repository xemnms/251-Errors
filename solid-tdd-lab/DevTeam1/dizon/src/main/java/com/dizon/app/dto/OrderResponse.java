package com.dizon.app.dto;

import com.dizon.app.entity.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;

// OOP: IMMUTABILITY - immutable response record. BEFORE this was a mutable class whose
// items list was filled in via a setter AFTER construction; AFTER the object is fully
// built in one shot and the items list is defensively copied to an unmodifiable view.
// BONUS: DTO pattern - the entity (Order) is never exposed directly to the web layer.
public record OrderResponse(
        Long id,
        String customerName,
        OrderStatus status,
        double total,
        LocalDateTime createdAt,
        List<OrderItemRequest> items
) {
    public OrderResponse {
        items = (items == null) ? List.of() : List.copyOf(items);
    }
}
