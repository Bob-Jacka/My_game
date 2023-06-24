package Main;

import java.io.IOException;

public class Main {
    /**
     *  Флаг, обозначающий выход из игры, по умолчанию false, если true игра закончена
     */
    static boolean IS_QUIT_GAME = false;

    public static void main(String[] args) throws IOException {

        //Start game
        GameEngine.gameLauncherMenu();

        //The game
        while (!IS_QUIT_GAME) {
            GameEngine.mainGameMenu();
        }
    }
}