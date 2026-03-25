public abstract class AbstractPayment_Arandela {

    private final String paymentType;
    private final String date;
    private double amount;
    private boolean isPaid;

    public AbstractPayment_Arandela(String paymentType, String date, double amount) {
        this.paymentType = paymentType;
        this.date = date;
        this.amount = amount;
        this.isPaid = false;
    }

    // ABSTRACT METHOD (to override)
    public abstract void processPayment();

    // CONCRETE METHOD
    public void displayPayment() {
        System.out.println("[" + date + "] " + paymentType + " - Amount: " + amount);
    }

    public void markAsPaid() {
        this.isPaid = true;
    }

    public String getStatus() {
        return isPaid ? "Paid" : "Pending";
    }
}