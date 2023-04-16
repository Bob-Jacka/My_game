package Items.Potions;

import Items.Items;

public class HealthPotion implements Items {


    public HealthPotion(String itemName, double recharge, int duration, int healthToRecover) {
        this.itemName = itemName;
        this.duration = duration;
        this.recharge = recharge;
        this.healthToRecover = healthToRecover;
    }

    private String itemName;
    private double recharge;
    private int duration;
    private static int healthToRecover;


    public String getItemName() {
        return itemName;
    }


    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public static int getHealthToRecover() {
        return healthToRecover;
    }

    public void setHealthToRecover(int healthToRecover) {
        this.healthToRecover = healthToRecover;
    }


    public void getParams() {
        System.out.println("Potion Name is " + this.itemName);
        System.out.println("Potion duration is " + this.duration);
        System.out.println("Potion recharge is " + this.recharge);


    }
}
