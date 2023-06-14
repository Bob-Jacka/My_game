package NPC;

import Heroes.Hero;

public interface NPC {
    String name = "StandardNPCName";
    int health = 100;
    int attack = 20;
    boolean isQuestTaken = false;  /// по стандарту false - квест не взят

    void takeQuest(Hero person);


    void attackEnemy();

    void talk();

    String getName();

    int getHealth();

    int getAttack();
}
