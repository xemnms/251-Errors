/*
This is a custom exception for division by zero errors. It demonstrates checked exception handling in Java.
Program can handle invalid division properly instead of crashing or giving incorrect results.
*/

package com.calculator.bautista.exception;

public class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}