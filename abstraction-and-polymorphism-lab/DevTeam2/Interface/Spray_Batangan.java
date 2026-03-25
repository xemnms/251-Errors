//Interface by Batangan
//Has 1 abstract and 1 concrete (default) method

public interface Spray_Batangan {

    void sprayPerfume(); // abstract

    default void chooseScent(String scent) { // concrete (default)
        System.out.println("Chosen scent note is " + scent);
    }
}
