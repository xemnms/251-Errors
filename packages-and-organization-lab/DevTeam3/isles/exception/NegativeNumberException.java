package exception;

//custom exception for negative numbers
public class NegativeNumberException extends RuntimeException {

    //constructor
    public NegativeNumberException(String message) {
        super(message); //passes message to RuntimeException
    }
}
