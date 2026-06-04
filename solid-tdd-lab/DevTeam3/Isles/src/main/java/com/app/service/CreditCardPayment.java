package com.app.service;

import org.springframework.stereotype.Component;

@Component
public class CreditCardPayment implements Payment {

    @Override
    public String method() {
        return "CREDIT_CARD";
    }

    @Override
    public PaymentReceipt process(double amount) {
        return new PaymentReceipt("credit-card", amount, "APPROVED");
    }
}
