// Abstraction and Polymorphism Demo by Bautista
// This code demonstrates the use of abstract classes, interfaces, method overriding, and method overloading.

public class AbstractionPolyDemo_Bautista {

    public static void main(String[] args) {
        
        // Dynamic Binding (Abstract Class)
        Cereal_Alvarez cereal = new CerealKiller_Bautista();

        // Calls overridden methods from abstract class
        cereal.prepare();
        cereal.eat();

        // Dynamic Binding (Interface)
        Breakfast_Alvarez breakfast = new RoomService_Bautista();

        breakfast.serve(); // Calls overridden method from interface
        breakfast.addMilk(); // Calls default method from interface

        // Method Overloading (RoomService)
        RoomService_Bautista roomService = new RoomService_Bautista();

        roomService.serve(101, "Pancakes");

        // Method Overloading (CerealKiller)
        CerealKiller_Bautista cerealKiller = new CerealKiller_Bautista();

        cerealKiller.prepare("Cornflakes");
    }
}

/* Code-Based Analysis
1. What abstract class did you create? 
        - Athlete_Bautista
        
2. What interface did you create? 
        - Training_Bautista 

3. What methods did you override? 
        - prepare() in CerealKiller_Bautista, serve() in RoomService_Bautista

4. What methods did you overload? 
        - serve(string, int) in RoomService_Bautista, prepare(string) in CerealKiller_Bautista

5. Where does dynamic binding occur in your code? 
        - When preare() and serve() are called. 

6. Which part shows polymorphism? 
        - CerealKiller_Bautista behaves as a Cereal_Alvarez type, and RoomService_Bautista behaves as 
        a Breakfast_Alvarez type.

7. How does your design achieve low coupling? 
        - By using abstract classes and interfaces, we decouple the implementation from the contract, 
        allowing for flexibility and easier maintenance.
        
8. How does your design achieve high cohesion? 
        - Each class has a single responsibility: CerealKiller_Bautista focuses on cereal preparation, 
        RoomService_Bautista focuses on serving breakfast, and the interfaces/abstract classes define clear 
        contracts for behavior without mixing responsibilities.
*/