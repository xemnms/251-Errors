package com.app.alvarez.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record OrderItemRequest(
        @NotBlank String productName,
        @Min(1) int quantity,
        @Positive double unitPrice
) {
}