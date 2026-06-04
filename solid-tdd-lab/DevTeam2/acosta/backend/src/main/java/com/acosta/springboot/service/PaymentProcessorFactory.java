package com.acosta.springboot.service;

// SOLID: DIP - OrderService depends on this abstraction, not the concrete factory
// SOLID: ISP - Small focused interface, one method only
// GRASP: Protected Variations - shields OrderService from factory implementation changes
public interface PaymentProcessorFactory {
    PaymentProcessor getProcessor(String paymentMethod);
}