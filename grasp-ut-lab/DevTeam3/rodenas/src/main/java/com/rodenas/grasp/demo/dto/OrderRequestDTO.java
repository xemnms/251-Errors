package com.rodenas.grasp.demo.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class OrderRequestDTO {

    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Payment method is required")
    private String paymentMethod;

    private List<OrderItemDTO> items;

    public OrderRequestDTO() {}

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String c) { this.customerName = c; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String p) { this.paymentMethod = p; }
    public List<OrderItemDTO> getItems() { return items; }
    public void setItems(List<OrderItemDTO> items) { this.items = items; }
}