public class CompositionDemo_Batangan {

    public static void main(String[] args) {

        // From teammate classes (Alvarez & Acosta)
        engine_alvarez engine1 = new engine_alvarez(150, "V4");
        Speakers_Acosta speakers1 = new Speakers_Acosta("JBL", "Xtreme", 30);

        // Pass them into composed class
        SmartCar_Batangan car = new SmartCar_Batangan("Pink Racer 🎀", engine1, speakers1);

        // Object Collaboration Demo
        car.displayCar();
        car.startCar();
        car.driveWithMusic();

        System.out.println("\n--- Replacing Components (Low Coupling Test) --- \n");

        // Replace components (LOW COUPLING)
        engine_alvarez engine2 = new engine_alvarez(300, "V8");
        Speakers_Acosta speakers2 = new Speakers_Acosta("Sony", "BoomBox", 50);

        car.setEngine(engine2);
        car.setSpeakers(speakers2);

        // System still works after replacement
        car.displayCar();
        car.startCar();
        car.driveWithMusic();
    }
}
