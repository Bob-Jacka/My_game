package Main;

import Heroes.Hero1;
import NPC.StartNPC;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static boolean isAutoSave;  // if false no autosave
    static boolean isQuitGame = false;
    static Hero1 person = new Hero1();
    static File saveFile = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/saveHeroParams.txt");
    static boolean isInBattle = false;
    static short forwardCoordinates = 0;
    static short backwardCoordinates = 0;
    static short leftCoordinates = 0;
    static short rightCoordinates = 0;

    public static void main(String[] args) throws IOException, InterruptedException {

        //Start game
        Source.startMenu(); //start menu

        StartNPC startNPC = Source.GenerateStartNPC();  ///встреча с нпс

        if (person.getActiveQuest() == null) {
            startNPC.takeQuest(person);
        } else  startNPC.setIsQuestTaken(true);

        //The game
        while (!isQuitGame) {
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
                    Source.quitGameMenu(isAutoSave, person);//TODO сделать чтобы если файл был недавно сохранён, то предупреждение не отображается
                    break;
            }
        }
    }
}
