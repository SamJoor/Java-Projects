import java.util.Random;

// Monster class represents a creature in the battle
public class Monster {
    private String name;      // Name of the monster
    private double strength;  // Strength of the monster
    private double health;    // Health of the monster

    // Constructor to initialize the monster's name, strength, and health
    public Monster(String name, double strength, double health) {
        this.name = name;
        this.strength = strength;
        this.health = health;
    }

    // Method to check if the monster is alive
    public boolean isAlive() {
        return health > 0;
    }

    // Method to calculate the damage dealt by the monster
    public double attack() {
        Random rand = new Random();
        double intensity = rand.nextDouble(); // Random number between 0 and 1
        return intensity * strength;
    }

    // Method to decrease the health of the monster by a specified amount (damage)
    public void takeDamage(double damage) {
        health -= damage;
    }

    // Getter method to retrieve the current health of the monster
    public double getHealth() {
        return health;
    }

    // Getter method to retrieve the strength of the monster
    public double getStrength() {
        return strength;
    }

    // Setter method to set the health of the monster
    public void setHealth(double health) {
        this.health = health;
    }

    // Setter method to set the strength of the monster
    public void setStrength(double strength) {
        this.strength = strength;
    }

    // Method to perform a special attack (to be overridden by subclasses)
    public void specialAttack(Monster opponent) {
        // Default behavior: no special attack
    }

    // Method to heal the monster by a specified amount
    public void heal(double amount) {
        health = Math.min(100, health + amount); // Ensure health does not exceed maximum (100)
    }

    // Method to display the name of the monster
    public String getName() {
        return name;
    }
}
