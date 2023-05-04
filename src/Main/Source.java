package Main;

import Dictionary.RandomArmorName;
import Dictionary.RandomFoodName;
import Dictionary.RandomNpcName;
import Enemies.Enemy;
import Heroes.Hero1;
import Items.Armor.*;
import Items.*;
import Items.OtherItems.Food;
import Items.OtherItems.ResurrectStone;
import Items.Potions.*;
import Items.Weapons.Firearms.Tunning.Muska;
import Items.Weapons.Firearms.Tunning.OpticalScope;
import Items.Weapons.Firearms.Tunning.muzzleBrake;
import Items.Weapons.MeleeCombatWeapon.Sword;
import NPC.StartNPC;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;


public class Source {

    static Random random = new Random(50);
    int IntegerValue = random.nextInt(5, 90);
    Double DoubleValue = random.nextDouble(1.0, 5.0);
    private static File toSaveFile
            = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/save1.txt");

   // private static LocalDateTime LDT = LocalDateTime.now();



    public Items GeneratePotion() {
//        Random random = new Random();
        int generationRate = random.nextInt(90);
        if (generationRate > 70) {
            return new HealthPotion("HealthPotion", DoubleValue, 1, IntegerValue);
        } else if (generationRate < 70) {
            return new ManaPotion("HealthPotion", DoubleValue, 1, IntegerValue);
        } else {
            System.out.println("There is no potions");
            return null;
        }
    }

    public Items GenerateWeapon() {
//        Random random = new Random();
        int generationRate = random.nextInt(90);
        if (generationRate > 75) {
            return new Sword("Sword", 15, 20, 50);
        } else {
            return new Sword("Sword", 40, 15, 50);
        }
    }


    public Items GenerateArmor() {
//        Random random = new Random();
        int generationRate = random.nextInt(90);
        if (generationRate > 85) {
            return new IronArmor(RandomArmorName.getRandomNPCName(), 80);
        } else if (generationRate > 60 && generationRate < 85) {
            return new LeatherArmor(RandomArmorName.getRandomNPCName(), 80);
        } else {
            System.out.println("There is nothing interesting");
            return null;
        }
    }

    public Hero1 CreateHero1() {
        System.out.print("Enter your hero name: ");
        Scanner name = new Scanner(System.in);
        String name_actual = name.next();

        System.out.print("Is your hero a magician (yes/no): ");
        Scanner magic = new Scanner(System.in);
        boolean magic_actual;

        if (magic.next().equals("yes")) {
            magic_actual = true;
        } else {
            magic_actual = false;
        }
        return new Hero1(name_actual, magic_actual);
    }


    public static Enemy generateEnemy() {
        return new Enemy();
    }

    public Items GenerateOtherItems() {
//        Random random = new Random();
        int generationRate = random.nextInt(90);
        if (generationRate > 85) {
            return new Food(RandomFoodName.getRandomFoodName(), 30, false);
        } else if (generationRate > 60 && generationRate < 85) {
            return new Food(RandomFoodName.getRandomFoodName(), 20, false);
        } else if (generationRate > 40 && generationRate < 60) {
            return new ResurrectStone("Valhalla", 3);
        } else if (generationRate > 80 && generationRate < 85) {
            return new ResurrectStone("Valhalaaaa", 4);
        } else {
            System.out.println("There is nothing interesting");
            return null;
        }
    }

    public Items GenerateTunning() {
        int generationRate = random.nextInt(90);
        if (generationRate > 50) {
            return new Muska(20, "Muska");
        } else if (generationRate > 50 && generationRate < 80) {
            return new OpticalScope("Callimator", 50);
        } else if (generationRate == 50) {
            return new muzzleBrake(100);
        } else return null;
    }

    public static StartNPC GenerateStartNPC() {
        return new StartNPC(RandomNpcName.getRandomNPCName());
    }


//////////////////Save and load game////////////////////////////

    ///file where save of the game


