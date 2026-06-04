package com.dizon.app.mapper;

import com.dizon.app.dto.OrderResponse;
import com.dizon.app.entity.Order;

// SOLID: ISP - tiny focused interface (one mapping responsibility).
// SOLID: DIP - OrderService depends on this abstraction for entity->DTO conversion.
public interface OrderMapper {

    OrderResponse toResponse(Order order);
}
