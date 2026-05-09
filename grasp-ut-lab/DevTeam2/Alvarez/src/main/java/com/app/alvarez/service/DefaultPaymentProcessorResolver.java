package com.app.alvarez.service;

import com.app.alvarez.entity.PaymentMethod;
import com.app.alvarez.exception.UnsupportedPaymentMethodException;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class DefaultPaymentProcessorResolver implements PaymentProcessorResolver {

    private final Map<PaymentMethod, PaymentProcessor> processors = new EnumMap<>(PaymentMethod.class);

    public DefaultPaymentProcessorResolver(List<PaymentProcessor> processors) {
        processors.forEach(processor -> this.processors.put(processor.supports(), processor));
    }

    // GRASP: Indirection - resolver shields OrderService from payment implementation selection details.
    @Override
    public PaymentProcessor resolve(PaymentMethod method) {
        PaymentProcessor processor = processors.get(method);
        if (processor == null) {
            throw new UnsupportedPaymentMethodException("Unsupported payment method: " + method);
        }
        return processor;
    }
}