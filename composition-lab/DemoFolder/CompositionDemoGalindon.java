public class CompositionDemoGalindon {
    public static void main(String[] args) {
        //Instantiate teammate classes

        // Agents
        Agents_Alonde agent1 = new Agents_Alonde("Jett", "Duelist", 7);
        Agents_Alonde agent2 = new Agents_Alonde("Sage", "Sentinel", 8);

        // Weapons
        Weapon_Nepomuceno weapon1 = new Weapon_Nepomuceno("Vandal", "Rifle", 40, 30);
        Weapon_Nepomuceno weapon2 = new Weapon_Nepomuceno("Ghost", "Pistol", 25, 15);

        // Payment with promo
        PromoPayment_Galindon payment1 = new PromoPayment_Galindon("GCash", 100, "VALORANT10");
        PromoPayment_Galindon payment2 = new PromoPayment_Galindon("Credit Card", 150, "INVALIDCODE");

        // Pass them into the composed class (Combat)
        Combat combat1 = new Combat(agent1, weapon1);
        Combat combat2 = new Combat(agent2, weapon2);

        // Call methods across objects
        System.out.println("=== Demo: Combat Scenario 1 ===");
        combat1.engage(6); // agent1 uses weapon1
        payment1.processPayment(); // process payment with promo

        System.out.println("\n=== Demo: Combat Scenario 2 ===");
        combat2.engage(7); // agent2 uses weapon2
        payment2.processPayment(); // invalid promo code demo

        // Demonstrate setter injection / swapping components
        System.out.println("\n=== Demo: Swap Weapon Mid-Combat ===");
        Weapon_Nepomuceno weapon3 = new Weapon_Nepomuceno("Operator", "Sniper", 150, 5);
        combat1.setWeapon(weapon3);
        combat1.engage(7); // agent1 now uses new weapon
    }
}




/*

1. What are the HAS-A relationships?

Combat HAS-A Agents_Alonde - each combat scenario requires an agent.
Combat HAS-A Weapon_Nepomuceno - each agent uses a weapon.
CompositionDemoYourSurname HAS-A PromoPayment_Galindon - payment is associated with each combat scenario.

2. Which classes were reused?

Agents_Alonde - reused for multiple agents 
Weapon_Nepomuceno - reused for multiple weapons 
PromoPayment_Galindon - reused for different payment scenarios 

3. How does composition reduce coupling?

The Combat class depends on abstractions (objects) rather than concrete implementations:
Weapons can be swapped without changing Combat.
Payments can be replaced with new PromoPayment_Galindon objects without modifying Combat.

4. How is cohesion maintained?

Each class has a single responsibility:
Agents_Alonde - manages agent attributes and abilities
Weapon_Nepomuceno - handles weapon actions (fire/reload)
PromoPayment_Galindon - manages payment processing with promo codes
Combat - coordinates agent and weapon actions in a fight

5. Why is inheritance NOT appropriate here?

The relationships between Combat, Agents_Alonde, Weapon_Nepomuceno, and PromoPayment_Galindon are “has-a”, not “is-a”.
Combat is not a type of Agent or Weapon, it contains them.
Using inheritance would misrepresent the relationship and create tighter coupling, reducing flexibility.

*/

