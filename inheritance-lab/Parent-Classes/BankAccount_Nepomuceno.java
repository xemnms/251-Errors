/*
 * Bank Account Parent Class
 * This class represents a basic bank account with possible child classes of SavingsAccount and CheckingAccount.
 * Author: JULLIANA NEPOMUCENO
 */

public class BankAccount_Nepomuceno {
    private static final String CLASS_ID = "Machine Class Created by NEPOMUCENO";
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private boolean isActive;
    
    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }

    // Constructors
    public BankAccount_Nepomuceno() {
        accountNumber = "000000";
        accountHolder = "Default Account Holder";
        balance = 0.0;
        isActive = false;
    }

    public BankAccount_Nepomuceno(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.isActive = false;
    }

    // Behaviors
    public void activateAccount() {
        if (!isActive) {
            isActive = true;
            System.out.println("Account activated.");
        } else {
            System.out.println("Account is already active.");
        }
    }

    public void deactivateAccount() {
        if (isActive) {
            isActive = false;
            System.out.println("Account deactivated.");
        } else {
            System.out.println("Account is already inactive.");
        }
    }

    public void deposit(double amount) {
        if (isActive) {
            System.out.println("Depositing: $" + amount);
            balance += amount;
        } else {
            System.out.println("Account is inactive. Cannot deposit.");
        }
    }
    
    public void withdraw(double amount) {
        if (isActive) {
            balance -= amount;
            System.out.println("Withdrawing: $" + amount);
        } else {
            System.out.println("Account is inactive. Cannot withdraw.");
        }
    }
    
    public void displayBalance() {
        if (isActive) {
            System.out.println("Current balance: $" + balance);
        } else {
            System.out.println("Account is inactive. Cannot display balance.");
        }
    }

    // Method intended to be overridden by subclasses
    public void accountType() {
        System.out.println("This is a general bank account.");
    }
}