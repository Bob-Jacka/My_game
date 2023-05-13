package NPC;

import Dictionary.Quest;
import Heroes.Hero1;

public interface NPC {
    String name = null;
    int health = 100;
    int attack = 20;
    boolean isQuestTaken = false;  /// по стандарту false - квест не взят

    default void takeQuest(Hero1 person) {
            if (isQuestTaken == false) {
                System.out.println();
                System.out.println(" ");
                System.out.println(Quest.Quest2);

                //adding quest to activeQuest
                person.setActiveQuest(Quest.Quest2);
                //adding quest to questList
                person.addToQuestList(Quest.Quest2);
                //this.isQuestTaken = true;
                System.out.println("Возьми это оружие и броню, они тебе пригодятся");

            } else {
                System.out.println("Задание уже взято");
            }
        }


    default void attackEnemy() {
        System.out.println(this.name + " is attacking enemy");
    };
    void talk();
    default String getName() {return this.name;};
    default int getHealth() {return this.health;};
    default int getAttack() {return this.attack;};
}
