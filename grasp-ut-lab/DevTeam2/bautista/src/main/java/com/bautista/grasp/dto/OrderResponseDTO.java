package com.bautista.grasp.dto;

public class OrderResponseDTO {

    private Long orderId;
    private double totalAmount;

    public OrderResponseDTO() {
    }

    public OrderResponseDTO(Long orderId, double totalAmount) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}