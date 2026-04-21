/*
 * Class created by Kayle Alonde
 * Represents a digital album in a music archive.
 */

public class DigitalAlbum_Alonde {
    // prrivate attributes
    private String title;
    private String artist;
    private int trackCount;
    private double price;

    // static attribute
    private static int totalAlbumsInArchive = 0;

    // constructors
    public DigitalAlbum_Alonde(String title, String artist) {
        setTitle(title);
        setArtist(artist);
        this.trackCount = 1;
        this.price = 0.0;
        totalAlbumsInArchive++;
    }

    public DigitalAlbum_Alonde(String title, String artist, int trackCount, double price) {
        setTitle(title);
        setArtist(artist);
        setTrackCount(trackCount);
        setPrice(price);
        totalAlbumsInArchive++;
    }

    // getters and setters with validation
    public String getTitle() { return title; }
    
    public void setTitle(String title) {
        // validation 1: title cannot be empty
        if (title != null && !title.trim().isEmpty()) {
            this.title = title;
        } else {
            this.title = "Unknown Album";
        }
    }

    public String getArtist() { return artist; }
    
    public void setArtist(String artist) {
        if (artist != null && !artist.trim().isEmpty()) {
            this.artist = artist;
        }
    }

    public int getTrackCount() { return trackCount; }
    
    public void setTrackCount(int trackCount) {
        // validation 2 & object invariant: trackCount must always be > 0
        if (trackCount > 0) {
            this.trackCount = trackCount;
        }
    }

    public double getPrice() { return price; }
    
    public void setPrice(double price) {
        // validation 3: price cannot be negative
        if (price >= 0) {
            this.price = price;
        }
    }

    // behaviors
    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            this.price -= (this.price * (percentage / 100));
            System.out.println("Discount applied to " + title + "! New price: $" + price);
        }
    }

    public void displayDetails() {
        System.out.println("--- Album Archive Entry ---");
        System.out.println("Title: " + title + " | Artist: " + artist);
        System.out.println("Tracks: " + trackCount + " | Price: $" + price);
    }

    // static behavior
    public static int getTotalAlbumsInArchive() {
        return totalAlbumsInArchive;
    }
}