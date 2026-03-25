// Interface by Batangan
// Has 1 abstract and 1 concrete method

public interface Spray_Batangan {

    void sprayPerfume(); // Abstract

    default void chooseScent(String scent) { // Concrete
        System.out.println("Chosen scent note is " + scent);
    }
}
