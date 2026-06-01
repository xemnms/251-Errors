package com.alonde.app.payment;

import com.alonde.app.exception.InvalidPaymentTypeException;
import org.springframework.stereotype.Component;
import java.util.*;

// grasp: indirection - routes to the correct processor without the Service needing to know
@Component
public class PaymentProcessorFactory {

    private final Map<String, PaymentProcessor> processorMap;

    public PaymentProcessorFactory(List<PaymentProcessor> processors) {
        processorMap = new HashMap<>();
        for (PaymentProcessor p : processors) {
            processorMap.put(p.getType(), p);
        }
    }

    public PaymentProcessor getProcessor(String type) {
        PaymentProcessor p = processorMap.get(type.toUpperCase());
        if (p == null) throw new InvalidPaymentTypeException(type);
        return p;
    }
}