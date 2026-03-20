/*
 * 1. IS-A Relationship: SavingsAccount_Alonde IS-A BankAccount_Nepomuceno.
 * 2. Overridden Method: accountType() and withdraw() were overridden.
 * 3. Dynamic Binding: When calling accountType() on a BankAccount reference 
 * pointing to a SavingsAccount_Alonde object, the child's version executes at runtime.
 * 4. Inherited Methods: activateAccount(), deposit(), and getBalance().
 * 5. New Behavior: addInterest() is unique to the SavingsAccount_Alonde subclass.
 */

public class Main_Alonde2 {
    public static void main(String[] args) {
        SavingsAccount_Alonde mySavings = new SavingsAccount_Alonde("1989-13", "Nils Sjoberg", 1000.0, 0.05);

        System.out.println("--- Testing Inherited & Overridden Methods ---");
        mySavings.activateAccount();
        mySavings.accountType(); 
        mySavings.addInterest(); 
        mySavings.displayBalance(); 

        System.out.println("\n--- Testing Dynamic Binding ---");
        
        BankAccount_Nepomuceno myAccount = new SavingsAccount_Alonde("1990-14", "Becky", 500.0, 0.03);
        
        myAccount.accountType(); 
        
        myAccount.activateAccount();
        myAccount.withdraw(100.0);
    }
}