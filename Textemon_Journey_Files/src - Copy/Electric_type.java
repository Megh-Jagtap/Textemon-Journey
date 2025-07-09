import java.util.Random;

public class Electric_type extends Textemon {
    private boolean found;
//    private static final double DODGE_CHANCE = 0.75; // Chance to dodge an attack


    public Electric_type(String name, String type, double health, double damage) {
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
        // Custom dodge chance for Electric type textemons
        return 0.20; // 75% dodge chance for Electric type
    }

   /* @Override
    public double defend() {
        // Electric type textemons have a higher chance to dodge attacks
        if (new Random().nextDouble() < getDodgeChance()) {
            System.out.println(getName() + " dodges the attack!");
            return 0; // Return 0 damage (no damage received)
        } else {
            System.out.println(getName() + " failed to dodge the attack!");
            return 0; // Return 0 damage (no damage received)
        }
    }*/


    @Override
    public void special_attack(Textemon playerTextemon) {
        if (spec_attac_counter >= 4) {
            double originalDamage = getDamage(); // Store the original damage value
            double increasedDamage = originalDamage * 2.00;
            Battle.attack(this, playerTextemon, increasedDamage);
            System.out.println(getName() + " uses Thunderbolt Fury, dealing twice the damage!");
            setDamage(originalDamage);
            spec_attac_counter = 0; // Reset the counter after using the special attack
        } else {
            System.out.println("Not enough successful attacks to use special attack.");
        }
    }

    public  boolean isSpecialAttacSuccessful(){
        return (spec_attac_counter >= 4);
    }

    @Override
    public void special_ability(Textemon opponentTextemon) {
        if (spec_ability_counter >= 3) {
            // Stun the opponent
            System.out.println(getName() + " uses Static!");
            System.out.println("The opponent is stunned and cannot attack!");
            opponentTextemon.setStunned(true);

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
        System.out.println("Displaying \033[1mElectric\033[0m type Textemons.");
        System.out.println("Electric type pokemons are like glass canons, they are known for their devastating attacks and special abilities. However they lack good health stats");
        System.out.println("The textemon: " + getName());
        System.out.println("Health " + getHealth());
        System.out.println("Base damage: " + getDamage());
        System.out.println("Damage reduction: " + 0.80 + "against \033[1mWater Type\033[0m textemons!");
        System.out.println("Special attack: Thunderbolt");
        System.out.println("Special ability: Static");
    }

    public static class Textemon_E extends Electric_type{
        public Textemon_E(String name, String type, double health, double damage) {
            super(name, type, health, damage);
        }
        public void display() {
            super.display();
        }
        public static final Electric_type PIKACHU = new Electric_type("Pikachu", "Electric", 100, 20);
        public static final Electric_type ELECTIVIRE = new Electric_type("Electivire", "Electric", 125, 25);
        public static final Electric_type THUNDERLORD = new Electric_type("Thunderlord", "Electric", 135, 30);
        public static final Electric_type ZEKROM = new Electric_type("Zekrom", "Legendary_Electric", 150, 40);
    }
}