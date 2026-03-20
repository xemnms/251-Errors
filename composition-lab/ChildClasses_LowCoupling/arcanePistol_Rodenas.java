/*
 * Child class by Kyla Cassandra Rodenas
 * Transforms the standard pistol into an Arcane Pistol that channels the mage’s elemental energy
 */
public class arcanePistol_Rodenas extends Pistol_Badosa {
    // constructor
    public arcanePistol_Rodenas(String model, int weight, int magazineCapacity) {
        super(model, weight, magazineCapacity);
    }

    // override behavior: fire arcane elemental projectiles
    @Override
    public void shoot() {
        System.out.println(getModel() + " fires arcane bullets that shimmer with magical energy!");
        System.out.println("Each bullet adapts to the mage's element for devastating effects!");
    }

    // combo with mage element for extra flair
    public void elementalArcaneCombo(String element) {

        switch (element.toLowerCase()) {
            case "fire":
                System.out.println("Bullets ignite into blazing arcs of fire!");
                break;
            case "ice":
                System.out.println("Bullets freeze mid-air, shattering into icy shards!");
                break;
            case "lightning":
                System.out.println("Bullets crackle with lightning, striking multiple targets!");
                break;
            default:
                System.out.println("Bullets glow with " + element + " energy!");
                break;
        }
    }
}