package CompositeClasses;

import ComponentClasses.Pistol_Badosa;
import ComponentClasses.Mage_Isles;

/*
 * Composed class by Kyla Cassandra Rodenas
 * Represents a combat mage using a pistol infused with elemental magic
 * Uses components from Pistol_Badosa and Mage_Isles
 */
public class combatMage_Rodenas {
    //attributes (HAS-A relationship: the mage has a pistol and magic abilities)
    private Pistol_Badosa combatPistol;
    private Mage_Isles combatMage;
    //constructor
    public combatMage_Rodenas(Pistol_Badosa combatPistol, Mage_Isles combatMage) {
        this.combatPistol = combatPistol;
        this.combatMage = combatMage;
    }
    //getters
    public Pistol_Badosa getCombatPistol() {
        return combatPistol;
    }

    public Mage_Isles getCombatMage() {
        return combatMage;
    }
    //setters
    public void setCombatPistol(Pistol_Badosa combatPistol) {
        this.combatPistol = combatPistol;
    }
    public void setCombatMage(Mage_Isles combatMage) {
        this.combatMage = combatMage;
    }

    //behavior: shoot pistol enhanced by mage's elemental magic
    public void magicShoot() {
        System.out.println("=== Magic Pistol Attack ===");
        String element = combatMage.getElementName();
        System.out.println("The " + combatPistol.getModel() + " glows with " + element + " energy!");
        System.out.println("Mage channels their " + element + " power into each bullet...");
        System.out.println("Bullets infused with " + element + " magic soar through the air!");
        combatPistol.shoot();
        combatMage.useElement();
        System.out.println("=== Attack Successful ===");
    }

    //display combined info
    public void showCombinedInfo() {
        System.out.println("=== Loadout ===");
        System.out.println("\nPistol:");
        System.out.println("Model: " + combatPistol.getModel());
        System.out.println("Weight: " + combatPistol.getWeight() + "kg");
        System.out.println("Magazine Capacity: " + combatPistol.getMagazineCapacity());
        System.out.println("\nMage:");
        System.out.println("Element: " + combatMage.getElementName());
        System.out.println("Power Level: " + combatMage.getPowerLevel());
        System.out.println("Type: " + combatMage.getType());
        System.out.println("=======================================");
    }

    //boost mage power and pistol bullets
    public void powerUp(int newPowerLevel, int extraBullets) {
        combatMage.setPowerLevel(newPowerLevel);
        combatPistol.setMagazineCapacity(combatPistol.getMagazineCapacity() + extraBullets);
        System.out.println("Power up! Mage power: " + newPowerLevel + ", Pistol bullets: " + combatPistol.getMagazineCapacity());
    }
}