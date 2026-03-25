public class AbstractionPolyDemo_Batangan {
    public static void main(String[] args) {

        // PerfumeModule_Batangan uses abstract class "LearningModule_Bagay"
        PerfumeModule_Batangan module = new PerfumeModule_Batangan();
        module.startLesson();
        module.showModuleTitle("Perfume Basics 🌸");

        // Overloading 
        module.startLesson("Strawberry Dream");

        // PerfumeTracker_batangan uses interface "Trackable_Bagay"
        PerfumeTracker_Batangan tracker = new PerfumeTracker_Batangan();
        tracker.trackProgress(40);
        tracker.progressTip();

        // Overloading on interface
        tracker.trackProgress(85, "Vanilla Bliss");
    }
}

/* Code-Based Analysis
What abstract class did you create?
- The abstract class I created is Perfume_Batangan, which contains one abstract method smell() and one concrete method spray(String message).

What interface did you create?
- The interface I created is Spray_Batangan, which contains one abstract method sprayPerfume() and one default method chooseScent(String scent).

What methods did you override?
- The methods I overrode are trackProgress(int percent) in PerfumeTracker_Batangan, and startLesson() in PerfumeModule_Batangan.

What methods did you overload?
-The methods I overloaded are trackProgress(int percent, String perfumeName) in PerfumeTracker_Batangan, and startLesson(String perfumeName) in PerfumeModule_Batangan.

Where does dynamic binding occur in your code?
- Dynamic binding occurs whenever an abstract class or interface reference points to a concrete object, such as when Trackable_Bagay variable references a PerfumeTracker_Batangan object.

Which part shows polymorphism?
- Same method name behaves differently in each concrete class smell(), sprayPerfume(), startLesson().

How does your design achieve low coupling?
- The design achieves low coupling because the classes depend on abstractions rather than concrete implementations, which allows concrete classes to be replaced or reused without affecting other parts of the code.

How does your design achieve high cohesion?
- The design achieves high cohesion because each class has a clear, single responsibility, and all methods within each class support that purpose, such as PerfumeModule_Batangan handling lessons and PerfumeTracker_Batangan tracking perfume usage.
*/
