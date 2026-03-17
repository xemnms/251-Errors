//Main Class Created by Andrew Dizon
//Classes used: MovieReservation_Arandela & Playlist_Batangan

import java.util.Random;

public class Main_Dizon {
    public static void main(String[] args) {
        Random rng = new Random();

        // Data arrays for varied object generation
        String[] cinemaList = {"Eternal Sunshine", "Spider-Verse", "The Godfather", "Inception"};
        String[] audioThemes = {"Midnight Driving", "Focus Flow", "Summer Hits", "Retro Vibes"};
        String[] musicStyles = {"Indie", "Classical", "Pop", "Rock"};

        System.out.println("--- SYSTEM INITIALIZATION: DIZON ---");

        //ARRAY STORAGE
        MovieReservation_Arandela[] movieBookings = new MovieReservation_Arandela[4];
        Playlist_Batangan[] musicPlaylists = new Playlist_Batangan[4];

        //POPULATION PHASE (Using both Constructors)
        for (int i = 0; i < movieBookings.length; i++) {
            // Arandela 
            if (i % 2 == 0) {
                movieBookings[i] = new MovieReservation_Arandela(); // Default
            } else {
                movieBookings[i] = new MovieReservation_Arandela(cinemaList[i], "Client_" + (i + 10), i + 1, "2026-04-12");
            }

            // Batangan
            musicPlaylists[i] = new Playlist_Batangan(audioThemes[i], musicStyles[i], 0, 0);
        }

        //OBJECT INTERACTION
        MovieReservation_Arandela activeMovie = movieBookings[rng.nextInt(movieBookings.length)];
        Playlist_Batangan activePlaylist = musicPlaylists[rng.nextInt(musicPlaylists.length)];

        System.out.println("\n[Action] Configuring Selected Services...");
        
        // Using Setters to update state
        activeMovie.setMovieTitle("The Batman (Special Screening)");
        activeMovie.setNumberOfTickets(6);
        
        activePlaylist.setPlaylistName("Dizon's Choice: " + activePlaylist.getPlaylistName());

        //BEHAVIORAL EXECUTION
        System.out.println("\n--- Processing Playlist Activities ---");
        activePlaylist.addSong(4); 
        activePlaylist.addSong(3);
        activePlaylist.removeSong(2); 
        activePlaylist.displayPlaylist(); 

        System.out.println("\n--- Processing Reservation Status ---");
        System.out.println("Reserved for: " + activeMovie.getCustomerName());
        System.out.println("Film: " + activeMovie.getMovieTitle());
        System.out.println("Booking Date: " + activeMovie.getReservationDate());

        //VALIDATION TESTING
        System.out.println("\n--- Encapsulation Integrity Test ---");

        //Testing Arandela's ticket 
        System.out.print("Testing 50-ticket limit: ");
        activeMovie.setNumberOfTickets(50); 
        System.out.println("Result: " + activeMovie.getNumberOfTickets());

        // Testing Batangan's string validation
        System.out.print("Testing empty genre assignment: ");
        activePlaylist.setGenre("   ");
        System.out.println("Result Genre: " + activePlaylist.getGenre());

        //STATIC REPORTING
        System.out.println("\n--- Global Analytics ---");
        System.out.println("Global Reservations: " + MovieReservation_Arandela.getTotalReservations());
        System.out.println("Global Playlists: " + Playlist_Batangan.getTotalPlaylists());
    }
}