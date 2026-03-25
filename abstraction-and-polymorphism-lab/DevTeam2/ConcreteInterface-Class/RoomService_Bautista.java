// Concrete interface class created by Bautista
// Uses teammate interface class "Breakfast_Alvarez" created by Alvarez.
// Demonstrates overriding and overloading.

public class RoomService_Bautista implements Breakfast_Alvarez {

    @Override
    public void serve() {
        System.out.println("Serving your ordered breakfast to your room.");   
    }
    // Overloading
    public void serve(int roomNumber, String meal) {
        System.out.println("Serving " + meal + " to room " + roomNumber + ".");
    }
}