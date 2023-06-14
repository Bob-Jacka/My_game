package Heroes;

import Heroes.classes.Healer;
import Heroes.classes.Warrior;
import Heroes.classes.Tank;
import Heroes.classes.Necromancer;
import Heroes.classes.Hunter;
import Heroes.Peasant;
import Items.OtherItems.ResurrectStone;

public class Knight extends Peasant implements Hero {
    /**
     * Third level of the hero
     *
     * @since 0.0.1
     */
    public Knight() {

    }

    protected Knight(String name, int health, int armor, int attack, boolean magic, int resistance) {
        super(name, health, armor, attack, magic, resistance);
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.attack = attack;
        this.magic = magic;
        this.resistance = resistance;
    }

    private String name;
    private int health;
    private int armor;
    private int attack;
    private boolean magic;
    private int resistance;
    private String quest;
    private int mana = 100;
    private int experience = 0;

//    public Pet summon() {
//        Random random = new Random();
//        int petNumber = random.nextInt();
//        Pet pet = new Pet();
//        System.out.println("summoning pet: " + RandomPetName.RandomPetName);
//        return pet;
//    }

    public void resurrect() {
        if (inventory.contains(ResurrectStone.class)) {
            this.inventory.remove(ResurrectStone.class);
            System.out.println("Resurrect!");
        } else {
            System.out.println("There is no resurrect stone in you inventory");
        }
    }

    ///////////////////////LevelUp after Hero3//////////////////////////////////////
    Healer HealerUp() {
        return new Healer(this.name, this.health + 100, this.armor + 10,
                this.attack, this.magic, this.resistance + 40);
    }

    Hunter HunterUp() {
        return new Hunter(this.name, this.health + 200, this.armor + 100,
                this.attack + 100, this.magic, this.resistance + 40);
    }

    Necromancer NecromancerUp() {
        return new Necromancer(this.name, this.health - 50, this.armor + 20,
                this.attack + 40, this.magic, this.resistance + 50);
    }

    Tank TankUp() {
        return new Tank(this.name, this.health + 500, this.armor + 300,
                this.attack, this.magic, this.resistance + 70);
    }

    Warrior WarriorUp() {
        return new Warrior(this.name, this.health + 150, this.armor + 80,
                this.attack + 140, this.magic, this.resistance + 50);
    }

}
