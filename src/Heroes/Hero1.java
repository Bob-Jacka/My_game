package Heroes;

import Enemies.Enemy;
import Items.Armor.Armor;
import Items.Items;
import Items.OtherItems.ResurrectStone;
import Items.Potions.*;
import java.util.ArrayList;
import static java.lang.System.gc;

public class Hero1 implements Hero {

//    public Hero1() {
//        this.health = 15;
//        this.name = "standartName";
//        this.armor = 15;
//        this.attack = 15;
//        this.magic = false;
//        this.inventory = new ArrayList<Items>();
//        System.out.println("Standart constructor activated");
//    }

    public Hero1(String name,  boolean magic) {
        this.name = name;
        this.magic = magic;
//        this.inventory = new ArrayList<Items>();
//        System.out.println("advanced Hero1 constructor");
    }

    // Test stand Heroes.Hero  ("Valera", 60, 60, 60, true, 60)
////////////////////////////////////////////////////////////////////////
    private String name;
    private int health = 100;
    private int armor = 20;
    private int attack = 20;
    private boolean magic;
    private int resistance = 15;
    private int mana = 100;
    private int experience = 0;
    public String activeQuest = null;
    public ArrayList<String> questList = new ArrayList<String>();
    public ArrayList<Items> inventory = new ArrayList<Items>();

/////////////////////////Getter/////////////////////////////////
    public int getAttack() {
        return attack;
    }
    public String getName() {
        return "his name is" + name;
    }
    public int getArmor() {
        return armor;
    }
    public boolean getMagic() {
        System.out.println("Yes, magic is allowed");
        return magic;
    }
    public int getHealth() {
        return health;
    }
    public int getResistance() {
        return resistance;
    }
    public int getExperience() {return experience;}

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
        System.out.println("New name is" + this.name);
    }
    public void setResistance(int resistance) {
        this.resistance = resistance;
    }
    public void setExperience(int experience) {this.experience = experience;}


/////////////////////////////////////////////////////////////////////////////
    public void attack(Enemy enemy) {
        System.out.println("Attacking");
        enemy.setHealth(((enemy.getHealth() + enemy.getResistance()) - this.getAttack()));
        if (enemy.getHealth() < 0) {
            enemy.dead();
        }
    }

    public void defendingMagick() {
        if ((this.magic) && (this.mana >= 40)) {
            this.armor += 10;
            this.resistance += 5;
            this.mana -= 30;
        }
        else {
            System.out.println("Not enough mana: " + this.mana);
        }
    }

    public void attackMagick() {
        if ((this.magic) && (this.mana >= 40)) {
            this.attack += 10;
            this.mana -= 40;
        }
        else {
            System.out.println("Not enough mana: " + this.mana);
        }
    }

    public void hurt() {
        this.setHealth(this.health - 10);
        System.out.println(this.health);
    }

    public void dead() {
        if (this.health == 0) {
            System.out.println(this.name + "is dead");
        } else {
            System.out.println(this.name + " is not dead yet");
        }
    }

    public void getParams() {
        System.out.println("Name: "+ this.name);
        System.out.println("health: "+ this.health);
        System.out.println("armor: "+ this.armor);
        System.out.println("attack: "+ this.attack);
        System.out.println("magic: "+ this.magic);
        System.out.println("resistance: "+ this.resistance);
        System.out.println("Your level is: Hero1" );
        System.out.print("Your inventory is: ");
        inventoryCall(this.inventory);
    }
    protected static void inventoryCall(ArrayList<Items> inventory) {
        for (int i = 0; i != inventory.size(); i++) {
            System.out.println(inventory.get(i));
        }

    }


///////////////QuestMethods/////////////////////////////////////////////
    public void getActiveQuest() {
        System.out.println("Your active quest is " + this.activeQuest);
    }
    public void getQuestsList() {
        for (String quest: questList) {
            System.out.println(quest);
        }
    }
    public void setActiveQuest(String quest) {
        this.activeQuest = quest;
        System.out.println("Active quest changed");
    }
    public void passTheQuest (String quest) {
        this.questList.remove(quest);
        System.out.println("quest is passed");
    }
    public void rejectTheQuest() {}

//////////////////////////inventory///////////////////////////////////////////
    public void inventoryPut(Items item) {
        inventory.add(item);
        System.out.println(item.toString() + " added to inventory");
}
    public void putOn(Armor anyArmor) {
        this.setArmor(this.getArmor() + anyArmor.getArmorDef());
        System.out.println(anyArmor.getArmorName() + " puted on");
    }
    public void healByHealthPotion() {
        if (this.inventory.contains(HealthPotion.class)) {
            this.health += HealthPotion.getHealthToRecover();
            if (this.health >= 100) {   ////maybe problems
                this.health = 100;
                this.inventory.remove(HealthPotion.class);
            }
        }
        else {
            System.out.println("There is no health potion in the inventory");
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
///////////////////////LevelUp/////////////////////////////////////////
    public Hero2 levelUpToHero2() {
        gc();
        return new Hero2("peasant " + this.name, this.health+150, this.armor+120,
                this.attack+80, this.magic, this.resistance+30);
    }


}




