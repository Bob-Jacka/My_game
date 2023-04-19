package Main;

import Heroes.Hero1;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static boolean isAutoSave = false;
    static boolean isQuitGame = false;
    static Source source = new Source();
    static Hero1 person = new Hero1();
    public static void main(String[] args) throws IOException, InterruptedException {

        //Start game


        System.out.println("1. create hero\n" +
                "2.What race do you like?\n" +
                "HINT: just type number of the clause");

        System.out.println(" ");   /// TODO сделать проверку на существование файла сахранения и вопрос хотите ли загрузить игру или создать новую игру
        System.out.print("To create Hero enter yes/no ");
        Scanner createHero = new Scanner(System.in);
        String askForCreateHero = createHero.nextLine();
        if (askForCreateHero.equals("yes")) {
            person = source.CreateHero1();
        } else {
            System.out.println("it is your choice");
        }

        //The game
        while(isQuitGame == false) {
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
                    if(isAutoSave == false) {
                        System.out.println("Attention, the game option auto save is disable");
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