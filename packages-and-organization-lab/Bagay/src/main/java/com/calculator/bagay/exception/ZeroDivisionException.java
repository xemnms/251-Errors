package com.calculator.bagay.exception;

/**
 * ZeroDivisionException is a checked exception thrown when attempting to
 * divide by zero, which is mathematically undefined.
 */
public class ZeroDivisionException extends Exception {
    public ZeroDivisionException(String message) {
        super(message);
    }
}