    protected static void whatInformationToSave(Hero1 valera) throws IOException {
//        Hero1 valera = new Hero1("Valera",true); ///// test, delete later  ///заглушка
        try {
            FileWriter writeSaveFile = new FileWriter(toSaveFile);

////Parameters to save

            writeSaveFile.write("|");
            writeSaveFile.write(valera.getHealth());
            writeSaveFile.write("|");

            writeSaveFile.write(valera.getArmor());
            writeSaveFile.write("|");

            writeSaveFile.write(valera.getAttack());
            writeSaveFile.write("|");

            if (valera.getMagic() == true) {     ///save magic boolean
                writeSaveFile.write(1);
                writeSaveFile.write("|");
            } else if (valera.getMagic() == false) {
                writeSaveFile.write(0);
                writeSaveFile.write("|");
            }
            writeSaveFile.write(valera.getResistance());
            writeSaveFile.write("|");


            writeSaveFile.write(valera.getMana());
            writeSaveFile.write("|");

            writeSaveFile.write(valera.getExperience());
            writeSaveFile.write("|");


            writeSaveFile.write(valera.getName().length());  //длина имени
            writeSaveFile.write("|");
            writeSaveFile.write(valera.getName());
            writeSaveFile.write("|");

            /// Save local date to save file
            //writeSaveFile.write(String.valueOf(LDT));  //Date
//            writeSaveFile.write(valera.getActiveQuest()); /// save active quest
//            writeSaveFile.write("|");

//            writeSaveFile.write(String.format("%h", valera.questList));  ///save QuestList
//            writeSaveFile.write("|");

//
//   PLACE FOR SAVE INVENTORY
//
//            writeSaveFile.write(String.format("%h", valera.getActiveWeapon()));  ///save weapon
//            writeSaveFile.write("|");
//
//            writeSaveFile.write(String.format("%h", valera.getActiveArmor()));  ///save armor
//            writeSaveFile.write("|");

            ////close file stream
            writeSaveFile.close();
        } catch (IOException e) {
            e.getStackTrace();
            System.out.println("There are problems on saving data");
        } finally {
            System.out.println("File saved");
        }

    }

    private static void deleteWrittenSaveFile() {
        try {
            toSaveFile.delete();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            System.out.println("File deleted");
        }
    }

    public static void SaveTheGame(Hero1 valera) throws IOException {
//        Scanner ScannerForSave = new Scanner(System.in);
//        System.out.println("Are you sure? yes/no ");      ///does not work in Test framework
//        String askForSave = ScannerForSave.nextLine();
        /**
         * This method contains two private functions and saving the game in txt file
         * /home/kirill/IdeaProjects/untitled/src/Saving_Files/save1.txt this path provides saving of the game*/
//        if (askForSave.equals("yes")) {
        if (toSaveFile.exists()) {
            System.out.println("Rewriting save file");
            Source.deleteWrittenSaveFile();
            Source.whatInformationToSave(valera);
        } else if (!toSaveFile.exists()) {
            Source.whatInformationToSave(valera);
        }
//        } else if (askForSave.equals("no")) {   ///   does not work in Test framework
//            System.out.println("Cancel saving");   //// does not work in Test framework
//        }
    }

    public static Hero1 LoadGame(String askForLoad, Hero1 afterLoad) throws FileNotFoundException {
        /**
         * This method makes load of the game by reading save file byte by byte and return Hero object
         */
//        Hero1 afterLoad = new Hero1();
        if (askForLoad.equals("yes")) {
            try {
                ArrayList<Integer> dataList = new ArrayList<>();
                FileReader loadReader = new FileReader(toSaveFile);

                for (char i = 0; i != toSaveFile.length(); i++) {
                    int fileData = loadReader.read();
//                    System.out.println(fileData);  /// delete to убрать в выводе данные
                    dataList.add(fileData);

                } //What parameters to load
                afterLoad.setName(AsciiDecoder.decode(dataList.subList(17,23)));  // name  //TODO исправить, потому что возращает New name is null
                afterLoad.setHealth(dataList.get(1));  //Health
                afterLoad.setArmor(dataList.get(3));       //Armor
                afterLoad.setAttack(dataList.get(5));
                if (dataList.get(8) == 1) {
                    afterLoad.setMagic(true);
                } else {  ///Magic
                    afterLoad.setMagic(false);
                }
                afterLoad.setResistance(dataList.get(9));
                afterLoad.setMana(dataList.get(11));
                afterLoad.setExperience(dataList.get(13));
                loadReader.close();
            } catch (IOException e) {
                e.getStackTrace();
            } finally {
                System.out.println("File loaded");
            }
        } else if (askForLoad.equals("no")) {
            System.out.println("It is your choice");
        }
        return afterLoad;
    }
///////////////////////////////////////////////////////////////////////

