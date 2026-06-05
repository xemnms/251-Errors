package com.bautista.grasp.entity;

// OCP: New payment type added without modifying existing Payment interface or other implementations
// LSP: Fully substitutable for any Payment reference
public class GCashPayment implements Payment {

    @Override
    public String process(double amount) {
        return String.format(
                "[PAYMENT SUCCESS] method=GCASH | amount=%.2f | status=SUCCESS",
                amount
        );
    }
}
