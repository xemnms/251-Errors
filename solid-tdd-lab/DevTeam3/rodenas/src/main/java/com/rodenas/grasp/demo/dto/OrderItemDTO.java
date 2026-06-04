package com.rodenas.grasp.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record OrderItemDTO(
        @NotBlank(message = "Menu item name is required")
        String menuItemName,

        @Min(value = 1, message = "Price must be greater than 0")
        double price,

        @Min(value = 1, message = "Quantity must be at least 1")
        int quantity
) {
}
