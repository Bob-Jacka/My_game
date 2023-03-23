package Items.Weapons;

import Items.Items;

public class Sword implements Items {

//    Weapon() {
//        System.out.println("Weapon created");
//    }

    public Sword(String weaponName, int weaponAttack, float weaponWeight, int sharpening) {
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

    public void GetWeaponParam() {
        System.out.println("Weapon Name is " + this.weaponName);
        System.out.println("Weapon attack is " + this.weaponAttack);
        System.out.println("Weapon weight is " + this.weaponWeight);
        System.out.println("Weapon sharpening is " + this.sharpening);
    }
}
