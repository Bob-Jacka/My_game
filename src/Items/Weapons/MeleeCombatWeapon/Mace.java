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

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void makeItSharp() {

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
