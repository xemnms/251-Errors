// Parent Class created by Bautista
// Represents musical instrument that can be played and tuned

public class Overthinker_Costiniano {

    //attributes
    String name;
    int thoughtsPerMinute;
    String favoriteWorry;

    //constructor
    public Overthinker_Costiniano(String name, int thoughtsPerMinute, String favoriteWorry) {
        this.name = name;
        this.thoughtsPerMinute = thoughtsPerMinute;
        this.favoriteWorry = favoriteWorry;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getThoughtsPerMinute() {
        return thoughtsPerMinute;
    }

    public String getFavoriteWorry() {
        return favoriteWorry;
    }

    //behaviors
    public void think() {
        System.out.println(name + " is overanalyzing everything.");
    }

    public void worry() {
        System.out.println(name + " is worrying about: " + favoriteWorry);
    }

    //method that can be overridden
    public void reactToProblem() {
        System.out.println("Overthinker is imagining 100 possible outcomes.");
    }
}