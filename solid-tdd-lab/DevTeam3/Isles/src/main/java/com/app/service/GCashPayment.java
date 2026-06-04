package com.app.service;

import org.springframework.stereotype.Component;

@Component
public class GCashPayment implements Payment {

    @Override
    public String method() {
        return "GCASH";
    }

    @Override
    public PaymentReceipt process(double amount) {
        return new PaymentReceipt("gcash", amount, "APPROVED");
    }
}
