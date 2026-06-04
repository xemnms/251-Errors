package com.bautista.grasp.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void shouldProcessCardPayment() {

        Payment payment = new CardPayment();

        String result = payment.process(1000);

        assertTrue(result.contains("CARD"));
        assertTrue(result.contains("1000"));
    }

    @Test
    void shouldProcessCashPayment() {

        Payment payment = new CashPayment();

        String result = payment.process(500);

        assertTrue(result.contains("CASH"));
    }
}