package Dictionary;

import java.util.Random;

public class RandomNpcName {
    public static String getRandomNPCName() {
        Random random = new Random();
        int randomSpeech = random.nextInt(RandomNpcName.NPCname.length);
        return NPCname[randomSpeech];
    }
    static String[] NPCname = new String[]{"Valera", "Valeamor", "Gendalf", "Saruman"};

}