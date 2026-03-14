public class Main_Badosa {
    public static void main(String[] args) {
        // Class Created by Costiniano
        System.out.println("RESERVATION TESTING");
        // Object Creation
        ReservationCostiniano reservation1 = new ReservationCostiniano();
        ReservationCostiniano reservation2 = new ReservationCostiniano();
        ReservationCostiniano reservation3 = new ReservationCostiniano();

        // Validation Testing
        reservation1.setGuestName(" ");
        reservation2.setGuestName(null);
        reservation3.setGuestName("Bien");

        reservation1.setReservationId(-123123);
        reservation2.setReservationId(0);
        reservation3.setReservationId(123456);

        reservation1.setNumberOfGuests(0);
        reservation2.setNumberOfGuests(-111);
        reservation3.setNumberOfGuests(12);

        reservation1.setNights(0);
        reservation2.setNights(-2);
        reservation3.setNights(3);
        reservation3.extendStay(2);

        // Getting details
        System.out.println("===========================");
        System.out.println("Name: " + reservation1.getGuestName());
        System.out.println("Reservation ID: " + reservation1.getReservationId());
        System.out.println("Number of Guests: " + reservation1.getNumberOfGuests());
        System.out.println("Nights: " + reservation1.getNights());
        System.out.println("===========================");
        System.out.println("Name: " + reservation2.getGuestName());
        System.out.println("Reservation ID: " + reservation2.getReservationId());
        System.out.println("Number of Guests: " + reservation2.getNumberOfGuests());
        System.out.println("Nights: " + reservation2.getNights());
        System.out.println("===========================");
        System.out.println("Name: " + reservation3.getGuestName());
        System.out.println("Reservation ID: " + reservation3.getReservationId());
        System.out.println("Number of Guests: " + reservation3.getNumberOfGuests());
        System.out.println("Nights: " + reservation3.getNights());
        System.out.println("===========================\n");

        // Class Created by Acosta
        System.out.println("CAT TESTING");

        // Object Creation
        Cat1_Acosta cat1 = new Cat1_Acosta();
        Cat1_Acosta cat2 = new Cat1_Acosta();

        // Validation testing
        cat1.setName("");
        cat2.setName("Poofy");
        /* cat2.setName(null) causes error */

        cat1.setAge(0);
        cat2.setAge(2);

        cat1.setBreed("");
        cat2.setBreed("Ginger");

        // Display
        System.out.println("=======================");
        cat1.introduceCat();
        cat2.introduceCat();
        System.out.println("=======================");
    }
}