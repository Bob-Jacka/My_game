package Dictionary;

import java.util.Random;

public class RandomWeaponName {
    public static String getRandomWeaponName() {
        Random random = new Random();
        int randomWeapon = random.nextInt(Dictionary.RandomWeaponName.RandomWeaponName.length);
        return RandomWeaponName[randomWeapon];
    }
    //TODO добавить имена оружия
    private static final String[] RandomWeaponName = new String[] {"Frostmorn", "Valeamor", "Gendalf", "Saruman"};
}
