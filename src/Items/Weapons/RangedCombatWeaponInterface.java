package Items.Weapons;

import Items.Items;

public interface RangedCombatWeaponInterface extends WeaponInterface {
    void HoldTheArrow();
    void repairTheRangedWeapon();
    String getTypeOfWeapon();
}
