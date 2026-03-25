// Interface created by Bautista
// This interface contains one abstract method and one default method.

public interface Training_Bautista {
    // Abstract method
    void train();

    // Default method
    default void schedule() {
        System.out.println("Training sessions are scheduled from Monday to Friday, 5 PM to 7 PM.");
    }
}