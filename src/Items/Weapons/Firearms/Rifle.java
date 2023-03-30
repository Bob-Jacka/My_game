package Items.Weapons.Firearms;

import Items.Weapons.RangedCombatWeaponInterface;

public class Rifle implements RangedCombatWeaponInterface {
    Rifle(String fireArmName, int bulletCount) {
        this.fireArmName = fireArmName;
        this.bulletCount = bulletCount;

    }
    private int bulletCount;
    private final String fireArmName;
    private final String typeOfFireArm = "Rifle";
    private int destination = 185;

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
