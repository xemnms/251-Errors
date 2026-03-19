//second child class by galindon, parent class by alonde

class IndieEra extends MusicEra {

    public IndieEra(String name, int year, int tracks) {
        super(name, year, tracks);
    }

    // New behavior
    public void playIndieVibes() {
        System.out.println("Enjoying indie vibes from the " + getEraName() + " era!");
    }

    // Override method
    @Override
    public void playEra() {
        System.out.println("Playing indie tracks from the " + getEraName() + " era!");
    }
}