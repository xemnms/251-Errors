package com.rodenas.grasp.demo.payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {

    @Test
    void shouldProcessAllPaymentTypes() {
        PaymentProcessor cash = new CashPaymentProcessor();
        PaymentProcessor gcash = new GCashPaymentProcessor();
        PaymentProcessor card = new CardPaymentProcessor();

        assertTrue(cash.process(100.0));
        assertEquals("CASH", cash.getPaymentMethod());
        assertTrue(cash.getReceipt(100.0).contains("CASH"));

        assertTrue(gcash.process(150.0));
        assertEquals("GCASH", gcash.getPaymentMethod());
        assertTrue(gcash.getReceipt(150.0).contains("GCASH"));

        assertTrue(card.process(200.0));
        assertEquals("CARD", card.getPaymentMethod());
        assertTrue(card.getReceipt(200.0).contains("CARD"));
    }
}
