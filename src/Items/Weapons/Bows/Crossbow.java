package Items.Weapons.Bows;


public class Crossbow extends Bow implements RangedCombatWeapon {
    Crossbow(String BowName, int arrowCount) {
        this.BowName = BowName;
        this.arrowCount = arrowCount;

    }
    private int arrowCount;
    private final String BowName;
    private String typeOfBow = "Crossbow";
}
