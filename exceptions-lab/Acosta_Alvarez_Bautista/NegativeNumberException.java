// This class defines a custom exception called NegativeNumberException that extends the built-in RuntimeException class.
// Used to handle specific error cases in the Calculator_System, such as when a negative number is encountered where it is not allowed.
// Created by Acosta, Alvarez and Bautista

public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}