package Main;

/////Dictionaries

import Dictionary.RandomArmorName;
import Dictionary.RandomFoodName;
import Dictionary.RandomNpcName;
import Dictionary.RandomPotion;
import Enemies.Enemy;
import Heroes.Hero1;
import Items.Armor.ClothArmor;
import Items.Armor.IronArmor;
import Items.Armor.LeatherArmor;
import Items.Items;
import Items.OtherItems.Food;
import Items.OtherItems.ResurrectStone;
import Items.Potions.HealthPotion;
import Items.Potions.ManaPotion;
import Items.Weapons.Firearms.Tunning.Muska;
import Items.Weapons.Firearms.Tunning.OpticalScope;
import Items.Weapons.Firearms.Tunning.muzzleBrake;
import Items.Weapons.MeleeCombatWeapon.*;
import NPC.StartNPC;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Source {
    static Random random = new Random(1000);
    static int IntegerValue = random.nextInt(5, 90);
    static Double DoubleValue = random.nextDouble(1.0, 5.0);
    private static int MapArea = 3;  //default value of the map
    private static ArrayList<ArrayList<Integer>> MAP = new ArrayList<>(MapArea * MapArea);

/////////////////////Generate Category//////////////////////////////////////////////////////////
    public static Items GeneratePotion() {
        int generationRate = random.nextInt(90);
        if (generationRate > 70) {
            return new HealthPotion(RandomPotion.getRandomPotionName(), DoubleValue, 1, IntegerValue);
        } else if (generationRate < 70) {
            return new ManaPotion(RandomPotion.getRandomPotionName(), DoubleValue, 1, IntegerValue);
        } else {
            System.out.println("There is no potions");
            return null;
        }
    }
    public static Items GenerateWeapon() {
        int generationRate = random.nextInt(90);
        if (generationRate > 75) {
            return new Sword("Sword", 15, 20, 50);
        } else if (generationRate > 80) {
            return new Sword("Sword", 40, 15, 50);
        } else {
            System.out.println("There is nothing interesting");
            return null;
        }
    }
    public static Items GenerateArmor() {
        int generationRate = random.nextInt(90);
        if (generationRate > 85) {
            return new IronArmor(RandomArmorName.getRandomArmorName(), 80);
        } else if (generationRate > 60 && generationRate < 85) {
            return new LeatherArmor(RandomArmorName.getRandomArmorName(), 80);
        } else {
            System.out.println("There is nothing interesting");
            return null;
        }
    }
    public static Hero1 CreateHero1() {
        System.out.println("Only latin letters and no numbers allowed");
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
    private static Enemy generateEnemy() {
        return new Enemy();
    }
    public static Items GenerateOtherItems() {
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
    public static Items GenerateTunning() {
        int generationRate = random.nextInt(90);
        if (generationRate > 50) {
            return new Muska(20, "Muska");
        } else if (generationRate > 50 && generationRate < 80) {
            return new OpticalScope("Callimator", 50);
        } else if (generationRate == 50) {
            return new muzzleBrake(100);
        } else return null;
    }
////NPC////////////////////////////////////////////////////////////
    public static StartNPC GenerateStartNPC() {
        return new StartNPC(RandomNpcName.getRandomNPCName());
    }

//    public static NPC GenerateNpc() {
//        int generationRate = random.nextInt(100);
//        if(generationRate < 10) {
//            return new NPC(RandomNpcName.getRandomNPCName()) {
//            };
//        } else {
//            return null;
//        }
//    }

/////////////////////Generate Category Close/////////////////////////////////////////////////////////


/////////////////Menu Category////////////////////////////////////////////////////////////////////////

    public static void quitGameMenu(boolean isAutoSave, Hero1 valera) throws IOException, InterruptedException {
        if (isAutoSave) {
            SaveTheGame(valera);
        } else if (isAutoSave == false) {
//                && Main.saveFile.lastModified() < Long.parseLong(LocalDateTime.now().toString())) { //TODO по идее второе условие так и так будет меньше
            System.out.println("Attention, the game option auto save is disabled");
            System.out.println("The game will not be saved");
            Thread.sleep(3_000);
        }
        System.out.println("Outing the game");
        Main.isQuitGame = true;
    }

    public static void configurateGameOptionsMenu() {
        boolean isClose = false;
        System.out.print("What would you like to change? ");
        System.out.println("""
                What can you do
                1. Change auto save parameter
                2. Change save path
                3. Close configuration
                HINT: just type number of the clause""");
        System.out.println();
        while (!isClose) {
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    if (!Main.isAutoSave) {
                        System.out.println("Auto save enabled");
                        Main.isAutoSave = true;
                        isClose = true;
                        break;
                    } else {
                        System.out.println("Auto save disabled");
                        Main.isAutoSave = false;
                        isClose = true;
                        break;
                    }
                case 2:
                    System.out.println("Enter new save File name");
                    System.out.println("You're currently in /home/kirill/IdeaProjects/My_game/src/Saving_Files/");
                    Scanner askForNewSavePath = new Scanner(System.in);
                    String newSavePath = askForNewSavePath.nextLine();
                    Main.saveFile = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/" + newSavePath);
                    isClose = true;
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
    }

    public static void movingMenu() throws IOException, InterruptedException {
        /***
         * This method is built for moving hero
         * Also contains chance of activating battle mode
         */
        boolean isClose = false;
        while (!isClose) {
            System.out.println("""
                    What location you need
                    1. move forward
                    2. move left
                    3. move right
                    4. move backward
                    5. open map
                    6. exit moving
                    HINT: just type number of the clause""");
            System.out.println();
            Random rand = new Random();
            int randint = rand.nextInt(1, 100);
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    System.out.println(Main.person.getName() + " moving forward");
//                    System.out.println(randint); //TODO для отладки удалить позже
                    if (randint < 25) {
                        fight();
                        isClose = true;
                    } else if (randint > 25) {
                        System.out.println("You're lucky, there is no enemy ");
                    }
                    Main.forwardCoordinates += 1;
                    break;
                case 2:
                    System.out.println(Main.person.getName() + " moving left");
                    if (randint < 8) {
                        fight();
                        isClose = true;
                    }
                    Main.leftCoordinates += 1;
                    break;
                case 3:
                    System.out.println(Main.person.getName() + " moving right");
                    if (randint < 8) {
                        fight();
                        isClose = true;
                    }
                    Main.rightCoordinates += 1;
                    break;
                case 4:
                    System.out.println(Main.person.getName() + " moving backward");
                    if (randint < 5) {
                        fight();
                        isClose = true;
                    }
                    Main.backwardCoordinates += 1;
                    break;
                case 5:
                    viewMap();
                    break;
                case 6:
                    System.out.println("Outing move menu");
                    isClose = true;
                    break;
            }
        }
    }

    private static void enterNewLocation(String LocationName) {
        System.out.println("You've entering " + LocationName);
    }

    private static void enterLocation() {
        boolean isClose = false;
        while (!isClose) {
            System.out.println("""
                    What location you need
                    1. Skyrim
                    2. Hammerfall
                    3. Ogrimar
                    4. Exit menu
                    HINT: just type number of the clause""");
            System.out.println();
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    Source.enterNewLocation("Skyrim");
                    break;
                case 2:
                    Source.enterNewLocation("Hammerfall");
                    break;
                case 3:
                    Source.enterNewLocation("Ogrimar");
                    break;
                case 4:
                    isClose = true;
                    break;
            }
        }
    }

    private static void paramsMenu(Hero1 person) {
        boolean isClose = false;
        while (!isClose) {
            System.out.println();
            System.out.println("Which params would you like to see?");
            System.out.println("""
                    1. Hero params
                    2. Weapon params
                    3. Armor params
                    4. Exit params menu
                    HINT: just type number of the clause""");
            System.out.println();
            switch (new Scanner(System.in).nextInt()) {
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

    public static void heroMenu() {
        boolean isClose = false;
        while (!isClose) {   /// Maybe problems
            System.out.println("""
                    Here are hero actions
                    1. Get params
                    2. Go to the city
                    3. Quest menu
                    4. Exit menu
                    HINT: just type number of the clause""");
            System.out.println();
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    Source.paramsMenu(Main.person);
                    isClose = true;
                    break;
                case 2:
                    Source.enterLocation();
                    isClose = true;
                    break;
                case 3:
                    questMenu();
                    break;
                case 4:
                    isClose = true;
                    break;
            }
        }
    }

    private static void questMenu() {
        boolean isQuitQuestMenu = false;
        while (!isQuitQuestMenu) {
            System.out.println("""
                    Here are quest actions
                    1. get active quest
                    2. get quest list
                    3. exit menu
                    HINT: just type number of the clause""");
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    Main.person.getActiveQuest();
                    isQuitQuestMenu = true;
                    break;
                case 2:
                    Main.person.getQuestsList();
                    isQuitQuestMenu = true;
                    break;
                case 3:
                    isQuitQuestMenu = true;
                    break;
            }
        }
    }

    public static void saveMenu() throws IOException {
        boolean isClose = false;
        while (isClose != true) {
            System.out.println("""
                    Do you need save or load
                    1. Save the game
                    2. Load the game
                    3. Exit
                    HINT: just type number of the clause""");
            System.out.println();
            switch (new Scanner(System.in).nextInt()) {
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

    public static void inventoryMenu() {
        boolean isClose = false;
        while (!isClose) {
            System.out.println("""
                    Inventory menu
                    1. Open inventory
                    2. Put on armor
                    3. Put on weapon
                    4. take off weapon
                    5. take off weapon
                    6. exit inventory menu
                    HINT: just type number of the clause""");
            System.out.println();
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    Main.person.inventoryCall();
                    break;
//                case 2:
//                    Main.person.putOnArmor();
//                    break;
//                case 3:
//                    Main.person.takeOffArmor();
//                    break;
//                case 4:
//                    Main.person.takeOffWeapon();
//                    break;
//                case 5:
//                    Main.person.putOnWeapon();
//                    break;
                case 6:
                    isClose = true;
                    break;
            }
        }
    }
//////////////////Menu Category Close///////////////////////////////////////////////////////

    //////////////////Fight Category///////////////////////////////////////////////////////////////
    private static void fight() throws IOException, InterruptedException {
        Enemy enemy = Source.generateEnemy();
        int enemyHealth = enemy.getHealth();
        Main.isInBattle = true;  ///enter fight mode
        System.out.println("You're currently in Battle mode");
        while (Main.isInBattle) {
            Source.attackEnemy(Main.person, enemy);
            System.out.println("You're won!");
            Main.person.setExperience(Main.person.getExperience() + enemyHealth / 2);
            System.out.println("Your experience is " + Main.person.getExperience());
            Main.isInBattle = false;  /// out fight mode
        }
    }

    private static void attackEnemy(Hero1 valera, Enemy enemy) throws IOException, InterruptedException {

        System.out.println("Do you really want to attack enemy (yes/no) ");
        Scanner questionAttack = new Scanner(System.in);
        if (questionAttack.nextLine().equals("yes")) { //Хотите атаковать?
            System.out.println("Do you want to Auto attack enemy (yes/no) ");
//            Scanner askForAutoAttack = new Scanner(System.in);  //TODO if no?
            if (new Scanner(System.in).nextLine().equals("yes")) { //Auto Attack Branch
                enemy.setHealth(((enemy.getHealth() + enemy.getResistance())) + (enemy.getArmor() % 2));  //добавление резистов и брони перед автобитвой
                valera.setHealth(((valera.getHealth() + valera.getResistance())) + (valera.getArmor() % 2));
                while (enemy.getHealth() >= 0) {
                    enemy.setHealth(enemy.getHealth() - valera.getAttack());
                    System.out.println("Enemy has heath " + enemy.getHealth());  //TODO отладачная информация
                    valera.setHealth(valera.getHealth() - enemy.getAttack());
                    System.out.println("Hero has heath " + valera.getHealth());  //TODO отладачная информация
                    if (enemy.getHealth() <= 0) {
                        enemy.dead();
                        if (Main.isAutoSave) {
                            System.out.println(" After fight saving game");
                            SaveTheGame(valera);
                        }
                    } else if (valera.getHealth() == 0) {
                        valera.dead();
                        Main.isQuitGame = true;   //TODO когда будут готовы камни воскрешения переписать этот фрагмент
                        System.out.println("The game is out, you lose");
                        Source.quitGameMenu(Main.isAutoSave, valera); // outing the game if dead
                    }
                }
                if ((valera.getHealth() - valera.getResistance()) <= 0) {
                    valera.setHealth(10);
                } else if ((valera.getHealth() - valera.getResistance()) > 10) {
                    valera.setHealth(((valera.getHealth() - valera.getResistance())));
                }
            } else {  //Manual fight branch
                enemy.setHealth(((enemy.getHealth() + enemy.getResistance())) + (enemy.getArmor() % 2));
                valera.setHealth(((valera.getHealth() + valera.getResistance())) + (valera.getArmor() % 2));
                while (enemy.getHealth() <= 0) {
                    System.out.println("""
                            Fight menu
                            1. regular attack
                            2. open inventory
                            3. use ability
                            HINT: just type number of the clause""");
                    if (enemy.getHealth() <= 0) {
                        enemy.dead();
                        if (Main.isAutoSave) {
                            System.out.println(" After fight saving game");
                            SaveTheGame(valera);
                        }
                    } else if (valera.getHealth() == 0) {
                        valera.dead();
                        Main.isQuitGame = true;   //TODO когда будут готовы камни воскрешения переписать этот фрагмент
                        System.out.println("The game is out, you lose");
                        Source.quitGameMenu(Main.isAutoSave, valera); // outing the game if dead
                    }
                    switch (new Scanner(System.in).nextInt()) {
                        case 1: {
                            enemy.setHealth(enemy.getHealth() - valera.getAttack());
                            System.out.println("Enemy has heath " + enemy.getHealth());  //TODO отладачная информация
                            valera.setHealth(valera.getHealth() - enemy.getAttack());
                            System.out.println("Hero has heath " + valera.getHealth());  //TODO отладачная информация
                            break;
                        }
                        case 2: {
                            System.out.println("opening inventory");
                            valera.inventoryCall();
                            break;
                        }
                        case 3: {
                            boolean isClose = false;
                            System.out.println("Ability list");
                            while (!isClose) {
                                System.out.println("""
                                        Fight menu
                                        1. defend magic
                                        2. attack magic
                                        3. exit menu
                                        HINT: just type number of the clause""");
                                Scanner askForAbility = new Scanner(System.in);
                                switch (askForAbility.nextInt()) {
                                    case 1: {
                                        valera.defendingMagick();
                                        isClose = true;
                                        break;
                                    }
                                    case 2: {
                                        valera.attackMagick();
                                        isClose = true;
                                        break;
                                    }
                                    case 3: {
                                        isClose = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (questionAttack.nextLine().equals("no")) {
            valera.setHealth((int) (valera.getHealth() * 0.5));
            Main.isInBattle = false;
            System.out.println("It is your choice");
        }
    }


//////////////////Fight Category Close///////////////////////////////////////////////////////////////

    /////////////////Save and load Category///////////////////////////////////////////////////////////////
    public static void TestLoad(Hero1 valera) {
        LoadGame("yes", valera);
    }

    public static void TestSave(Hero1 valera) throws IOException {
        SaveTheGame(valera);
    }

    private static void whatInformationToSave(Hero1 valera) {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(Main.saveFile));
////Parameters to save
            bf.write(valera.getName());  //0
            bf.write(' ');

            bf.write(String.valueOf(valera.getHealth()));  ///1
            bf.write(' ');

            bf.write(String.valueOf(valera.getArmor())); //2
            bf.write(' ');

            bf.write(String.valueOf(valera.getAttack()));  //3
            bf.write(' ');

            if (valera.getMagic()) {     ///save magic boolean  //4
                bf.write(String.valueOf(true));
                bf.write(' ');
            } else if (valera.getMagic() == false) {
                bf.write(String.valueOf(false));
                bf.write(' ');
            }
            bf.write(String.valueOf(valera.getResistance()));  //5
            bf.write(' ');

            bf.write(String.valueOf(valera.getMana()));  //6
            bf.write(' ');

            bf.write(String.valueOf(valera.getExperience()));  //7

            if (valera.getActiveQuest() == null) {   ///Active quest save
                bf.newLine();
                bf.write("null");
            } else if (valera.getActiveQuest() != null) {
                bf.newLine();
                bf.write(valera.getActiveQuest());
            }

            if (valera.getActiveArmor().isEmpty()) {  ///ARMOR
                bf.newLine();
                bf.write("null");
            } else {
                bf.newLine();
                bf.write(valera.getActiveArmor().get(0).getItemName());
                bf.write(' ');
                bf.write(((String.valueOf(valera.getActiveArmor().get(0).getArmorDef()))));
                bf.write(' ');
                bf.write(((String.valueOf(valera.getActiveArmor().get(0).getTypeOfArmor()))));
            }

            if (valera.getActiveWeapon().isEmpty()) {  ///WEAPON
                bf.newLine();
                bf.write("null");
            } else {
                bf.newLine();
                bf.write(valera.getActiveWeapon().get(0).getItemName());
                bf.write(' ');
                bf.write((String.valueOf(valera.getActiveWeapon().get(0).getAttack())));
                bf.write(' ');
                bf.write(((String.valueOf(valera.getActiveWeapon().get(0).getTypeOfWeapon()))));
            }
            bf.newLine();
            bf.write(String.valueOf(Main.isAutoSave));  //запись параметра системы
            bf.newLine();
            bf.write(String.valueOf(MapArea));
            bf.newLine();
            bf.write(String.valueOf(Main.saveFile));  //Save file path

            /////COORDINATES
            bf.newLine();
            bf.write(String.valueOf(Main.forwardCoordinates)); // load forward coordinates
            bf.write(' ');
            bf.write(String.valueOf(Main.rightCoordinates)); // load right coordinates
            bf.write(' ');
            bf.write(String.valueOf(Main.backwardCoordinates)); // load back coordinates
            bf.write(' ');
            bf.write(String.valueOf(Main.leftCoordinates)); // load left coordinates
            bf.write(' ');
            /////COORDINATES

            ///Map
            for(int i = 0; i<MAP.size(); i++) {
                bf.newLine();
                bf.write(String.valueOf(MAP.get(i)));

            }

            bf.close();   ////close file stream
        } catch (IOException e) {
            e.getStackTrace();
            System.out.println("There are problems on saving data");
        } finally {
            System.out.println("File saved");
        }
    }

    private static void deleteWrittenSaveFile() {
        try {
            Main.saveFile.delete();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private static void SaveTheGame(Hero1 valera) throws IOException {
//        Scanner ScannerForSave = new Scanner(System.in);
//        System.out.println("Are you sure? yes/no ");      ///does not work in Test framework
//        String askForSave = ScannerForSave.nextLine();
        /**
         * This method contains two private functions and saving the game in txt file
         * /home/kirill/IdeaProjects/untitled/src/Saving_Files/save1.txt this path provides saving of the game*/
//        if (askForSave.equals("yes")) {   ///   does not work in Test framework
            if (Main.saveFile.exists()) {
                System.out.println("Rewriting save file");
                Source.deleteWrittenSaveFile();
                Source.whatInformationToSave(valera);
            } else if (!Main.saveFile.exists()) {
                Source.whatInformationToSave(valera);
            }
//        } else if (askForSave.equals("no")) {   ///   does not work in Test framework
//            System.out.println("Cancel saving");   //// does not work in Test framework
//        }
    }

    static Hero1 LoadGame(String askForLoad, Hero1 afterLoad) {
        /**
         * This method makes load of the game by reading save file byte by byte and return Hero object
         */
        if (askForLoad.equals("yes")) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(Main.saveFile));
                //What parameters to load
                String[] HeroParams = br.readLine().split(" ");  //name  ///TODO можно сделать массив строк через сплит

                String activeQuest = br.readLine();
                String[] activeArmor = br.readLine().split(" ");
                String[] activeWeapon = br.readLine().split(" ");
                String isAutoSaveTheGame = br.readLine();
                String mapaArea = br.readLine();
                String gameSaveFile = br.readLine();
                String[] Coordinates = br.readLine().split(" ");

                ArrayList<ArrayList<Integer>> afterLoadMap = new ArrayList<>(Integer.parseInt(mapaArea) * Integer.parseInt(mapaArea));
                ///TODO Остановился здесь, сделать загрузку из сохранения для карты
                ///Hero Params
                if (!activeArmor.equals("null")) {
                    switch (activeArmor[2]) {
                        case "Cloth":
                            afterLoad.putOnArmor(new ClothArmor(activeArmor[0],
                                    Integer.parseInt(activeArmor[1])));
                            break;
                        case "Iron":
                            afterLoad.putOnArmor(new IronArmor(activeArmor[0],
                                    Integer.parseInt(activeArmor[1])));
                            break;
                        case "Leather":
                            afterLoad.putOnArmor(new LeatherArmor(activeArmor[0],
                                    Integer.parseInt(activeArmor[1])));
                            break;
                    }
                }
                if (!activeWeapon.equals("null")) {
                    switch (activeWeapon[2]) {
                        case "Bo":
                            afterLoad.putOnWeapon(new Bo(activeWeapon[0],
                                    Integer.parseInt(activeWeapon[1])));
                            break;
                        case "Cathars":
                            afterLoad.putOnWeapon(new Cathars(activeWeapon[0],
                                    Integer.parseInt(activeWeapon[1])));
                            break;
                        case "Chakram":
                            afterLoad.putOnWeapon(new Chakram(activeWeapon[0],
                                    Integer.parseInt(activeWeapon[1])));
                            break;
                        case "Knife":
                            afterLoad.putOnWeapon(new Knife(activeWeapon[0],
                                    Integer.parseInt(activeWeapon[1])));
                            break;
                        case "Mace":
                            afterLoad.putOnWeapon(new Mace(activeWeapon[0],
                                    Integer.parseInt(activeWeapon[1])));
                            break;
                        case "Sword":
                            afterLoad.putOnWeapon(new Sword(activeWeapon[0],
                                    Integer.parseInt(activeWeapon[1])));
                            break;
                    }
                }
                if (!activeQuest.equals("null")) {
                    afterLoad.setActiveQuest(activeQuest);
                }
                afterLoad.setName(HeroParams[0]);  // name
                afterLoad.setHealth(Integer.parseInt(HeroParams[1]));
                afterLoad.setArmor(Integer.parseInt(HeroParams[2]));       //Armor
                afterLoad.setAttack(Integer.parseInt(HeroParams[3]));
                if (HeroParams[4].equals("true")) {
                    afterLoad.setMagic(true);
                } else {  ///Magic
                    afterLoad.setMagic(false);
                }
                afterLoad.setResistance(Integer.parseInt(HeroParams[5]));
                afterLoad.setMana(Integer.parseInt(HeroParams[6]));
                afterLoad.setExperience(Integer.parseInt(HeroParams[7]));
                ///Game params
                MapArea = Integer.parseInt(mapaArea);
                Main.saveFile = new File(gameSaveFile);
                Main.isAutoSave = Boolean.parseBoolean(isAutoSaveTheGame);
                ///Coordinates
                Main.forwardCoordinates = Short.parseShort(Coordinates[0]);
                Main.rightCoordinates = Short.parseShort(Coordinates[1]);
                Main.backwardCoordinates = Short.parseShort(Coordinates[2]);
                Main.leftCoordinates = Short.parseShort(Coordinates[3]);
                MAP = afterLoadMap;

                br.close();
            } catch (IOException e) {
                System.out.println("Load failed");
                e.getStackTrace();
            } finally {
                System.out.println("File loaded");
            }
        } else if (askForLoad.equals("no")) {
            System.out.println("It is your choice");
        }
        return afterLoad;
    }
//////////////////Save and Load Category Close///////////////////////////////////////////////////////////////

/////////////////Map category///////////////////////////////////////////////////////////////////////////
    public static void createMap(int mapCapacity) {
       ArrayList<Integer> emptyBlock = new ArrayList();
        int randint;
        emptyBlock.add(0);
        emptyBlock.add(0);
        emptyBlock.add(0);

        if (mapCapacity < MapArea) {
            System.out.println("Минимальная площадь карты это " + MapArea);
            createMap(new Scanner(System.in).nextInt());
        } else {
            Source.MapArea = mapCapacity;
            for (int i = 0; i <= (MapArea * MapArea); i++) {
                ArrayList<Integer> nonEmptyBlock = (ArrayList<Integer>) emptyBlock.clone();
                randint = random.nextInt(0, 150);
//                System.out.println(randint); //TODO отладочная информация

                if (randint > 100 && randint < 150) {
                    nonEmptyBlock.set(0, 1);
//                    nonEmptyBlock.put("IsNpc", 1);
                    MAP.add(nonEmptyBlock);
//                    System.out.println(nonEmptyBlock); //TODO отладочная информация

                } else if (randint > 50 && randint < 100) {
//                    nonEmptyBlock.remove("IsCity");
                    nonEmptyBlock.set(1, 1);
                    MAP.add(nonEmptyBlock);
//                    System.out.println(nonEmptyBlock); //TODO отладочная информация

                } else if (randint > 0 && randint < 50) {
                    nonEmptyBlock.set(2, 1);
//                    nonEmptyBlock.put("IsDungeon", 1);
                    MAP.add(nonEmptyBlock);
//                    System.out.println(nonEmptyBlock); //TODO отладочная информация

                } else {
                    MAP.add(emptyBlock);
//                    System.out.println(emptyBlock); //TODO отладочная информация
                }
            }
        }
    }
    public static void viewMap() {
        char sign = 'x';
        for (int z = 0; z < (MapArea % 2); z++) {
            for (int x = 0; x < (MapArea / 2) - 1; x++) {
                System.out.print(sign);
            }
            System.out.println(sign);
        }
    }
    public static ArrayList<ArrayList<Integer>> getMAP() {  ///TODO для тестов, удалить потом
        return MAP;
    }
/////////////////Map category Close///////////////////////////////////////////////////////////////////////////
}