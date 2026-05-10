package com.bautista.grasp.entity;

/*
 * GRASP: Polymorphism implementation
 */
public class CardPayment implements Payment {

    @Override
    public String process(double amount) {
        return String.format(
                "[PAYMENT SUCCESS] method=CARD | amount=%.2f | status=SUCCESS",
                amount
        );
    }
}