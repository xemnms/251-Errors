package com.app.dto;

import java.util.List;

public record OrderResponse(
        Long id,
        String customerName,
        List<OrderItemResponse> items,
        double total
) {
    public OrderResponse {
        // Immutability: defensive copy prevents callers from mutating response state.
        items = List.copyOf(items);
    }
}
