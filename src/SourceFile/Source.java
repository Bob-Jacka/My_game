package SourceFile;

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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public void enterNewLocation() {
        System.out.println("You've entering new location");
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

    protected static void whatInformationToSave() throws IOException {
        Hero1 valera = new Hero1("Valera",true); ///// test, delete later
        try {
            FileWriter writeSaveFile = new FileWriter(toSaveFile);

////Parameters to save

            writeSaveFile.write(valera.getName());   ///save name
            writeSaveFile.write("|");

            writeSaveFile.write(String.format("%d", valera.getHealth()));  //save health int
            writeSaveFile.write("|");

            //            writeSaveFile.write(valera.getArmor());
            writeSaveFile.write(String.format("%d", valera.getArmor()));  ///save armor int
            writeSaveFile.write("|");


//          writeSaveFile.write(valera.getAttack());
            writeSaveFile.write(String.format("%d", valera.getAttack()));  ///save attack  int
            writeSaveFile.write("|");


            writeSaveFile.write(String.format("%s", valera.getMagic()));  ///save magic boolean
            writeSaveFile.write("|");

//          writeSaveFile.write(valera.getResistance());
            writeSaveFile.write(String.format("%d", valera.getResistance()));  ///save resistance int
            writeSaveFile.write("|");

            writeSaveFile.write(String.format("%d", valera.getMana()));  ///save resistance int
            writeSaveFile.write("|");

            //            writeSaveFile.write(valera.getExperience());
            writeSaveFile.write(String.format("%d", valera.getExperience()));  ///save experience int
            writeSaveFile.write("|");

//            writeSaveFile.write(valera.getActiveQuest()); /// save active quest
            writeSaveFile.write("|");

            writeSaveFile.write(String.format("%h", valera.questList));  ///save QuestList
            writeSaveFile.write("|");

//
//   PLACE FOR SAVE INVENTORY
//
            writeSaveFile.write(String.format("%h", valera.getActiveWeapon()));  ///save weapon
            writeSaveFile.write("|");

            writeSaveFile.write(String.format("%h", valera.getActiveArmor()));  ///save armor
            writeSaveFile.write("|");

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
    public static void SaveTheGame() throws IOException {
//        Scanner ScannerForSave = new Scanner(System.in);
//        System.out.println("Are you sure? yes/no ");      ///does not work in Test framework
//        String askForSave = ScannerForSave.nextLine();
        String askForSave = "yes";
        if (askForSave.equals("yes")) {
            if (toSaveFile.exists()) {
                System.out.println("Rewriting save file");
                Source.deleteWrittenSaveFile();
                Source.whatInformationToSave();
            } else if (!toSaveFile.exists()) {
                Source.whatInformationToSave();
            }
        } else if (askForSave.equals("no")) {
            System.out.println("Cancel saving");
        }
    }


    public void LoadGame() {}
///////////////////////////////////////////////////////////////////////
}



