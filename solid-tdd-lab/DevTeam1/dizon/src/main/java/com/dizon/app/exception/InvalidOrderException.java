package com.dizon.app.exception;

// BONUS: custom exception handling. Thrown by the OrderValidator when a request
// breaks a business rule. Distinct from OrderNotFoundException so the
// GlobalExceptionHandler can map it to a different HTTP status (400 vs 404).
public class InvalidOrderException extends RuntimeException {

    public InvalidOrderException(String message) {
        super(message);
    }
}
