// Abstract class by Batangan
// 1 abstract method and 1 concrete method

public abstract class Perfume_Batangan {

    // Abstract method
    abstract void smell(); 

    // Concrete method
    void spray(String message) {
        System.out.println("You sprayed the perfume: " + message);
    }
}
