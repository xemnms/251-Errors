package com.app.service;

import com.app.exception.InvalidOrderException;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;

@Service
public class PaymentProcessor implements PaymentGateway {

    private final Map<String, Payment> payments;

    public PaymentProcessor(CreditCardPayment creditCardPayment, PayPalPayment payPalPayment) {
        this.payments = Map.of(
                "CREDIT_CARD", creditCardPayment,
                "PAYPAL", payPalPayment
        );
    }

    // GRASP: Indirection - PaymentProcessor routes requests without exposing concrete payment classes to OrderService.
    @Override
    public PaymentReceipt process(String paymentMethod, double amount) {
        Payment payment = payments.get(normalize(paymentMethod));
        if (payment == null) {
            throw new InvalidOrderException("Unsupported payment method");
        }
        return payment.process(amount);
    }

    private String normalize(String paymentMethod) {
        return paymentMethod == null ? "" : paymentMethod.trim().toUpperCase(Locale.ROOT);
    }
}
