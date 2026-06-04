package com.bautista.grasp.service;

import com.bautista.grasp.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    // GRASP: Polymorphism - behavior depends on implementation
    public void processPayment(Payment payment, double amount) {
        payment.process(amount);
    }
}