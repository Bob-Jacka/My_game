package Main;


import NPC.StartNPC;

import java.io.IOException;

public class Main {
    static boolean IS_QUIT_GAME = false;

    public static void main(String[] args) throws IOException, InterruptedException {

        //Start game
        Source.startMenu(); //start menu

        StartNPC startNPC = Source.GenerateStartNPC();  ///встреча с нпс

        if (Player.PERSON.getActiveQuest() == null) {
            startNPC.takeQuest(Player.PERSON);
        } else startNPC.setIsQuestTaken(true);

        //The game
        while (!IS_QUIT_GAME) {
            Source.mainGameMenu();
        }
    }
}