package com.app.service;

import com.app.exception.InvalidOrderException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentPolymorphismTest {

    @Test
    void creditCardPaymentShouldProcessUsingItsOwnImplementation() {
        Payment payment = new CreditCardPayment();

        PaymentReceipt receipt = payment.process(50.0);

        assertThat(receipt.provider()).isEqualTo("credit-card");
        assertThat(receipt.status()).isEqualTo("APPROVED");
    }

    @Test
    void payPalPaymentShouldProcessUsingItsOwnImplementation() {
        Payment payment = new PayPalPayment();

        PaymentReceipt receipt = payment.process(75.0);

        assertThat(receipt.provider()).isEqualTo("paypal");
        assertThat(receipt.amount()).isEqualTo(75.0);
    }

    @Test
    void gCashPaymentShouldProcessUsingItsOwnImplementation() {
        Payment payment = new GCashPayment();

        PaymentReceipt receipt = payment.process(125.0);

        assertThat(receipt.provider()).isEqualTo("gcash");
        assertThat(receipt.status()).isEqualTo("APPROVED");
    }

    @Test
    void processorShouldRouteNewPaymentImplementationWithoutCoreLogicChange() {
        PaymentProcessor processor = new PaymentProcessor(List.of(
                new CreditCardPayment(),
                new PayPalPayment(),
                new GCashPayment()));

        PaymentReceipt receipt = processor.process("gcash", 90.0);

        assertThat(receipt.provider()).isEqualTo("gcash");
        assertThat(receipt.amount()).isEqualTo(90.0);
    }

    @Test
    void processorShouldRejectUnknownPaymentMethod() {
        PaymentProcessor processor = new PaymentProcessor(List.of(new CreditCardPayment(), new PayPalPayment()));

        assertThatThrownBy(() -> processor.process("CASH", 10.0))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessage("Unsupported payment method");
    }
}
