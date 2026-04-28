/*
Checked exception for invalid input errors such as division by zero.
Demonstrates custom exception creation.
Created by Isles and Rodenas
*/

public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}