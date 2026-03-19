package ComponentClasses;
    //Class by Badosa, represents a pistol with attributes: model, weight, and magazine capacity.
public class Pistol_Badosa{
    private String model;
    private int weight;
    private int magazineCapacity;
    
    //Constructor
    public Pistol_Badosa(String model,int weight, int magazineCapacity){
        this.model = model;
        this.weight = weight;
        this.magazineCapacity = magazineCapacity;
    }

    //Getters
    public int getMagazineCapacity() {
        return magazineCapacity;
    }
    public int getWeight() {
        return weight;
    }
    public String getModel() {
        return model;
    }

    //Setter
    public void setMagazineCapacity(int magazineCapacity) {
        if (magazineCapacity < 0) {
            System.out.println("Magazine capacity cannot be negative.");
        }else {
            this.magazineCapacity = magazineCapacity;
            System.out.println("Magazine capacity set to: " + magazineCapacity);
        }
    }
    public void setWeight(int weight) {
        if (weight < 0) {
            System.out.println("Weight cannot be negative.");
        } else {
            this.weight = weight;
            System.out.println("Weight set to: " + weight);
        }
    }
    public void setModel(String model) {
        this.model = model;
        System.out.println("Model set to: " + model);
    }

    //Behaviors 
    public void shoot(){
        System.out.println (model+" Pistol " + "go BOOM BOOM!");
    }
    public void reload(){
        System.out.println("Reloading the " + model + " pistol...");
    }
}