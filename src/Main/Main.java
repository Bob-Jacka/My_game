package Main;

import Heroes.Hero1;
import NPC.StartNPC;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static boolean isAutoSave = false;  // if false никакого autosave
    static boolean isQuitGame = false;
    //    static Source source = new Source();
    static Hero1 person = new Hero1();
    static File saveFile = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/save1.txt");
    static boolean isInBattle = false;

    //    private static LocalDateTime ldtMain = LocalDateTime.now();
    static short forwardCoordinates = 0;
    static short backwardCoordinates = 0;
    static short leftCoordinates = 0;
    static short rightCoordinates = 0;

    public static void main(String[] args) throws IOException, InterruptedException {

        //Start game


        if (saveFile.exists()) {  ///if save file exists
            System.out.println("""
                    Welcome to the game
                    1. Continue the game
                    2. New game
                    3. Settings
                    4. Exit
                    HINT: just type number of the clause
                    """);
            Scanner welcomeScanner = new Scanner(System.in);
            boolean isClose = false;
            if (!isClose) {
                switch (welcomeScanner.nextInt()) {
                    case 1:
                        System.out.println("Файл сохранения найден, хотите ли загрузить сохранение? yes/no ");
                        Scanner questionForLoad = new Scanner(System.in);
                        String askForLoad = questionForLoad.nextLine();

                        if (askForLoad.equals("yes")) {
                            person = Source.LoadGame(askForLoad, person);
                            //TODO загрузка карты из сохранения
                        } else {
                            System.exit(1);
                        }
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("New game");
                        System.out.println("""
                                1. create hero
                                2.What race do you like?
                                HINT: just type number of the clause""");
                        System.out.println();
                        System.out.print("To create Hero enter yes/no ");
                        Scanner createHero = new Scanner(System.in);
                        String askForCreateHero = createHero.nextLine();
                        if (askForCreateHero.equals("yes")) {
                            person = Source.CreateHero1();
                            System.out.print("укажите величину карты ");    /// создание карты
                            Source.createMap(new Scanner(System.in).nextInt());
                        } else {
                            System.exit(1);
                        }
                    case 3:
                        Source.configurateGameOptionsMenu();
                        break;
                    case 4:
                        System.exit(1);
                        break;
                }
            }
        } else if (!saveFile.exists()) {  ///if save file does not exist
            System.out.println("""
                    Welcome to the game
                    1. New game
                    2. Settings
                    3. Exit
                    HINT: just type number of the clause
                    """);
            Scanner welcomeScanner = new Scanner(System.in);
            switch (welcomeScanner.nextInt()) {
                case 1:
                    System.out.println();
                    System.out.println("New game");
                    System.out.println("""
                            1. create hero
                            2.What race do you like?
                            HINT: just type number of the clause""");
                    System.out.println();
                    System.out.print("To create Hero enter yes/no ");
                    Scanner createHero = new Scanner(System.in);
                    String askForCreateHero = createHero.nextLine();
                    if (askForCreateHero.equals("yes")) {
                        person = Source.CreateHero1();
                        System.out.print("укажите величину карты ");    /// создание карты
                        Source.createMap(new Scanner(System.in).nextInt());
                    } else {
                        System.exit(1);
                    }
                    break;
                case 2:
                    Source.configurateGameOptionsMenu();
                    break;
                case 3:
                    System.exit(1);
                    break;
            }
        }
        if (person.getActiveQuest() == null) {
            StartNPC startNPC = Source.GenerateStartNPC();  ///встреча с нпс
            startNPC.takeQuest(person);
        }

        //The game
        while (isQuitGame == false) {

            System.out.println();
            System.out.println("""
                    What can you do
                    1. Move
                    2. Hero menu
                    3. save or load the game
                    4. configurate the game
                    5. put on weapon
                    6. quit game
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
                    Source.saveMenu();
                    break;
                case 4:
                    isAutoSave = Source.configurateGameOptionsMenu();
                    break;
//                case 5:
//                    person.putOnWeapon();
//                    break;
                case 6:
                    isQuitGame = Source.quitGameMenu(isAutoSave, person);//TODO сделать чтобы если файл был недавно сохранён, то предупреждение не отображается
                    break;
            }
        }
    }
}
