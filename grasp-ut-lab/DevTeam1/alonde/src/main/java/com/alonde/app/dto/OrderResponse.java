package com.alonde.app.dto;

public class OrderResponse {
    private Long id;
    private String customerName;
    private String status;
    private String paymentType;
    private double total;

    public OrderResponse(Long id, String customerName, String status,
                         String paymentType, double total) {
        this.id           = id;
        this.customerName = customerName;
        this.status       = status;
        this.paymentType  = paymentType;
        this.total        = total;
    }

    public Long getId()              { return id; }
    public String getCustomerName() { return customerName; }
    public String getStatus()       { return status; }
    public String getPaymentType()  { return paymentType; }
    public double getTotal()        { return total; }
}