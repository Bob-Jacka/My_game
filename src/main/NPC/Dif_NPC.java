package NPC;

import Dictionary.RandomNpcSpeech;
import Heroes.Hero;

public final class Dif_NPC implements NPC {
    private final String name;
    private final int health = 100;
    private final int attack = 10;
    private final String quest;
    private boolean isQuestTaken = false;  /// по стандарту false - квест не взят

    public Dif_NPC(String name, String quest) {
        this.name = name;
        this.quest = quest;
    }

    @Override
    public void takeQuest(Hero person) {
        if (!isQuestTaken) {
            System.out.println();
            System.out.println(" ");
            System.out.println(quest);

            //adding quest to activeQuest
            person.setActiveQuest(quest);
            //adding quest to questList
            person.addToQuestList(quest);
            this.isQuestTaken = true;

            //TODO место для поощрения

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
        System.out.println(RandomNpcSpeech.getRandomNPCSpeech());
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
