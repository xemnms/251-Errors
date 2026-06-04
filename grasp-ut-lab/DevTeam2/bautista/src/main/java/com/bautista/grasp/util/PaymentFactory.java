package com.bautista.grasp.util;

import com.bautista.grasp.entity.*;

import java.util.Map;
import java.util.function.Supplier;

/*
 * GRASP: Pure Fabrication (utility class)
 * GRASP: Indirection (decouples service from concrete payment creation)
 */
public class PaymentFactory {

    private static final Map<String, Supplier<Payment>> REGISTRY = Map.of(
            "CARD", CardPayment::new,
            "CASH", CashPayment::new
    );

    public static Payment getPayment(String type) {

        Supplier<Payment> supplier = REGISTRY.get(type.toUpperCase());

        if (supplier == null) {
            throw new IllegalArgumentException("Unsupported payment type: " + type);
        }

        return supplier.get();
    }
}