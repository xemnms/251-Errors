package com.app.payment;

import org.junit.jupiter.api.Test;

class PaymentTest {

    @Test
    void testAllPaymentTypes() {
        Payment cash = new CashPayment();
        Payment card = new CreditCardPayment();
        Payment gcash = new GCashPayment();

        cash.pay(100);
        card.pay(200);
        gcash.pay(300);
    }
}