// Author: Julliana Nepomuceno, Payment_Arandela by Jherrymei Arandela, Skin_Dizon by Andrew Dizon
public class CompositionDemoNepomuceno {
    public static void main(String[] args) {
        System.out.println("\n\n==================================================\n");
        System.out.println("=====   COMPOSITION LAB DEMO - SKIN SHOP    =====");
        System.out.println("=====      By: Julliana Nepomuceno          =====");

        // Skins from Dizon's class
        Skin_Dizon primeSkin = new Skin_Dizon("Prime", "Ultra", 4);
        Skin_Dizon reaverSkin = new Skin_Dizon("Reaver", "Premium", 3);
        Skin_Dizon standardSkin = new Skin_Dizon("Standard", "Select", 1);


        // Payments from Arandela's class
        Payment_Arandela payment1 = new Payment_Arandela("Credit Card", 29.99);
        Payment_Arandela payment2 = new Payment_Arandela("PayPal", 24.99);
        Payment_Arandela payment3 = new Payment_Arandela("Gift Card", 19.99);

        System.out.println("\nCreated Payment_Arandela components:");
        System.out.println("Credit Card - $29.99");
        System.out.println("PayPal - $24.99");
        System.out.println("Gift Card - $19.99");

        // Create Composed Shop
        System.out.println("\n\n====================================\n");
        System.out.println(" CREATING SHOP:\n");

        SkinShop_Nepomuceno shop = new SkinShop_Nepomuceno("PRIME SKIN EMPORIUM");

        System.out.println(" Created SkinShop_Nepomuceno");
        System.out.println("   HAS-A Skin_Dizon (Dizon's class)");
        System.out.println("   HAS-A Payment_Arandela (Arandela's class)");
        System.out.println("\n\n====================================\n");
        // Demonstrate Transactions
        System.out.println("\n TRANSACTIONS:\n");

        // Transaction 1
        System.out.println("=== Transaction 1: Purchase Prime Skin ===");
        shop.browseSkin(primeSkin);
        shop.makePurchase(primeSkin, payment1);

        // Transaction 2
        System.out.println("\n=== Transaction 2: Purchase Reaver Skin ===");
        shop.browseSkin(reaverSkin);
        shop.makePurchase(reaverSkin, payment2);

        // Transaction 3
        System.out.println("\n=== Transaction 3: Purchase Standard Skin ===");
        shop.browseSkin(standardSkin);
        System.out.println();
        shop.makePurchase(standardSkin, payment3);
        System.out.println();

/*
 * QUESTION 1: What are the HAS-A relationships?
 * ─────────────────────────────────────────────────────────────────────
 * HAS-A relationships are composition relationships where one class contains
 * instances of other classes.
 * 
 * In this program:
 *   - SkinShop_Nepomuceno HAS-A Skin_Dizon
 *   - SkinShop_Nepomuceno HAS-A Payment_Arandela
 * 
 * Example:
 *   private Skin_Dizon skin;           // SkinShop HAS-A Skin
 *   private Payment_Arandela payment;  // SkinShop HAS-A Payment
 * 
 * The shop CONTAINS these objects and uses their methods to function.
 * This is composition - the shop is made up of these components.
 * 
 * 
 * QUESTION 2: Which classes were reused?
 * ────────────────────────────────────────────────────────────────────────
 * Reused classes are classes created by teammates that we use in our code.
 * 
 * In this program:
 *   - Skin_Dizon - Created by: Dizon (teammate)
 *     - Used to represent skin properties (name, rarity, upgrade level)
 *     - Methods: examine(), playSFX()
 * 
 *   - Payment_Arandela - Created by: Arandela (teammate)
 *     - Used to represent payment information
 *     - Methods: processPayment(), displayPaymentDetails()
 * 
 * Both classes work perfectly in our SkinShop_Nepomuceno class without
 * needing to modify them. We REUSE their functionality!
 * 
 * 
 * QUESTION 3: How does composition reduce coupling?
 * ────────────────────────────────────────────────────────────────────────
 * Coupling = how dependent classes are on each other.
 * LOW coupling = classes are independent and don't rely on each other.
 * 
 * How composition reduces coupling:
 * 
 * 1. ENCAPSULATION:
 *    - SkinShop doesn't need to know HOW Skin_Dizon works internally
 *    - SkinShop doesn't need to know HOW Payment_Arandela processes payments
 *    - We only care about the PUBLIC INTERFACE (the methods we use)
 *    - Internal details are hidden (encapsulated)
 * 
 * 2. FLEXIBILITY:
 *    - If we change Skin_Dizon's internal code, SkinShop still works
 *    - If we change Payment_Arandela's internal code, SkinShop still works
 *    - As long as the methods exist, the shop works
 * 
 * 3. EASY TO SWAP:
 *    - We can replace Skin_Dizon with a different skin class
 *    - We can replace Payment_Arandela with a different payment class
 *    - Shop code doesn't need to change
 * 
 * Example of LOW COUPLING:
 *    SkinShop calls: skin.examine(), payment.processPayment()
 *    Shop doesn't care HOW these methods work, just THAT they work.
 *    This loose connection = LOW COUPLING
 * 
 * 
 * QUESTION 4: How is cohesion maintained?
 * ─────────────────────────────────────────────────────────────────────
 * Cohesion = how focused a class is on doing ONE job.
 * HIGH cohesion = classes are focused and single-purpose.
 * 
 * In this program, each class does ONE job:
 * 
 * 1. Skin_Dizon (by Dizon):
 *    - ONLY manages skin properties
 *    - Attributes: skinName, rarity, upgradeLevel
 *    - Methods: examine(), playSFX()
 *    - Job: Display skin info and play sound effects
 *    - Cohesion: ALL methods relate to SKIN MANAGEMENT
 * 
 * 2. Payment_Arandela (by Arandela):
 *    - ONLY manages payment information
 *    - Attributes: paymentMethod, amount, isPaid
 *    - Methods: processPayment(), displayPaymentDetails()
 *    - Job: Process and display payment info
 *    - Cohesion: ALL methods relate to PAYMENT PROCESSING
 * 
 * 3. SkinShop_Nepomuceno (by Nepomuceno):
 *    - ONLY coordinates transactions
 *    - Methods: browseSkin(), makePurchase(), displayShop()
 *    - Job: Manage shop operations using skin and payment objects
 *    - Cohesion: ALL methods relate to SHOP OPERATIONS
 *    - DOES NOT duplicate skin or payment logic
 *    - DELEGATES to Skin_Dizon and Payment_Arandela
 * 
 * Why this is HIGH COHESION:
 *   - No class does the job of another class
 *   - Each class has a clear, focused purpose
 *   - Related code is grouped together
 * 
 * 
 * QUESTION 5: Why is inheritance NOT appropriate here?
 * ───────────────────────────────────────────────────────────────────────
 * Inheritance (IS-A relationship) creates a parent-child relationship.
 * Example: Dog IS-A Animal, Car IS-A Vehicle
 * 
 * Why inheritance would be WRONG for SkinShop:
 * 
 *  SkinShop IS NOT A TYPE of Skin
 *   - A shop is not a skin
 *   - Extending Skin_Dizon would be semantically wrong
 * 
 *  SkinShop IS NOT A TYPE of Payment
 *   - A shop is not a payment
 *   - Extending Payment_Arandela would be semantically wrong
 * 
 *  SkinShop USES Skin and Payment (HAS-A)
 *   - The shop contains/owns skins and payments
 *   - The shop coordinates them, not IS them
 * 
 *  Inheritance would create TIGHT COUPLING
 *   - Changes to parent class affect child class
 *   - Hard to replace parent with something else
 *   - Violates the "favor composition over inheritance" principle
 * 
 *  COMPOSITION is correct
 *   - Shop has-a Skin, has-a Payment
 *   - Shop is independent from them
 *   - Easy to modify or replace components
 *   - Follows best practices (low coupling, high cohesion)
 * 
 * PRINCIPLE: "Favor Composition Over Inheritance"
 *   Use IS-A (inheritance) for TYPE relationships
 *   Use HAS-A (composition) for OWNERSHIP relationships
 * 
 * ============================================================================
 */
    }
}