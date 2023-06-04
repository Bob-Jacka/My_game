package Heroes;

import Items.Armor.Armor;
import Items.Items;
import Items.Weapons.WeaponInterface;

import java.util.ArrayList;

public interface Hero {
    ///////////////methods////////////
    void resurrect();

    void dead();

    void getParams();

    /////QuestMethods///
    void getQuestsList();

    void passTheQuest(String quest);

    //////////////////Getter//////////////////
    String getName();

    int getAttack();

    int getArmor();

    int getHealth();

    boolean getMagic();

    int getResistance();

    int getExperience();

    int getMana();

    /////////////////Setter///////////////////////
    void setHealth(int Health);

    void setArmor(int Armor);

    void setName(String Name);

    void setAttack(int Attack);

    void setResistance(int Resistance);

    void setExperience(int Exp);

    void setMagic(boolean magic);

    void setMana(int mana);

    String getActiveQuest();

    ArrayList<WeaponInterface> getActiveWeapon();

    ArrayList<Armor> getActiveArmor();

    void putOnArmor(Armor anyArmor);

    void putOnWeapon(WeaponInterface anyWeapon);

    void takeOffArmor(Armor anyArmor);

    void takeOffWeapon(WeaponInterface anyWeapon);

    void setActiveQuest(String quest);

    void addToQuestList(String quest);

    void inventoryCall();

    void defendingMagick();

    void attackMagick();

    ArrayList<String> getQuestListSimple();
    void inventoryPut(Items item);
}
