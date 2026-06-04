package com.bautista.grasp.entity;

/*
 * GRASP: Polymorphism implementation
 */
public class CashPayment implements Payment {

    @Override
    public String process(double amount) {
        return String.format(
                "[PAYMENT SUCCESS] method=CASH | amount=%.2f | status=SUCCESS",
                amount
        );
    }
}