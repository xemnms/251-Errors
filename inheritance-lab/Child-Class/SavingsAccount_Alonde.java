public class SavingsAccount_Alonde extends BankAccount_Nepomuceno {
    private double interestRate;
    private boolean vaultLocked;

    public SavingsAccount_Alonde(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
        this.vaultLocked = true;
    }

    public void unlockVault() {
        this.vaultLocked = false;
        System.out.println("Vault unlocked. You can now move your savings.");
    }

    public void applyInterest() {
        if (isActive()) {
            double interest = getBalance() * (interestRate / 100);
            deposit(interest); 
            System.out.println("Interest applied at " + interestRate + "%. New balance: $" + getBalance());
        }
    }

    @Override
    public void withdraw(double amount) {
        if (vaultLocked) {
            System.out.println("Withdrawal blocked! Your Savings Vault is currently locked.");
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public void accountType() {
        System.out.println("This is a High-Yield Savings Account.");
    }
}