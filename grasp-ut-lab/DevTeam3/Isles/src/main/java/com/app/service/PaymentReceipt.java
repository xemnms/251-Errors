package com.app.service;

public record PaymentReceipt(
        String provider,
        double amount,
        String status
) {
}
