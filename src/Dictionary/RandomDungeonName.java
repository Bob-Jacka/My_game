package Dictionary;

import java.util.Random;

public class RandomDungeonName {
    private static final String[] RandomDungeonName = new String[]{"Cavern", "Underground", "Hammerfall", "Morrowind"};

    public static String getRandomDungeonName() {

        Random random = new Random();
        int randomDungeon = random.nextInt(Dictionary.RandomDungeonName.RandomDungeonName.length);
        return RandomDungeonName[randomDungeon];
    }
}
