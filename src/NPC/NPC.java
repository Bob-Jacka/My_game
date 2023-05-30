package NPC;

import Dictionary.Quest;
import Heroes.Hero;
import Heroes.Slave;

public abstract class NPC {
    String name = "StandardNPCName";
    int health = 100;
    int attack = 20;
    boolean isQuestTaken = false;  /// по стандарту false - квест не взят

    void takeQuest(Hero person) {
            if (isQuestTaken == false) {
                System.out.println();
                System.out.println(" ");
                System.out.println(Quest.Quest2);

                //adding quest to activeQuest
                person.setActiveQuest(Quest.Quest2);
                //adding quest to questList
                person.addToQuestList(Quest.Quest2);
                this.isQuestTaken = true;
                System.out.println("Возьми это оружие и броню, они тебе пригодятся");

            } else {
                System.out.println("Задание уже взято");
            }
        }


    void attackEnemy() {
        System.out.println(this.name + " is attacking enemy");
    };

    void talk() {

    }

    String getName() {return this.name;};
    int getHealth() {return this.health;};
    int getAttack() {return this.attack;};
}
