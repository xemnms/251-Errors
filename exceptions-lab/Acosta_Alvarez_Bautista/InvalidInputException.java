// This class defines a custom exception called InvalidInputException that extends the built-in Exception class. 
// Used to handle specific error cases in the Calculator_System, such as division by zero or invalid inputs.
// Created by Acosta, Alvarez and Bautista

public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}