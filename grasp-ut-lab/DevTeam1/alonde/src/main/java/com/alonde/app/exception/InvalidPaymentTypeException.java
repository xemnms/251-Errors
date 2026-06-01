package com.alonde.app.exception;

public class InvalidPaymentTypeException extends RuntimeException {
    public InvalidPaymentTypeException(String type) {
        super("Unknown payment type: " + type + ". Use CREDIT_CARD, CASH, or GCASH.");
    }
}
