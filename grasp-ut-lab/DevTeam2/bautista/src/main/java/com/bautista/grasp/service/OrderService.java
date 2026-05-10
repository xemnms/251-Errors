package com.bautista.grasp.service;

import com.bautista.grasp.dto.OrderRequestDTO;
import com.bautista.grasp.dto.OrderResponseDTO;

public interface OrderService {

    OrderResponseDTO createOrder(OrderRequestDTO request);

    double getOrderTotal(Long orderId);

    String processPayment(Long orderId, String paymentType);
}