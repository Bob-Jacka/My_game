package Dictionary;

import java.util.Random;

public class RandomCityName {
    private static final String[] RandomCityName = new String[]{"Ogrimar", "Skyrim", "Hammerfall", "Morrowind"};

    public static String getRandomCityName() {

        Random random = new Random();
        int randomCity = random.nextInt(Dictionary.RandomCityName.RandomCityName.length);
        return RandomCityName[randomCity];
    }
}