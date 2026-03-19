package CompositeClasses;
//composite class created by Costiniano
import ComponentClasses.Pistol_Badosa;
import ComponentClasses.SchedulePlanner_Rodenas;

public class AgentMission_Costiniano {

	private Pistol_Badosa pistol;
	private SchedulePlanner_Rodenas schedule;
	
	//constructor injection
	public AgentMission_Costiniano(Pistol_Badosa pistol, SchedulePlanner_Rodenas schedule) {
		this.pistol = pistol;
		this.schedule = schedule;
	}
	
	//behavior: start mission
	public void StartMission() {
		System.out.println("Mission Starting...");
		schedule.displaySchedule();
		pistol.shoot();
	}
	
	//behavior: reload weapon
	public void reloadWeapon() {
		pistol.reload();
	}
	
	//behavior: change mission subject
	public void  updateMission(String newSubject) {
		schedule.updateSubject(newSubject);
	}
}