package Items.Armor;

import java.util.Random;

public class LeatherArmor extends Armor {

    public LeatherArmor(String armorName, int armorDef) {
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
            this.setArmorDef((int) (this.getArmorDef() / 1.7));}
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
}
