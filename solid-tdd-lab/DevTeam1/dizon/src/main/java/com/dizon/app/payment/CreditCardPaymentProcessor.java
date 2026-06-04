package com.dizon.app.payment;

import org.springframework.stereotype.Component;

// SOLID: LSP - fully honours the PaymentProcessor contract; substitutable for any other.
// SOLID: SRP - knows only how to process a credit card payment.
@Component
public class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public void process(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }

    @Override
    public String getPaymentType() {
        return "CREDIT_CARD";
    }
}
