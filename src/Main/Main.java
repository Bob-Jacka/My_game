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

        System.out.println(" ");
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
                    "1. attack enemy\n" +
                    "2. go to the city\n" +
                    "3. get hero params\n" +
                    "4. show active quest\n" +
                    "5. save the game\n" +
                    "6. load the game\n" +
                    "7. configurate the game\n" +
                    "8. put on weapon\n" +
                    "9. quit game\n" +
                    "HINT: just type number of the clause");
            System.out.println();
            Scanner askForAction = new Scanner(System.in);
            int action = askForAction.nextInt();
            switch (action) {
//                case 1:
//                    person.attack();
                case 2:
                    System.out.println("What location you need\n" +
                            "1. skyrim\n" +
                            "2. hammerfall\n" +
                            "3. ogrimar\n" +
                            "HINT: just type number of the clause");
                    Scanner questionForLocation = new Scanner(System.in);
                    int askForLocation = questionForLocation.nextInt();
                    switch (askForLocation) {
                        case 1:
                            source.enterNewLocation("skyrim");
                            break;
                        case 2:
                            source.enterNewLocation("Hammerfall");
                            break;
                        case 3:
                            source.enterNewLocation("ogrimar");
                            break;
                    }
                    break;
                case 3:
                    person.getParams();
                    break;
                case 4:
                    person.getActiveQuest();
                    break;
                case 5:
                    Source.SaveTheGame(person);
                    break;
                case 6:
                    person = Source.LoadGame("yes", person);
                case 7:
                    isAutoSave = Source.configurateGameOptions(isAutoSave);
                    break;
//                case 8:
//                    person.putOnWeapon();
//                    break;
                case 9:
                    if(isAutoSave == false) {
                        System.out.println("Attention, the game option auto save is disable");
                        System.out.println("The game will not be saved");
                        Thread.sleep(5_000);
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