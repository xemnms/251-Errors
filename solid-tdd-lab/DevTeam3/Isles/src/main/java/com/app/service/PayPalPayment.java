package com.app.service;

import org.springframework.stereotype.Component;

@Component
public class PayPalPayment implements Payment {

    @Override
    public String method() {
        return "PAYPAL";
    }

    @Override
    public PaymentReceipt process(double amount) {
        return new PaymentReceipt("paypal", amount, "APPROVED");
    }
}
