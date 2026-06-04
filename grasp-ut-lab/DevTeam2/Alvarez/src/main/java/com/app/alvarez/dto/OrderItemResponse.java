package com.app.alvarez.dto;

public record OrderItemResponse(
        String productName,
        int quantity,
        double unitPrice,
        double subtotal
) {
}