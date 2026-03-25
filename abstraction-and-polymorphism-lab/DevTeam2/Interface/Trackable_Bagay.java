// Interface by Bagay
// Contains one abstract method and one default method.

public interface Trackable_Bagay {
    void trackProgress(int percent);

    default void progressTip() {
        System.out.println("Review each lesson summary before moving to the next module.");
    }
}