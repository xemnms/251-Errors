package com.app.dto;

import com.app.entity.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {

    private Long id;
    private String customerName;
    private OrderStatus status;
    private double total;
    private LocalDateTime createdAt;
    private List<OrderItemRequest> items;

    public OrderResponse() {}

    public OrderResponse(Long id, String customerName, OrderStatus status, double total, LocalDateTime createdAt) {
        this.id = id;
        this.customerName = customerName;
        this.status = status;
        this.total = total;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public List<OrderItemRequest> getItems() { return items; }
    public void setItems(List<OrderItemRequest> items) { this.items = items; }
}
