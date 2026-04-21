package com.calculator.dizon.exception;
//Unchecked Exception: Does not need to be declared in method signatures.

public class NegativeResultException_Dizon extends RuntimeException {
    public NegativeResultException_Dizon(String message) {
        super(message);
    }
}