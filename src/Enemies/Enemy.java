package Enemies;

public class Enemy {
    public Enemy(String name, boolean magic) {
        this.name = name;  //TODO проблема при генерации противника, вызывается стандартный конструктор
        this.magic = magic;
    }
    public Enemy() {
        System.out.println("Basic constructor");
    }

    private String name;
    private int health = 100;
    private int armor = 40;
    private int attack = 5;
    private boolean magic;
    private int resistance = 15;

    /////////////////////////Getter/////////////////////////////////
    public int getAttack() {
        return attack;
    }
    public String getName() {
        return name;
    }
    public int getArmor() {
        return armor;
    }
    public void getMagic() {
        System.out.println("Yes, magic is allowed");
    }
    public int getHealth() {
        return health;
    }
    public int getResistance() {
        return resistance;
    }

    /////////////////////////////Setter/////////////////////////////////////
    public void setHealth(int health) {
        this.health = health;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setMagic(boolean magic) {
        this.magic = magic;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("New name is " + name);
    }
    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    /////////////////////////////////////////////////////////////////////////////
    public static void attack() {
        System.out.println("Attacking");// Do  something;

    }

    public void defendingMagick() {
        if (this.magic) {
            this.armor += 10;
            this.resistance += 5;
        }
    }

    public void attackMagick() {
        if (this.magic) {
            this.attack += 10;
        }
    }

    public void hurt() {
        this.setHealth(this.health - 10);
        System.out.println(this.health);
    }

    public void dead() {
        if (this.health == 0) {
            System.out.println(this.name + " is dead");
        }
    }
    public void getParams() {
        System.out.println("Name: "+this.name);
        System.out.println("health: "+this.health);
        System.out.println("armor: "+this.armor);
        System.out.println("attack: "+this.attack);
        System.out.println("magic: "+this.magic);
        System.out.println("resistance: "+this.resistance);
    }

}







