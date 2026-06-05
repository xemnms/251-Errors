package com.bautista.grasp.util;

import com.bautista.grasp.entity.*;
import com.bautista.grasp.service.PaymentProvider;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Supplier;

// DIP: Implements PaymentProvider so it can be injected as an abstraction
// OCP: New payment types are registered here only - no other class changes needed
// GRASP: Pure Fabrication, Indirection
@Component
public class PaymentFactory implements PaymentProvider {

    // OCP: registry is the only place to add new payment types
    private static final Map<String, Supplier<Payment>> REGISTRY = Map.of(
            "CARD", CardPayment::new,
            "CASH", CashPayment::new,
            "GCASH", GCashPayment::new  // OCP: GCash added without touching Card or Cash
    );

    // DIP: instance method allows this factory to be injected via PaymentProvider interface
    @Override
    public Payment getPayment(String type) {

        Supplier<Payment> supplier = REGISTRY.get(type.toUpperCase());

        if (supplier == null) {
            throw new IllegalArgumentException("Unsupported payment type: " + type);
        }

        return supplier.get();
    }
}