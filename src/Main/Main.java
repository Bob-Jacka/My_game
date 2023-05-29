package Main;

import Heroes.Hero1;
import NPC.StartNPC;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static boolean IS_AUTO_SAVE;  // if false no autosave
    static boolean IS_QUIT_GAME = false;
    static Hero1 PERSON = new Hero1();
    static File SAVE_FILE = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/saveHeroParams.txt");
    static boolean IS_IN_BATTLE = false;
    static short HERO_LOCATION = 0; // местоположение героя на карте

    public static void main(String[] args) throws IOException, InterruptedException {

        //Start game
        Source.startMenu(); //start menu
        if(HERO_LOCATION == 0) Source.getMAP().get(0).add(2); //Задание стартовой позиции героя

        StartNPC startNPC = Source.GenerateStartNPC();  ///встреча с нпс

        if (PERSON.getActiveQuest() == null) {
            startNPC.takeQuest(PERSON);
        } else startNPC.setIsQuestTaken(true);

        //The game
        while (!IS_QUIT_GAME) {
            System.out.println();
            System.out.println("""
                    What can you do
                    1. Move
                    2. Hero menu
                    3. Inventory
                    4. Save or load the game
                    5. Settings
                    6. Quit game
                    HINT: just type number of the clause""");
            System.out.println();
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    Source.movingMenu();
                    break;
                case 2:
                    Source.heroMenu();
                    break;
                case 3:
                    Source.inventoryMenu();
                    break;
                case 4:
                    Source.saveMenu();
                    break;
                case 5:
                    Source.configurateGameOptionsMenu();
                    break;
                case 6:
                    Source.quitGameMenu(IS_AUTO_SAVE, PERSON);//TODO сделать чтобы если файл был недавно сохранён, то предупреждение не отображается
                    break;
            }
        }
    }
}
