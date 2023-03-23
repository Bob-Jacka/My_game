package Items.Armor;

import java.util.Random;

public class ClothArmor extends Armor{
    public ClothArmor(String armorName, int armorDef) {
        this.armorName = armorName;
        this.armorDef = armorDef;
    }
    private final String armorName;

    private int armorDef;
    private int armoragility;
    private int mana;
    private int strenght;
    public void penetrate() {
        Random random = new Random();
        if(random.nextBoolean()) {
            System.out.println("Пробито");
            this.setArmorDef((int) (this.getArmorDef() / 1.9));}
        else {
            System.out.println("Не пробито");
        }
    }
}

