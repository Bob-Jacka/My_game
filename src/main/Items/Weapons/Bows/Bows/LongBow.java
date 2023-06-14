package Items.Weapons.Bows.Bows;

import Items.Weapons.RangedCombatWeaponInterface;

public class LongBow implements RangedCombatWeaponInterface {
    public LongBow(String weaponName, int arrowCount, int attack, int attack1) {
        this.weaponName = weaponName;
        this.arrowCount = arrowCount;
        this.attack = attack1;
    }

    private int arrowCount;
    private int attack;
    private final String weaponName;
    private final String typeOfBow = "Crossbow";
    private int destination = 75;

    @Override
    public void getParams() {
        System.out.println("Weapon Name is " + this.weaponName);
        System.out.println("Weapon type is " + this.typeOfBow);
        System.out.println("Weapon destination is " + this.destination);
        System.out.println("Weapon arrowCount is " + this.arrowCount);
        System.out.println("Weapon attack is " + this.attack);
    }

    @Override
    public String getItemName() {
        return this.weaponName;
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

    @Override
    public String getTypeOfWeapon() {
        return typeOfBow;
    }
}
