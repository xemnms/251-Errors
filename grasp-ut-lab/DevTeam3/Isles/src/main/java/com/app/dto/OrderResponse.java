package com.app.dto;

import java.util.List;

public record OrderResponse(
        Long id,
        String customerName,
        List<OrderItemResponse> items,
        double total
) {
}
