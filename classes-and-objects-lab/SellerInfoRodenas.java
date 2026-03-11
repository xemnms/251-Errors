/**
 * This class represents the information of a Seller in Bulldog BlueMarket
 * showing the seller's name, course, and year level.
 * This class was made by Kyla Cassandra Rodenas
 */

public class SellerInfoRodenas {

    // Attributes
    String sellerName;
    String course;
    int yearLevel;

    // Static attribute
    static int totalSellers = 0;

    // Default constructor
    public SellerInfoRodenas() {
        sellerName = "Unknown";
        course = "Undeclared";
        yearLevel = 1;
        totalSellers++;
    }

    // Parameterized constructor
    public SellerInfoRodenas(String sellerName, String course, int yearLevel) {
        this.sellerName = sellerName;
        this.course = course;
        this.yearLevel = yearLevel;
        totalSellers++;
    }

    // Overloaded constructor
    public SellerInfoRodenas(String sellerName, String course) {
        this.sellerName = sellerName;
        this.course = course;
        this.yearLevel = 1; //default year
        totalSellers++;
    }

    // Behavior without parameters
    void introduceSeller() {
        System.out.println("Seller Name: " + sellerName);
        System.out.println("Course: " + course);
        System.out.println("Year Level: " + yearLevel);
    }

    // Behavior with parameter
    void updateYearLevel(int newYearLevel) {
        yearLevel = newYearLevel;
        System.out.println(sellerName + " updated year level to " + yearLevel);
    }

    // Static method
    static void displayTotalSellers() {
        System.out.println("Total Sellers Created: " + totalSellers);
    }
}