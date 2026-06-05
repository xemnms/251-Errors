package com.bautista.grasp.util;

import com.bautista.grasp.entity.*;
import com.bautista.grasp.service.PaymentProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    // DIP: referencing via the interface, not the concrete PaymentFactory directly
    private final PaymentProvider factory = new PaymentFactory();

    @Test
    void shouldReturnCardPayment() {

        Payment payment = factory.getPayment("CARD");

        assertInstanceOf(CardPayment.class, payment);
    }

    @Test
    void shouldReturnCashPayment() {

        Payment payment = factory.getPayment("CASH");

        assertInstanceOf(CashPayment.class, payment);
    }

    @Test
    void shouldReturnGCashPayment() {

        // OCP proof: GCash was added to the registry without touching any existing class
        Payment payment = factory.getPayment("GCASH");

        assertInstanceOf(GCashPayment.class, payment);
    }

    @Test
    void shouldBeCaseInsensitive() {

        // Edge case: lowercase input should resolve correctly
        Payment payment = factory.getPayment("card");

        assertInstanceOf(CardPayment.class, payment);
    }

    @Test
    void shouldThrowOnInvalidType() {

        assertThrows(IllegalArgumentException.class,
                () -> factory.getPayment("INVALID"));
    }
}