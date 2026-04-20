/* 
Unchecked exception for invalid negative number inputs.
Demonstrates runtime exception handling in the Calculator system.
Created by Isles and Rodenas
*/

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}