    public static boolean quitGame(boolean isAutoSave, boolean isQuitGame, Hero1 valera) throws IOException {
//        boolean isAutoSave = true;  ///specially for Junit ,  delete later
//        boolean isQuitGame = false;  ///specially for Junit ,  delete later
        if (isAutoSave == true) {
            SaveTheGame(valera);
        }
        System.out.println("Outing the game");
        return Main.isQuitGame = true;
    }

    public static boolean configurateGameOptions(boolean isAutoSave) throws IOException {
        boolean isClose = false;
        System.out.print("What would you like to change? ");
        System.out.println("What can you do\n" +
                "1. change auto save parameter\n" +
                "2. change save path\n" +
                "3. close configuration\n" +
                "HINT: just type number of the clause");
        while (isClose != true) {
            Scanner isChange = new Scanner(System.in);
            int askFor = isChange.nextInt();
            switch (askFor) {
                case 1:
                    Main.isAutoSave = true;
                    break;
                case 2:
                    System.out.println("Enter new saveFile name");
                    System.out.println("You're currently in /home/kirill/IdeaProjects/My_game/src/Saving_Files/");
                    Scanner askForNewSavePath = new Scanner(System.in);
                    String newSavePath = askForNewSavePath.nextLine();
                    toSaveFile = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/" + newSavePath);
                    isClose = true;
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
        return Main.isAutoSave;
    }

    public static void fight() {
        Enemy enemy = Source.generateEnemy();
        Main.isInBattle = true;
        System.out.println("You're currently in Battle mode");
        while (Main.isInBattle != false) {
            Source.attackEnemy(Main.person, enemy);
            System.out.println("You're won!");
            Main.person.getParams();
            Main.isInBattle = false;
        }
    }



    public static void moving() {
        /**
         * This method is built for moving hero
         * Also contains chance of activating battle mode
         */
        boolean isClose = false;
        while (!isClose) {
            System.out.println("What location you need\n" +
                    "1. move forward\n" +
                    "2. move left\n" +
                    "3. move right\n" +
                    "4. move backward\n" +
                    "5. exit moving\n" +
                    "HINT: just type number of the clause");
            Scanner questionMove = new Scanner(System.in);
            int askForMove = questionMove.nextInt();
            Random rand = new Random();
            int randint = rand.nextInt(1, 100);
            switch (askForMove) {
                case 1:
                    System.out.println(Main.person.getName() + " moving forward");
                    System.out.println(randint); //TODO для отладки удалить позже
                    if (randint < 25) {
                        fight();
                        isClose = true;
                    } else if (randint > 25) {
                        System.out.println("You're lucky, there is no enemy ");
                    }
                    break;
                case 2:
                    System.out.println(Main.person.getName() + " moving left");
                    if (randint < 8) {
                        fight();
                        isClose = true;
                    }
                    break;
                case 3:
                    System.out.println(Main.person.getName() + " moving right");
                    if (randint < 8) {
                        fight();
                        isClose = true;
                    }
                    break;
                case 4:
                    System.out.println(Main.person.getName() + " moving backward");
                    if (randint < 5) {
                        fight();
                        isClose = true;
                    }
                    break;
                case 5:
                    System.out.println("Outing move menu");
                    isClose = true;
                    break;
            }
        }
    }

    private static void enterNewLocation(String LocationName) {
        System.out.println("You've entering " + LocationName);
    }

    public static void enterLocation() {
        System.out.println("What location you need\n" +
                "1. skyrim\n" +
                "2. hammerfall\n" +
                "3. ogrimar\n" +
                "HINT: just type number of the clause");
        Scanner questionForLocation = new Scanner(System.in);
        int askForLocation = questionForLocation.nextInt();
        switch (askForLocation) {
            case 1:
                Source.enterNewLocation("skyrim");
                break;
            case 2:
                Source.enterNewLocation("Hammerfall");
                break;
            case 3:
                Source.enterNewLocation("ogrimar");
                break;
        }

    }

    private static void params(Hero1 person) {
        boolean isClose = false;
        while (!isClose) {
            System.out.println();
            System.out.println("Which params would you like to see?");
            System.out.println(
                    "1. Hero params\n" +
                            "2. Weapon params\n" +
                            "3. Armor params\n" +
                            "4. exit params menu\n" +
                            "HINT: just type number of the clause");
            System.out.println();
            Scanner askForParams = new Scanner(System.in);
            int ParamNum = askForParams.nextInt();  /// action ask
            switch (ParamNum) {
                case 1:
                    person.getParams();
                    break;
                case 2:
                    if (person.activeWeapon.isEmpty()) {
                        System.out.println("There is no active weapon");
                    } else {
                        person.activeWeapon.get(0).getParams();
                    }
                    break;
                case 3:
                    if (person.activeArmor.isEmpty()) {
                        System.out.println("There is no active armor");
                    } else {
                        person.activeArmor.get(0).getParams();
                    }
                    break;
                case 4:
                    isClose = true;
                    break;
            }
        }
    }

    public static void hero_menu() {
        boolean isClose = false;
        while (isClose != true) {
            System.out.println("Here are hero actions\n" +
                    "1. get params\n" +
                    "2. go to the city\n" +
                    "3. Quest menu\n" +
                    "4. exit menu\n" +
                    "HINT: just type number of the clause");
            Scanner askForaAction = new Scanner(System.in);
            int actionNum = askForaAction.nextInt();  /// action ask
            switch (actionNum) {
                case 1:
                    Source.params(Main.person);
                    break;
                case 2:
                    Source.enterLocation();
                    break;
                case 3:
                    Main.person.getActiveQuest();
                    break;
                case 4:
                    isClose = true;
                    break;
            }
        }
    }

    public static void saveMenu() throws IOException {
        boolean isClose = false;
        while (isClose != true) {
            System.out.println("Do you need save or load\n" +
                    "1. save the game\n" +
                    "2. Load the game\n" +
                    "3. exit\n" +
                    "HINT: just type number of the clause");
            Scanner askForSaveOrLoad = new Scanner(System.in);
            int actionNum = askForSaveOrLoad.nextInt();  /// action ask
            switch (actionNum) {
                case 1:
                    Source.SaveTheGame(Main.person);
                    isClose = true;
                    break;
                case 2:
                    Main.person = Source.LoadGame("yes", Main.person);
                    isClose = true;
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
    }

    public static void attackEnemy(Hero1 valera, Enemy enemy) {

        System.out.println("Do you really want to attack enemy (yes/no) ");
//        System.out.println("Do you really want to Auto attack enemy (yes/no) ");  //TODO сделать пошаговую битву
        Scanner questionAttack = new Scanner(System.in);
        if (questionAttack.nextLine().equals("yes")) {
            enemy.setHealth(((enemy.getHealth() + enemy.getResistance())));
            valera.setHealth(((valera.getHealth() + valera.getResistance())));
            while (enemy.getHealth() >= 0) {
                enemy.setHealth(enemy.getHealth() - valera.getAttack());
                System.out.println(enemy.getHealth());  //TODO отладачная информация
                valera.setHealth(valera.getHealth() - enemy.getAttack());
                System.out.println(valera.getHealth());  //TODO отладачная информация
                if (enemy.getHealth() <= 0) {
                    enemy.dead();
                } else if (valera.getHealth() == 0) {
                    valera.dead();
                    Main.isQuitGame = true;   //TODO когда будут готовы камни воскрешения переписать этот метод
                    System.out.println("The game is out, you lose");
                }
            }
            if ((valera.getHealth() - valera.getResistance()) <= 0) {
                valera.setHealth(10);
            } else if ((valera.getHealth() - valera.getResistance()) > 10) {
                valera.setHealth(((valera.getHealth() - valera.getResistance())));
            }
        } else if (questionAttack.nextLine().equals("no")) {
            System.out.println("It is your choice");
        }
    }
}




