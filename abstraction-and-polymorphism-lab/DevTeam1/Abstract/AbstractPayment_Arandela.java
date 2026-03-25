public abstract class AbstractPayment_Arandela {

    private final String paymentType;
    private final String date;
    private double amount;
    private boolean isPaid;
    private static int paymentCounter = 0;

    // Constructor
    public AbstractPayment_Arandela(String paymentType, String date, double amount) {
        this.paymentType = paymentType;
        this.date = date;
        this.amount = amount;
        this.isPaid = false;
        paymentCounter++;
    }

    // OVERLOADED CONSTRUCTOR
    public AbstractPayment_Arandela(String paymentType, String date) {
        this.paymentType = paymentType;
        this.date = date;
        this.amount = 0.0;
        this.isPaid = false;
        paymentCounter++;
    }

    // ABSTRACT METHOD
    public abstract void processPayment();

    // CONCRETE METHODS
    public void displayPayment() {
        System.out.println("[" + date + "] " + paymentType + " - Amount: " + amount);
    }

    public void markAsPaid() {
        this.isPaid = true;
        System.out.println("Payment completed.");
    }

    // GETTERS
    public String getStatus() {
        return isPaid ? "Paid" : "Pending";
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public static int getTotalPayments() {
        return paymentCounter;
    }
}