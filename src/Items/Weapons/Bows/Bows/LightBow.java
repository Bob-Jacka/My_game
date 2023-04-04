package Items.Weapons.Bows.Bows;

import Items.Weapons.RangedCombatWeaponInterface;

public class LightBow implements RangedCombatWeaponInterface {
    public LightBow(String weaponName, int arrowCount) {
        this.weaponName = weaponName;
        this.arrowCount = arrowCount;
    }

    private int arrowCount;
    private final String weaponName;
    private final String typeOfBow = "LightBow";
    private int destination = 35;


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
