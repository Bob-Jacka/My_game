package Heroes;

import Dictionary.PetName;
import Heroes.classes.*;
import Heroes.classes.Summons.Pet;
import Items.OtherItems.ResurrectStone;

import java.util.Random;

public class Hero3 extends Hero2 {
    //    protected Hero3() {
//        super();
//    }
    protected Hero3(String name, int health, int armor, int attack, boolean magic, int resistance) {
        super(name, health, armor, attack, magic, resistance);  ////maybe problems
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

    //    public void getParams() {
//        System.out.println("Name: " + "master " + this.getName());
//        System.out.println("health: "+ this.getHealth());
//        System.out.println("armor: "+ this.getArmor());
//        System.out.println("attack: "+ this.getAttack());
//        System.out.println("magic: "+this.getMagic());
//        System.out.println("resistance: "+ this.getResistance());
//    }
    public Pet summon() {
//        Random random = new Random();
//        int petNumber = random.nextInt();
        Pet pet = new Pet();
        System.out.println("summoning pet: " + PetName.Boomer);
        return pet;
    }

    //    public void getParams() {
//        System.out.println("Name: "+ "peasant " + this.name);
//        System.out.println("health: "+this.health);
//        System.out.println("armor: "+this.armor);
//        System.out.println("attack: "+this.attack);
//        System.out.println("magic: "+this.magic);
//        System.out.println("resistance: "+this.resistance);
//        System.out.print("Your inventory is: ");
//        inventory_call(this.inventory);
//    }
    public void getParams() {
        System.out.println("Name: " + this.name);
        System.out.println("health: " + this.health);
        System.out.println("armor: " + this.armor);
        System.out.println("attack: " + this.attack);
        System.out.println("magic: " + this.magic);
        System.out.println("resistance: " + this.resistance);
        System.out.println("Your level is: Hero3");
        System.out.print("Your inventory is: ");
        inventoryCall(this.inventory);
    }
    public void resurrect() {
        if (inventory.contains(ResurrectStone.class)) {
            this.inventory.remove(ResurrectStone.class);
            System.out.println("Resurrect!");
        } else {
            System.out.println("There is no resurrect stone in you inventory");
        }
    }

    ///////////////////////LevelUp after Hero3//////////////////////////////////////
    public Healer HealerUp() {
        return new Healer(this.name, this.health + 100, this.armor + 10,
                this.attack, this.magic, this.resistance + 40);
    }

    public Hunter HunterUp() {
        return new Hunter(this.name, this.health + 200, this.armor + 100,
                this.attack + 100, this.magic, this.resistance + 40);
    }

    public Necromancer NecromancerUp() {
        return new Necromancer(this.name, this.health - 50, this.armor + 20,
                this.attack + 40, this.magic, this.resistance + 50);
    }

    public Tank TankUp() {
        return new Tank(this.name, this.health + 500, this.armor + 300,
                this.attack, this.magic, this.resistance + 70);
    }

    public Warrior WarriorUp() {
        return new Warrior(this.name, this.health + 150, this.armor + 80,
                this.attack + 140, this.magic, this.resistance + 50);
    }

}
