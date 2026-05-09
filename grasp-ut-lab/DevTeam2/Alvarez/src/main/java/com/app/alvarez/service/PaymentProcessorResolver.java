package com.app.alvarez.service;

import com.app.alvarez.entity.PaymentMethod;

public interface PaymentProcessorResolver {

    PaymentProcessor resolve(PaymentMethod method);
}