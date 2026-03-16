public class Main_Acosta {
    public static void main(String[] args) {

        // Room.java Class Created by Badosa

        // FIRST OBJECT OF THE ROOM CLASS
        System.out.println("\nFirst Room Object:");
        Room_Badosa roomOne = new Room_Badosa();
        roomOne.setRoomNumber(101); // Setters with validation
        roomOne.setRoomPrice(500);
        roomOne.setRoomType("Triple"); // Purposefully entering an invalid room type to test validation
        roomOne.checkIn(); // Two behaviours of the Room class
        roomOne.checkOut();
        roomOne.getRoomDetails(); // Getter to display the details of the room
        System.out.println("\nTotal Rooms Created:"); // Using the static method to display the total number of rooms
                                                      // created
        roomOne.getTotalRoom();

        System.out.println("\n-----------------------------\n");
        // Reservation Class Created by Costiniano
        System.out.println("First Reservation Object:");
        Reservation_Costiniano reservationOne = new Reservation_Costiniano("Mako", 01, -1, 999); // Creating an object
                                                                                                 // with invalid values
                                                                                                 // to
                                                                                                 // test the validation
                                                                                                 // in
                                                                                                 // the setters
        System.out.println("\nReservation Details:");
        System.out.println("Guest Name: " + reservationOne.getGuestName()); // Using getters to display the details of
                                                                            // the reservation
        System.out.println("Reservation ID: " + reservationOne.getReservationId());
        System.out.println("Number of Guests: " + reservationOne.getNumberOfGuests());
        System.out.println("Nights: " + reservationOne.getNights());
        System.out.println("\nExtending the stay by 1 night...");
        reservationOne.extendStay(1); // Testing the extend stay method
        System.out.println("Updated Nights: " + reservationOne.getNights()); // Using getter to display the updated
                                                                             // number of nights

        System.out.println("Total Reservations: " + Reservation_Costiniano.getTotalReservations()); // Using the static
                                                                                                    // method to display
                                                                                                    // the total number
                                                                                                    // of reservations
                                                                                                    // created

    }

}
