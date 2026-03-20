//component class created by Costiniano
public class Fighter_Costiniano {
	private String name;
	private int health;
	private int attackPower;
	private boolean isAlive;

	// constructor
	public Fighter_Costiniano(String name, int health, int attackPower) {
		this.name = name;
		setHealth(health);
		setAttackPower(attackPower);
		this.isAlive = true;
	}

	// getters
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getAttacPower() {
		return attackPower;
	}

	public boolean isAlive() {
		return isAlive;
	}

	// setters with validation
	public void setHealth(int health) {
		if (health > 0) {
			this.health = health;
		} else {
			System.out.println("Health must be positive!");
			this.health = 100;
		}
	}

	public void setAttackPower(int attackPower) {
		if (attackPower > 0) {
			this.attackPower = attackPower;
		} else {
			System.out.println("Attack power must be positive!");
			this.attackPower = 10;
		}
	}

	// behaviors
	public void attack(Fighter_Costiniano opponent) {
		if (!isAlive) {
			System.out.println(name + " cannot attack because they have been slain.");
			return;
		}

		System.out.println(name + " attacks " + opponent.getName());
		opponent.takeDamage(attackPower);
	}

	public void takeDamage(int damage) {
		health -= damage;
		System.out.println(name + " takes " + damage + " damage.");

		if (health <= 0) {
			health = 0;
			isAlive = false;
			System.out.println(name + " has been slain!");
		}
	}

	public void heal(int amount) {
		if (amount > 0 && isAlive) {
			health += amount;
			System.out.println(name + " heals for " + amount);
		}
	}
}
