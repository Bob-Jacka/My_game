package Main;

/////Dictionaries

import Dictionary.RandomArmorName;
import Dictionary.RandomFoodName;
import Dictionary.RandomNpcName;
import Dictionary.RandomPotion;
//////
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
import NPC.NPC;
import NPC.StartNPC;


import java.io.*;
import java.util.*;


public class Source {

    static Random random = new Random(50);
    static int IntegerValue = random.nextInt(5, 90);
    static Double DoubleValue = random.nextDouble(1.0, 5.0);
    private static File DefaultSaveFilePath
            = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/save1.txt");

    // private static LocalDateTime LDT = LocalDateTime.now();
    private static int mapArea = 5;  //default value of the map
    private static final ArrayList<HashMap<String, Integer>> MAP = new ArrayList<>(mapArea * mapArea);

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
//        Random random = new Random();
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
//        Random random = new Random();
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

    public Hero1 CreateHero1() {
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

    public static boolean quitGameMenu(boolean isAutoSave, Hero1 valera) throws IOException, InterruptedException {
//        boolean isAutoSave = true;  ///specially for Junit ,  delete later
//        boolean isQuitGame = false;  ///specially for Junit ,  delete later
        if (isAutoSave == true) {
            SaveTheGame(valera);
        } else if (isAutoSave == false) {
            System.out.println("Attention, the game option auto save is disabled");
            System.out.println("The game will not be saved");
            Thread.sleep(3_000);
        }
        System.out.println("Outing the game");
        return Main.isQuitGame = true;
    }

    public static boolean configurateGameOptionsMenu() {
        boolean isClose = false;
        System.out.print("What would you like to change? ");
        System.out.println("""
                What can you do
                1. change auto save parameter
                2. change save path
                3. close configuration
                HINT: just type number of the clause""");
        while (isClose != true) {
//            Scanner isChange = new Scanner(System.in);
//            int askFor = isChange.nextInt();
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    if (Main.isAutoSave == false) {
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
                    System.out.println("Enter new saveFile name");
                    System.out.println("You're currently in /home/kirill/IdeaProjects/My_game/src/Saving_Files/");
                    Scanner askForNewSavePath = new Scanner(System.in);
                    String newSavePath = askForNewSavePath.nextLine();
                    DefaultSaveFilePath = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/" + newSavePath);
                    isClose = true;
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
        return Main.isAutoSave;
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
//            Scanner questionMove = new Scanner(System.in);
//            int askForMove = questionMove.nextInt();
            Random rand = new Random();
            int randint = rand.nextInt(1, 100);
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    System.out.println(Main.person.getName() + " moving forward");
                    System.out.println(randint); //TODO для отладки удалить позже
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
        System.out.println("""
                What location you need
                1. skyrim
                2. hammerfall
                3. ogrimar
                HINT: just type number of the clause""");
//        Scanner questionForLocation = new Scanner(System.in);
//        int askForLocation = questionForLocation.nextInt();
        switch (new Scanner(System.in).nextInt()) {
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

    private static void paramsMenu(Hero1 person) {
        boolean isClose = false;
        while (!isClose) {
            System.out.println();
            System.out.println("Which params would you like to see?");
            System.out.println("""
                    1. Hero params
                    2. Weapon params
                    3. Armor params
                    4. exit params menu
                    HINT: just type number of the clause""");
            System.out.println();
//            Scanner askForParams = new Scanner(System.in);
//            int ParamNum = askForParams.nextInt();  /// action ask
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
        while (isClose != true) {
            System.out.println("""
                    Here are hero actions
                    1. get params
                    2. go to the city
                    3. Quest menu
                    4. exit menu
                    HINT: just type number of the clause""");
//            Scanner askForaAction = new Scanner(System.in);
//            int actionNum = askForaAction.nextInt();  /// action ask
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
                    1. save the game
                    2. Load the game
                    3. exit
                    HINT: just type number of the clause""");
//            Scanner askForSaveOrLoad = new Scanner(System.in);
//            int actionNum = askForSaveOrLoad.nextInt();  /// action ask
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
//////////////////Menu Category Close///////////////////////////////////////////////////////


    //////////////////Fight Category///////////////////////////////////////////////////////////////
    private static void fight() throws IOException, InterruptedException {
        Enemy enemy = Source.generateEnemy();
        int enemyHealth = enemy.getHealth();
        Main.isInBattle = true;  ///enter fight mode
        System.out.println("You're currently in Battle mode");
        while (Main.isInBattle != false) {
            Source.attackEnemy(Main.person, enemy);
            System.out.println("You're won!");
            Main.person.setExperience(Main.person.getExperience() + enemyHealth / 2);
            System.out.println("Your experience is " + Main.person.getExperience());
//            Main.person.getParams();
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
                        if (Main.isAutoSave == true) {
                            System.out.println(" After fight saving game");
                            SaveTheGame(valera);
                        }
                    } else if (valera.getHealth() == 0) {
                        valera.dead();
                        Main.isQuitGame = true;   //TODO когда будут готовы камни воскрешения переписать этот фрагмент
                        System.out.println("The game is out, you lose");
                        Main.isQuitGame = Source.quitGameMenu(Main.isAutoSave, valera); // outing the game if dead
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
                        if (Main.isAutoSave == true) {
                            System.out.println(" After fight saving game");
                            SaveTheGame(valera);
                        }
                    } else if (valera.getHealth() == 0) {
                        valera.dead();
                        Main.isQuitGame = true;   //TODO когда будут готовы камни воскрешения переписать этот фрагмент
                        System.out.println("The game is out, you lose");
                        Main.isQuitGame = Source.quitGameMenu(Main.isAutoSave, valera); // outing the game if dead
                    }
//                    Scanner askForAction = new Scanner(System.in);
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
                            valera.inventoryCall(valera.inventory);
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
//        Hero1 valera = new Hero1("Valera",true); ///// test, delete later  ///заглушка
        try {
            FileWriter writeSaveFile = new FileWriter(DefaultSaveFilePath);
            BufferedWriter bf = new BufferedWriter(writeSaveFile);
////Parameters to save

/////TEST////////////////////////////////////////////////////////////////////////////////////////
            bf.write("|");
            bf.write(valera.getHealth());  ///1
            bf.write("|");

            bf.write(valera.getArmor()); //3
            bf.write("|");

            bf.write(valera.getAttack());  //5
            bf.write("|");

            if (valera.getMagic() == true) {     ///save magic boolean  //7
                bf.write(1);
                bf.write("|");
            } else if (valera.getMagic() == false) {
                bf.write(0);
                bf.write("|");
            }
            bf.write(valera.getResistance());  //9
            bf.write("|");

            bf.write(valera.getMana());  //11
            bf.write("|");

            bf.write(valera.getExperience());  //12
            bf.write("|");

            bf.write(valera.getName().length());  //длина имени  //14
            bf.write("|");
            bf.write(valera.getName());  //16
            bf.write("|");

            if (valera.getActiveQuest() == null) {
                bf.newLine();
                bf.write("null");
            } else if (valera.getActiveQuest() != null) {
                bf.newLine();
                bf.write(valera.getActiveQuest());
            }

            if (valera.getActiveArmor().isEmpty()) {
                bf.newLine();
                bf.write("null");
            } else {
                bf.newLine();
                bf.write(valera.getActiveArmor().get(0).getItemName());
                bf.write((valera.getActiveArmor().get(0).getArmorDef()));
            }

            if (valera.getActiveWeapon().isEmpty()) {
                bf.newLine();
                bf.write("null");
            } else {
                bf.newLine();
                bf.write(valera.getActiveWeapon().get(0).getItemName());
                bf.write((valera.getActiveWeapon().get(0).getAttack()));
            }
            bf.newLine();
            bf.write(String.valueOf(Main.isAutoSave));  //запись параметра системы

/////TEST///////////////////////////////////////////////////////////////////////////////////
//            writeSaveFile.write("|");
//            writeSaveFile.write(valera.getHealth());  ///1
//            writeSaveFile.write("|");
//
//            writeSaveFile.write(valera.getArmor()); //3
//            writeSaveFile.write("|");
//
//            writeSaveFile.write(valera.getAttack());  //5
//            writeSaveFile.write("|");
//
//            if (valera.getMagic() == true) {     ///save magic boolean  //7
//                writeSaveFile.write(1);
//                writeSaveFile.write("|");
//            } else if (valera.getMagic() == false) {
//                writeSaveFile.write(0);
//                writeSaveFile.write("|");
//            }
//            writeSaveFile.write(valera.getResistance());  //9
//            writeSaveFile.write("|");
//
//            writeSaveFile.write(valera.getMana());  //11
//            writeSaveFile.write("|");
//
//            writeSaveFile.write(valera.getExperience());  //12
//            writeSaveFile.write("|");
//
//            writeSaveFile.write(valera.getName().length());  //длина имени  //14
//            writeSaveFile.write("|");
//            writeSaveFile.write(valera.getName());  //16
//            writeSaveFile.write("|");
//


            /// Save local date to save file
            //writeSaveFile.write(String.valueOf(LDT));  //Date
//            writeSaveFile.write(valera.getActiveQuest()); /// save active quest
//            writeSaveFile.write("|");

//            writeSaveFile.write(String.format("%h", valera.questList));  ///save QuestList
//            writeSaveFile.write("|");

//   PLACE FOR SAVE INVENTORY
//
//            writeSaveFile.write(String.format("%h", valera.getActiveWeapon()));  ///save weapon
//            writeSaveFile.write("|");
//
//            writeSaveFile.write(String.format("%h", valera.getActiveArmor()));  ///save armor
//            writeSaveFile.write("|");

            ////close file stream
            bf.close();
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
            DefaultSaveFilePath.delete();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            System.out.println("File deleted");
        }
    }

    private static void SaveTheGame(Hero1 valera) throws IOException {
//        Scanner ScannerForSave = new Scanner(System.in);
//        System.out.println("Are you sure? yes/no ");      ///does not work in Test framework
//        String askForSave = ScannerForSave.nextLine();
        /**
         * This method contains two private functions and saving the game in txt file
         * /home/kirill/IdeaProjects/untitled/src/Saving_Files/save1.txt this path provides saving of the game*/
//        if (askForSave.equals("yes")) {
            if (DefaultSaveFilePath.exists()) {
                System.out.println("Rewriting save file");
                Source.deleteWrittenSaveFile();
                Source.whatInformationToSave(valera);
            } else if (!DefaultSaveFilePath.exists()) {
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
                ArrayList<Integer> dataList = new ArrayList<>();
                ArrayList<Integer> activeQuest = new ArrayList<>();
                ArrayList<Integer> activeArmor = new ArrayList<>();
                ArrayList<Integer> activeWeapon = new ArrayList<>();

                FileReader loadReader = new FileReader(DefaultSaveFilePath);
                BufferedReader br = new BufferedReader(loadReader);

                for (char i = 0; i != DefaultSaveFilePath.length(); i++) {
                    if(i == '\n') {
//                        dataList.add(Integer.valueOf(br.readLine()));
                    }
                    int fileData = br.read();
                    //System.out.println(fileData);
                    dataList.add(fileData);


                } //What parameters to load
                afterLoad.setName(AsciiDecoder.decode(dataList.subList(17, dataList.lastIndexOf( 124))));  // name  //TODO исправить, потому что возращает New name is null
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
                //TODO загрузить другие строки
                //afterLoad.setActiveQuest(AsciiDecoder.decode(dataList.subList(17, dataList.lastIndexOf( 124))));
//                afterLoad.putOnWeapon();
//                afterLoad.putOnArmor();

                br.close();
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


//////////////////Save and Load Category Close///////////////////////////////////////////////////////////////


    /////////////////Map category///////////////////////////////////////////////////////////////////////////
    public void createMap(int mapCapacity) {
        Source.mapArea = mapCapacity * mapCapacity;
        HashMap<String, Integer> emptyMap = new HashMap<>();
        emptyMap.put("IsNpc", 0);
        emptyMap.put("Iscity", 0);
        emptyMap.put("Isdung", 0);

        for (int i = 0; i <= (mapArea); i++) {
            MAP.add(emptyMap);
        }
    }

    private static void viewMap() {
        char sign = 'x';
        for (int z = 0; z < (mapArea / 2); z++) {
            for (int x = 0; x < (mapArea / 2) - 1; x++) {
                System.out.print(sign);
            }
            System.out.println(sign);
        }
    }

/////////////////Map category Close///////////////////////////////////////////////////////////////////////////
}