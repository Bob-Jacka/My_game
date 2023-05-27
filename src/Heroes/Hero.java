package Heroes;

import Enemies.Enemy;
import Items.Items;

import java.util.ArrayList;

public interface Hero {
    ///////////////methods////////////
    void resurrect();
    void dead();
    void getParams();
    /////QuestMethods///
//    void getActiveQuest();
//    void getQuestsList();
//    void setActiveQuest(String quest);
//    void passTheQuest (String quest);

    //////////////////Getter//////////////////
    String getName();
    int getAttack();
    int getArmor();
    int getHealth();
    boolean getMagic();
    int getResistance();
    int getExperience();
    /////////////////Setter///////////////////////
    void setHealth(int Health);
    void setArmor(int Armor);
    void setName(String Name);
    void setAttack(int Attack);
    void setResistance(int Resistance);
    void setExperience(int Exp);
    void setMagic(boolean magic);


}
