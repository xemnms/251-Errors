package com.calculator.bagay.exception;

/**
 * InvalidInputException is a checked exception thrown when calculator receives
 * invalid input such as NaN or infinite values.
 */
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
