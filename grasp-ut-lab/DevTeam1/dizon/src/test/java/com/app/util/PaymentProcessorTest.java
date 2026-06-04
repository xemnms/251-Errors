package com.app.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// GRASP: Polymorphism - testing that different implementations behave correctly through the same interface
class PaymentProcessorTest {

    @Test
    void shouldProcessCreditCardPayment() {
        // Arrange
        PaymentProcessor processor = new CreditCardPaymentProcessor();

        // Act & Assert
        assertDoesNotThrow(() -> processor.process(100.00));
        assertEquals("CREDIT_CARD", processor.getPaymentType());
    }

    @Test
    void shouldProcessCashPayment() {
        // Arrange
        PaymentProcessor processor = new CashPaymentProcessor();

        // Act & Assert
        assertDoesNotThrow(() -> processor.process(50.00));
        assertEquals("CASH", processor.getPaymentType());
    }

    // GRASP: Polymorphism - same interface, different behavior
    @Test
    void shouldHaveDifferentPaymentTypesForDifferentImplementations() {
        PaymentProcessor creditCard = new CreditCardPaymentProcessor();
        PaymentProcessor cash = new CashPaymentProcessor();

        assertNotEquals(creditCard.getPaymentType(), cash.getPaymentType());
    }

    @Test
    void shouldProcessZeroAmountWithoutError() {
        // Edge case: zero amount
        PaymentProcessor processor = new CreditCardPaymentProcessor();
        assertDoesNotThrow(() -> processor.process(0.0));
    }

    @Test
    void shouldProcessLargeAmountWithoutError() {
        // Edge case: large amount
        PaymentProcessor processor = new CashPaymentProcessor();
        assertDoesNotThrow(() -> processor.process(999999.99));
    }
}
