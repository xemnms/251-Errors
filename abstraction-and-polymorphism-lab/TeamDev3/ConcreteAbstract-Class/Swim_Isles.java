/**
 * Uses abstract class Swim_Badosa by Badosa
 * This class was made by Isles
 */

public class Swim_Isles extends Swim_Badosa {
    //override abstract method
    @Override
    public void swim() {
        System.out.println("Swimming freestyle across the pool!");
    }

    //overloaded method (optional but good for demo)
    public void swim(String style) {
        System.out.println("Swimming using " + style + " style!");
    }
}
