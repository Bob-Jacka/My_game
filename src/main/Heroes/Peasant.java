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

    @Ability
    public void redemption() {
        if (this.mana > 40) {
            System.out.println("REDEMPTION!!!");
        } else {
            System.out.println("You don't have enough mana");
        }

    }
    @Ability
    public void resurrect() {
        if (inventory.contains(ResurrectStone.class)) {
            this.inventory.remove(ResurrectStone.class);
            System.out.println("Resurrect!");
        } else {
            System.out.println("There is no resurrect stone in you inventory");
        }
    }

    public Knight levelUpToHero3() {
        gc();
        return new Knight(this.name, this.health + 150, this.armor + 120,
                this.attack + 80, this.magic, this.resistance + 30);
    }
}
