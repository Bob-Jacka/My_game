package Items.Weapons.Swords;

public class Mace extends Sword implements MeleeCombatWeapon{
    public Mace(String SwordName, int weaponAttack, float weaponWeight, int sharpening) {
        this.SwordName = SwordName;
        this.weaponAttack = weaponAttack;
        this.weaponWeight= weaponWeight;
        this.sharpening = sharpening;
    }
    private String SwordName;
    private int weaponAttack;
    private float weaponWeight;
    private int sharpening;  ///// заточка
    private String typeOfSword = "Mace";
}
