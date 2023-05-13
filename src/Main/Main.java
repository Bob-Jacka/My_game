package Main;

import Heroes.Hero1;
import NPC.StartNPC;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static boolean isAutoSave = false;  // if false никакого autosave
    static boolean isQuitGame = false;
    static Source source = new Source();
    static Hero1 person = new Hero1();
    static File saveFile = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/save1.txt");
    public static boolean isInBattle = false;

    //    private static LocalDateTime ldtMain = LocalDateTime.now();
    static short forwardCoordinates = 0;
    static short backwardCoordinates = 0;
    static short leftCoordinates = 0;
    static short rightCoordinates = 0;
    public static void main(String[] args) throws IOException, InterruptedException {

        //Start game


        if (saveFile.exists()) {
            System.out.println("Файл сохранения найден, хотите ли загрузить сохранение? yes/no ");
            Scanner questionForLoad = new Scanner(System.in);
            String askForLoad = questionForLoad.nextLine();

            if (askForLoad.equals("yes")) {
                person = Source.LoadGame(askForLoad, person);
                //TODO загрузка карты из сохранения
            } else {
                System.out.println();
                System.out.println("New game");
                System.out.println("1. create hero\n" +
                        "2.What race do you like?\n" +
                        "HINT: just type number of the clause");
                System.out.println();
                System.out.print("To create Hero enter yes/no ");
                Scanner createHero = new Scanner(System.in);
                String askForCreateHero = createHero.nextLine();
                if (askForCreateHero.equals("yes")) {
                    person = source.CreateHero1();
                    System.out.print("укажите величину карты ");    /// создание карты
                    source.createMap(new Scanner(System.in).nextInt());
                } else {
                    System.exit(1);
                }
            }
            if(!person.getActiveQuest().isEmpty()) {
                StartNPC startNPC = Source.GenerateStartNPC();  ///встреча с нпс
                startNPC.takeQuest(person);
            }


            //The game
            while (isQuitGame == false) {

                //TODO сделать чтобы баттл мод не был зависим от наличия противника

                System.out.println();
                System.out.println("What can you do\n" +
                        "1. move\n" +
                        "2. Hero menu\n" +
                        "3. save or load the game\n" +
                        "4. configurate the game\n" +
                        "5. put on weapon\n" +
                        "6. quit game\n" +
                        "HINT: just type number of the clause");

                System.out.println();
                Scanner askForAction = new Scanner(System.in);
                int action = askForAction.nextInt();  /// action ask
                switch (action) {
                    case 1:
                        Source.moving();
                        break;
                    case 2:
                        Source.hero_menu();
                        break;
                    case 3:
                        Source.saveMenu();
                        break;
                    case 4:
                        isAutoSave = Source.configurateGameOptions(isAutoSave);
                        break;
//                case 5:
//                    person.putOnWeapon();
//                    break;
                    case 6:
//                    && (Integer.parseInt((Source.currentTime)) != Integer.parseInt(ldtMain.toString()))
                        if ((isAutoSave == false)) {  //TODO сделать чтобы если файл был недавно сохранён, то предупреждение не отображается
                            System.out.println("Attention, the game option auto save is disabled");
                            System.out.println("The game will not be saved");
                            Thread.sleep(3_000);
                            isQuitGame = Source.quitGame(isAutoSave, person);
                            break;
                        } else {
                            isQuitGame = Source.quitGame(isAutoSave, person);
                            break;
                        }
                }
            }
        }
    }
}

