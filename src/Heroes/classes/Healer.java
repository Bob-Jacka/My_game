package Heroes.classes;

import Heroes.Knight;


public class Healer extends Knight {
    public Healer(String name, int health, int armor, int attack, boolean magic, int resistance) {
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
    private String quest;
    private int experience = 0;

    public Healer() {

    }
///////////////////////////////////////////////////////////

    public void selfHeal() {
        if (this.mana >= 30) {
            this.health += 50;
            this.mana -= 30;
        } else {
            System.out.println("Not enough mana: " + this.name);
        }
    }

    public void defend() {
        if (this.mana >= 50) {
            this.armor += 70;
            this.mana -= 50;
        } else {
            System.out.println("Not enough mana: " + this.name);
        }
    }

    public void strongHeal() {
        if (this.mana == 100) {
            this.health += 100;
            this.mana -= 100;
        } else {
            System.out.println("Not enough mana: " + this.name);
        }
    }
}
