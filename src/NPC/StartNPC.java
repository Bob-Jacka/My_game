package NPC;

import Dictionary.RandomNpcSpeech;
import Heroes.Hero;

import java.lang.reflect.Field;
import java.util.Random;

public class StartNPC implements NPC {
    private final String name;
    private final int health = 100;
    private final int attack = 10;
    private boolean isQuestTaken = false;  /// по стандарту false - квест не взят

    public StartNPC(String name) {
        this.name = name;
        System.out.println("Message from StartNPC");
    }

    @Override
    public void takeQuest() throws NoSuchFieldException {
        if (isQuestTaken == false) {
            try {
                String quest = "Тебе нужно убить 10 волков";
                System.out.println("С пробуждением, рада тебя видеть, у меня есть задание для тебя");
                System.out.println(quest);
                this.isQuestTaken = true;
                //adding quest to activeQuest
                Field fieldActiveQuest = Hero.class.getField("activeQuest");
                fieldActiveQuest.set(quest, quest);   ///// this place is problematic
                //adding quest to questList
                Field fieldListQuest = Hero.class.getField("questList");
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
        Random random = new Random();
        int randomSpeech = random.nextInt(RandomNpcSpeech.speech.length);
            System.out.println(RandomNpcSpeech.speech[randomSpeech]); ////make random choose
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
