package com.calculator.rodenas.exception;

/*
Unchecked exception for negative number inputs.
Created by Rodenas and Isles from exceptions lab
*/

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}