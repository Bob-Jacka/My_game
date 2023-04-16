package Main;

import Dictionary.RandomArmorName;
import Dictionary.RandomFoodName;
import Dictionary.RandomNpcName;
import Enemies.Enemy;
import Heroes.Hero;
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
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;




public class Source {

    Random random = new Random(50);
    int IntegerValue = random.nextInt(5, 90);
    Double DoubleValue = random.nextDouble(1.0, 5.0);


    public Items GeneratePotion() {
//        Random random = new Random();
        int generationRate = random.nextInt(90);
        if (generationRate > 70) {
            return new HealthPotion("HealthPotion", DoubleValue, 1, IntegerValue);
        } else if (generationRate < 70) {
            return new ManaPotion("HealthPotion", DoubleValue, 1, IntegerValue);
        }
        else {
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
        }
        else {
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

    public void enterNewLocation(String LocationName) {
        System.out.println("You've entering " + LocationName);
    }



    public Enemy generateEnemy() {
        int genEn = random.nextInt(1, 50);
        if (genEn > 50) {
            System.out.println("An enemy appeared ");
            return new Enemy();
        } else {
            System.out.printf("You're lucky, there is no enemy ");
        }
        return null;
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
        } else if (generationRate == 50){
            return new muzzleBrake( 100);
        } else return null;
    }
    public static StartNPC GenerateStartNPC() {
        return new StartNPC(RandomNpcName.getRandomNPCName());
    }


//////////////////Save and load game////////////////////////////

    ///file where save of the game
    private static final File toSaveFile
        = new File("/home/kirill/IdeaProjects/untitled/src/Saving_Files/save1.txt");

    protected static void whatInformationToSave(Hero1 valera) throws IOException {
//        Hero1 valera = new Hero1("Valera",true); ///// test, delete later  ///заглушка
        try {
            FileWriter writeSaveFile = new FileWriter(toSaveFile);

////Parameters to save
            writeSaveFile.write(valera.getHealth());
//            writeSaveFile.write(String.format("%d", valera.getHealth()));  //save health int
            writeSaveFile.write("|");


//            writeSaveFile.write(String.format("%d", valera.getArmor()));  ///save armor int
            writeSaveFile.write(valera.getArmor());
            writeSaveFile.write("|");

            writeSaveFile.write(valera.getAttack());
//            writeSaveFile.write(String.format("%d", valera.getAttack()));  ///save attack  int
            writeSaveFile.write("|");

            if(valera.getMagic() == true) {     ///save magic boolean
                writeSaveFile.write(1);
                writeSaveFile.write("|");
            } else if (valera.getMagic() == false) {
                writeSaveFile.write(0);
                writeSaveFile.write("|");
            }
            writeSaveFile.write(valera.getResistance());
//            writeSaveFile.write(String.format("%d", valera.getResistance()));  ///save resistance int
            writeSaveFile.write("|");

//            writeSaveFile.write(String.format("%d", valera.getMana()));  ///save resistance int
            writeSaveFile.write(valera.getMana());
            writeSaveFile.write("|");

            writeSaveFile.write(valera.getExperience());
//            writeSaveFile.write(String.format("%d", valera.getExperience()));  ///save experience int
            writeSaveFile.write("|");

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
    protected static void deleteWrittenSaveFile() {
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
                afterLoad.setName(afterLoad.getName());
                afterLoad.setHealth(dataList.get(0));  //Health
                afterLoad.setArmor(dataList.get(2));       //Armor
                afterLoad.setAttack(dataList.get(4));
                if (dataList.get(6) == 1) {
                    afterLoad.setMagic(true);
                } else {  ///Magic
                    afterLoad.setMagic(false);
                }
                afterLoad.setResistance(dataList.get(8));
                afterLoad.setMana(dataList.get(10));
                afterLoad.setExperience(dataList.get(12));
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
        if(isAutoSave == true) {
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
                        "2. close configuration\n" +
                        "HINT: just type number of the clause");
        while(isClose != true) {
            Scanner isChange = new Scanner(System.in);
            int askFor = isChange.nextInt();
            switch (askFor) {
                case 1:
                    Main.isAutoSave = true;
                    break;
                case 2:
                    isClose = true;
                    break;
            }
        }
        return Main.isAutoSave;
    }
}


