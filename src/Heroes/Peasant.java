package Heroes;

import Items.OtherItems.ResurrectStone;

import static java.lang.System.gc;

public class Peasant extends Slave implements Hero {
    /**
     * Second level of the hero
     *
     * @since 0.0.1
     */
    public Peasant() {
    }

    protected Peasant(String name, int health, int armor, int attack, boolean magic, int resistance) {
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

    public void redemption() {
        if (this.mana > 40) {
            System.out.println("REDEMPTION!!!");
        } else {
            System.out.println("You don't have enough mana");
        }

    }

    public void resurrect() {
        if (inventory.contains(ResurrectStone.class)) {
            this.inventory.remove(ResurrectStone.class);
            System.out.println("Resurrect!");
        } else {
            System.out.println("There is no resurrect stone in you inventory");
        }
    }
//    @Override
//    public void getParams() {
//        System.out.println("Name: " + this.name);
//        System.out.println("health: " + this.health);
//        System.out.println("armor: " + this.armor);
//        System.out.println("attack: " + this.attack);
//        System.out.println("magic: " + this.magic);
//        System.out.println("resistance: " + this.resistance);
//        System.out.println("Your level is: Hero2");
//        System.out.print("Your inventory is: ");
//        inventoryCall();
//    }

    public Knight levelUpToHero3() {
        gc();
        return new Knight(this.name, this.health + 150, this.armor + 120,
                this.attack + 80, this.magic, this.resistance + 30);
    }


}
