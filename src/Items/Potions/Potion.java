package Items.Potions;

import Items.Items;

public class Potion implements Items {
    Potion() {

    }
    Potion(String itemName, double recharge, int duration) {
        this.itemName = itemName;
        this.recharge = recharge;
        this.duration = duration;
    }

    private double recharge;
    private int duration;
    private String itemName;




    /////////////////////////////////////////////////////////////////
    public String getItemName() {
        return itemName;
    }

    public double getRecharge() {
        return recharge;
    }

    public void setRecharge(double recharge) {
        this.recharge = recharge;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
//////////////////////////////////////////////////////////
    public void getPotionParam() {
        System.out.println("Potion Name is " + this.itemName);
        System.out.println("Potion duration is " + this.duration);
        System.out.println("Potion recharge is " + this.recharge);

}
}
