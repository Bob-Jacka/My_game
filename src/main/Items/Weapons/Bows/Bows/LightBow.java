package Items.Weapons.Bows.Bows;

import Items.Weapons.RangedCombatWeaponInterface;

public class LightBow implements RangedCombatWeaponInterface {
    public LightBow(String weaponName, int arrowCount, int attack) {
        this.weaponName = weaponName;
        this.arrowCount = arrowCount;
        this.attack = attack;
    }

    private int arrowCount;
    private final String weaponName;
    private final String typeOfBow = "LightBow";
    private int destination = 35;
    private int attack;


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

    @Override
    public String getTypeOfWeapon() {
        return typeOfBow;
    }
}
