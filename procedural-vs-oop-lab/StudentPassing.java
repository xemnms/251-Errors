public class StudentPassing {
    public static void main(String[] args) {
        // Example student grades
        double grade1 = 85.0;
        double grade2 = 74.5;
        double grade3 = 92.3;

        double average = calculateAverage(grade1, grade2, grade3);
        boolean passing = hasPassingGrade(average);

        System.out.println("Average grade: " + average);
        if (passing) {
            System.out.println("The student is passing.");
        } else {
            System.out.println("The student is not passing.");
        }
    }

    // Procedural helper methods
    public static double calculateAverage(double g1, double g2, double g3) {
        return (g1 + g2 + g3) / 3.0;
    }

    public static boolean hasPassingGrade(double avg) {
        // passing threshold is 75
        return avg >= 75.0;
    }
}

//javac procedural-vs-oop-lab/StudentPassing.java
//java -cp procedural-vs-oop-lab StudentPassing