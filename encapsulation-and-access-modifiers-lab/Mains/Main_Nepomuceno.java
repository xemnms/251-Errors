public class Main_Nepomuceno {
    public static void main(String[] args){
       System.out.println("========== PRISONER MANAGEMENT SYSTEM DEMO ==========\n");

        // Create prisoners
        Prisoner_Bagay prisoner1 = new Prisoner_Bagay();
        Prisoner_Bagay prisoner2 = new Prisoner_Bagay("Jane Smith", 50, 45);
        Prisoner_Bagay prisoner3 = new Prisoner_Bagay("Mike Johnson", 120, 85);

        // Display all prisoners
        System.out.println("--- Initial Prisoner Status ---\n");
        displayPrisonerInfo(prisoner1);
        displayPrisonerInfo(prisoner2);
        displayPrisonerInfo(prisoner3);

        // Test serveMonths
        System.out.println("\n--- Testing serveMonths() ---\n");
        System.out.println("Prisoner 1 serving 5 months...");
        prisoner1.serveMonths(5);
        displayPrisonerInfo(prisoner1);

        System.out.println("Prisoner 2 serving 20 months...");
        prisoner2.serveMonths(20);
        displayPrisonerInfo(prisoner2);

        System.out.println("Prisoner 3 trying to serve 150 months (exceeds limit)...");
        prisoner3.serveMonths(150);
        displayPrisonerInfo(prisoner3);

        // Test addBehaviorPoints
        System.out.println("\n--- Testing addBehaviorPoints() ---\n");
        System.out.println("Prisoner 2 adding 25 behavior points...");
        prisoner2.addBehaviorPoints(25);
        displayPrisonerInfo(prisoner2);

        System.out.println("Prisoner 3 adding 10 behavior points...");
        prisoner3.addBehaviorPoints(10);
        displayPrisonerInfo(prisoner3);

        // Test extendSentence
        System.out.println("\n--- Testing extendSentence() ---\n");
        System.out.println("Prisoner 1 extending sentence by 50 months...");
        prisoner1.extendSentence(50);
        displayPrisonerInfo(prisoner1);

        System.out.println("Prisoner 2 extending sentence by 10 months...");
        prisoner2.extendSentence(10);
        displayPrisonerInfo(prisoner2);

        // Test setInmateName
        System.out.println("\n--- Testing setInmateName() ---\n");
        System.out.println("Changing Prisoner 1 name to 'Robert Williams'...");
        prisoner1.setInmateName("Robert Williams");
        displayPrisonerInfo(prisoner1);

        System.out.println("Trying to set Prisoner 2 name to empty string...");
        prisoner2.setInmateName("");
        System.out.println("Name remains: " + prisoner2.getInmateName() + "\n");

        // Final summary
        System.out.println("\n--- Final Summary ---\n");
        displayPrisonerInfo(prisoner1);
        displayPrisonerInfo(prisoner2);
        displayPrisonerInfo(prisoner3);

        System.out.println("Total Prisoners Created: " + Prisoner_Bagay.getTotalPrisonersCreated());
        System.out.println("\n========== END OF DEMO ==========");
    }

    // Helper method to display prisoner information so that it is not hardcoded in the main method
    private static void displayPrisonerInfo(Prisoner_Bagay prisoner) {
        System.out.println("Name: " + prisoner.getInmateName());
        System.out.println("ID: " + prisoner.getInmateId());
        System.out.println("Sentence: " + prisoner.getSentenceMonths() + " months");
        System.out.println("Behavior Score: " + prisoner.getBehaviorScore() + "/100");
        System.out.println("Parole Eligible: " + prisoner.isParoleEligible());
        System.out.println();
    }
}