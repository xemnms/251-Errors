public class engine_alvarez {

    // private attributes
    private int horsepower;
    private String type;
    private boolean isRunning;

    // constructor
    public engine_alvarez(int horsepower, String type) {
        this.horsepower = horsepower;
        this.type = type;
        this.isRunning = isRunning;
    }

    // getter horsepower
    public int getHorsepower() {
        return horsepower;
    }

    // setter horsepower
    public void setHorsepower(int horsepower) {
        if (horsepower > 0) { // validation
        this.horsepower = horsepower;

        } else {
            System.out.println("anong klasing engine iyan? kabayo?");
        }
    }
    // getter type
    public String getType() {
        return type;
    }

    // setter type
    public void setType(String type) {
        this.type = type;
    }

    // getter isRunning
    public boolean isRunning() {
        return isRunning;
    }

    // setter isRunning
    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    // Behaviour 1
    public void startEngine() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("zzzzzzsttu stu stu stu.");
        } else {
            System.out.println("vroom vroom vroom");
        }
    }
}