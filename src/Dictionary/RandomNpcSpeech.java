package Dictionary;

import java.util.Random;


public abstract class RandomNpcSpeech {
    public static String getRandomSpeech() {
        Random random = new Random();
        int randomSpeech = random.nextInt(RandomNpcSpeech.speech.length);
        return speech[randomSpeech];
    }
    public static String[] speech = new String[]{"Когда то и меня вела дорога приключений,но потом мне прострелили колено",
            "Отвали, щенок!", "Для Орды!", "Что тебе нужно?", "Иди с честью", "Хорошо, что встретились!",
            "Ааа.. я ждал тебя", "Ты испытываешь мое терпение", "Ты испытываешь мое терпение", "Что тебя беспокоит?",
            "Что-то не так?", "Дай-ка угадаю, кто-то украл твой сладкий рулет?!", "Нечего бездельничать!", "Эх, глотнуть бы старого доброго мёда... Сразу стало бы теплее и веселее.",
            "Нужно держать ухо востро! Проклятые орки могут броситься на нас в любой момент.", "Отличная у тебя броня. Старое доброе железо никогда не подводит.",
            "Что тебе нужно, кошатина?", "Втяни свои когти, каджит."};



}
