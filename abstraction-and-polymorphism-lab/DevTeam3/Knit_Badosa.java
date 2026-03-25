//Interface by Badosa

public interface Knit_Badosa {
    // abstract method
    void knit();

    // default method
    default void displayKnit() {
        System.out.println("Knitting in progress...");
    }
}