public class LaptopIsles {
	// Dan Marvin Isles
	// this class represents laptops with its usual displayed specs

	// encapsulated attributes of laptop
	private String brand;
	private int maxStorage; // storage counted in gigabytes
	private boolean refurbished;
	
	static int defaultRam = 8; // static value

	// default constructor + sets the laptop's specs
	public LaptopIsles() {
		this.brand = "MSI";
		this.maxStorage = 1000;
		this.refurbished = true;
	}

	// parameterized constructor + allows user to set the laptop's specs
	public LaptopIsles(String brand, int maxStorage, boolean refurbished) {
		this.brand = brand;
		this.maxStorage = maxStorage;
		this.refurbished = refurbished;
	}

	// getters (read access)
	public String getBrand() {
		return brand;
	}

	public int getMaxStorage() {
		return maxStorage;
	}

	public boolean isRefurbished() {
		return refurbished;
	}

	// setters (write access)
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setMaxStorage(int maxStorage) {
		this.maxStorage = maxStorage;
	}

	public void setRefurbished(boolean refurbished) {
		this.refurbished = refurbished;
	}

	// method w/o parameter and displays the laptop's specs
	void displaySpecs() {
		System.out.println("Brand: " + brand);
		System.out.println("Max Storage: " + maxStorage + "GB");
		System.out.println("Refurbished: " + refurbished);
		System.out.println("Default RAM: " + defaultRam + "GB");
	}

	// method with parameters that updates the laptop's specs
	void newLaptop(String brand, int maxStorage, boolean refurbished) {
		this.brand = brand;
		this.maxStorage = maxStorage;
		this.refurbished = refurbished;
	}
}
