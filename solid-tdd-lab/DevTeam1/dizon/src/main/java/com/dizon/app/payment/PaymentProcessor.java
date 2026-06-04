package com.dizon.app.payment;

// SOLID: OCP - the system is OPEN for extension (add a new payment type by adding a new
//        class) but CLOSED for modification (no existing class changes).
// SOLID: LSP - any PaymentProcessor implementation must be usable wherever this type is
//        expected, with no surprising behaviour.
// OOP:  Polymorphism - one contract, many interchangeable behaviours.
public interface PaymentProcessor {

    void process(double amount);

    String getPaymentType();
}
