package Items.Weapons.Firearms;

import Items.Weapons.RangedCombatWeaponInterface;

public class Musket implements RangedCombatWeaponInterface {
    public Musket(String fireArmName, int bulletCount, int attack) {
        this.fireArmName = fireArmName;
        this.bulletCount = bulletCount;
        this.attack = attack;
    }
    private int bulletCount;
    private final String fireArmName;
    private final String typeOfFireArm = "Musket";
    private int destination = 150;
    private int attack;

    @Override
    public void getParams() {
        System.out.println("Weapon Name is " + this.fireArmName);
        System.out.println("Weapon type is " + this.typeOfFireArm);
        System.out.println("Weapon destination is " + this.destination);
        System.out.println("Weapon bullet Count is " + this.bulletCount);
        System.out.println("Weapon attack is " + this.attack);
    }

    @Override
    public String getItemName() {
        return this.fireArmName;
    }

    @Override
    public void HoldTheArrow() {

    }

    @Override
    public void repairTheRangedWeapon() {

    }

    @Override
    public int getAttack() {
        return this.attack;
    }
}
