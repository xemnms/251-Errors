package com.acosta.springboot.service;
import com.acosta.springboot.entity.Order;
import org.springframework.stereotype.Component;

// GRASP: Polymorphism - this is the CASH version of PaymentProcessor

@Component
public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(Order order) {

        System.out.println("Cash payment received. Total: " + order.calculateTotal());
        order.setStatus("COMPLETED");
    }
}