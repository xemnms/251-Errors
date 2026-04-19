package com.calculator.bagay.exception;

/**
 * NegativeNumberException is an unchecked exception (RuntimeException) thrown
 * when the calculator receives negative numbers, which are restricted by
 * business rules.
 */
public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}
