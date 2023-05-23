package Items.Armor;

import Items.Items;

import java.util.Random;

public class Armor implements Items {

    public Armor(String armorName, int armorDef) {
        this.armorName = armorName;
        this.armorDef = armorDef;
    }
     Armor() {

    }

    private String armorName;
    private int armorDef;    ////How many def pluses to Hero.armor
    private int armorAgility;
    private int mana;
    private int strenght;
    private String typeOfArmor;

    @Override
    public void getParams() {
        System.out.println("Armor name is " + this.armorName);
        System.out.println("Armor defence is " + this.armorDef);
    }

    /////////////////////////////////////////////
    public String getItemName() {
        return armorName;
    }

    public int getArmorDef() {
        return armorDef;
    }
    public void setArmorDef(int armorDef) {
        this.armorDef = armorDef;
    }

    public String getTypeOfArmor() {
        return typeOfArmor;
    }
    public void penetrate() {
        Random random = new Random();
        if(random.nextBoolean()) {
            System.out.println("Пробито");
            this.armorDef = this.armorDef/2;}
        else {
            System.out.println("Не пробито");
            }
    }

}
