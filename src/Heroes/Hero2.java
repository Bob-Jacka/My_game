package Heroes;

import java.util.ArrayList;

import static java.lang.System.gc;

public class Hero2 extends Hero1 {

//    protected Hero2() {
//        System.out.println("advanced Heroes.Hero created");
//    }

    protected Hero2(String name, int health, int armor, int attack, boolean magic, int resistance) {
        super(name, magic);    /////////Maybe problems
        this.health = health;
        this.name = super.getName();
        this.magic = super.getMagic();
        this.armor = armor;
        this.attack = attack;
        this.resistance = resistance;
    }

    private String name;
    private int health;
    private int armor;
    private int attack;
    private boolean magic;
    private int resistance;
    private int mana = 100;
    private int experience = 0;

    //    public void getParams() {
//        System.out.println("Name: " + "apprentice " + this.getName());
//        System.out.println("health: "+ this.getHealth());
//        System.out.println("armor: "+ this.getArmor());
//        System.out.println("attack: "+ this.getAttack());
//        System.out.println("magic: "+this.getMagic());
//        System.out.println("resistance: "+ this.getResistance());
//    }
    public void redemption() {
        if (this.mana > 40) {
            System.out.println("REDEMPTION!!!");
        } else {
            System.out.println("You don't have enough mana");
        }

    }

    public void resurrect() {
        if (inventory.contains(resurrectStone.class)) {
            this.inventory.remove(resurrectStone);
            System.out.println("Resurrect!");
        } else {
            System.out.println("There is no resurrect stone in you inventory");
        }
    }
    public void getParams() {
        System.out.println("Name: " + this.name);
        System.out.println("health: " + this.health);
        System.out.println("armor: " + this.armor);
        System.out.println("attack: " + this.attack);
        System.out.println("magic: " + this.magic);
        System.out.println("resistance: " + this.resistance);
        System.out.println("Your level is: Hero2");
        System.out.print("Your inventory is: ");
        inventoryCall(this.inventory);
    }

    protected Hero3 levelUpToHero3() {
        gc();
        return new Hero3("Master " + this.name, this.health+150, this.armor+120,
                this.attack+80, this.magic, this.resistance+30);
    }


}
