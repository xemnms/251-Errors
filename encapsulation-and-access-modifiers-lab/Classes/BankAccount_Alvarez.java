/* Bank Account class with encapsulation and validation for attributes
* (account number, account holder, balance, account type) and a static 
* attribute to track total number of accounts.
* Class created by Angelo hayden Alvarez
 */

public class BankAccount_Alvarez {
    
   
    // ---------- PRIVATE ATTRIBUTES ----------
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String accountType;

    // ---------- STATIC ATTRIBUTE ----------
    private static int totalAccounts = 0;

    // ---------- CONSTRUCTORS ----------

    // Constructor 1: Full initialization
    public BankAccount_Alvarez(String accountNumber, String accountHolder, double balance, String accountType) {
        this.accountNumber = accountNumber;
        setAccountHolder(accountHolder);
        setBalance(balance);
        setAccountType(accountType);
        totalAccounts++;
    }

    // Constructor 2: Default balance = 0
    public BankAccount_Alvarez(String accountNumber, String accountHolder, String accountType) {
        this(accountNumber, accountHolder, 0.0, accountType);
    }

    // ---------- BEHAVIORS ----------
    public void deposit(double amount) {
        if (amount <= 0) return;
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) return;
        balance -= amount;
    }

    // ---------- GETTERS ----------
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }

    // ---------- SETTERS ----------
    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.isEmpty()) this.accountHolder = accountHolder;
    }

    private void setBalance(double balance) {
        this.balance = Math.max(balance, 0); // Validation: balance >= 0
    }

    public void setAccountType(String accountType) {
        if ("Savings".equalsIgnoreCase(accountType) || "Checking".equalsIgnoreCase(accountType))
            this.accountType = accountType;
    }

    // ---------- STATIC METHOD ----------
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // ---------- RULE VALIDATION ----------
    public boolean isValid() {
        return balance >= 0;
    }
}