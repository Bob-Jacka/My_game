package Items.Weapons.MeleeCombatWeapon;

import Heroes.Hero;
import Items.Weapons.MeleeCombatWeaponInterface;

public class Sword implements MeleeCombatWeaponInterface {

//    public Sword() {
//    }

    public Sword(String weaponName, int weaponAttack, float weaponWeight, int sharpening) {
        this.weaponName = weaponName;
        this.weaponAttack = weaponAttack;
        this.weaponWeight = weaponWeight;
        this.sharpening = sharpening;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public void setWeaponAttack(int weaponAttack) {
        this.weaponAttack = weaponAttack;
    }

    public void setWeaponWeight(float weaponWeight) {
        this.weaponWeight = weaponWeight;
    }

    public void setSharpening(int sharpening) {
        this.sharpening = sharpening;
    }

    ///////////////////////////////////////////////////////////
    private String weaponName;
    private int weaponAttack;
    private float weaponWeight;
    private int sharpening;  ///// заточка
    private String typeOfSword = "Sword";


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
    public void getParams() {
        System.out.println("Weapon Name is " + this.weaponName);
        System.out.println("Weapon attack is " + this.weaponAttack);
        System.out.println("Weapon weight is " + this.weaponWeight);
        System.out.println("Weapon sharpening is " + this.sharpening);
    }

    @Override
    public String getItemName() {
        return weaponName;
    }

    @Override
    public int getAttack() {
        return weaponAttack;
    }
}
