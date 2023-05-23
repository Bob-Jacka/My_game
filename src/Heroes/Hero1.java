package Heroes;

import Enemies.Enemy;
import Items.Armor.Armor;
import Items.Items;
import Items.OtherItems.ResurrectStone;
import Items.Potions.*;
import Items.Weapons.MeleeCombatWeapon.Sword;
import Items.Weapons.MeleeCombatWeaponInterface;
import Items.Weapons.WeaponInterface;
import Main.Main;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static java.lang.System.gc;

public class Hero1 implements Hero {

    public Hero1() {
    }

    public Hero1(String name, boolean magic) {
        this.name = name;
        this.magic = magic;
    }

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
    private int inventoryCapacity = 10;
    public ArrayList<String> questList = new ArrayList<>();  ///для квестов
    public ArrayList<Items> inventory = new ArrayList<>(inventoryCapacity);   //// инвентарь
    public ArrayList<WeaponInterface> activeWeapon = new ArrayList<>(1);  /// оружие в руках у героя
    public ArrayList<Armor> activeArmor = new ArrayList<>(1);  /// броня у героя


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

    public boolean getMagic() {
        return magic;
    }

    public int getHealth() {
        return health;
    }

    public int getResistance() {
        return resistance;
    }

    public int getExperience() {
        return experience;
    }

    public int getMana() {
        return this.mana;
    }

    public ArrayList<WeaponInterface> getActiveWeapon() {
        return activeWeapon;
    }

    public ArrayList<Armor> getActiveArmor() {
        return activeArmor;
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
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setInventoryCapacity(int newCapacity) {
        this.inventoryCapacity = newCapacity;
    }

    /////////////////////////////////////////////////////////////////////////////
    public void defendingMagick() {
        if ((this.magic) && (this.mana >= 40)) {
            this.armor += 10;
            this.resistance += 5;
            this.mana -= 30;
        } else {
            System.out.println("Not enough mana: " + this.mana);
        }
    }

    public void attackMagick() {
        if ((this.magic) && (this.mana >= 40)) {
            this.attack += 10;
            this.mana -= 40;
        } else {
            System.out.println("Not enough mana: " + this.mana);
        }
    }

    public void hurt() {
        this.setHealth(this.health - 20);
        System.out.println("Your health is " + this.health);
    }

    public void dead() {
        System.out.println(this.name + "is dead");
    }


    ///////////////QuestMethods/////////////////////////////////////////////
    public String getActiveQuest() {
        if (activeQuest != null) {
            System.out.println("Your active quest is " + this.activeQuest);
            return this.activeQuest;
        }
        return null;
    }

    public void getQuestsList() {
        if (questList.size() != 0) {
            for (String quest : questList) {
                System.out.println(quest);
            }
        } else {
            System.out.println("There are no quests here");
        }
    }

    public void setActiveQuest(String quest) {
        this.activeQuest = quest;
    }

    public void passTheQuest(String quest) {
        this.questList.remove(quest);
        System.out.println("Quest is passed");
    }

    public void addToQuestList(String quest) {
        this.questList.add(quest);
        System.out.println("Quest added");
    }

    public void rejectTheQuest() throws NoSuchFieldException {
//        Field field = StartNPC.class.getField("isQuestTaken");
//        field.set(Object quest, );
    }
//////////////////////////inventory///////////////////////////////////////////
    public void inventoryPut(Items item) {   ///кладёт в инвентарь
        inventory.add(item);
        System.out.println(item.getItemName() + " added to inventory");
    }

    public void putOnArmor(Armor anyArmor) {
        this.setArmor(this.getArmor() + anyArmor.getArmorDef());
        this.activeArmor.add(anyArmor);
//        System.out.println(anyArmor.getItemName() + " puted on");
    }

    public void putOnWeapon(WeaponInterface anyWeapon) {
        this.setAttack(this.getAttack() + anyWeapon.getAttack());
        this.activeWeapon.add(anyWeapon);
//        System.out.println(anyWeapon.getItemName() + " puted on");
    }

    public void takeOffArmor(Armor anyArmor) {
        this.setArmor(this.getArmor() - anyArmor.getArmorDef());
        this.activeArmor.remove(anyArmor);
    }

    public void takeOffWeapon(WeaponInterface anyWeapon) {
        this.setAttack(this.getAttack() - anyWeapon.getAttack());
        this.activeWeapon.remove(anyWeapon);
    }

    public void getParams() {
        System.out.println("Name: " + this.name);
        System.out.println("Health: " + this.health);
        System.out.println("Armor: " + this.armor);
        System.out.println("Attack: " + this.attack);
        System.out.println("Magic: " + this.magic);
        System.out.println("Resistance: " + this.resistance);
        System.out.println("Experience: " + this.experience);
        System.out.println("Your level is: " + this.getClass());
        System.out.print("Your inventory is: ");
        inventoryCall();
    }

    public void inventoryCall() {
        if (!inventory.isEmpty()) {
            if (inventory.size() > 1) {
                for (Items inventoryItem : inventory) {
                    System.out.println(inventoryItem.getItemName() + ',');
                }
            } else if (inventory.size() == 1) {
                for (Items inventoryItem : inventory) {
                    System.out.println(inventoryItem.getItemName());
                }
            }
        //inventory. //TODO удалить последюю запитую
        } else {
            System.out.println("There is no items");
        }
    }

///////////////////////////////////////////////////////////////
    public void healByHealthPotion(Items healthPotion) {
        if (this.inventory.contains(healthPotion.getClass())) {
            this.health += HealthPotion.getHealthToRecover();
            if (this.health >= 100) {   ////maybe problems
                this.health = 100;
                this.inventory.remove(healthPotion); /// this.inventory.remove(HealthPotion.class);
            }
        } else {
            System.out.println("There is no health potion in the inventory");
        }
    }

    public void resurrect() {
        if (this.inventory.contains(ResurrectStone.class)) {
            this.inventory.remove(ResurrectStone.class);
            System.out.println("Resurrect!");
        } else {
            System.out.println("There is no resurrect stone in you inventory");
        }
    }

    @Override
    public void attack(Enemy enemy) {

    }

///////////////////////LevelUp/////////////////////////////////////////
    public Hero2 levelUpToHero2() {
        gc();
        return new Hero2(this.name, this.health + 150, this.armor + 120,
                this.attack + 80, this.magic, this.resistance + 30);
    }

}