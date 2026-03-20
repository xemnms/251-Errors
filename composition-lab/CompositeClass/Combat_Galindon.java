public class Combat {
    // Private fields (composition)
    private Agents_Alonde agent;
    private Weapon_Nepomuceno weapon;

    // Constructor injection
    public Combat(Agents_Alonde agent, Weapon_Nepomuceno weapon) {
        this.agent = agent;
        this.weapon = weapon;
    }

    // Setter injection (optional)
    public void setAgent(Agents_Alonde agent) {
        this.agent = agent;
    }

    public void setWeapon(Weapon_Nepomuceno weapon) {
        this.weapon = weapon;
    }

    // Behavior: simulate combat
    public void engage(int currentUltPoints) {
        System.out.println("=== COMBAT ENGAGED ===");

        // Agent actions
        System.out.println(agent.getName() + " is engaging the enemy!");
        agent.useSignatureAbility();
        agent.checkUltStatus(currentUltPoints);

        // Weapon actions
        System.out.println("\nAttacking with " + weapon.getWeaponName());
        weapon.fire();
        weapon.fire();
        weapon.fire();

        // Reload if needed
        if (weapon.getAmmo() == 0) {
            weapon.reload();
        }

        System.out.println("=== COMBAT END ===\n");
    }
}