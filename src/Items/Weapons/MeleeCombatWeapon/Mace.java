package Items.Weapons.MeleeCombatWeapon;

import Items.Weapons.MeleeCombatWeaponInterface;

public class Mace implements MeleeCombatWeaponInterface {
    public Mace(String weaponName, int weaponAttack, float weaponWeight, int sharpening) {
        this.weaponName = weaponName;
        this.weaponAttack = weaponAttack;
        this.weaponWeight= weaponWeight;
        this.sharpening = sharpening;
    }
    private String weaponName;
    private int weaponAttack;
    private float weaponWeight;
    private int sharpening;  ///// заточка
    private String typeOfSword = "Mace";

    @Override
    public void getParams() {
        System.out.println("Weapon Name is " + this.weaponName);
        System.out.println("Weapon attack is " + this.weaponAttack);
        System.out.println("Weapon weight is " + this.weaponWeight);
        System.out.println("Weapon sharpening is " + this.sharpening);
    }

    @Override
    public String getItemName() {
        return this.weaponName;
    }

    @Override
    public void makeItSharp() {
        this.sharpening += 20;
    }

    @Override
    public void repairTheMeleeWeapon() {

    }

    @Override
    public void ThrowIt() {

    }

    @Override
    public int getAttack() {
        return weaponAttack;
    }
}
