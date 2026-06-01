package com.alonde.app.dto;

import jakarta.validation.constraints.*;
import java.util.List;

// grasp: low coupling - controller depends on this dto, not on order entity directly
public class CreateOrderRequest {

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Payment type is required")
    private String paymentType;   // "credit_card", "cash", "gcash"

    @NotEmpty(message = "Order must have at least one item")
    private List<OrderItemRequest> items;

    public String getCustomerName()              { return customerName; }
    public void setCustomerName(String n)        { this.customerName = n; }
    public String getPaymentType()               { return paymentType; }
    public void setPaymentType(String t)         { this.paymentType = t; }
    public List<OrderItemRequest> getItems()     { return items; }
    public void setItems(List<OrderItemRequest> i){ this.items = i; }
}