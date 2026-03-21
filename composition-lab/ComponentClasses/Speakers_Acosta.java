/* Class Created by Acosta
*  Speaker component class with encapsulation and invalidation in attributes.
*/
public class Speakers_Acosta {
    
    //Attributes
    private String brand;
    private String model;
    private int volume;
    private boolean isOn;


    //Constructor
    public Speakers_Acosta(String brand, String model, int volume) {
        setBrand(brand);
        setModel(model);
        setVolume(volume);
        this.isOn = false;
    }

    // behaviours
    public void turnOn() {
        System.out.println("The " + brand + " "+ model + " speakers are now ON.");
        isOn = true;
    }

    public void turnOff() {
        System.out.println("The " +brand + " "+ model + " speakers are now OFF.");
        isOn = false;
    }

    public void increaseVolume() {
        if (volume < 100) {
            volume++;
        }
    }

    public void decreaseVolume() {
        if (volume > 0) {
            volume--;
        }
    }


    //Getters
    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public int getVolume(){
        return volume;
    }

    public boolean isOn(){
        return isOn;
    }

    //Setters

    public void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            System.out.println("Brand cannot be empty.");
        } else {
            this.brand = brand;
        }
    }

    public void setModel(String model) {
        if (model == null || model.isEmpty()) {
            System.out.println("Model cannot be empty.");
        } else {
            this.model = model;
        }
    }


    public void setVolume(int volume) {
        if (volume < 0 || volume > 100) {
            System.out.println("You can only set the volume from 0-100.");
        } else {
            this.volume = volume;
        }
    }


}
