// Uses interface Breakfast_Alvarez by Alvarez

public class Breakfast_Acosta implements Breakfast_Alvarez{
    
    @Override
    public void serve() {
        System.out.println("Your cereal is here!");
    }

    //Overloaded method
    public void addMilk(String milkFlavor) { // ex. Chocolate
        System.out.println("You poured " + milkFlavor + " milk!");
    }

}
