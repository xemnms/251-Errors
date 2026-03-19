
package DemoFolder;
//this demo class was created by Costiniano
import ComponentClasses.Pistol_Badosa;
import ComponentClasses.SchedulePlanner_Rodenas;
import CompositeClasses.AgentMission_Costiniano;

public class CompositionDemoCostiniano {

    public static void main(String[] args) {
        
        //creates a pistol object
        Pistol_Badosa pistol = new Pistol_Badosa("Glock", 2, 15);
        
        //creates a schedule object
        SchedulePlanner_Rodenas schedule =
                new SchedulePlanner_Rodenas("Monday", "10:00", "Recon Mission");
        
        //combines both objects into one mission
        AgentMission_Costiniano mission =
                new AgentMission_Costiniano(pistol, schedule);
        
        //starts the mission (uses pistol and schedule)
        mission.StartMission();
        
        //reloads the pistol
        mission.reloadWeapon();
        
        //changes the mission task
        mission.updateMission("Stealth Operation");
    }
}