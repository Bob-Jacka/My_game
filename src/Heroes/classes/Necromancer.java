package Heroes.classes;

import Heroes.Hero3;
import Heroes.classes.Summons.Pet;
import Heroes.classes.Summons.Skeleton;

public class Necromancer extends Hero3 {
    public Necromancer(String name, int health, int armor, int attack, boolean magic, int resistance) {
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

    public void resurect() {
        if ((mana == 100) && (this.health == 0)) {
            this.health += 200;
            this.mana = 0;
            System.out.println(this.name + "Rusurected");
        }
        else {
            System.out.println("Not enough mana");
        }

    }


    public Skeleton skeletonSummon() {
        return new Skeleton("valera");
    }

}
