import java.util.Random;

public class Water_type extends Textemon {
    private boolean found;
    public Water_type(String name, String type, double health, double damage) {
        super(name, type, health, damage);
        this.found = false;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found){
        this.found = found;
    }

    @Override
    public double getDodgeChance() {
        // Custom dodge chance for Water type textemons
        return 0.15; // 40% dodge chance for Water type
    }

    @Override
    public void special_attack(Textemon opponentTextemon) {
        if (spec_attac_counter >= 4) {
            double originalDamage = getDamage(); // Store the original damage value
            double increasedDamage = originalDamage * 1.90; // Increase damage by 90% for special attack
            Battle.attack(this, opponentTextemon, increasedDamage); // Apply increased damage to the opponent
            System.out.println(getName() + " uses Hydro Cannon, dealing increased damage!");
            setDamage(originalDamage); // Reset damage to original value
            spec_attac_counter = 0; // Reset the counter after using the special attack
        } else {
            System.out.println("Not enough successful attacks to use special attack.");
        }
    }

    public boolean isSpecialAttackSuccessful() {
        return spec_attac_counter >= 4;
    }

    @Override
    public void special_ability(Textemon playerTextemon) {
        if (spec_ability_counter >= 3) {
            // Heal the player's Textemon
            double healAmount = 0.50 * playerTextemon.getHealth(); // Heal 25% of maximum health
            playerTextemon.setHealth(playerTextemon.getHealth() + healAmount);
            if (playerTextemon.getHealth() > playerTextemon.getHealth()) {
                playerTextemon.setHealth(playerTextemon.getHealth()); // Ensure health does not exceed maximum
            }

            System.out.println(getName() + " uses Special Ability: Healing Wave!");
            System.out.println("Your " + playerTextemon.getName() + " is healed by " + (int) healAmount + " HP.");
//            spec_ability_counter = 0; // Reset the counter after using the special ability
        } else {
            System.out.println("Not enough successful attacks to use special ability.");
        }
    }

    public boolean isSpecialAbilitySuccessful() {
        if(spec_ability_counter >= 3){
            spec_ability_counter = 0;
            return true;
        }
        else{
            return false;
        }
//        return spec_ability_counter >= 3;
    }

    @Override
    public void display() {
        System.out.println("Displaying \033[1mWater\033[0m type Textemons.");
        System.out.println("Water type Pokémon often excel in defensive capabilities and have balanced stats.");
        System.out.println("The textemon: " + getName());
        System.out.println("Health " + getHealth());
        System.out.println("Damage: " + getDamage());
        System.out.println("Damage reduction: " + 0.90);
        System.out.println("Special attack: Hydro Pump");
        System.out.println("Special ability: Rain Dish");
    }

    public static class Textemon_W extends Water_type {
        public Textemon_W(String name, String type, double health, double damage) {
            super(name, type, health, damage);
        }

        public void display() {
            super.display();
        }

        public static final Water_type SQUIRTLE = new Water_type("Squirtle", "Water", 110, 18);
        public static final Water_type TOTODILE = new Water_type("Totodile", "Water", 120, 20);
        public static final Water_type GYARADOS = new Water_type("Gyarados", "Water", 133, 25);
        public static final Water_type BLASTOISE = new Water_type("Blastoise", "Water", 140, 30);
//        public static final Water_type VAPOREON = new Water_type("Vaporeon", "Water", 140, 28);
    }
}
