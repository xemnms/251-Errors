/* Interface Created by Alvarez
for Cereal_Alvarez Abstract Class */

// interface
interface Breakfast_Alvarez {

    // abstract method
    void serve();

    // default method
    default void addMilk() {
        System.out.println("Splash Splash...");
    }
}