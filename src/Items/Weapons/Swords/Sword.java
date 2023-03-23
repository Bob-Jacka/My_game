package Items.Weapons.Swords;

public class Sword implements MeleeCombatWeapon {

    public Sword() {
        System.out.println("Weapon created");
    }

    public Sword(String weaponName, int weaponAttack, float weaponWeight, int sharpening) {
        this.SwordName = weaponName;
        this.weaponAttack = weaponAttack;
        this.weaponWeight = weaponWeight;
        this.sharpening = sharpening;
        System.out.println(this.SwordName + " Created");
    }
///////////////////////////////////////////////////////////
    private String SwordName;
    private int weaponAttack;
    private float weaponWeight;
    private int sharpening;  ///// заточка
    private String typeOfSword;

    public void GetWeaponParam() {
        System.out.println("Weapon Name is " + this.SwordName);
        System.out.println("Weapon attack is " + this.weaponAttack);
        System.out.println("Weapon weight is " + this.weaponWeight);
        System.out.println("Weapon sharpening is " + this.sharpening);
    }

    @Override
    public void makeItSharp() {

    }
}
