/* Demo class showing:
   - Overriding
   - Overloading
   - Dynamic Binding
   - Use of abstract class and interface
*/

public class AbstractionPolyDemo_Bautista {

    public static void main(String[] args) {
        
        // Dynamic Binding (Abstract Class)
        Cereal_Alvarez cereal = new CerealKiller_Bautista();

        // Calls overridden method (runtime decides which method to use)
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