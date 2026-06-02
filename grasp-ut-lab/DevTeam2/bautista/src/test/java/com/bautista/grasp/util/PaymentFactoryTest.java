package com.bautista.grasp.util;

import com.bautista.grasp.entity.CardPayment;
import com.bautista.grasp.entity.Payment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentFactoryTest {

    @Test
    void shouldReturnCardPayment() {

        Payment payment = PaymentFactory.getPayment("CARD");

        assertTrue(payment instanceof CardPayment);
    }

    @Test
    void shouldThrowOnInvalidType() {

        assertThrows(IllegalArgumentException.class,
                () -> PaymentFactory.getPayment("INVALID"));
    }
}