//Interface by Badosa
public interface Knit_Badosa {
    //
    public boolean hasYarn();

    public boolean hasNeedles();

    default boolean canKnit() {
        // Logic for knitting 
        if (!hasYarn()) {
            System.out.println("No yarn.");
            return false;
        }
        if (!hasNeedles()) {
            System.out.println("No needles.");
            return false;
        }
        return true;
    }
    //abstract method
    public void knit();

    //default method 
    default void prepare() {
        System.out.println("Preparing to knit...");
    }
}