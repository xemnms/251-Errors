/**
 * This abstract class represents Baymax, the personal healthcare companion from Disney's Big Hero 6.
 * It handles core healthcare functions including introducing himself, assessing pain, providing care, 
 * comforting patients, giving treats, and performing friendly gestures.
 * This class was made by Kyla Cassandra Rodenas
 */
public abstract class Baymax_Rodenas {

    //the name for the baymax mode
    String modeName;

    //constructor to initialize baymax with a mode name
    Baymax_Rodenas(String modeName) {
        this.modeName = modeName;
    }

    //abstract method to provide care, must be implemented by subclasses
    abstract void provideCare();

    //concrete method for baymax's opening 
    void BaymaxIntroduction() {
        System.out.println("Hello! I am Baymax, your personal healthcare companion.");
    }

    void assessPain() {
        System.out.println("I was alerted to the need for medical attention when you said \"ow\".");
        System.out.println("On a scale of 1 to 10, how would you rate your pain?");
    }

    void showCapabilities() {
        System.out.println("I am programmed with over 10,000 medical procedures to help you.");
    }

    void deactivationReminder() {
        System.out.println("I cannot deactivate until you say you are satisfied with your care.");
    }

    void showMode() {
        System.out.println("Current mode: " + modeName);
    }

    void fistBump() {
        System.out.println("Bah-a-la-la-la.");
    }

    void comfortPatient() {
        System.out.println("It is alright to cry. Crying is a natural response to pain.");
    }

    void giveLollipop() {
        System.out.println("You have been good. Have a lollipop!");
    }

    void offerHug() {
        System.out.println("Would you like a hug?");
    }
}