package Main;

import Heroes.Hero1;
import NPC.StartNPC;

import javax.naming.spi.DirectoryManager;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static boolean isAutoSave = false;  // if false no autosave
    static boolean isQuitGame = false;
    static Hero1 person = new Hero1();
    static File saveFileHeroParams = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/saveHeroParams.txt");
//    static File saveFileGameConfig = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/saveGameConfig.txt");
    static boolean isInBattle = false;

    //    private static LocalDateTime ldtMain = LocalDateTime.now();
    public static short forwardCoordinates = 0; //TODO сделать кординаты пакетно видимыми
    public static short backwardCoordinates = 0;
    public static short leftCoordinates = 0;
    public static short rightCoordinates = 0;

    public static void main(String[] args) throws IOException, InterruptedException {

        //Start game


        if (saveFileHeroParams.exists()) {  ///if save file exists
            System.out.println("""
                    Welcome to the game
                    1. Continue the game
                    2. New game
                    3. Settings
                    4. Exit
                    HINT: just type number of the clause
                    """);
            Scanner welcomeScanner = new Scanner(System.in);
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
                    System.out.println();
//                    System.out.println("""
//                            1. create hero
//                            2.What race do you like?
//                            HINT: just type number of the clause""");
//                    System.out.println();
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
                case 3:
                    Source.configurateGameOptionsMenu();
                    break;
                case 4:
                    System.exit(1);
                    break;
            }

        } else if (!saveFileHeroParams.exists()) {  ///if save file does not exist
            System.out.println();
            System.out.println("""
                    Welcome to the game
                    1. New game
                    2. Settings
                    3. Exit
                    HINT: just type number of the clause""");
            Scanner welcomeScanner = new Scanner(System.in);
            switch (welcomeScanner.nextInt()) {
                case 1:
                    System.out.println();
                    System.out.println("New game");
                    System.out.println();
//                    System.out.println("""
//                            1. create hero
//                            2.What race do you like?
//                            HINT: just type number of the clause""");
//                    System.out.println();
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
                    Source.configurateGameOptionsMenu();  ///TODO если сохранения нету, если зайти в настройки и выйти, то игра начнётся без создания персонажа
                    break;
                case 3:
                    System.exit(1);//TODO если сохранения нету, если выйти, то игра начнётся без создания персонажа
                    break;
            }
        }
        if (person.getActiveQuest() == null) {
            StartNPC startNPC = Source.GenerateStartNPC();  ///встреча с нпс
            startNPC.takeQuest(person);
        }

        //The game
        while (!isQuitGame) {

            System.out.println();
            System.out.println("""
                    What can you do
                    1. Move
                    2. Hero menu
                    3. inventory
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
                case 4:
                    Source.saveMenu();
                    break;
                case 5:
                    Source.configurateGameOptionsMenu();
                    break;
                case 3:
                    boolean isClose = false;
                    while(!isClose) {
                        System.out.println("""
                            Inventory menu
                            1. Open inventory
                            2. Put on armor
                            3. Put on weapon
                            4. exit inventory menu
                            HINT: just type number of the clause""");
                        switch (new Scanner(System.in).nextInt()) {
                            case 1:
                                person.inventoryCall(person.inventory);
                                isClose = true;
                                break;
//                            case 2:
//                                person.putOnArmor();
//                                isClose = true;
//                                break;
//                            case 3:
//                                person.putOnWeapon();
//                                isClose = true;
//                                break;
                            case 4:
                                isClose = true;
                                break;
                        }
                    }
//                    Source.inventoryMenu();
                    break;
                case 6:
                    Source.quitGameMenu(isAutoSave, person);//TODO сделать чтобы если файл был недавно сохранён, то предупреждение не отображается
                    break;
            }
        }
    }
}
