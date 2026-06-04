package com.dizon.app.payment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * OCP proof: PaymentService routes to the right processor with no if/else chain.
 * A brand-new processor (the anonymous "GCASH" one below) is wired in WITHOUT changing
 * PaymentService at all - demonstrating the class is closed for modification but the
 * behaviour set is open for extension.
 */
@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Test
    void shouldRouteToMatchingProcessor() {
        PaymentProcessor cash = mock(PaymentProcessor.class);
        when(cash.getPaymentType()).thenReturn("CASH");
        PaymentProcessor card = mock(PaymentProcessor.class);
        when(card.getPaymentType()).thenReturn("CREDIT_CARD");

        PaymentService service = new PaymentService(List.of(cash, card));
        service.processPayment("CREDIT_CARD", 250.0);

        verify(card).process(250.0);
        verify(cash, never()).process(anyDouble());
    }

    // OCP: a new payment type added with ZERO changes to PaymentService.
    @Test
    void shouldSupportNewlyAddedProcessor_withoutModifyingService() {
        PaymentProcessor gcash = new PaymentProcessor() {
            @Override public void process(double amount) { /* no-op */ }
            @Override public String getPaymentType() { return "GCASH"; }
        };

        PaymentService service = new PaymentService(List.of(new CashPaymentProcessor(), gcash));

        assertTrue(service.supportedTypes().contains("GCASH"));
        assertDoesNotThrow(() -> service.processPayment("GCASH", 75.0));
    }

    // Edge case: unsupported payment type.
    @Test
    void shouldThrow_forUnsupportedType() {
        PaymentService service = new PaymentService(List.of(new CashPaymentProcessor()));

        assertThrows(IllegalArgumentException.class,
                () -> service.processPayment("BITCOIN", 10.0));
    }
}
