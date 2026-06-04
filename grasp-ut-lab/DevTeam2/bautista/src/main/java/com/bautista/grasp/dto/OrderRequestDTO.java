package com.bautista.grasp.dto;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/*
 * GRASP: Protected Variations (input boundary protection)
 */
public class OrderRequestDTO {

    @NotEmpty(message = "Order must contain at least one item")
    private List<OrderItemDTO> items;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(List<OrderItemDTO> items) {
        this.items = items;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}