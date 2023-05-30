package NPC;

import Dictionary.Quest;
import Heroes.Hero;
import Heroes.Slave;

public class SecondNpc extends NPC {
    private final String name;
    private final int health = 100;
    private final int attack = 10;
    private boolean isQuestTaken = false;  /// по стандарту false - квест не взят

    public SecondNpc(String name) {
        this.name = name;
        System.out.println("StartNPC is created");
    }

    @Override
    public void takeQuest(Hero person) {
            if (isQuestTaken == false) {
                System.out.println();
                System.out.println(" ");
                System.out.println(Quest.Quest2);

                //adding quest to activeQuest
                person.setActiveQuest(Quest.Quest2);
                //adding quest to questList
                person.addToQuestList(Quest.Quest2);
                this.isQuestTaken = true;
//                System.out.println("Возьми это оружие и броню, они тебе пригодятся");

            } else {
                System.out.println("Задание уже взято");
            }
    }


    @Override
    public void attackEnemy() {

    }

    @Override
    public void talk() {

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }
}
