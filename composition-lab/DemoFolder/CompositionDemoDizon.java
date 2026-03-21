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
        

        /* 
        TASK 8: DESIGN ANALYSIS - COMPOSITION & COUPLING

        1. WHAT ARE THE HAS-A RELATIONSHIPS?
        - ValorantLoadout_Dizon HAS-A Weapon_Nepomuceno (Primary Weapon)
        - ValorantLoadout_Dizon HAS-A Payment_Arandela (Economy/Credits)
        
        2. WHICH CLASSES WERE REUSED?
        - The component classes 'Payment_Arandela' and 'Weapon_Nepomuceno' 
        were reused and integrated into the Loadout system.
        
        3. HOW DOES COMPOSITION REDUCE COUPLING?
        - The 'ValorantLoadout_Dizon' class does not need to know the internal 
        logic of how a weapon fires or how a payment is validated. It only 
        interacts with the public methods (API) provided by those classes. 
        This allows us to swap a 'Standard Vandal' with an 'Elderflame Vandal' 
        without changing a single line of code in the Loadout class.
        
        4. HOW IS COHESION MAINTAINED?
        - High Cohesion is achieved by ensuring each class has one responsibility:
        - Weapon_Nepomuceno: Manages ammo and firing mechanics.
        - Payment_Arandela: Manages financial transactions and balance.
        - ValorantLoadout_Dizon: Manages the player's equipment state.
        
        5. WHY IS INHERITANCE NOT APPROPRIATE HERE?
        - Using inheritance (e.g., 'ValorantLoadout extends Weapon') would imply 
        an "IS-A" relationship. A Loadout is NOT a Weapon; it is a collection 
        of items. If we used inheritance, the Loadout would inherit unnecessary 
        methods like 'reload()' or 'setAmmo()', which violates the Principle 
        of Least Privilege and creates a fragile, rigid design.

        */
    }
}