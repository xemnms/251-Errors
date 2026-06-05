package com.bautista.grasp.service;

import com.bautista.grasp.dto.OrderRequestDTO;
import com.bautista.grasp.dto.OrderResponseDTO;

// ISP: Interface segregated - payment processing moved to PaymentService
// SRP: This interface is focused only on order lifecycle (creation and retrieval)
public interface OrderService {

    OrderResponseDTO createOrder(OrderRequestDTO request);

    double getOrderTotal(Long orderId);
}