package com.app.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void shouldProcessCashPayment() {

        Payment payment =
                new CashPayment();

        assertDoesNotThrow(
                payment::process
        );
    }

    @Test
    void shouldProcessCreditCardPayment() {

        Payment payment =
                new CreditCardPayment();

        assertDoesNotThrow(
                payment::process
        );
    }
}