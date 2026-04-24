/* 
This custom exception is used when the user enters a negative number where it is not allowed. It demonstrates unchecked exception handling in Java.
It helps ensure that only valid inputs are processed in the calculator.
*/

package com.calculator.bautista.exception;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}