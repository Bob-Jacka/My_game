package Items.Potions;

public class ManaPotion extends Potion {

    public ManaPotion(String itemName, double recharge, int duration, int manaToRecover) {
        this.itemName = itemName;
        this.duration = duration;
        this.recharge = recharge;
        this.manaToRecover = manaToRecover;
    }
    private String itemName;
    private double recharge;
    private int duration;
    private int manaToRecover;
}
