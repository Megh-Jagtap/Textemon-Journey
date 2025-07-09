import java.util.Random;

public class Fire_type extends Textemon {
    private boolean found;

    public Fire_type(String name, String type, double health, double damage) {
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
        return 0.12; // 75% dodge chance for Electric type
    }

    @Override
    public void special_attack(Textemon opponentTextemon) {
        if (spec_attac_counter >= 4) {
            double originalDamage = getDamage(); // Store the original damage value
            double increasedDamage = originalDamage * 2.0; // Double the damage for special attack
            Battle.attack(this, opponentTextemon, increasedDamage); // Apply increased damage to the opponent
            System.out.println(getName() + " uses Inferno Blast, dealing massive damage!");
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
    public void special_ability(Textemon opponentTextemon) {
        spec_ability_counter++;
        if (spec_ability_counter >= 4) {
            // Apply special ability logic
            double originalDamage = getDamage(); // Store the original damage value
            double increasedDamage = originalDamage * 1.35; // Increase damage by 35%
            System.out.println(getName() + "'s special ability activated! " + getName() + "'s damage has been increased by 50% for one round!");

            // Call the attack method in the Battle class with the increased damage
            Battle.attack(this, opponentTextemon, increasedDamage);

            // Reset the damage back to the original value after one round
            setDamage(originalDamage);
            spec_ability_counter = 0; // Reset the counter after using the special ability
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
        System.out.println("Displaying \033[1mFire\033[0m type Textemons.");
        System.out.println("Fire type Pokémon are known for their high offensive capabilities.");
        System.out.println("The textemon: " + getName());
        System.out.println("Health " + getHealth());
        System.out.println("Base damage: " + getDamage());
        System.out.println("Damage reduction: " + 0.92 + "against \033[1mGrass Type\033[0m textemons");
        System.out.println("Special attack: Flamethrower");
        System.out.println("Special ability: Blaze");
    }

    public static class Textemon_F extends Fire_type {
        public Textemon_F(String name, String type, double health, double damage) {
            super(name, type, health, damage);
        }

        public void display() {
            super.display();
        }

        public static final Fire_type CHARMENDAR = new Fire_type("Charmendar", "Fire", 110, 23);
        public static final Fire_type CHARIZARD = new Fire_type("Charizard", "Fire", 145, 27);
        public static final Fire_type INFERNAPE = new Fire_type("Infernape", "Fire", 155, 30);
        public static final Fire_type VOLCARONA = new Fire_type("Volcarona", "Fire", 155, 32);

//        public static final Fire_type NINETALES = new Fire_type("Ninetales", "Fire", 120, 30);
//        public static final Fire_type ARCANINE = new Fire_type("Arcanine", "Fire", 140, 32);
    }
}
