package Main;


import java.io.IOException;

public class Main {
    static boolean IS_QUIT_GAME = false;

    public static void main(String[] args) throws IOException, InterruptedException {

        //Start game
        Source.startMenu(); //start menu

        //The game
        while (!IS_QUIT_GAME) {
            Source.mainGameMenu();
        }
    }
}