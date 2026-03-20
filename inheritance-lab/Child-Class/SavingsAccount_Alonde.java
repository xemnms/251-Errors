public class SavingsAccount_Alonde extends BankAccount_Nepomuceno {
    private double interestRate;

    // Constructor
    public SavingsAccount_Alonde(String accountNumber, String accountHolder, double initialBalance, double interestRate) {
        super(accountNumber, accountHolder, initialBalance);
        this.interestRate = interestRate;
    }

    // Getter
    public double getInterestRate() {
        return interestRate;
    }

    // Setter
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Overridden method
    @Override
    public void accountType() {
        System.out.println("This is a Savings Account with " + (interestRate * 100) + "% interest rate.");
    }

    // Overridden withdraw method with withdrawal limit
    @Override
    public void withdraw(double amount) {
        if (isActive()) {
            if (getBalance() >= amount) {
                if (amount <= 500) { // Savings account withdrawal limit
                    System.out.println("Withdrawing: $" + amount);
                    // Direct balance manipulation (you may need a protected method in parent)
                } else {
                    System.out.println("Withdrawal limit exceeded. Maximum withdrawal: $500");
                }
            } else {
                System.out.println("Insufficient funds. Cannot withdraw $" + amount);
            }
        } else {
            System.out.println("Account is inactive. Cannot withdraw.");
        }
    }

    // New behavior unique to SavingsAccount
    public void addInterest() {
        if (isActive()) {
            double interest = getBalance() * interestRate;
            System.out.println("Adding interest: $" + interest);
        } else {
            System.out.println("Account is inactive. Cannot add interest.");
        }
    }
}