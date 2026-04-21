package com.calculator.rodenas.exception;

/*
Checked exception for invalid input such as division by zero.
Created by Rodenas and Isles from exceptions lab
*/

public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}