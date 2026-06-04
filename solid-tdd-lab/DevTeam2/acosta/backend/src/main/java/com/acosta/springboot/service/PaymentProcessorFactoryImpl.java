package com.acosta.springboot.service;

import org.springframework.stereotype.Component;

// SOLID: OCP - Add new payment types here only, nothing else changes
// SOLID: SRP - Only job is to return the correct processor
// GRASP: Protected Variations - shields OrderService from payment type changes
@Component
public class PaymentProcessorFactoryImpl implements PaymentProcessorFactory {

    private final CashPaymentProcessor cashProcessor;
    private final GCashPaymentProcessor gcashProcessor;

    // DIP: Concrete processors injected by Spring, not created here
    public PaymentProcessorFactoryImpl(CashPaymentProcessor cashProcessor,
            GCashPaymentProcessor gcashProcessor) {
        this.cashProcessor = cashProcessor;
        this.gcashProcessor = gcashProcessor;
    }

    // OCP: To add CardPayment, just add a new case here — nothing else touched
    @Override
    public PaymentProcessor getProcessor(String paymentMethod) {
        return switch (paymentMethod.toUpperCase()) {
            case "CASH" -> cashProcessor;
            case "GCASH" -> gcashProcessor;
            default -> throw new IllegalArgumentException(
                    "Unknown payment method: " + paymentMethod);
        };
    }
}