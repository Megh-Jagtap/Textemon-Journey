import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

interface TextemonActions {
//    double defend();
    double getDodgeChance();
    void special_attack(Textemon textemon);
    void special_ability(Textemon textemon);
    void display();
}

abstract class Textemon implements TextemonActions {
    protected String name;
    protected String type;
    protected double health;
    protected double damage;
    private boolean found;
    protected int spec_attac_counter;
    protected int spec_ability_counter;
    protected boolean stunned;
    private double originalHealth;

    // Constructor
    public void resetHealth() {
        this.health = this.originalHealth;
    }

    public Textemon(String name, String type, double health, double damage) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.originalHealth = health;
        this.damage = damage;
        this.spec_ability_counter = 0;
        this.spec_attac_counter = 0;
        this.stunned = false;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public void incrementSuccessfulAttacks() {
        spec_attac_counter++;
        spec_ability_counter++;
    }

    public void resetSpecialAttackCounter() {
        this.spec_attac_counter = 0;
    }

    public void resetSpecialAbilityCounter() {
        this.spec_ability_counter = 0;
    }
    public int getSpecialAttackCounter(){
        return spec_attac_counter;
    }

    public int getSpecialAbilityCounter(){
        return spec_ability_counter;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getHealth(){
        return health;
    }

    public double getDamage(){
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void resetHealth(double health){
        this.health = health;
    }


    public void setHealth(double damageDealt){
        health -= damageDealt;

//        if(health <= 0){
//            setHealth();
//            System.out.println("Your textemon is knocked out!! Let him take rest in peace.");
//        }
    }
    public double getDodgeChance() {
        return 0.1; // Default dodge chance: 10%
    }
}