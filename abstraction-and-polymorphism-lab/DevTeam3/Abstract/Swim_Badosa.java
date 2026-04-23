//Abstract Class by Badosa

public abstract class Swim_Badosa {
    // instance variables to track the swimmer's status
    private boolean inWater = false;
    private boolean isWarmedUp = false;

    // abstract method
    public abstract void swim();

    // concrete method
    public void warmUp() {
        isWarmedUp = true;
        System.out.println("Warming up");
    }

    public void enterWater() {
        if (isWarmedUp) {
            inWater = true;
            System.out.println("Entering the water");
        } else if (inWater) {
            System.out.println("You are already in the water.");
        } else {
            System.out.println("Please warm up before entering the water.");
        }
    }

    public void exitWater() {
        if (inWater) {
            inWater = false;
            System.out.println("Exiting the water");
        } else {
            System.out.println("You are already on land");
        }
    }

    public void checkStatus() {
        if (inWater && isWarmedUp) {
            System.out.println("You are in the water and warmed up, ready to swim!");
        } else if (inWater) {
            System.out.println("You are in the water but not warmed up, please warm up before swimming.");
        } else if (isWarmedUp) {
            System.out.println("You are warmed up but not in the water, please enter the water to swim.");
        } else {
            System.out
                    .println("You are not in the water and not warmed up, please warm up and enter the water to swim.");
        }
    }
    // NOTE: When making your subclass, make sure to implement conditions for the
    // swimmer to only swim when they are in the water and warmed up.(Atleast that
    // is my intention for this class)
}
