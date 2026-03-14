public class Playlist_Batangan {

    // Static attribute (counts how many playlists were created)
    private static int totalPlaylists = 0;

    // Private attributes (encapsulation)
    private String playlistName;
    private String genre;
    private int numberOfSongs;
    private int durationMinutes;

    // Constructor 1 (default)
    public Playlist_Batangan() {
        this.playlistName = "My Playlist";
        this.genre = "Unknown";
        this.numberOfSongs = 0;
        this.durationMinutes = 0;
        totalPlaylists++;
    }

    // Constructor 2 (parameterized)
    public Playlist_Batangan(String playlistName, String genre, int numberOfSongs, int durationMinutes) {
        setPlaylistName(playlistName);
        setGenre(genre);
        setNumberOfSongs(numberOfSongs);
        setDurationMinutes(durationMinutes);
        totalPlaylists++;
    }

    // Getters
    public String getPlaylistName() {
        return playlistName;
    }

    public String getGenre() {
        return genre;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public static int getTotalPlaylists() {
        return totalPlaylists;
    }

    // Setters with validation rules

    // Validation 1: name cannot be empty
    public void setPlaylistName(String playlistName) {
        if (playlistName != null && !playlistName.trim().isEmpty()) {
            this.playlistName = playlistName;
        }
    }

    // Validation 2: genre cannot be empty
    public void setGenre(String genre) {
        if (genre != null && !genre.trim().isEmpty()) {
            this.genre = genre;
        }
    }

    // Validation 3: number of songs cannot be negative
    public void setNumberOfSongs(int numberOfSongs) {
        if (numberOfSongs >= 0) {
            this.numberOfSongs = numberOfSongs;
        }
    }

    // Validation 4: duration cannot be negative
    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes >= 0) {
            this.durationMinutes = durationMinutes;
        }
    }

    // Behavior 1: add a song
    public void addSong(int minutes) {
        if (minutes > 0) {
            numberOfSongs++;
            durationMinutes += minutes;
        }
    }

    // Behavior 2: remove a song
    public void removeSong(int minutes) {
        if (numberOfSongs > 0 && minutes > 0 && durationMinutes - minutes >= 0) {
            numberOfSongs--;
            durationMinutes -= minutes;
        }
    }

    // Behavior 3: display playlist details
    public void displayPlaylist() {
    	System.out.println("-----------PLAYLIST-----------");
        System.out.println("Playlist Name:   " + playlistName);
        System.out.println("Genre:           " + genre);
        System.out.println("Number of Songs: " + numberOfSongs);
        System.out.println("Total Duration:  " + durationMinutes + " minutes");
        System.out.println("------------------------------");
    }
}
