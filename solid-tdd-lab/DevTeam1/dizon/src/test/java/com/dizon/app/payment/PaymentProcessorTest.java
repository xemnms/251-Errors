package com.dizon.app.payment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * POLYMORPHISM + LSP tests: multiple PaymentProcessor implementations are exercised
 * through the SAME interface reference and must all behave correctly and be substitutable.
 */
class PaymentProcessorTest {

    @Test
    void cashAndCreditCard_haveDistinctTypes() {
        PaymentProcessor cash = new CashPaymentProcessor();
        PaymentProcessor card = new CreditCardPaymentProcessor();

        assertEquals("CASH", cash.getPaymentType());
        assertEquals("CREDIT_CARD", card.getPaymentType());
        assertNotEquals(cash.getPaymentType(), card.getPaymentType());
    }

    // LSP: every implementation must process a normal amount without throwing,
    // proving they are all safely substitutable for the PaymentProcessor type.
    // (BONUS: parameterized over all implementations.)
    @ParameterizedTest
    @MethodSource("allProcessors")
    void everyProcessor_handlesValidAmount(PaymentProcessor processor) {
        assertDoesNotThrow(() -> processor.process(100.00));
        assertNotNull(processor.getPaymentType());
    }

    @ParameterizedTest
    @MethodSource("allProcessors")
    void everyProcessor_handlesEdgeAmounts(PaymentProcessor processor) {
        assertDoesNotThrow(() -> processor.process(0.0));         // edge: zero
        assertDoesNotThrow(() -> processor.process(999_999.99));  // edge: large
    }

    static Stream<PaymentProcessor> allProcessors() {
        return Stream.of(new CashPaymentProcessor(), new CreditCardPaymentProcessor());
    }
}
