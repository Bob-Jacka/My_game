package Heroes.classes.Summons;

public class Pet {

    private String petName;
    private static int health = 200;
    private int armor = 40;
    private int attack = 50;
    private int resistance = 50;
    private boolean isFollow = true;

    public Pet() {
        //this.petName = petName;
        System.out.println("Standart Pet constructor activated");
    }

//    public Pet(PetName petName ) {
//        this.petName = petName;
////        this.health = health;
////        this.armor = armor;
////        this.attack = attack;
////        this.resistance = resistance;
//    }

    //////////////////////////////////Getter//////////////////
    public int getHealth() {
        return health;
    }


    public int getArmor() {
        return armor;
    }


    public int getAttack() {
        return attack;
    }


    public int getResistance() {
        return resistance;
    }
    public String getName() {
        return petName;
    }

    //////////////////////////////////Setter///////////////////
    public void setHealth(int health) {
        this.health = health;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
///////////////////////////////////////////////////////////

    public void attack() {
        System.out.println(this.petName + " attacking");
    }
    public void defend() {
        System.out.println(this.petName + " defending");
        this.armor += 25;
    }
    public void dead() {
        if (Pet.health == 0) {
            System.out.println(this.petName + " is dead");
        } else {
            System.out.println("Error");
        }

    }
    public boolean follow() {
        System.out.println(this.petName + " is following you now");
        return this.isFollow = true;
    }
}
