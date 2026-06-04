package com.app.service;

// GRASP: Protected Variations - OrderService is protected from changes in payment routing.
// ISP: Exposes only the operation OrderService needs.
public interface PaymentGateway {

    PaymentReceipt process(String paymentMethod, double amount);
}
