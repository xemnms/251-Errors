//interface created by Costiniano

public interface Summonable_Costiniano {

    // abstract method
    void performAction();

    // default method
    default void chant() {
        System.out.println("Chanting a magical summoning ritual...");
    }
}