package com.app.dto;

public record OrderItemResponse(
        String productName,
        int quantity,
        double unitPrice,
        double subtotal
) {
}
