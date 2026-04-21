//this abstract class is created by Costiniano which represents Astolfo

public abstract class Astolfo_Costiniano {

    //instance variables to track servant status
    private boolean isSummoned = false;
    private boolean hasWeapon = false;

    //abstract method
    public abstract void noblePhantasm();

    //concrete methods
    public void summon() {
        isSummoned = true;
        System.out.println("Astolfo has been summoned!");
    }

    public void equipWeapon() {
        if (isSummoned) {
            hasWeapon = true;
            System.out.println("Weapon equipped!");
        } else if (hasWeapon) {
            System.out.println("Weapon is already equipped.");
        } else {
            System.out.println("Summon Astolfo first before equipping a weapon.");
        }
    }

    public void removeWeapon() {
        if (hasWeapon) {
            hasWeapon = false;
            System.out.println("Weapon removed.");
        } else {
            System.out.println("No weapon to remove.");
        }
    }

    public void checkStatus() {
        if (isSummoned && hasWeapon) {
            System.out.println("Astolfo is summoned and fully equipped, ready for battle!");
        } else if (isSummoned) {
            System.out.println("Astolfo is summoned but has no weapon.");
        } else if (hasWeapon) {
            System.out.println("Weapon is ready but Astolfo is not summoned.");
        } else {
            System.out.println("Astolfo is not summoned and has no weapon.");
        }
    }
}
