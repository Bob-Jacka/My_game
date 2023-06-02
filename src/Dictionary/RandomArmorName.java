package Dictionary;

import java.util.Random;

public class RandomArmorName {
    public static String getRandomArmorName() {
        Random random = new Random();
        int randomSpeech = random.nextInt(RandomArmorName.ArmorName.length);
        return ArmorName[randomSpeech];
    }

    private static final String[] ArmorName = new String[]{"SouthLat", "Valeamor", "Gendalf", "Saruman"};
}
