public class Gadgets_Bagay {

	// Private attributes (minimum: 3)
	private String gadgetType;
	private int batteryLevel;
	private boolean isOn;

	// Constructor
	public Gadgets_Bagay(int batteryLevel) {
		setBatteryLevel(batteryLevel);
		this.isOn = false;
	}

	// Behaviors (minimum: 2)
	public void turnOn() {
		if (batteryLevel <= 0) {
			System.out.println(gadgetType + " cannot turn on. Battery is empty.");
			return;
		}
		isOn = true;
		System.out.println(gadgetType + " is now ON.");
	}

	public void turnOff() {
		isOn = false;
		System.out.println(gadgetType + " is now OFF.");
	}

	public void fullCharge() {
		batteryLevel = 100;
		System.out.println(gadgetType + " is now fully charged.");
	}

	public boolean isLowBattery() {
		return batteryLevel <= 20;
	}

	public void displayDetails() {
		System.out.println("Gadget Type: " + gadgetType);
		System.out.println("Battery Level: " + batteryLevel + "%");
		System.out.println("Power: " + (isOn ? "ON" : "OFF"));
		System.out.println("Low Battery: " + (isLowBattery() ? "YES" : "NO"));
	}

	// Getters
	public String getGadgetType() {
		return gadgetType;
	}

	public int getBatteryLevel() {
		return batteryLevel;
	}

	public boolean isOn() {
		return isOn;
	}

	// Setters
	public void setGadgetType(String gadgetType) {
		if (gadgetType == null || gadgetType.trim().isEmpty()) {
			System.out.println("Gadget type cannot be empty.");
			return;
		}

		this.gadgetType = gadgetType;
	}

	public void setBatteryLevel(int batteryLevel) {
		if (batteryLevel < 0 || batteryLevel > 100) {
			System.out.println("Battery level must be from 0 to 100.");
			return;
		}
		this.batteryLevel = batteryLevel;
	}

	public void setOn(boolean on) {
		if (on && batteryLevel <= 0) {
			System.out.println("Cannot power ON when battery is empty.");
			return;
		}
		this.isOn = on;
	}
}
