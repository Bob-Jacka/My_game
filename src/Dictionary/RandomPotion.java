package Dictionary;

import java.util.Random;

public class RandomPotion {
    //////Potions////////
//    WHITE_HONEY, ///Устраняет токсичность и воздействия других эликсиров.
//    WOLF,  ///Увеличивает шанс нанести точный удар на 50%.
//    THUNDER, ///Увеличивает урон на 100%. Снижает вероятность уклонения или отражения удара на 50%.
//    RAFARIS_POTIOON, ///Мгновенно восстанавливает часть утраченного здоровья.
//    iWE, /// Даёт иммунитет к оглушению и нокдауну.
//    SWALLOW, ////Ускоряет восстановление здоровья.
//    KISS, ////Увеличивает сопротивление кровотечению на 70%. Останавливает уже начавшееся кровотечение.
//    MOONLIGHT, ////Увеличивает максимальный уровень здоровья на 100%.
//    TAWNY_OWL, ////Ускоряет восстановление энергии.

    private static final String[] RandomPotionName = new String[]{"WHITE_HONEY", "WOLF", "THUNDER", "RAFARIS_POTIOON",
            "iWE", "SWALLOW", "KISS", "MOONLIGHT", "TAWNY_OWL"};

    public static String getRandomPotionName() {
        Random random = new Random();
        int randomSpeech = random.nextInt(RandomPotion.RandomPotionName.length);
        return RandomPotionName[randomSpeech];
    }

}
