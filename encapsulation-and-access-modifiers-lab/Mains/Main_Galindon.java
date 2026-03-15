public class Main_Galindon{
    public static void main(String[] args){
        // class created by Arandela, object created by Galindon

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



        //Class Created by Batangan, object created by Galindon

        // Object 1 using default constructor
        Playlist_Batangan playlist1 = new Playlist_Batangan();

        // Object 2 using parameterized constructor
        Playlist_Batangan playlist2 = new Playlist_Batangan("Yearning", "Blues", 10, 35);

        // Object 3 using parameterized constructor
        Playlist_Batangan playlist3 = new Playlist_Batangan("Productivity Mix", "Pop", 15, 60);

        // Using behaviors
        playlist1.addSong(4);
        playlist1.addSong(3);

        playlist2.addSong(5);
        playlist3.removeSong(10);

        // Display playlist information
        playlist1.displayPlaylist();
        playlist2.displayPlaylist();
        playlist3.displayPlaylist();

        // Display total playlists created
        System.out.println("Total Playlists Created: " + Playlist_Batangan.getTotalPlaylists());
    }

}

