//main demo created by Dan Isles
//this file demonstrates object collaboration, low coupling, and design analysis

//1 fighter class has-a gun to shoot with
//2 the three classes that were used are: CombatSystem_Isles, Pistol_Badosa, Fighter_Costiniano
//3 composition reduces coupling because classes are loosely connected. Each class works independently, so if one class changes, it does not heavily affect the others.
//4 cohesion is maintained by making sure each class has one clear responsibility. Each class only does what it is supposed to do, making the code easier to understand and manage.
//5 inheritance is not appropriate because the classes do not have an “IS-A” relationship. They are not types of each other, but rather parts of a whole, so composition (HAS-A) is the better choice.

public class CompositionDemoIsles {
    public static void main(String[] args) {

        // starts teammate classes
        Fighter_Costiniano fighter1 = new Fighter_Costiniano("Soldier", 100, 20);
        Pistol_Badosa pistol1 = new Pistol_Badosa("Glock", 2, 15);

        // pass them into composed class
        CombatSystem_Isles player1 = new CombatSystem_Isles("Dan", fighter1, pistol1);
        // object collaboration (nag-iinteract yung objects)
        player1.displayLoadout();
        // combat simulation
        Fighter_Costiniano enemy = new Fighter_Costiniano("Enemy", 80, 15);
        player1.engageCombat(enemy);

        System.out.println("\n--- Low Coupling Demo ---");

        // replace component (new pistol object)
        Pistol_Badosa pistol2 = new Pistol_Badosa("Desert Eagle", 3, 7);
        // same system, different object
        CombatSystem_Isles player2 = new CombatSystem_Isles("Dan", fighter1, pistol2);

        // shows that system still works
        pl ayer2.displayLoadout();
    }
}
