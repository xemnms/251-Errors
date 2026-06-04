package com.acosta.springboot.service;
import com.acosta.springboot.entity.Order;

// GRASP Polymorphism: defines a shared contract all payment types must follow
public interface PaymentProcessor {
    void process(Order order);
}