//parent class by alonde, child class by galindon
//first class, popopoppop era by nayeon eme

class PopEra extends MusicEra_Alonde {

    public PopEra(String name, int year, int tracks) {
        super(name, year, tracks);
    }

    public PopEra() {
        super();
    }

    // New behavior
    public void performConcert() {
        System.out.println("Performing a pop concert from this era!");
    }

    // Overriding parent method
    @Override
    public void playEra() {
        System.out.println("Playing pop hits from the " + getEraName() + " era!");
    }
}