package Items.Weapons.Firearms;

import Items.Weapons.RangedCombatWeaponInterface;

public class Musketon implements RangedCombatWeaponInterface {

    Musketon(String fireArmName, int bulletCount) {
        this.fireArmName = fireArmName;
        this.bulletCount = bulletCount;

    }
    private int bulletCount;
    private final String fireArmName;
    private final String typeOfFireArm = "Musketon";
    private int destination = 105;

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

    @Override
    public int getAttack() {
        return 0;
    }
}
