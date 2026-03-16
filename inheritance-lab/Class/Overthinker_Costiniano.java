//Parent class created by Costiniano
//Represents Overthinker who tends to analyze a lot

public class Overthinker {

    String name;
    int thoughtsPerMinute;
    String favoriteWorry;

    public void think() {
        System.out.println(name + " is overanalyzing everything.");
    }

    public void worry() {
        System.out.println(name + " is worrying about: " + favoriteWorry);
    }

    // This method can be overridden by subclasses
    public void reactToProblem() {
        System.out.println("Overthinker is imagining 100 possible outcomes.");
    }
}