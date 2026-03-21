/* composite class created by Alvarez
* for speaker class craeated by Acosta
*/

public class SoundSystem_Alvarez {

    // private field
    private Speakers_Acosta speakers;

    // constructor injection
    public SoundSystem_Alvarez(Speakers_Acosta speakers) {
        this.speakers = speakers;
    }

    // behaviour (low coupling)
    public void turnOnSystem() {
        speakers.turnOn();
        System.out.println("ah naririnig ko na... " + "anong gentle gentle");
    }

    public void turnOffSystem() {
        speakers.turnOff();
        System.out.println("ah nawawala na ang porsyento ni taguro...");
    }

    public void increaseVolume() {
        speakers.increaseVolume();
        System.out.println("Nilalakasan ang porsyento sa: " + speakers.getVolume());
    }

    public void decreaseVolume() {
        speakers.decreaseVolume();
        System.out.println("Binabawasan ang porsyento sa: " + speakers.getVolume());
    }

    public void showStatus() {
        System.out.println("Speaker Brand: " + speakers.getBrand());
        System.out.println("Speaker Model: " + speakers.getModel());
        System.out.println("Volume: " + speakers.getVolume());
        System.out.println("Power: " + (speakers.isOn() ? "ON" : "OFF"));
    }
}