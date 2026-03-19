//main demo created by Dan Isles
//this file demonstrates object collaboration, low coupling, and design analysis
package DemoFolder;

import ComponentClasses.Pistol_Badosa;
import ComponentClasses.Fighter_Costiniano;

public class CompositionDemoIsles {
    public static void main(String[] args) {

        //starts teammate classes
        Fighter_Costiniano fighter1 = new Fighter_Costiniano("Soldier", 100, 20);
        Pistol_Badosa pistol1 = new Pistol_Badosa("Glock", 2, 15);

        //pass them into composed class
        CombatSystem_Isles player1 = new CombatSystem_Isles("Dan", fighter1, pistol1);

        //object collaboration (nag-iinteract yung objects)
        player1.displayLoadout();

        //combat simulation
        Fighter_Costiniano enemy = new Fighter_Costiniano("Enemy", 80, 15);
        player1.engageCombat(enemy);

        System.out.println("\n--- Low Coupling Demo ---");

        //replace component (new pistol object)
        Pistol_Badosa pistol2 = new Pistol_Badosa("Desert Eagle", 3, 7);

        //same system, different object
        CombatSystem_Isles player2 = new CombatSystem_Isles("Dan", fighter1, pistol2);

        //shows that system still works
        player2.displayLoadout();
    }
}
