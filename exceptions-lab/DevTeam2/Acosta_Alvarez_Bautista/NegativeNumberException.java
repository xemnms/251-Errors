/* 
Unchecked exception for invalid negative numbers inputs.
Demonstrates runtime exception handling in the Calculator_System.
Created by Acosta, Alvarez and Bautista 
*/

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}