public class MusicEra {
    //static attribute
    private static int totalErasCount = 0;

    //private attributes
    private String eraName;
    private int releaseYear;
    private int trackCount;
    private boolean isOwnedByArtist;

    //constructors
    public MusicEra(String name, int year, int tracks) {
        setEraName(name);       //validation rule 1
        setReleaseYear(year);   //validation rule 2
        setTrackCount(tracks);  //validation rule 3
        this.isOwnedByArtist = true;
        
        totalErasCount++; //static behavior
    }

    public MusicEra() {
        this("Reputation", 2017, 15);
    }

    //strong encapsulation & validation logic
    public String getEraName() { 
        return eraName; 
    }

    public void setEraName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.eraName = name;
        }
    }

    public int getReleaseYear() { return releaseYear; }

    // validation rule 2
    public void setReleaseYear(int year) {
        if (year >= 2006) {
            this.releaseYear = year;
        }
    }

    public int getTrackCount() { return trackCount; }

    //rule: trackCount must always be 1 or more.
    public void setTrackCount(int count) {
        if (count > 0) {
            this.trackCount = count;
        }
    }

    //behaviors (methods)
    public void playEra() {
        System.out.println("Now playing the " + eraName + " era.");
    }

    public void displayInfo() {
        System.out.println("Era: " + eraName + " | Year: " + releaseYear);
    }

    public static int getTotalEras() {
        return totalErasCount;
    }
}