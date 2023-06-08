package Main;

import Dictionary.Levels;
import Heroes.Hero;
import Heroes.Knight;
import Heroes.Peasant;
import Heroes.Slave;
import Heroes.classes.*;

import java.io.File;

public class Player {

    static boolean IS_AUTO_SAVE;  // if false no autosave
    static Hero PERSON = new Slave();
    static File SAVE_FILE = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/saveHeroParams.txt");
    public static boolean[] STATUSES = new boolean[]{false, false, false, false, false};
    // 0 - isInBattle, 1- nearNPC, 2-isInCity, 3-isInDungeon, 4 - action menu
    static short HERO_LOCATION = 0; // местоположение героя на карте


    static void setPerson(int heroNumber) {
        if (heroNumber == Levels.Slave) PERSON = new Slave();

        else if (heroNumber == Levels.Peasant) PERSON = new Peasant();

        else if (heroNumber == Levels.Knight) PERSON = new Knight();

        else if (heroNumber == Levels.Healer) PERSON = new Healer();

        else if (heroNumber == Levels.Hunter) PERSON = new Hunter();

        else if (heroNumber == Levels.Necromancer) PERSON = new Necromancer();

        else if (heroNumber == Levels.Tank) PERSON = new Tank();

        else if (heroNumber == Levels.Warrior) PERSON = new Warrior();
    }
}
