package com.acosta.springboot.dto;
import com.acosta.springboot.entity.Order;

// GRASP Low Coupling: client receives a clean DTO, not a raw database entity

public class OrderResponse {

    private Long id;
    private String customerName;
    private String status;
    private double total;
    private int itemCount;

    public OrderResponse() {}

    // A static factory method: converts an Order entity to OrderResponse DTO
    public static OrderResponse fromEntity(Order order) {
        OrderResponse response = new OrderResponse();
        response.id = order.getId();
        response.customerName = order.getCustomerName();
        response.status = order.getStatus();
        response.total = order.calculateTotal();
        response.itemCount = order.getItems().size();
        return response;
    }

    //Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public int getItemCount() { return itemCount; }
    public void setItemCount(int itemCount) { this.itemCount = itemCount; }
}