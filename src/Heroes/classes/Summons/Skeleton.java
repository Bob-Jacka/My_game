package Heroes.classes.Summons;

public class Skeleton extends Pet {
    private final String petName;
    private int health;
    private int armor;
    private int attack;
    private int resistance;
    private boolean isFollow = true;

    public Skeleton(String petName) {
        this.petName = petName;
        System.out.println(this.petName +" constructed");

    }
    public Skeleton(String petName, int health, int armor, int attack, int resistance) {
        this.petName = petName;
        this.health = health;
        this.armor = armor;
        this.attack = attack;
        this.resistance = resistance;

    }
}
