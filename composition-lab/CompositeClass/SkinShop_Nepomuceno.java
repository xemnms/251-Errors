public class SkinShop_Nepomuceno {
    
    // HAS-A relationships (Composition)
    private Skin_Dizon skin;
    private Payment_Arandela payment;
    
    // Shop attributes
    private String shopName;
    private double balance;
    private int salesCount;

    // Constructor
    public SkinShop_Nepomuceno(String shopName) {
        this.shopName = shopName;
        this.balance = 1000.0;
        this.salesCount = 0;
        this.skin = null;
        this.payment = null;
    }

    // Method 1: Browse skin
    public void browseSkin(Skin_Dizon selectedSkin) {
        this.skin = selectedSkin;
        System.out.println("\nBrowsing: " + selectedSkin.getSkinName());
        selectedSkin.examine();
    }

    // Method 2: Make purchase
    public void makePurchase(Skin_Dizon selectedSkin, Payment_Arandela selectedPayment) {
        this.skin = selectedSkin;
        this.payment = selectedPayment;
        
        System.out.println("\nProcessing purchase...");
        selectedPayment.processPayment();
        
        if (selectedPayment.isPaid()) {
            balance += selectedPayment.getAmount();
            salesCount++;
            System.out.println("Purchase successful!");
            System.out.println("Shop balance: $" + balance);
        } else {
            System.out.println("Purchase failed!");
        }
    }

    // Getters
    public Skin_Dizon getSkin() {
        return skin;
    }

    public Payment_Arandela getPayment() {
        return payment;
    }

    public double getBalance() {
        return balance;
    }

    public int getSalesCount() {
        return salesCount;
    }
}