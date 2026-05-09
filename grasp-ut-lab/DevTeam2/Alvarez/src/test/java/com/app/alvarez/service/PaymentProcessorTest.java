package com.app.alvarez.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.app.alvarez.entity.PaymentMethod;
import com.app.alvarez.exception.UnsupportedPaymentMethodException;
import java.util.List;
import org.junit.jupiter.api.Test;

class PaymentProcessorTest {

    @Test
    void shouldUseCardProcessorPolymorphically() {
        PaymentProcessor processor = new CardPaymentProcessor();

        assertEquals(PaymentMethod.CARD, processor.supports());
        assertDoesNotThrow(() -> processor.process(10.00));
    }

    @Test
    void shouldUseCashProcessorPolymorphically() {
        PaymentProcessor processor = new CashPaymentProcessor();

        assertEquals(PaymentMethod.CASH, processor.supports());
        assertDoesNotThrow(() -> processor.process(10.00));
    }

    @Test
    void shouldResolveProcessorByMethod() {
        DefaultPaymentProcessorResolver resolver = new DefaultPaymentProcessorResolver(List.of(
                new CardPaymentProcessor(),
                new CashPaymentProcessor()
        ));

        assertEquals(PaymentMethod.CARD, resolver.resolve(PaymentMethod.CARD).supports());
        assertEquals(PaymentMethod.CASH, resolver.resolve(PaymentMethod.CASH).supports());
    }

    @Test
    void shouldRejectMissingProcessor() {
        DefaultPaymentProcessorResolver resolver = new DefaultPaymentProcessorResolver(List.of());

        assertThrows(UnsupportedPaymentMethodException.class, () -> resolver.resolve(PaymentMethod.CARD));
    }
}