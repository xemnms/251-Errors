//Abstraction Demo by Acosta
//

public class AbstractionPolyDemo_Acosta {
    public static void main(String[] args) {
        
        // KokoCrunch_Acosta uses Abstract class Cereal_Alvarez by Alvarez
        Cereal_Alvarez cereal = new KokoCrunch_Acosta(); // dynamic binding
        cereal.prepare(); //Overridden method

        // Overloading
        KokoCrunch_Acosta KokoCrunch = new KokoCrunch_Acosta();
        KokoCrunch.prepare(4);
        KokoCrunch.eat();

        //Breakfast_Acosta interface is from Breakfast_Alvarez
        Breakfast_Acosta breakfast = new Breakfast_Acosta();
        breakfast.addMilk("chocolate"); // Overloading
        breakfast.serve();
    }
}
