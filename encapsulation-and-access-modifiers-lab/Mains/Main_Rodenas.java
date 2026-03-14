/*
 * Objects created by Kyla Cassandra Rodenas using Batangan and Isles Class
 */
public class Main_BatanganIsles {
    public static void main(String[] args) {
        //Create objects from Playlist_Batangan class
        Playlist_Batangan playlist1 = new Playlist_Batangan();
        Playlist_Batangan playlist2 = new Playlist_Batangan("Chill Vibes", "Lo-fi", 5, 25);
        System.out.println("---- Setting Playlist Information ----");
        //Using setters with validation
        playlist1.setPlaylistName("");          // invalid
        playlist1.setPlaylistName("Workout Hits"); //valid

        playlist1.setGenre("");                 //invalid
        playlist1.setGenre("Pop");             // valid

        playlist1.setNumberOfSongs(-3);        //invalid
        playlist1.setNumberOfSongs(4);         //valid

        playlist1.setDurationMinutes(-10);     //invalid
        playlist1.setDurationMinutes(30);      //valid

        System.out.println("\n---- Playlist Details ----");

        //Using getter-like method
        playlist1.displayPlaylist();
        playlist2.displayPlaylist();

        System.out.println("\n---- Modifying Playlists ----");

        //Behavior 1: add/remove songs
        playlist1.addSong(3);
        playlist1.addSong(4);
        playlist1.removeSong(2);

        playlist2.addSong(5);
        playlist2.removeSong(10); //demonstrates validation
        System.out.println("\n---- Updated Playlist Details ----");
        playlist1.displayPlaylist();
        playlist2.displayPlaylist();

        System.out.println("\n---- Total Playlists Created ----");
        //Static method
        System.out.println("Total Playlists: " + Playlist_Batangan.getTotalPlaylists());

        //Create objects from Isles_Reservations class
        Isles_Reservations res1 = new Isles_Reservations();
        Isles_Reservations res2 = new Isles_Reservations("Clisha", false, 3, 1500);

        System.out.println("\n---- Setting Reservation Details ----");

        //Using setters with validation
        res1.setBookerName("");        //invalid
        res1.setBookerName("Marco");   //valid

        res1.setBookerTime(-2);        //invalid
        res1.setBookerTime(4);         //valid

        res1.setBookerAmount(-500);    //invalid
        res1.setBookerAmount(2000);    //valid

        System.out.println("\n---- Reservation Information ----");

        //Using getters
        System.out.println("Booker Name: " + res1.getBookerName());
        System.out.println("Time Booked: " + res1.getBookTime() + " hours");
        System.out.println("Amount Paid: " + res1.getAmountBook() + " pesos");

        System.out.println("\n---- Confirming Reservations ----");

        //Behavior: confirm booking
        res1.confirmBooking();
        res2.confirmBooking();

        System.out.println("\n---- Reservation Status ----");

        System.out.println("Reservation 1 confirmed: " + res1.getConfirmedBook());
        System.out.println("Reservation 2 confirmed: " + res2.getConfirmedBook());

        System.out.println("\n---- Total Confirmed Reservations ----");

        //Static attribute demonstration
        System.out.println("Total confirmed bookers: " + Isles_Reservations.getTotalBookers());
    }
}
