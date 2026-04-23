package exception;

//custom checked exception for invalid input
public class InvalidInputException extends Exception {

    //constructor
    public InvalidInputException(String message) {
        super(message); //passes message to Exception
    }
}
