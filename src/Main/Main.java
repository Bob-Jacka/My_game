package Main;

import Heroes.Hero;
import Heroes.Slave;
import NPC.StartNPC;

import java.io.File;
import java.io.IOException;

public class Main {
    static boolean IS_AUTO_SAVE;  // if false no autosave
    static boolean IS_QUIT_GAME = false;
    static Hero PERSON = new Slave();
    static File SAVE_FILE = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/saveHeroParams.txt");
    public static boolean[] STATUSES = new boolean[]{false, false, false, false}; // 0 - isInBattle, 1- nearNPC, 2-isInCity, 3-isInDungeon
    static short HERO_LOCATION = 0; // местоположение героя на карте

    public static void main(String[] args) throws IOException, InterruptedException {

        //Start game
        Source.startMenu(); //start menu

        StartNPC startNPC = Source.GenerateStartNPC();  ///встреча с нпс

        if (PERSON.getActiveQuest() == null) {
            startNPC.takeQuest(PERSON);
        } else startNPC.setIsQuestTaken(true);

        //The game
        while (!IS_QUIT_GAME) {
            Source.mainGameMenu();
        }
    }
}

