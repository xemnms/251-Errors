package after;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PaymentProcessor implements PaymentGateway {

    private final Map<String, Payment> payments;

    public PaymentProcessor(List<Payment> payments) {
        // DIP: Depends on Payment abstraction, not concrete payment classes.
        // OCP: PaymentProcessor does not change when a new Payment implementation is added.
        this.payments = payments.stream()
                .collect(Collectors.toUnmodifiableMap(payment -> normalize(payment.method()), Function.identity()));
    }

    // KISS: A simple lookup replaces long if-else chains.
    @Override
    public PaymentReceipt process(String paymentMethod, double amount) {
        Payment payment = payments.get(normalize(paymentMethod));
        if (payment == null) {
            throw new IllegalArgumentException("Unsupported payment method");
        }
        return payment.process(amount);
    }

    private String normalize(String paymentMethod) {
        return paymentMethod == null ? "" : paymentMethod.trim().toUpperCase(Locale.ROOT);
    }
}
