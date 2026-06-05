package com.bautista.grasp.service;

// ISP: Segregated from OrderService - this interface only handles payment concerns
// SRP: Not mixed with order creation or retrieval logic
public interface PaymentService {

    String processPayment(Long orderId, String paymentType);
}