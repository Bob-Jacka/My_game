package Items.Potions;

import Items.Items;

public class ManaPotion implements Items {

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

    @Override
    public void getParams() {

    }

    @Override
    public String getItemName() {
        return this.itemName;
    }
}
