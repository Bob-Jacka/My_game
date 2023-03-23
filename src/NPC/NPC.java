package NPC;

public interface NPC {
    String name = null;
    int health = 100;
    int attack = 20;
    boolean isQuestTaken = false;  /// по стандарту false - квест не взят

    void takeQuest() throws NoSuchFieldException;
    void attackEnemy();
    void talk();
    String getName();
    int getHealth();
    int getAttack();
}
