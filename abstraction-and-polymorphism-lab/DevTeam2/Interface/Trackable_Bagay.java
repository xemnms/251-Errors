// Interface created by Bagay
// This interface contains one abstract method and one default method.

public interface Trackable_Bagay {
    // Abstract method
    void trackProgress(int percent);

    // Default method
    default void progressTip() {
        System.out.println("Review each lesson summary before moving to the next module.");
    }
}