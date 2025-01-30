// Battle class pits monsters against each other in a battle to the death
public class Battle {
    public static void main(String[] args) {
        // Create a giant, an ogre, and a dragon for the battle
        Monster giant = new Monster("Giant", 15, 100); // Giant has strength 15 and health 100
        Monster ogre = new Monster("Ogre", 25, 60);   // Ogre has strength 25 and health 60
        Monster dragon = new Monster("Dragon", 30, 50); // Dragon has strength 30 and health 150

        // Simulate the battle until two monsters have negative health points
        int round = 1;
        while (!gameOver(giant, ogre, dragon)) {
            // Display the current round number
            System.out.printf("Round %d\n", round);

            // Perform actions for each monster
            performMonsterAction(giant, ogre, dragon);
            performMonsterAction(ogre, giant, dragon);
            performDragonAction(dragon, giant, ogre);

            // Increment the round number
            round++;
        }

        // Determine the outcome of the battle
        if (giant.getHealth() <= 0 && ogre.getHealth() <= 0) {
            System.out.println("Both Giant and Ogre died.");
        } else if (giant.getHealth() <= 0 && dragon.getHealth() <= 0) {
            System.out.println("Both Giant and Dragon died.");
        } else if (ogre.getHealth() <= 0 && dragon.getHealth() <= 0) {
            System.out.println("Both Ogre and Dragon died.");
        } else {
            System.out.println("Game over.");
        }
    }

    // Method to perform actions for a monster
    public static void performMonsterAction(Monster attacker, Monster opponent1, Monster opponent2) {
        // Check if the attacker is alive
        if (attacker.isAlive()) {
            // Perform a normal attack on the first opponent
            double damage1 = attacker.attack();
            opponent1.takeDamage(damage1);
            System.out.printf("%s attacks %s for %.2f damage. %s's Health: %.2f\n",
                    attacker.getName(), opponent1.getName(), damage1, opponent1.getName(), opponent1.getHealth());

            // If the second opponent is the dragon, perform an attack
            if (opponent2.getName().equals("Dragon")) {
                double damage2 = attacker.attack();
                opponent2.takeDamage(damage2);
                System.out.printf("%s attacks %s for %.2f damage. %s's Health: %.2f\n",
                        attacker.getName(), opponent2.getName(), damage2, opponent2.getName(), opponent2.getHealth());
            }
        }
    }

    // Method to perform actions for the dragon (special attack every two rounds)
    public static void performDragonAction(Monster dragon, Monster opponent1, Monster opponent2) {
        // Check if the dragon is alive
        if (dragon.isAlive()) {
            // Dragon attacks opponents every two rounds
            double damage = dragon.attack();
            opponent1.takeDamage(damage);
            opponent2.takeDamage(damage);
            System.out.printf("Dragon attacks %s and %s for %.2f damage each. %s's Health: %.2f, %s's Health: %.2f\n",
                    opponent1.getName(), opponent2.getName(), damage, opponent1.getName(), opponent1.getHealth(), opponent2.getName(), opponent2.getHealth());
        }
    }

    // Method to check if the game is over (two monsters have negative health)
    public static boolean gameOver(Monster... monsters) {
        int deadMonsters = 0;
        for (Monster monster : monsters) {
            if (monster.getHealth() <= 0) {
                deadMonsters++;
            }
        }
        return deadMonsters >= 2;
    }
}
