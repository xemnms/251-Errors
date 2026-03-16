public class Travel_Dizon {

    // Private Attributes
    private int travelExpenses;
    private String travelDestination;
    private int travelDays;
    private int travelGuests;

    // Static Attributes 
    private static int totalTripsCreated = 0;
    private static int totalGlobalExpenses = 0;

    // Default
    public Travel_Dizon() {
        this.travelExpenses = 0;
        this.travelDestination = "Unknown";
        this.travelDays = 1;
        this.travelGuests = 1;
        totalTripsCreated++;
    }

    // Parameterized Consructor
    public Travel_Dizon(int travelExpenses, String travelDestination, int travelDays, int travelGuests) {
        setTravelExpenses(travelExpenses);
        setTravelDestination(travelDestination);
        setTravelDays(travelDays);
        setTravelGuests(travelGuests);
        totalTripsCreated++;
    }

    // Getters
    public int getTravelExpenses() { return travelExpenses; }
    public String getTravelDestination() { return travelDestination; }
    public int getTravelDays() { return travelDays; }
    public int getTravelGuests() { return travelGuests; }
    public static int getTotalTripsCreated() { return totalTripsCreated; }
    public static int getTotalGlobalExpenses() { return totalGlobalExpenses; }

    //SETTERS with Validation

    //Expenses cannot be negative
    public void setTravelExpenses(int travelExpenses) {
        if (travelExpenses >= 0) {
            // Adjust the static total if the expense changes
            totalGlobalExpenses -= this.travelExpenses; 
            this.travelExpenses = travelExpenses;
            totalGlobalExpenses += this.travelExpenses;
        } else {
            System.out.println("Error: Expenses cannot be negative.");
        }
    }

    // Destination cannot be empty or null
    public void setTravelDestination(String travelDestination) {
        if (travelDestination != null && !travelDestination.trim().isEmpty()) {
            this.travelDestination = travelDestination;
        } else {
            System.out.println("Error: Destination cannot be empty.");
        }
    }

    // Object Invariant
    public void setTravelDays(int travelDays) {
        if (travelDays > 0) {
            this.travelDays = travelDays;
        } else {
            System.out.println("Error: Travel duration must be at least 1 day.");
        }
    }

    public void setTravelGuests(int travelGuests) {
        if (travelGuests > 0) {
            this.travelGuests = travelGuests;
        } else {
            System.out.println("Error: There must be at least 1 guest.");
        }
    }

    // BEHAVIORS

    // Calculate cost per person
    public double calculateCostPerPerson() {
        return (double) travelExpenses / travelGuests;
    }

    // additional unplanned expenses
    public void addExtraExpense(int amount) {
        if (amount > 0) {
            this.travelExpenses += amount;
            totalGlobalExpenses += amount;
            System.out.println("Added " + amount + " to the budget.");
        }
    }
}