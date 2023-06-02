package Dictionary;

import java.util.Random;

public class RandomPetName {

///////////PetName//////////////

    private static final String[] RandomPetName = new String[]{"Jorge", "Puffy", "Buddy", "Boomer",
            "Vulcan", "Vesta", "Geta", "Gera",
            "Josephina", "Jacks", "Eva", "Ingebar", "Inga", "Lumbra"};

    public static String getRandomPetName() {
        Random random = new Random();
        int randomSpeech = random.nextInt(Dictionary.RandomPetName.RandomPetName.length);
        return RandomPetName[randomSpeech];
    }

}
