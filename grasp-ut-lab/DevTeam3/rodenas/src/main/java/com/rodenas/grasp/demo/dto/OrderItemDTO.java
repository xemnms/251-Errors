package com.rodenas.grasp.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class OrderItemDTO {

    @NotBlank(message = "Menu item name is required")
    private String menuItemName;

    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

    @Min(value = 1, message = "Quantity must be at least 1")
    private int quantity;

    public OrderItemDTO() {}

    public OrderItemDTO(String menuItemName, double price, int quantity) {
        this.menuItemName = menuItemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getMenuItemName() { return menuItemName; }
    public void setMenuItemName(String m) { this.menuItemName = m; }
    public double getPrice() { return price; }
    public void setPrice(double p) { this.price = p; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int q) { this.quantity = q; }
}