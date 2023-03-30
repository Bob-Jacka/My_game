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

    /////////////////////////////////////////////
    public String getName() {
        return armorName;
    }

    public int getArmorDef() {
        return armorDef;
    }
    public void setArmorDef(int armorDef) {
        this.armorDef = armorDef;
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

    @Override
    public void getParams() {

    }




}
