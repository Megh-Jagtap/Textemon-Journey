import java.util.Random;

public class Grass_type extends Textemon {
    private boolean found;
    protected boolean isDefensiveStance;


    public Grass_type(String name, String type, double health, double damage) {
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
        return 0.10; // 75% dodge chance for Electric type
    }

    @Override
    public void special_attack(Textemon opponentTextemon) {
        if (spec_attac_counter >= 4) {
            double originalDamage = getDamage(); // Store the original damage value
            double increasedDamage = originalDamage * 1.8; // Increase damage by 80% for special attack
            Battle.attack(this, opponentTextemon, increasedDamage); // Apply increased damage to the opponent
            System.out.println(getName() + " uses Solar Beam, dealing increased damage!");
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
        if (spec_ability_counter >= 3) {
            if (!isDefensiveStance) {
                // Activate defensive stance
                isDefensiveStance = true;
                System.out.println(getName() + "'s special ability activated! " + getName() + " enters a defensive stance, reducing incoming damage.");
            } else {
                // Deactivate defensive stance
                isDefensiveStance = false;
                System.out.println(getName() + " exits the defensive stance.");
            }
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
        System.out.println("Displaying \033[1mGrass\033[0m type Textemons.");
        System.out.println("Grass type Pokémon often have good defensive stats and support moves.");
        System.out.println("The textemon: " + getName());
        System.out.println("Health " + getHealth());
        System.out.println("Damage: " + getDamage());
        System.out.println("Damage reduction: " + 0.94);
        System.out.println("Special attack: Solar Beam");
        System.out.println("Special ability: Overgrow");
    }

    public static class Textemon_G extends Grass_type {
        public Textemon_G(String name, String type, double health, double damage) {
            super(name, type, health, damage);
        }

        public void display() {
            super.display();
        }

        public static final Grass_type BULBOSAUR = new Grass_type("Bulbosaur", "Grass", 125, 22);
        public static final Grass_type FORESTOX = new Grass_type("Forestox", "Grass", 135, 26);
        public static final Grass_type SCEPTILE = new Grass_type("Sceptile", "Grass", 142, 28);
        public static final Grass_type VENUSAUR = new Grass_type("Venusaur", "Grass", 155, 30);

//        public static final Grass_type EXEGGUTOR = new Grass_type("Exeggutor", "Grass", 130, 28);
//        public static final Grass_type VICTREEBEL = new Grass_type("Victreebel", "Grass", 125, 30);
    }
}
