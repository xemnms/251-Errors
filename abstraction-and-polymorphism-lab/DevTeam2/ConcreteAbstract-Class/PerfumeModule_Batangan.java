// Created by Batangan
// Uses teammate abstract class "LearningModule_Bagay"
// Demonstrates overriding and overloading

public class PerfumeModule_Batangan extends LearningModule_Bagay {

    @Override
    void startLesson() {
        System.out.println("Starting perfume lesson: Understanding scent notes 🌸");
    }

    // Overloading
    void startLesson(String perfumeName) {
        System.out.println("Starting lesson for perfume: " + perfumeName);
    }
}
