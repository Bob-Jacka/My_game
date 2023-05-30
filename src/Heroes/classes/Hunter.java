package Heroes.classes;

import Heroes.Knight;
import Heroes.classes.Summons.Wolf;

public class Hunter extends Knight {
    public Hunter(String name, int health, int armor, int attack, boolean magic, int resistance) {
        super(name, health, armor, attack, magic, resistance);  ////maybe problems
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.attack = attack;
        this.magic = magic;
        this.resistance = resistance;  ////
    }
    private String name;
    private int health;
    private int armor;
    private int attack;
    private boolean magic;
    private int resistance;
    private int mana = 100;
    private int experience = 0;
    private String quest;

    public Wolf wolfSummon() {
        if(mana >= 60) {
            return new Wolf("valera");
        }
        else {
            System.out.println("Not enough mana: " + this.name);
        }
        return null;
    }
    public void hunterVision() {
        if(mana > 40) {
            this.attack += 30;
            this.mana -= 40;
        }
        else {
            System.out.println("Not enough mana: " + this.name);
        }
    }
}
