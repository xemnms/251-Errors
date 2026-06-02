package com.acosta.springboot.service;

import com.acosta.springboot.entity.Order;
import org.springframework.stereotype.Component;

// SOLID: OCP - New payment type added WITHOUT modifying OrderService
// SOLID: LSP - Fully substitutable for PaymentProcessor interface
// GRASP: Polymorphism - Same interface, GCash-specific behavior
@Component
public class GCashPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(Order order) {
        System.out.println("GCash payment received. Total: " + order.calculateTotal());
        order.setStatus("COMPLETED");
    }
}