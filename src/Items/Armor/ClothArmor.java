package Items.Armor;

import Items.Items;

import java.util.Random;

public class ClothArmor extends Armor implements Items {
    public ClothArmor(String armorName, int armorDef) {
        this.armorName = armorName;
        this.armorDef = armorDef;
    }
    private final String armorName;

    private final int armorDef;
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
    @Override
    public String getItemName() {
        return this.armorName;
    }

    @Override
    public void getParams() {
        System.out.println("Armor name is " + this.armorName);
        System.out.println("Armor defence is " + this.armorDef);
    }
    @Override
    public int getArmorDef() {
        return this.armorDef;
    }
}

