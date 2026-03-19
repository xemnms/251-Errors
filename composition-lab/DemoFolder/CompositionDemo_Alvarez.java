/* Compostion Demo created by Alvarez
* for composition speakers_Acosta created by Acosta 
* and composite SoundSystem_Alvarez created by Alvarez
*/

public class CompositionDemo_Alvarez {
    public static void main(String[] args) {

        // create a speaker
        Speakers_Acosta mySpeakers = new Speakers_Acosta("Sony haze", "S100", 73);

        // SoundSystem HAS-A speakers_Acosta
        SoundSystem_Alvarez mySystem = new SoundSystem_Alvarez(mySpeakers);
        System.out.println("Buhay na kwarto Sistema");

        mySystem.turnOnSystem();
        mySystem.increaseVolume();
        mySystem.showStatus();
        mySystem.turnOffSystem();

        /* Compostion Demo created by Alvarez
        * for composition TimeMachine_Bautista created by Bautista
        * and composite TimeController_Alvarez created by Alvarez
        */

       // Create object
        TimeMachine_Bautista machine = new TimeMachine_Bautista("TM-01", 2025, 3, "Japan");

        // Inject into composed class
        TimeController_Alvarez controller = new TimeController_Alvarez(machine);

        // Run the program
        controller.startJourney();
    }
}