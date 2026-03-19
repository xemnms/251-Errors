package CompositeClasses;

import ComponentClasses.Mage_Isles;
import ComponentClasses.SchedulePlanner_Rodenas;;

public class MageAttackPlanning_Badosa {
    private Mage_Isles mage;
    private SchedulePlanner_Rodenas schedule;

    // Constructor using components
    public MageAttackPlanning_Badosa(Mage_Isles mage, SchedulePlanner_Rodenas schedule) {
        this.mage = mage;
        this.schedule = schedule;
    }

    // Getters and setters
    public Mage_Isles getMage() {
        return mage;
    }

    public SchedulePlanner_Rodenas getSchedule() {
        return schedule;
    }

    public void setMage(Mage_Isles mage) {
        if (mage != null && !mage.getElementName().isEmpty()) {
            this.mage = mage;
        }else {
            System.out.println("Invalid mage. Mage cannot be null or empty.");
        }
    }

    public void setSchedule(SchedulePlanner_Rodenas schedule) {
        if (schedule != null && !schedule.getDay().isEmpty()) {
            this.schedule = schedule;
        }else {
            System.out.println("Invalid schedule. Schedule cannot be null or empty.");
        }
    }

    // Demonstrates how the two components collaborate
    public void displayPlan() {
        System.out.println("=== Mage Attack Plan ===");
        System.out.println("Mage Element: " + mage.getElementName());
        System.out.println("Mage Power Level: " + mage.getPowerLevel());
        System.out.println("Scheduled Attack: ");
        schedule.displaySchedule();
    }
}
