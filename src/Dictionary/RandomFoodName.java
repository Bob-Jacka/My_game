package Dictionary;

import java.util.Random;

public class RandomFoodName {

    public static String[] RandomFoodName = new String[]{"hlebyshek", "vodka", "solyanka", "borch"
    };
    public static String getRandomFoodName() {
        Random random = new Random();
        int randomSpeech = random.nextInt(Dictionary.RandomFoodName.RandomFoodName.length);
        return RandomFoodName[randomSpeech];
    }
}
