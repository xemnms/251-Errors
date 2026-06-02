package com.app.alvarez.dto;

import com.app.alvarez.entity.OrderStatus;
import java.util.List;

public record OrderResponse(
        Long id,
        String customerName,
        OrderStatus status,
        List<OrderItemResponse> items,
        double total
) {
}