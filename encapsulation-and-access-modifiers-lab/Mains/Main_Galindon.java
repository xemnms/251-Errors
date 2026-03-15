public class Main_Galindon{
    public static void main(String[] args){
        // class created by Arandela, object created by galindon
        //constructor without parameter
        MovieReservation_Arandela m1 = new MovieReservation_Arandela();
        System.out.println("== Default Reservation ==");
        System.out.println("Movie Title: " + m1.getMovieTitle());
        System.out.println("Customer Name: " + m1.getCustomerName());
        System.out.println("Number of Tickets: " + m1.getNumberOfTickets());
        System.out.println("Reservation Date: " + m1.getReservationDate());
        System.out.println("Total Reservations: " + m1.getTotalReservations() + "\n");

        //Create constructor with parameter
        MovieReservation_Arandela m2 = new MovieReservation_Arandela("Interstellar", "Max", 2, " March 21 2026");
        System.out.println("== Valid Reservation ==");
        System.out.println("Movie Title: " + m2.getMovieTitle());
        System.out.println("Customer Name: " + m2.getCustomerName());
        System.out.println("Number of Tickets: " + m2.getNumberOfTickets());
        System.out.println("Reservation Date: " + m2.getReservationDate());
        System.out.println("Total Reservations: " + m2.getTotalReservations() + "\n");

        //demonstrate setters
        m1.setMovieTitle("Wicked");
        m1.setCustomerName("Ralph");
        m1.setNumberofTickets(3);
        m1.setReservationDate("March 22, 2026");

        System.out.println("== New Reservation Using Setters ==");
        System.out.println("Movie Title: " + m1.getMovieTitle());
        System.out.println("Customer Name: " + m1.getCustomerName());
        System.out.println("Number of Tickets: " + m1.getNumberOfTickets());
        System.out.println("Reservation Date: " + m1.getReservationDate());
        System.out.println("Total Reservations: " + m1.getTotalReservations() + "\n");

        //display total reservation count
        System.out.println("Total Reservations Made: " + MovieReservation_Arandela.getTotalReservations());


    }

}