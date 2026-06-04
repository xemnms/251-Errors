package com.nepomuceno.app.mapper;

import com.nepomuceno.app.dto.OrderResponse;
import com.nepomuceno.app.entity.Order;

// SOLID: DIP - service depends on this abstraction, not on a concrete mapper class
// SOLID: ISP - small, focused interface with a single mapping concern
//
// BEFORE (no interface — mapping was hardcoded inside OrderService):
//   private OrderResponse toResponse(Order order) {
//       double total = order.calculateTotal();
//       return new OrderResponse(..., PriceFormatter.format(total));
//   }
//
// AFTER (interface extracted):
//   OrderService depends on OrderMapper (abstraction)
//   OrderMapperImpl provides the concrete implementation
//
// WHY: With DIP, we can swap or mock the mapper in tests without
// touching OrderService. It also gives OrderService one fewer reason to change.
public interface OrderMapper {

    // Maps a domain Order entity to an API-safe OrderResponse DTO
    OrderResponse toResponse(Order order);
}
