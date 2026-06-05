package com.bautista.grasp.service;

import com.bautista.grasp.entity.Payment;

// DIP: Abstraction layer between payment consumers and concrete payment implementations
// ISP: Single focused method - resolves a payment strategy by type
public interface PaymentProvider {

    Payment getPayment(String type);
}
