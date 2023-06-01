package NPC;

import Dictionary.Quest;
import Dictionary.RandomNpcSpeech;
import Heroes.Hero;

public class Dif_NPC implements NPC {
    private final String name;
    private final int health = 100;
    private final int attack = 10;
    private boolean isQuestTaken = false;  /// по стандарту false - квест не взят

    public Dif_NPC(String name) {
        this.name = name;
        System.out.println("NPC is created");
    }

    @Override
    public void takeQuest(Hero person) {
        if (!isQuestTaken) {
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
        System.out.println(this.name + " is attacking enemy");
    }

    @Override
    public void talk() {
        System.out.println(RandomNpcSpeech.getRandomSpeech());
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
