public class E_Bike_Nepomuceno {
    private Battery battery;
    private Motor motor;
    private String bikeName;
    private String frameColor;
    private double wheelSize;
    private boolean isLocked;

    // Constructor with dependency injection
    public EBikeNepomuceno(String bikeName, String frameColor, double wheelSize, Battery battery, Motor motor) {
        this.bikeName = bikeName;
        this.frameColor = frameColor;
        this.wheelSize = wheelSize;
        this.battery = battery;
        this.motor = motor;
        this.isLocked = true;
    }

    // Alternative constructor with setters
    public EBikeNepomuceno(String bikeName, String frameColor, double wheelSize) {
        this.bikeName = bikeName;
        this.frameColor = frameColor;
        this.wheelSize = wheelSize;
        this.isLocked = true;
    }

    // Getter and setter for Battery
    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        if (battery != null) {
            this.battery = battery;
        }
    }

    // Getter and setter for Motor
    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        if (motor != null) {
            this.motor = motor;
        }
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        if (bikeName != null && !bikeName.isEmpty()) {
            this.bikeName = bikeName;
        }
    }

    public String getFrameColor() {
        return frameColor;
    }

    public void setFrameColor(String frameColor) {
        if (frameColor != null && !frameColor.isEmpty()) {
            this.frameColor = frameColor;
        }
    }

    public double getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(double wheelSize) {
        if (wheelSize > 0) {
            this.wheelSize = wheelSize;
        }
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    // EBike behavior - unlock the bike
    public void unlockBike() {
        if (battery != null && battery.getChargeLevel() > 5) {
            isLocked = false;
            System.out.println(bikeName + " is now unlocked!");
        } else {
            System.out.println("Cannot unlock - insufficient battery!");
        }
    }

    // EBike behavior - lock the bike
    public void lockBike() {
        isLocked = true;
        System.out.println(bikeName + " is now locked!");
    }

    // EBike behavior - start riding
    public void startRiding() {
        if (isLocked) {
            System.out.println("Cannot ride - bike is locked!");
            return;
        }

        if (battery != null && motor != null) {
            if (battery.getChargeLevel() > 10) {
                System.out.println("Starting ride on " + bikeName + "...");
                motor.engageMotor();
                battery.consumePower(5);
                System.out.println("Ready to ride!");
            } else {
                System.out.println("Cannot start ride - battery too low!");
            }
        }
    }

    // EBike behavior - accelerate with motor assistance
    public void accelerateWithAssistance(int level) {
        if (isLocked) {
            System.out.println("Bike is locked!");
            return;
        }

        if (battery != null && motor != null) {
            if (battery.getChargeLevel() > 15) {
                System.out.println("Accelerating " + bikeName + " with assistance level " + level + "...");
                motor.setAssistanceLevel(level);
                motor.engage();
                battery.consumePower(level * 2);
                System.out.println("Motor assistance engaged!");
            } else {
                System.out.println("Battery too low for motor assistance!");
            }
        }
    }

    // EBike behavior - stop and disengage motor
    public void stopRiding() {
        if (motor != null) {
            System.out.println("Stopping " + bikeName + "...");
            motor.disengage();
        }
    }

    // EBike behavior - charge the battery
    public void chargeBattery() {
        if (battery != null) {
            System.out.println("Charging " + bikeName + "'s battery...");
            battery.recharge();
        }
    }

    // Get bike status
    public String getBikeStatus() {
        String status = "=== " + bikeName + " Status ===\n";
        status += "Frame Color: " + frameColor + "\n";
        status += "Wheel Size: " + wheelSize + " inches\n";
        status += "Locked: " + isLocked + "\n";

        if (battery != null) {
            status += "Battery Charge: " + battery.getChargeLevel() + "%\n";
        }
        if (motor != null) {
            status += "Motor Status: " + (motor.isEngaged() ? "Engaged" : "Disengaged") + "\n";
        }

        return status;
    }

    @Override
    public String toString() {
        return "EBikeNepomuceno{" +
                "bikeName='" + bikeName + '\'' +
                ", frameColor='" + frameColor + '\'' +
                ", wheelSize=" + wheelSize +
                ", isLocked=" + isLocked +
                ", battery=" + battery +
                ", motor=" + motor +
                '}';
    }
}