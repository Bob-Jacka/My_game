package NPC;

import Dictionary.Quest;
import Dictionary.RandomNpcSpeech;
import Heroes.Hero;
import Items.Armor.ClothArmor;
import Items.Weapons.MeleeCombatWeapon.Sword;


public class StartNPC implements NPC {
    private final String name;
    private final int health = 100;
    private final int attack = 10;

    public boolean getIsQuestTaken() {
        return isQuestTaken;
    }

    public void setIsQuestTaken(boolean isQuestTaken) {
        this.isQuestTaken = isQuestTaken;
    }

    private boolean isQuestTaken = false;  /// по стандарту false - квест не взят

    public StartNPC(String name) {
        this.name = name;
    }

    @Override
    public void takeQuest(Hero person) {
        if (!isQuestTaken) {
            System.out.println();
            System.out.println("С пробуждением, рада тебя видеть, у меня есть задание для тебя");
            System.out.println(Quest.Quest1);

            person.setActiveQuest(Quest.Quest1);
            person.addToQuestList(Quest.Quest1);
            this.isQuestTaken = true;
            System.out.println();
            System.out.println("Возьми это оружие и броню, они тебе пригодятся");
            System.out.println("training sword added to the inventory");
            System.out.println("training armor added to the inventory");
            person.putOnWeapon(new Sword("training_sword", 15, 1.5f, 20));
            person.putOnArmor(new ClothArmor("training_armor", 10));
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
        System.out.println(RandomNpcSpeech.getRandomSpeech()); ////make random choice
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
