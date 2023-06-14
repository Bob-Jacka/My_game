package Dictionary;

import java.util.HashMap;

public abstract class Levels {
    public static final char Slave = 1;
    public static final char Peasant = 2;

    public static final char Knight = 3;
    public static final char Healer = 4;
    public static final char Hunter = 5;
    public static final char Necromancer = 6;
    public static final char Tank = 7;
    public static final char Warrior = 8;

    public static int decode(String key) {
        final HashMap<String, Integer> LevelsMap = new HashMap<>(8);
        LevelsMap.put("Slave", 1);
        LevelsMap.put("Peasant", 2);
        LevelsMap.put("Knight", 3);
        LevelsMap.put("Healer", 4);
        LevelsMap.put("Hunter", 5);
        LevelsMap.put("Necromancer", 6);
        LevelsMap.put("Tank", 7);
        LevelsMap.put("Warrior", 8);

        return LevelsMap.getOrDefault(key, 0);
    }
}