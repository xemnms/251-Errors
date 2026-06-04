package before;

import java.util.Map;

public class PaymentProcessor implements PaymentGateway {

    private final Map<String, Payment> payments;

    public PaymentProcessor(CreditCardPayment creditCardPayment, PayPalPayment payPalPayment) {
        this.payments = Map.of(
                "CREDIT_CARD", creditCardPayment,
                "PAYPAL", payPalPayment
        );
    }

    @Override
    public PaymentReceipt process(String paymentMethod, double amount) {
        Payment payment = payments.get(paymentMethod);
        if (payment == null) {
            throw new IllegalArgumentException("Unsupported payment method");
        }
        return payment.process(amount);
    }
}
