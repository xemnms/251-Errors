public class AbstractionPolyDemo_Batangan {
    public static void main(String[] args) {

        // PerfumeModule_Batangan uses abstract class `LearningModule_Bagay`
        PerfumeModule_Batangan module = new PerfumeModule_Batangan();
        module.startLesson();
        module.showModuleTitle("Perfume Basics 🌸");

        // Overloading on a concrete class
        module.startLesson("Strawberry Dream");

        // PerfumeTracker_batangan uses interface `Trackable_Bagay`
        PerfumeTracker_Batangan tracker = new PerfumeTracker_Batangan();
        tracker.trackProgress(40);
        tracker.progressTip();

        // Overloading on interface
        tracker.trackProgress(85, "Vanilla Bliss");
    }
}
