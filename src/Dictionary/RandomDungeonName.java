package Dictionary;

import java.util.Random;

public class RandomDungeonName {
    public static String[] RandomDungeonName = new String[]{"Cavern", "Underground", "Hammerfall", "Morrowind"};

    public static String getRandomDungeonName() {

        Random random = new Random();
        int randomCity = random.nextInt(Dictionary.RandomCityName.RandomCityName.length);
        return RandomDungeonName[randomCity];
    }
}
