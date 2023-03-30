package Items.Weapons.Firearms;

import Items.Weapons.RangedCombatWeaponInterface;

public class Musket implements RangedCombatWeaponInterface {
    Musket(String fireArmName, int bulletCount) {
        this.fireArmName = fireArmName;
        this.bulletCount = bulletCount;

    }
    private int bulletCount;
    private final String fireArmName;
    private final String typeOfFireArm = "Musket";
    private int destination = 150;

    @Override
    public void getParams() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void HoldTheArrow() {

    }

    @Override
    public void repairTheRangedWeapon() {

    }
}
