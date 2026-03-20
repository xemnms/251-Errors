public class CompositionDemoDizon {
    public static void main(String[] args) {
        // Instantiate Components
        Weapon_Nepomuceno ghost = new Weapon_Nepomuceno("Ghost", "Pistol", 30, 15);
        Payment_Arandela credits = new Payment_Arandela("Credits", 3000.00);

        // Create Composed Object
        ValorantLoadout_Dizon myLoadout = new ValorantLoadout_Dizon("Vic", ghost, credits);

        // 1. Initial Purchase
        myLoadout.buyPhase();
        
        // 2. Use Setter to swap to a better weapon (Task 7: Low Coupling)
        Weapon_Nepomuceno vandal = new Weapon_Nepomuceno("Vandal", "Rifle", 40, 25);
        myLoadout.setPrimaryWeapon(vandal); 

        // 3. Object Collaboration
        myLoadout.combat();
        
        // Analysis Check:
        // System still works because ValorantLoadout doesn't care if the 
        // Weapon is a Ghost or a Vandal. It just knows it can call .fire()
    }
}