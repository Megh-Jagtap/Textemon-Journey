import java.util.Random;
import java.util.Scanner;

public class Battle {
    private Textemon playerTextemon;
    private Textemon opponentTextemon;
    private static double playerHealth;
    private static double opponentHealth;
    private boolean opponentstunned;
    private Random random;
    boolean playerwins = false;

    public Battle(Textemon playerTextemon, Textemon opponentTextemon) {
        this.playerTextemon = playerTextemon;
        this.opponentTextemon = opponentTextemon;
        this.playerHealth = playerTextemon.getHealth();
        this.opponentHealth = opponentTextemon.getHealth();
        this.random = new Random();
        this.opponentstunned = false;
    }

    public boolean startBattle() {
        Partition.display_partition();
        System.out.println("A wild " + opponentTextemon.getName() + " appeared!");

        Scanner scanner = new Scanner(System.in);

        while (playerHealth > 0 && opponentHealth > 0) {
            String choice;
            do {
                System.out.println("Special Attack Counter: " + playerTextemon.getSpecialAttackCounter());
                System.out.println("Special Ability Counter: " + playerTextemon.getSpecialAbilityCounter());

                System.out.println("Choose your action:");
                System.out.println("1. Attack");
                System.out.println("2. Special Attack");
                System.out.println("3. Special Ability");

                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        attack(playerTextemon, opponentTextemon);
                        break;
                    case "2":
                        playerTextemon.special_attack(opponentTextemon);
                        if(playerTextemon instanceof Electric_type){
                            Electric_type electricType = (Electric_type) playerTextemon;
                            if(electricType.isSpecialAttacSuccessful()){
                                electricType.special_attack(playerTextemon);
                            }
                        } else if (playerTextemon instanceof Water_type) {
                            Water_type waterType = (Water_type) playerTextemon;
                            if(waterType.isSpecialAttackSuccessful()){
                                waterType.special_attack(playerTextemon);
                            }
                        } else if (playerTextemon instanceof Grass_type) {
                            Grass_type grassType = (Grass_type) playerTextemon;
                            if(grassType.isSpecialAttackSuccessful()){
                                grassType.special_attack(playerTextemon);
                            }
                        } else if (playerTextemon instanceof Fire_type) {
                            Fire_type fireType = (Fire_type) playerTextemon;
                            if(fireType.isSpecialAttackSuccessful()){
                                fireType.special_attack(playerTextemon);
                            }
                        }
                        break;
                    case "3":
                        playerTextemon.special_ability(opponentTextemon); // Pass opponentTextemon as a parameter
                        if (playerTextemon instanceof Electric_type) {
                            Electric_type electricType = (Electric_type) playerTextemon;
                            if (electricType.isSpecialAbilitySuccessful()) {
                                opponentstunned = true;
                                System.out.println("The opponent is stunned and cannot attack!");
                                attack(playerTextemon, opponentTextemon);
                            }
                        } else if(playerTextemon instanceof Water_type){
                            Water_type waterType = (Water_type) playerTextemon;
                            if(waterType.isSpecialAbilitySuccessful()){
                                playerHealth += playerTextemon.getHealth() * 0.50;//Adjust health increment
                                if (playerHealth > playerTextemon.getHealth()) {
                                    playerHealth = playerTextemon.getHealth(); // Ensure health doesn't exceed max health
                                }
                                System.out.println("Your " + playerTextemon.getName() + " healed for 50% of its max health!");
                            } else if (playerTextemon instanceof Grass_type) {
                                Grass_type grassType = (Grass_type) playerTextemon;
                                if(grassType.isSpecialAbilitySuccessful()){
                                    grassType.special_ability(playerTextemon);
                                }
                            } else if (playerTextemon instanceof Fire_type){
                                Fire_type fireType = (Fire_type) playerTextemon;
                                if(fireType.isSpecialAbilitySuccessful()){
                                    fireType.special_ability(playerTextemon);
                                }
                            }
                        }
                        break;

                    default:
                        System.out.println("Invalid choice. Please choose again.");
                        break;
                }
            } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"));

            // Check if opponent's health is zero or less
            if (opponentHealth <= 0) {
                System.out.println("Congratulations! You defeated the wild " + opponentTextemon.getName() + "!");
                opponentTextemon.setFound(true);
                Textedox.addFoundTextemon(opponentTextemon);
                playerwins = true;
                resetBattle();
                return playerwins;
            }

            // Opponent's turn
            // For simplicity, opponent always uses regular attack
            if (!opponentstunned) {
                double opponentDamage = calculateDamage(opponentTextemon, playerTextemon);
                // Check if the player's textemon dodges the attack
                if (random.nextDouble() < playerTextemon.getDodgeChance()) {
                    System.out.println(playerTextemon.getName() + " dodges the attack!");
                } else {
                    // Inflict damage only if the dodge was unsuccessful
                    playerHealth -= opponentDamage;
                    System.out.println("The wild " + opponentTextemon.getName() + " attacks you! You received " + (int) opponentDamage + " damage.");

                    // Check if player's health is zero or less
                    if (playerHealth <= 0) {
                        System.out.println("Oh no! Your " + playerTextemon.getName() + " fainted...");
                        resetBattle();
                        break;
                    }
                }
            } else {
                System.out.println("The opponent is stunned and cannot attack!");
                opponentstunned = false;
            }

            // Display updated health status
            System.out.println("Your " + playerTextemon.getName() + "'s health: " + (int) playerHealth);
            System.out.println("Wild " + opponentTextemon.getName() + "'s health: " + (int) opponentHealth);
        }
        return playerwins;
    }


    protected void attack(Textemon attacker, Textemon defender) {
        // Randomly determine if the attack fails or misses
        if (random.nextDouble() < 0.1) { // 10% chance of failure or miss
            System.out.println(attacker.getName() + "'s attack missed!");
            return;
        }

        // Check if the attack is dodged
        if (random.nextDouble() < defender.getDodgeChance()) {
            System.out.println(defender.getName() + " dodged the attack!");
            return;
        }

        double damage = calculateDamage(attacker, defender);
        if (damage > 0) {
            opponentHealth -= damage;
            System.out.println(attacker.getName() + " attacks " + defender.getName() + "! " + defender.getName() + " received " + (int) damage + " damage.");
            playerTextemon.incrementSuccessfulAttacks();
            System.out.println();
        } else {
            System.out.println("The attack had no effect!");
        }
    }

    public static void attack(Textemon attacker, Textemon defender, double damage) {
        Random random = new Random();
        // Randomly determine if the attack fails or misses
        if (random.nextDouble() < 0.05) { // 5% chance of failure or miss
            System.out.println(attacker.getName() + "'s attack missed!");
            return;
        }

        // Check if the attack is dodged
        if (random.nextDouble() < defender.getDodgeChance()) {
            System.out.println(defender.getName() + " dodged the attack!");
            return;
        }

        if (damage > 0) {
            opponentHealth -= damage;
            System.out.println(attacker.getName() + " attacks " + defender.getName() + "! " + defender.getName() + " received " + (int) damage + " damage.");
            attacker.incrementSuccessfulAttacks();
        } else {
            System.out.println("The attack had no effect!");
        }
    }

    private double calculateDamage(Textemon attacker, Textemon defender) {
        double baseDamage = attacker.getDamage();
        double typeModifier = getTypeModifier(attacker.getType(), defender.getType());

        // Randomize type modifier slightly
        typeModifier *= (0.9 + random.nextDouble() * 0.2); // Random value between 0.9 and 1.1

        if (defender instanceof Grass_type && ((Grass_type) defender).isDefensiveStance) {
            // Reduce damage by 40% while in defensive stance
            baseDamage *= 0.6; // 60% of the original damage
        }

        double damage = baseDamage * typeModifier;
        return damage;
    }

    private double getTypeModifier(String attackerType, String defenderType) {
        double typeModifier = 1.0; // Default modifier

        // Implement damage reduction factors based on attacker and defender types
        if (attackerType.equals("Fire")) {
            if (defenderType.equals("Grass")) {
                typeModifier = 1.10; // Fire type deals increased damage to Grass type
            } else if (defenderType.equals("Water")) {
                typeModifier = 0.9; // Fire type deals decreased damage to Water type
            }
        } else if (attackerType.equals("Water")) {
            if (defenderType.equals("Fire")) {
                typeModifier = 1.15; // Water type deals increased damage to Fire type
            } else if (defenderType.equals("Electric")) {
                typeModifier = 0.9; // Water type deals decreased damage to Electric type
            }
        } else if (attackerType.equals("Grass")) {
            if (defenderType.equals("Water")) {
                typeModifier = 0.8; // Grass type deals reduced damage to Water type
            } else if (defenderType.equals("Electric")) {
                typeModifier = 1.15; // Grass type deals increased damage to Electric type
            }
        } else if (attackerType.equals("Electric")) {
            if (defenderType.equals("Water")) {
                typeModifier = 1.2; // Electric type deals reduced damage to Water type
            } else if (defenderType.equals("Grass")) {
                typeModifier = 0.8; // Electric type deals increased damage to Fire type
            }
        }

        return typeModifier;
    }

    public void resetBattle() {
        // Reset player and opponent health
        playerHealth = playerTextemon.getHealth();
        opponentTextemon.resetHealth();

        // Reset special attack and ability counters
        playerTextemon.resetSpecialAttackCounter();
        playerTextemon.resetSpecialAbilityCounter();
    }

}