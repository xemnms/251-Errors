/*
Checked exception for division by zero errors.
Demonstrates custom exception creation.
Created by Acosta, Alvarez and Bautista
*/

public class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}