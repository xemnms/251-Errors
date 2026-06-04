package com.app.util;

import com.app.entity.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// GRASP: Polymorphism - verifies different Payment implementations behave correctly
class PaymentPolymorphismTest {

    @Test
    void cashShouldReturnCorrectType() {
        assertEquals("CASH", new CashPayment().getPaymentType());
    }

    @Test
    void cardShouldReturnCorrectType() {
        assertEquals("CARD", new CardPayment().getPaymentType());
    }

    @Test
    void bothShouldHaveDifferentTypes() {
        assertNotEquals(new CashPayment().getPaymentType(), new CardPayment().getPaymentType());
    }

    @Test
    void bothShouldImplementPaymentInterface() {
        assertInstanceOf(Payment.class, new CashPayment());
        assertInstanceOf(Payment.class, new CardPayment());
    }
}
