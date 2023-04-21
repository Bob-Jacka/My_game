package Main;

import Heroes.Hero1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static boolean isAutoSave = false;
    static boolean isQuitGame = false;
    static Source source = new Source();
    static Hero1 person = new Hero1();
    static File saveFile = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/save1.txt");

    public static void main(String[] args) throws IOException, InterruptedException {

        //Start game


        if (saveFile.exists()) {
            System.out.println("Файл сохранения найден, хотите ли загрузить сохранение? yes/no ");
            Scanner questionForLoad = new Scanner(System.in);
            String askForLoad = questionForLoad.nextLine();

            if (askForLoad.equals("yes")) {
                person = Source.LoadGame(askForLoad, person);
            } else if (askForLoad.equals("no")) {
                System.out.println();
                System.out.print("To create Hero enter yes/no ");
                Scanner createHero = new Scanner(System.in);
                String askForCreateHero = createHero.nextLine();
                if (askForCreateHero.equals("yes")) {
                    person = source.CreateHero1();
                } else {
                    throw new RuntimeException("There is no no answer");
                }
            }
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
            } else {
                throw new RuntimeException("it is your choice");
            }
        }

        //The game
        while (isQuitGame == false) {
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
                    if (isAutoSave == false) {  //TODO сделать чтобы если файл был недавно сохранён, то предупреждение не отображается
                        System.out.println("Attention, the game option auto save is disabled");
                        System.out.println("The game will not be saved");
                        Thread.sleep(3_000);
                        isQuitGame = Source.quitGame(isAutoSave, isQuitGame, person);
                        break;
                    } else {
                        isQuitGame = Source.quitGame(isAutoSave, isQuitGame, person);
                        break;
                    }
            }
        }
    }
}