package com.bautista.grasp.service;

import com.bautista.grasp.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

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

    @Test
    void shouldProcessGCashPayment() {

        // OCP: GCashPayment added without touching CardPayment or CashPayment
        Payment payment = new GCashPayment();

        String result = payment.process(750.0);

        assertTrue(result.contains("GCASH"));
        assertTrue(result.contains("SUCCESS"));
    }

    @Test
    void shouldAllPaymentImplementationsBeSubstitutableForLSP() {

        // LSP: every concrete Payment must work correctly when referenced as Payment
        List<Payment> payments = List.of(
                new CardPayment(),
                new CashPayment(),
                new GCashPayment()
        );

        for (Payment payment : payments) {
            String result = payment.process(100.0);
            assertNotNull(result, "No Payment implementation should return null");
            assertTrue(result.contains("SUCCESS"), "All implementations must honor the SUCCESS contract");
        }
    }

    // Parameterized test: proves all payment types share a consistent behavioral contract
    @ParameterizedTest
    @MethodSource("paymentImplementations")
    void shouldAllPaymentsContainMethodNameAndSuccess(Payment payment, String expectedMethod) {

        String result = payment.process(200.0);

        assertTrue(result.contains(expectedMethod));
        assertTrue(result.contains("SUCCESS"));
    }

    static Stream<Arguments> paymentImplementations() {
        return Stream.of(
                Arguments.of(new CardPayment(), "CARD"),
                Arguments.of(new CashPayment(), "CASH"),
                Arguments.of(new GCashPayment(), "GCASH")
        );
    }
}