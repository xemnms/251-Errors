package com.app.dto;

// GRASP: High Cohesion - only carries data between layers
public class OrderDTO {
    private String customerName;
    private String paymentType;

    public OrderDTO() {}
    public OrderDTO(String customerName, String paymentType) {
        this.customerName = customerName;
        this.paymentType = paymentType;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getPaymentType() { return paymentType; }
    public void setPaymentType(String paymentType) { this.paymentType = paymentType; }
}
