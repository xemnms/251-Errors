package com.dizon.app.payment;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

// SOLID: OCP in action. Spring injects EVERY PaymentProcessor bean as a List. This class
//        routes to the right one by type WITHOUT a single if/else or switch. Adding a new
//        payment method = create one new @Component class. This file never changes. That is
//        the Open-Closed Principle made concrete.
// SOLID: DIP - depends on the PaymentProcessor abstraction, never on the concrete classes.
// OOP:  COMPOSITION OVER INHERITANCE - PaymentService is composed of the processors; it
//        does not inherit from any of them.
@Service
public class PaymentService {

    // BEFORE (a typical OCP violation): a long if/else chain like
    //   if (type.equals("CASH")) { ... } else if (type.equals("CREDIT_CARD")) { ... }
    // AFTER: a lookup map built from all injected processors.
    private final Map<String, PaymentProcessor> processorsByType;

    public PaymentService(List<PaymentProcessor> processors) {
        this.processorsByType = processors.stream()
                .collect(Collectors.toMap(PaymentProcessor::getPaymentType, Function.identity()));
    }

    public void processPayment(String type, double amount) {
        PaymentProcessor processor = processorsByType.get(type);
        if (processor == null) {
            throw new IllegalArgumentException("Unsupported payment type: " + type);
        }
        processor.process(amount);
    }

    public Set<String> supportedTypes() {
        return processorsByType.keySet();
    }
}
