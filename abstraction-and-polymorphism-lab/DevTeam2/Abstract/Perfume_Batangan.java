//Abstract class by Batangan
//1 abstract method and 1 concrete method

public abstract class Perfume_Batangan {

    // abstract method
    abstract void smell(); 

    // concrete method
    void spray(String message) {
        System.out.println("You sprayed the perfume: " + message);
    }
}
