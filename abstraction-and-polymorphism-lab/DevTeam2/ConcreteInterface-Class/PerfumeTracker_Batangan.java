// Created by Batangan
// Uses teammate interface `Trackable_Bagay`
// Demonstrates overriding and overloading.

public class PerfumeTracker_Batangan implements Trackable_Bagay {

    @Override
    public void trackProgress(int percent) {
        System.out.println("Perfume usage is at " + percent + "%.");
    }

    // Overloading method
    public void trackProgress(int percent, String perfumeName) {
        System.out.println(perfumeName + " is used up to " + percent + "%.");
    }
}
