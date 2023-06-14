package Items.Weapons.Firearms.Tunning;

import Items.Items;

public class muzzleBrake implements Items {  /////Дульный тормоз
    public muzzleBrake(int damagePlus) {
        this.damagePlus = damagePlus;
    }

    private final int damagePlus;
    private String name = "muzzle brake";

    @Override
    public void getParams() {

    }

    @Override
    public String getItemName() {
        return null;
    }
}
