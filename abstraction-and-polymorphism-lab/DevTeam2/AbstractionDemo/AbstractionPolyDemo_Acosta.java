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

/* Code-Based Analysis
* 1.) What abstract class did you create? : petAnimal_Acosta.java
* 2.) What interface did you create? : Feed_Acosta.java
* 3.) What methods did you override? : void prepare in KokoCrunch_Acosta from abstract class Cereal_Alvarez & void serve in Breakfast_Acosta from interface Breakfast_Alvarez
* 4.) What methods did you overload? : void prepare(int bowlAmount) in KokoCrunch_Acosta class & void addMilk(String milkFlavor) in Breakfast_Acosta interface
* 5.) Where does dynamic binding occur in your code? : When making the cereal object in the demo file.
* 6.) Which part shows polymorphism? : KokoCrunch_Acosta is extended from Cereal_Alvarez class. Breakfast_Acosta implements the Breakfast_Alvarez interface.
* 7.) How does your design achieve low coupling? : Parameters and behaviours between the classes and interfaces still work and are independent from one another.
* 8.) How does your design achieve high cohesion? : The classes and interface have one clear responsibility.
*/
