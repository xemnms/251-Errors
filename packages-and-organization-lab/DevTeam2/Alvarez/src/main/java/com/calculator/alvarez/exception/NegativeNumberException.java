/* 
Unchecked exception for invalid negative numbers inputs.
Demonstrates runtime exception handling in the Calculator_System.
Created by Acosta, Alvarez and Bautista 
*/

package com.calculator.alvarez.exception;

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}