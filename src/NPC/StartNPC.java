package NPC;

import Dictionary.RandomNpcSpeech;
import Heroes.Hero1;

import java.lang.reflect.Field;

public class StartNPC implements NPC {
    private final String name = "Angela";
    private final int health = 100;
    private final int attack = 10;
    private boolean isQuestTaken = false;  /// по стандарту false - квест не взят

    @Override
    public void takeQuest() throws NoSuchFieldException {
        if (isQuestTaken == false) {
            try {
                String quest = "Тебе нужно убить 10 волков";
                System.out.println("С пробуждением, рада тебя видеть, у меня есть задание для тебя");
                System.out.println(quest);
                this.isQuestTaken = true;
                //adding quest to activeQuest
                Field fieldActiveQuest = Hero1.class.getField("activeQuest");
                fieldActiveQuest.set(quest, quest);   ///// this place is problematic
                //adding quest to questList
                Field fieldListQuest = Hero1.class.getField("questList");
                fieldListQuest.set(quest, quest);   ///// this place is problematic
            } catch (NoSuchFieldException e) {
                e.getStackTrace();
                System.out.println("Quest is ungettable");
            } catch (IllegalAccessException e) {
                e.getStackTrace();
                System.out.println("Quest is ungettable");
            }
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
        System.out.println(RandomNpcSpeech.speech1);  ////make random choose
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
