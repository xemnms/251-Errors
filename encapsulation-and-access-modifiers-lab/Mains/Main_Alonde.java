/*
 * Main Class Created by Kayle Alonde
 * Classes Used: Room_Badosa (Created by Badosa) and Travel_Dizon (Created by Dizon)
 */

public class Main_Alonde {
    public static void main(String[] args) {
        System.out.println("=== Team Collaboration: Encapsulation Demo ===\n");

        // 1. Room_Badosa class

        System.out.println("STARTING HOTEL SYSTEM DEMO");
        Room_Badosa suite = new Room_Badosa();
        
        // use setters
        suite.setRoomNumber(101);
        suite.setRoomType("Luxury");
        suite.setRoomPrice(250);
        
        // call behaviors
        suite.checkIn();
        suite.getRoomDetails();

        // test invalid inputs for room
        System.out.println("\nTesting Room Validation:");
        suite.setRoomNumber(-10);    // Should fail (must be > 0)
        suite.setRoomType("Economy"); // Should fail (invalid type)
        
        System.out.println("\n" + "=".repeat(45) + "\n");

        // 2. Travel_Dizon class

        System.out.println("STARTING TRAVEL SYSTEM DEMO");
        Travel_Dizon trip = new Travel_Dizon(1500, "Seoul", 6, 3);
        
        // access data via getters
        System.out.println("Destination: " + trip.getTravelDestination());
        System.out.println("Base Cost Per Guest: $" + trip.calculateCostPerPerson());

        // test Behavior
        trip.addExtraExpense(450);

        // test invalid inputs for travel
        System.out.println("\nTesting Travel Validation:");
        trip.setTravelExpenses(-100); // should fail (cannot be negative)
        trip.setTravelGuests(0);      // should fail (must be at least 1)
        
        System.out.println("\nFinal Travel Summary for " + trip.getTravelDestination());
        System.out.println("Total Global Expenses in System: $" + Travel_Dizon.getTotalGlobalExpenses());

        System.out.println("\nALL SYSTEM DEMOS COMPLETE");
    }
}