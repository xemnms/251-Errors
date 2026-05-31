package com.alonde.app.dto;

import jakarta.validation.constraints.*;

public class OrderItemRequest {

    @NotBlank private String productName;
    @Positive private int quantity;
    @Positive private Double unitPrice;

    public String getProductName()          { return productName; }
    public void setProductName(String n)    { this.productName = n; }
    public int getQuantity()               { return quantity; }
    public void setQuantity(int q)        { this.quantity = q; }
    public Double getUnitPrice()           { return unitPrice; }
    public void setUnitPrice(Double p)     { this.unitPrice = p; }
}
