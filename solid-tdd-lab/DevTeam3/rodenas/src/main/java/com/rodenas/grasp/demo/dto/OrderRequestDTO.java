package com.rodenas.grasp.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public record OrderRequestDTO(
        @NotBlank(message = "Customer name is required")
        String customerName,

        @NotBlank(message = "Payment method is required")
        String paymentMethod,

        @Valid
        List<OrderItemDTO> items
) {
}
