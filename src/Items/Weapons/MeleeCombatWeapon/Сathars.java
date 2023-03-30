package Items.Weapons.MeleeCombatWeapon;

import Items.Weapons.MeleeCombatWeaponInterface;

public class Сathars extends Sword implements MeleeCombatWeaponInterface {
    public Сathars() {
        System.out.println("Weapon created");
    }

    public Сathars(String weaponName, int weaponAttack, float weaponWeight, int sharpening) {
        this.weaponName = weaponName;
        this.weaponAttack = weaponAttack;
        this.weaponWeight = weaponWeight;
        this.sharpening = sharpening;
        System.out.println(this.weaponName + " Created");
    }
    ///////////////////////////////////////////////////////////
    private String weaponName;
    private int weaponAttack;
    private float weaponWeight;
    private int sharpening;  ///// заточка
    private String typeOfSword = "Cathars";

    public void GetWeaponParam() {
        System.out.println("Weapon Name is " + this.weaponName);
        System.out.println("Weapon attack is " + this.weaponAttack);
        System.out.println("Weapon weight is " + this.weaponWeight);
        System.out.println("Weapon sharpening is " + this.sharpening);
    }
}
