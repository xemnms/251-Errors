public class Agents_Alonde {
    private String name;
    private String role;
    private int ultimatePoints;

    //constructor
    public Agents_Alonde(String name, String role, int ultimatePoints) {
        this.name = name;
        this.role = role;
        setUltimatePoints(ultimatePoints); 
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getUltimatePoints() { return ultimatePoints; }

    public void setUltimatePoints(int points) {
        if (points >= 6 && points <= 9) {
            this.ultimatePoints = points;
        } else {
            System.out.println("Invalid Ultimate points. Defaulting to 7.");
            this.ultimatePoints = 7;
        }
    }

    public void useSignatureAbility() {
        System.out.println(name + " (" + role + ") is using their signature ability!");
    }

    public void checkUltStatus(int currentPoints) {
        if (currentPoints >= ultimatePoints) {
            System.out.println("ULTIMATE READY for " + name + "!");
        } else {
            int remaining = ultimatePoints - currentPoints;
            System.out.println(name + " needs " + remaining + " more points for Ultimate.");
        }
    }
}