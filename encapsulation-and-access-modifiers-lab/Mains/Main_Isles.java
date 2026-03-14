public class Main_Isles {
    public static void main(String[] args) {
    	//objects created by dan isles, class made by kyla rodenas
        System.out.println("=======LRCBook Demo=======\n");
        //creates first book using default constructor
        LRCBook_Rodenas book1 = new LRCBook_Rodenas();
        book1.setBookId(-15);
        book1.setTitle("");
        book1.setPages(250);
        System.out.println();

        //initializes getters to print book details out
        book1.getBookDetails();
        book1.borrowBook();
        book1.getBookDetails();

        System.out.println();

        //creates second book using parameterized constructor
        LRCBook_Rodenas book2 = new LRCBook_Rodenas(102, "", 320);

        book2.getBookDetails();
        book2.borrowBook();
        book2.returnBook();
        book2.getBookDetails();

        System.out.println();

        //shows total books borrowed and created
        LRCBook_Rodenas.getTotalBooks();
        LRCBook_Rodenas.getTotalBorrowedBooks();
        
    	//objects created by dan isles, class made by clisha batangan
        System.out.println("\n=======Playlist_Batangan Demo=======\n");
        //creates first playlist using default constructor
        Playlist_Batangan playlist1 = new Playlist_Batangan();
        playlist1.setPlaylistName("Chill Vibes");
        playlist1.setGenre("Lo-Fi");
        playlist1.setNumberOfSongs(-5);
        playlist1.setDurationMinutes(25);

        playlist1.displayPlaylist();

        //add and remove songs
        playlist1.addSong(1);
        playlist1.removeSong(3);

        System.out.println("After adding/removing songs:");
        playlist1.displayPlaylist();
        System.out.println();

        //creates second playlist using parameterized constructor
        Playlist_Batangan playlist2 = new Playlist_Batangan("Workout Hits", "Pop", 10, 40);
        playlist2.displayPlaylist();

        //adds a song
        playlist2.addSong(-12);
        System.out.println("After adding a song:");
        playlist2.displayPlaylist();

        System.out.println();

        //shows total playlists created
        System.out.println("Total playlists created: " + Playlist_Batangan.getTotalPlaylists());
    }
}
