package Dictionary;

import java.util.Random;

public class RandomArmorName {
    public static String getRandomNPCName() {
        Random random = new Random();
        int randomSpeech = random.nextInt(RandomArmorName.ArmorName.length);
        return ArmorName[randomSpeech];
    }
    static String[] ArmorName = new String[]{"SouthLat", "Valeamor", "Gendalf", "Saruman"};
}
