package Items.Potions;

public class HealthPotion extends Potion {


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

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public double getRecharge() {
        return recharge;
    }

    @Override
    public void setRecharge(double recharge) {
        this.recharge = recharge;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public static int getHealthToRecover() {
        return healthToRecover;
    }

    public void setHealthToRecover(int healthToRecover) {
        this.healthToRecover = healthToRecover;
    }

//    public void getPotionParam() {
//        System.out.println("Potion Name is " + this.itemName);
//        System.out.println("Potion duration is " + this.duration);
//        System.out.println("Potion recharge is " + this.recharge);
//
//
//    }
}
