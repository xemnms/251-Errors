/**
 * This interface defines Baymax's patient assistance behaviors,
 * including helping patients, scanning vitals, comforting, offering treats, and hugs.
 * All lines are based on Big Hero 6.
 * This interface was made by Kyla Cassandra Rodenas
 */
public interface BaymaxChip_Rodenas {

    //abstract method for assisting a patient
    void assistPatient();

    //default method to scan patient vitals
    default void scanVitals() {
        System.out.println("On a scale of 1 to 10, how would you rate your pain?");
    }

    default void comfortPatient() {
        System.out.println("It is alright to cry. Crying is a natural response to pain.");
    }

    default void encouragePatient() {
        System.out.println("You are doing great, keep going!");
    }

    default void giveTreat() {
        System.out.println("You have been good. Have a lollipop!");
    }

    default void offerHug() {
        System.out.println("Would you like a hug?");
    }
}
