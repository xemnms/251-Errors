package com.app.dto;

import java.util.List;

public record CreateOrderRequest(
        String customerName,
        String paymentMethod,
        List<OrderItemRequest> items
) {
}
