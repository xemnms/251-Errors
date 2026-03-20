package DemoFolder;

/*
 * Main class by Kyla Cassandra Rodenas
 * Demonstrates a combat mage using elemental magic as bullets for a pistol
 * Shows composition using Pistol_Badosa and Mage_Isles
 *
 * What are the HAS-A relationships:
 * combatMage_Rodenas HAS-A Pistol_Badosa and Mage_Isles
 *
 * Which classes were reused:
 * Pistol_Badosa and Mage_Isles were reused as component classes
 *
 * How does composition reduce coupling:
 * Composition allows combatMage_Rodenas to use the pistol and mage without depending on their internal implementation.
 * The components can be changed or replaced without breaking the system as long as their methods stay the same.
 *
 * How is cohesion maintained:
 * Each class has a clear role. The pistol handles shooting, the mage handles magic,
 * and combatMage_Rodenas combines both into one system. All parts work together logically.
 *
 * Why is inheritance NOT appropriate here:
 * Inheritance would imply an IS-A relationship, which is incorrect.
 * The combat mage is not a pistol or a mage, it only uses them, so HAS-A (composition) is more appropriate.
 */

import ComponentClasses.Pistol_Badosa;
import ComponentClasses.Mage_Isles;
import CompositeClasses.combatMage_Rodenas;
import ChildClasses_LowCoupling.arcanePistol_Rodenas;

public class CompositionDemoRodenas {
    public static void main(String[] args) {
        //create initial components
        Pistol_Badosa pistol = new Pistol_Badosa("Glock", 2, 15);
        Mage_Isles mage = new Mage_Isles();
        mage.setElementName("Fire");
        mage.setPowerLevel(50);
        mage.setType("Offense");

        //create composed object
        combatMage_Rodenas hero = new combatMage_Rodenas(pistol, mage);
        //display info
        hero.showCombinedInfo();
        //perform magic attack
        hero.magicShoot();
        //demonstrate low coupling by swapping loadouts
        System.out.println("\n--- Loadout Swap ---");
        Pistol_Badosa newPistol = new Pistol_Badosa("Desert Eagle", 3, 12);
        Mage_Isles newMage = new Mage_Isles();
        newMage.setElementName("Ice");
        newMage.setPowerLevel(70);
        newMage.setType("Defense");
        hero.setCombatPistol(newPistol);
        hero.setCombatMage(newMage);
        //display new loadout
        hero.showCombinedInfo();
        hero.magicShoot();
        //replace pistol with child class (arcanePistol)
        System.out.println("\n--- Replacing Pistol with Arcane Pistol (2x Multiplier) ---");
        arcanePistol_Rodenas arcanePistol = new arcanePistol_Rodenas("ArcaneBlaster", 2, 12);
        hero.setCombatPistol(arcanePistol); //swap in child class
        arcanePistol.elementalArcaneCombo(hero.getCombatMage().getElementName()); //show elemental effect
        hero.magicShoot();

        //final power-up
        System.out.println("\n--- Power Up ---");
        hero.powerUp(90, 10);
        hero.showCombinedInfo();
        hero.magicShoot();
    }
}