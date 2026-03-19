//composed class created by Dan Isles
//this class represents a combat system (HAS-A fighter and pistol)
import ComponentClasses.Pistol_Badosa;
import ComponentClasses.Fighter_Costiniano;

public class CombatSystem_Isles {

    //private attributes
    private String playerName; //name of player

    //composition (HAS-A relationship)
    private Fighter_Costiniano fighter; //character stats
    private Pistol_Badosa pistol; //weapon used

    //constructor injection (pinapasa agad yung objects)
    public CombatSystem_Isles(String playerName, Fighter_Costiniano fighter, Pistol_Badosa pistol) {
        this.playerName = playerName;
        this.fighter = fighter;
        this.pistol = pistol;
    }

    //behavior method (displays info of player + equipment)
    public void displayLoadout() {
        System.out.println("Player: " + playerName);
        //fighter details
        System.out.println("Fighter Name: " + fighter.getName());
        System.out.println("Health: " + fighter.getHealth());
        System.out.println("Attack Power: " + fighter.getAttacPower());
        //pistol details
        System.out.println("Pistol Model: " + pistol.getModel());
        System.out.println("Weight: " + pistol.getWeight());
        System.out.println("Magazine Capacity: " + pistol.getMagazineCapacity());
    }
    //behavior method (uses BOTH objects)
    public void engageCombat(Fighter_Costiniano opponent) {
        System.out.println(playerName + " enters combat!");

        pistol.shoot(); //uses pistol behavior
        fighter.attack(opponent); //uses fighter behavior
    }
}
