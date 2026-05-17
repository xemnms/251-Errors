package com.app.dto;

public record OrderItemRequest(
        String productName,
        int quantity,
        double unitPrice
) {
}
