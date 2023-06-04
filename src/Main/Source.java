package Main;

/////Dictionaries

import Dictionary.*;
import Enemies.Enemy;
import Heroes.Hero;
import Heroes.Knight;
import Heroes.Peasant;
import Heroes.Slave;
import Heroes.classes.*;
import Items.Armor.ClothArmor;
import Items.Armor.IronArmor;
import Items.Armor.LeatherArmor;
import Items.Items;
import Items.OtherItems.Food;
import Items.Potions.HealthPotion;
import Items.Weapons.Firearms.Tunning.Muska;
import Items.Weapons.Firearms.Tunning.OpticalScope;
import Items.Weapons.Firearms.Tunning.muzzleBrake;
import Items.Weapons.MeleeCombatWeapon.*;
import Locations.City;
import Locations.Dungeon;
import NPC.Dif_NPC;
import NPC.NPC;
import NPC.StartNPC;

import java.io.*;
import java.time.LocalTime;
import java.util.*;


public final class Source {
    private static final Random random = new Random(1000);
    private static int MapArea = 3;  //default value of the map
    private static ArrayList<ArrayList<Integer>> MAP = new ArrayList<>(MapArea * MapArea);
//    private final String[] HERO_LEVELS = new String[] {"Slave", "Peasant", "Knight", "Healer", "Hunter", "Necromancer", "Tank", "Warrior"};

    /////////////////////Generate Category//////////////////////////////////////////////////////////
    private static Items GeneratePotion() {
        return new HealthPotion(RandomPotion.getRandomPotionName(), random.nextDouble(), random.nextInt(4), random.nextInt());
    }

    private static Items GenerateWeapon() {
        return new Sword(RandomWeaponName.getRandomWeaponName(), random.nextInt(40), random.nextInt(30), random.nextInt(80));
    }

    private static Items GenerateArmor() {
        return new IronArmor(RandomArmorName.getRandomArmorName(), random.nextInt());
    }

    private static Slave CreateHero1() {
        System.out.println("Only latin letters and no numbers allowed");
        System.out.print("Enter your hero name: ");
        Scanner name = new Scanner(System.in);
        String name_actual = name.next();

        System.out.print("Is your hero a magician (yes/no): ");
        String magic = _StringInput();
        boolean magic_actual;

        if (magic.equals("yes")) {
            magic_actual = true;
        } else {
            magic_actual = false;
        }
        return new Slave(name_actual, magic_actual);
    }

    private static Enemy GenerateEnemy() {
        return new Enemy(RandomNpcName.getRandomNPCName(), random.nextBoolean());
    }

    private static Items GenerateOtherItems() {
        return new Food(RandomFoodName.getRandomFoodName(), random.nextInt(50), random.nextBoolean());
    }

    private static Items GenerateTunning() {
        int generationRate = random.nextInt(90);
        if (generationRate > 50) {
            return new Muska(random.nextInt(25), "Muska");
        } else if (generationRate > 50 && generationRate < 80) {
            return new OpticalScope("Callimator", 50);
        } else if (generationRate == 50) {
            return new muzzleBrake(100);
        } else return null;
    }

    public static Items publicGenerator(int AskForGenerator) {
        switch (AskForGenerator) {
            case 1:
                return GeneratePotion();

            case 2:
                return GenerateWeapon();

            case 3:
                return GenerateArmor();

//            case 4:
//                return GenerateTunning();

            case 5:
                return GenerateOtherItems();
        }
        return null;
    }

    private static Items LootGenerator() {
        int generationRate = random.nextInt(100);
        if (generationRate < 30) {
            return null;
        } else if (generationRate > 30 && generationRate < 50) {
            GenerateWeapon();
        } else if (generationRate > 50 && generationRate < 70) {
            GenerateArmor();
        } else if (generationRate > 70 && generationRate <= 100) {
            GenerateOtherItems();
        }
        System.out.println("There are nothing interesting");
        return null;
    }

    private static Hero GenerateHero(int HeroNumber) {
        if (HeroNumber == 1) return new Slave();

        else if (HeroNumber == 2) return new Peasant();

        else if (HeroNumber == 3) return new Knight();

        else if (HeroNumber == 4) return new Healer();

        else if (HeroNumber == 5) return new Hunter();

        else if (HeroNumber == 6) return new Necromancer();

        else if (HeroNumber == 7) return new Tank();

        else if (HeroNumber == 8) return new Warrior();

        return null;
    }

    ////NPC////////////////////////////////////////////////////////////
    static StartNPC GenerateStartNPC() {
        return new StartNPC(RandomNpcName.getRandomNPCName());
    }

    private static Dif_NPC GenerateNpc() {
        return new Dif_NPC(RandomNpcName.getRandomNPCName());
    }

/////////////////////Generate Category Close/////////////////////////////////////////////////////////


/////////////////Menu Category////////////////////////////////////////////////////////////////////////

    private static void quitGameMenu() throws IOException, InterruptedException {
        if (Main.IS_AUTO_SAVE) {
            SaveTheGame();
        } else if (Main.IS_AUTO_SAVE == false && Main.SAVE_FILE.lastModified() > (LocalTime.MAX.getNano() - 100_000)) {
            //TODO по идее второе условие так и так будет меньше
            System.out.println("Attention, the game option auto save is disabled");
            System.out.println("The game will not be saved");
            Thread.sleep(3_000);
        }
        System.out.println("Outing the game");
        Main.IS_QUIT_GAME = true;
    }

    private static void _configurateGameOptionsMenu() {
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
            switch (_IntegerInput(3)) {
                case 1:
                    if (!Main.IS_AUTO_SAVE) {
                        System.out.println("Auto save enabled");
                        Main.IS_AUTO_SAVE = true;
                        isClose = true;
                        break;
                    } else {
                        System.out.println("Auto save disabled");
                        Main.IS_AUTO_SAVE = false;
                        isClose = true;
                        break;
                    }
                case 2:
                    System.out.println("Enter new save File name");
                    System.out.println("You're currently in ~/Saving_Files/");
                    Scanner askForNewSavePath = new Scanner(System.in);
                    String newSavePath = askForNewSavePath.nextLine();
                    Main.SAVE_FILE = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/" + newSavePath);
                    isClose = true;
                    break;
                case 3:
                    isClose = true;
                    break;
                default:
                    System.out.println("Такого действия нет");
                    isClose = true;
                    break;
            }
        }
    }

    private static void movingMenu() throws IOException, InterruptedException {
        /***
         * This method is built for moving hero
         * Also contains chance of activating battle mode
         */
        boolean isClose = false;
        while (!isClose) {
            System.out.println("""
                    What direction you need
                    1. Move forward
                    2. Move left
                    3. Move right
                    4. Move backward
                    5. Open map
                    6. Exit moving
                    HINT: just type number of the clause""");
            System.out.println();
            Random rand = new Random();
            int randint = rand.nextInt(1, 100);
            //    System.out.println("вероятность встречи с врагом " + randint); // для отладки удалить позже
            switch (_IntegerInput(6)) {
                case 1:
                    if (randint < 25) {
                        _fight();
                        isClose = true;
                    } else if (randint > 25) {
                        System.out.println("You're lucky, there is no enemy ");
                    }
                    moving("forward", 1);
                    break;
                case 2:
                    if (randint < 8) {
                        _fight();
                        isClose = true;
                    } else if (randint > 25) {
                        System.out.println("You're lucky, there is no enemy ");
                    }
                    moving("left", 1);
                    break;
                case 3:
                    if (randint < 8) {
                        _fight();
                        isClose = true;
                    } else if (randint > 25) {
                        System.out.println("You're lucky, there is no enemy ");
                    }
                    moving("right", 1);
                    break;
                case 4:
                    if (randint < 5) {
                        _fight();
                        isClose = true;
                    } else if (randint > 25) {
                        System.out.println("You're lucky, there is no enemy ");
                    }
                    moving("backward", 1);
                    break;
                case 5:
                    viewMapBlocked();
                    break;
                case 6:
                    isClose = true;
                    break;
                default:
                    isClose = true;
                    break;
            }
        }
    }

    private static void moving(String direction, int howManyPointsToGo) throws IOException { //TODO сделать перемещение по карте
        switch (direction) {
            case "forward":
                if (Main.HERO_LOCATION + howManyPointsToGo >= MAP.size()) {
                    System.out.println("Вы подошли к границе карты, идите назад");
                } else {
                    System.out.println(Main.PERSON.getName() + " moving forward");
                    _changeHeroCoordinates(howManyPointsToGo);
                    getActionMenu();
                }
                break;
            case "right":
                if (Main.HERO_LOCATION + MapArea >= MAP.size()) {
                    System.out.println("Вы подошли к границе карты, идите влево");
                } else {
                    System.out.println(Main.PERSON.getName() + " moving right");
                    _changeHeroCoordinates(MapArea);
                    getActionMenu();
                }
                break;
            case "backward":
                if (Main.HERO_LOCATION + howManyPointsToGo <= MAP.size()) {
                    System.out.println("Вы подошли к границе карты, идите вперёд");
                } else {
                    System.out.println(Main.PERSON.getName() + " moving backward");
                    _changeHeroCoordinates(-1);
                    getActionMenu();
                }
                break;
            case "left":
                if (Main.HERO_LOCATION + (-MapArea) <= 0) {
                    System.out.println("Вы подошли к границе карты, идите вправо");
                } else {
                    System.out.println(Main.PERSON.getName() + " moving left");
                    _changeHeroCoordinates(-MapArea);
                    getActionMenu();
                }
                break;
            default:
                throw new IllegalArgumentException("Unexpected value");
        }
    }

    private static void _changeHeroCoordinates(int howManyPointsToGo) throws IOException {
        /**
         * This method changed hero coordinates
         * @since 0.1.1
         */
        try {
            MAP.get(Main.HERO_LOCATION).remove(3);  /// берём текущий массив в котором герой и убираем его
            Main.HERO_LOCATION += howManyPointsToGo;  /// двигаем позицию
            MAP.get(Main.HERO_LOCATION).add(2);  //берём следующий массив и ставим героя
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getStackTrace();
            System.out.println("Файл сохранения неисправен, положение героя неверно");
            if (Main.IS_AUTO_SAVE) {
                System.out.println("Аварийное сохранение");
                SaveTheGame();
            }
            System.exit(1);
        }
    }


    private static void getActionMenu() {
        if (MAP.get(Main.HERO_LOCATION).get(0) == 1) {
            StartNPC npc = GenerateStartNPC();
            _NPCMenu(npc);
        } else if ((MAP.get(Main.HERO_LOCATION).get(1) == 1)) {
            City city = new City(RandomCityName.getRandomCityName());
            _locationMenu(city);
        } else if ((MAP.get(Main.HERO_LOCATION).get(2) == 1)) {
            Dungeon dungeon = new Dungeon(RandomDungeonName.getRandomDungeonName());
            dungeonMenu(dungeon);
        }
    }

    private static void _NPCMenu(NPC npc) {
        System.out.println("""
                NPC menu
                1.Talk
                2.Take quest
                3.Pass quest
                4.Exit menu
                HINT: just type number of the clause
                """);
        boolean isClose = false;
        while (!isClose) {
            switch (_IntegerInput(4)) {
                case 1:
                    npc.talk();
                    break;
                case 2:
                    npc.takeQuest(Main.PERSON);
                    break;
                case 4:
                    isClose = true;
                    break;
            }
        }
    }

    private static void _locationMenu(City city) {
        System.out.println("""
                Location menu
                1.Enter location
                2.Exit the city
                3.Open map
                4.Exit menu
                HINT: just type number of the clause
                """);
        boolean isClose = false;
        while (!isClose) {
            switch (_IntegerInput(4)) {
                case 1:
                    city.enterTheCity();
                    break;
                case 2:
                    city.exitTheCity();
                    isClose = true;
                    break;
                case 3:
                    viewMapBlocked();
                    isClose = true;
                    break;
            }
        }
    }

    private static void dungeonMenu(Dungeon dungeon) {
        System.out.println("""
                Dungeon menu
                1.Enter the dungeon
                2.Exit the dungeon
                3.Exit menu
                HINT: just type number of the clause
                """);
        boolean isClose = false;
        while (!isClose) {
            switch (_IntegerInput(3)) {
                case 1:
                    dungeon.enterTheDungeon();
                    break;
                case 2:
                    dungeon.exitTheDungeon();
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
    }

    private static void paramsMenu(Hero person) {
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
            switch (_IntegerInput(4)) {
                case 1:
                    person.getParams();
                    break;
                case 2:
                    if (person.getActiveWeapon().isEmpty()) {
                        System.out.println("There is no active armor");
                    } else person.getActiveWeapon().get(0).getParams();
                    break;
                case 3:
                    if (person.getActiveArmor().isEmpty()) {
                        System.out.println("There is no active armor");
                    } else person.getActiveArmor().get(0).getParams();
                    break;
                case 4:
                    isClose = true;
                    break;
            }
        }
    }

    private static void heroMenu() {
        boolean isClose = false;
        while (!isClose) {   /// Maybe problems
            System.out.println("""
                    Here are hero actions
                    1. Get params
                    2. Abilities
                    3. Go to the city
                    4. Quest menu
                    5. Exit menu
                    HINT: just type number of the clause""");
            System.out.println();
            switch (_IntegerInput(5)) {
                case 1:
                    paramsMenu(Main.PERSON);
                    isClose = true;
                    break;
                case 2:
                    abilityMenu();
                    isClose = true;
                    break;
                case 3:
                    //TODO сделать переход в меню
                    isClose = true;
                    break;
                case 4:
                    questMenu();
                    break;
                case 5:
                    isClose = true;
                    break;
            }
        }
    }

    private static void abilityMenu() {
        boolean isClose = false;
        while (!isClose) {
            System.out.println("""
                    Here are hero actions
                    1.See abilities
                    2.Level Up
                    3.Exit menu
                    HINT: just type number of the clause""");
            System.out.println();
            switch (_IntegerInput(3)) {
                case 1:
                    //TODO сделать список способностей
                    isClose = true;
                    break;
                case 2:
                    if (Main.PERSON.getExperience() > 1000) {
                        System.out.println("Level up");
                        //TODO сделать повышение уровня
                    } else System.out.println("You do not have enough experience");
                    isClose = true;
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
    }

    private static void questMenu() {
        boolean isClose = false;
        while (!isClose) {
            System.out.println("""
                    Here are quest actions
                    1. Get active quest
                    2. Get quest list
                    3. Exit menu
                    HINT: just type number of the clause""");
            switch (_IntegerInput(3)) {
                case 1:
                    System.out.println(Main.PERSON.getActiveQuest());
                    isClose = true;
                    break;
                case 2:
                    Main.PERSON.getQuestsList();
                    isClose = true;
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
    }

    private static void saveMenu() throws IOException {
        boolean isClose = false;
        while (isClose != true) {
            System.out.println("""
                    Do you need save or load
                    1. Save the game
                    2. Load menu
                    3. Exit
                    HINT: just type number of the clause""");
            System.out.println();
            switch (_IntegerInput(3)) {
                case 1:
                    SaveTheGame();
                    isClose = true;
                    break;
                case 2:
                    loadFilesMenu();
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
    }

    private static void loadFilesMenu() {
        File defaultSaveDirectory = new File("/home/kirill/IdeaProjects/My_game/src/Saving_Files/");
        boolean isClose = false;
        while (!isClose) {
            System.out.println();
            System.out.println("""
                    Load menu
                    1.See save files
                    2.Load the game
                    3.Exit Load menu
                    HINT: just type number of the clause""");
            System.out.println();
            switch (_IntegerInput(3)) {
                case 1:
                    System.out.println(Arrays.toString(defaultSaveDirectory.listFiles()));
                    break;
                case 2:
                    _LoadGame();
                    isClose = true;
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
    }

    private static void inventoryMenu() {
        boolean isClose = false;
        while (!isClose) {
            System.out.println("""
                    Inventory menu
                    1. Open inventory
                    2. Put on armor
                    3. Put on weapon
                    4. Take off armor
                    5. Take off weapon
                    6. Exit inventory menu
                    HINT: just type number of the clause""");
            System.out.println();
            switch (_IntegerInput(6)) {
                case 1:
                    Main.PERSON.inventoryCall();
                    break;
//                case 2:
//                    Main.person.putOnArmor();
//                    break;
//                case 3:
//                    Main.person.putOnWeapon();
//                    break;
//                case 4:
//                    Main.person.takeOffArmor();
//                    break;
//                case 5:
//                    Main.person.takeOffWeapon();
//                    break;
                case 6:
                    isClose = true;
                    break;
            }
        }
    }

    static void startMenu() {
        System.out.println("""
                ████████████████████████░░░▀██▀█████████
                ██████▀▀▀▀░░░▀▀▀█████▀▀▀▀░░░░▀░░████████
                █████▄░░░░░░░▄██▀▀░░░░░░░░░▄░░░░░███████
                █████▀░░░░░▄██▀░░░░░░░░░░░░███▄░░▀██████
                ███▀░░▄█▄▄███▀░░░░░░░▄███▄░░░▀▀░░░░▀▀███
                ██▀░░████████░░░░░░░██████░░░░░░░░░░░░██
                ██░░▄████████▄░░░░░░░████████▄▄▄▄░░░░███
                █░░░██████████▄░░░░░░░▀█████████████████
                █░░░▀███████████░░░░░░░░░▀▀█████████████
                ██░░░████████████▄▄░░░░░░░░░░▀▀█████████
                ██░░░░██████████████▄░░░░░░░░░░░▀███████
                ██▄░░░░▀███████████████▄░░░░░░░░░░██████
                ███▄░░░░░▀███████████████░░░░░░░░░░█████
                ████▄░░░░░░▀▀████████████░░░░░░░░░▄█████
                █████▄░░░░░░░░░▀▀▀▀██▀▀▀░░░░░░░░░░██████
                ███████▄░░░░░░░░░░░░░░░░░░░░░░░░▄███████
                █████████▄▄░░░░░░░░░░░░░░░░░░░▄█████████
                ████████████▄▄░░░░░░░░░░░░▄▄████████████
                """);
        if (Main.SAVE_FILE.exists() && Main.SAVE_FILE.length() != 0L) {  ///if save file exists
            ifSaveFileExists();
        } else ifSaveFileNotExists();
    }

    private static void ifSaveFileExists() {
        System.out.println("""
                Welcome to the game
                1. Continue the game
                2. New game
                3. Settings
                4. Exit
                HINT: just type number of the clause
                """);
        switch (_IntegerInput(4)) {
            case 1:
                System.out.print("Файл сохранения найден, хотите ли загрузить сохранение? yes/no ");
                String askForLoad = _StringInput();
                if (askForLoad.equals("yes")) {
                    _LoadGame();
                }
                break;
            case 2:
                System.out.println();
                System.out.println("New game");
                System.out.println();
                System.out.print("To create Hero enter yes/no ");
                String askForCreateHero = _StringInput();
                if (askForCreateHero.equals("yes")) {
                    Main.PERSON = CreateHero1();
                    System.out.print("Укажите величину карты ");    /// создание карты
                    createMap(new Scanner(System.in).nextInt());
                    Main.HERO_LOCATION = 0;
                    Source.getMAP().get(0).add(2);  //Задание стартовой позиции героя
                } else {
                    System.out.print("""
                            An error occurred, do you want to
                            1. create hero
                            2. or exit game
                            HINT: just type number of the clause
                                    """);
                    if (new Scanner(System.in).nextInt() == 1) {
                        Main.PERSON = CreateHero1();
                        System.out.print("Укажите величину карты ");    /// создание карты
                        createMap(new Scanner(System.in).nextInt());
                        Main.HERO_LOCATION = 0;
                        Source.getMAP().get(0).add(2);  //Задание стартовой позиции героя
                    } else {
                        System.exit(1);
                    }
                }
                break;
            case 3:
                _configurateGameOptionsMenu();
                break;
            case 4:
                System.exit(1);
                break;
        }
        getActionMenu();
    }

    private static void ifSaveFileNotExists() {
        System.out.println("""
                Welcome to the game
                1. New game
                2. Settings
                3. Exit
                HINT: just type number of the clause""");
        switch (_IntegerInput(3)) {
            case 1:
                System.out.println();
                System.out.println("New game");
                System.out.println();
                System.out.print("To create Hero enter yes/no ");
                String askForCreateHero = _StringInput();
                if (askForCreateHero.equals("yes")) {
                    Main.PERSON = CreateHero1();
                    System.out.print("Укажите величину карты ");    /// создание карты
                    createMap(new Scanner(System.in).nextInt());
                    Main.HERO_LOCATION = 0;
                    Source.getMAP().get(0).add(2);  //Задание стартовой позиции героя
                    getActionMenu();  ///стартовое общение с нпс
                }
                break;
            case 2:
                _configurateGameOptionsMenu();  ///TODO если сохранения нет, если зайти в настройки и выйти, то игра начнётся без создания персонажа
                break;
            case 3:
                System.exit(1);
                break;
        }
    }

    static void mainGameMenu() throws IOException, InterruptedException {
        System.out.println();
        System.out.println("""
                What you can do
                1. Move
                2. Hero menu
                3. Inventory
                4. Save or load the game
                5. Settings
                6. Quit game
                HINT: just type number of the clause""");
        System.out.println();
        switch (_IntegerInput(6)) {
            case 1:
                movingMenu();
                break;
            case 2:
                heroMenu();
                break;
            case 3:
                inventoryMenu();
                break;
            case 4:
                saveMenu();
                break;
            case 5:
                _configurateGameOptionsMenu();
                break;
            case 6:
                quitGameMenu();
                break;
        }
    }

//////////////////Menu Category Close///////////////////////////////////////////////////////

    //////////////////Fight Category///////////////////////////////////////////////////////////////
    private static void _fight() throws IOException, InterruptedException {
        Enemy enemy = GenerateEnemy();
        int enemyHealth = enemy.getHealth();
        Items loot = LootGenerator();
        Main.STATUSES[0] = true;  ///enter fight mode
        System.out.println("You're currently in Battle mode");
        boolean attackEnemyBoolean = attackEnemy(Main.PERSON, enemy); //сама битва
        while (Main.STATUSES[0]) {
            if (attackEnemyBoolean) {  //true - win, false - lose
                System.out.println("You're won!");
                Main.PERSON.setExperience(Main.PERSON.getExperience() + enemyHealth / 2); ///начисление опыта
                System.out.println("Your experience is " + Main.PERSON.getExperience());
                if (loot != null) {
                    System.out.println("You find something interesting");
                    Main.PERSON.inventoryPut(loot);
                } else {
                    System.out.println("There are nothing interesting");
                }
            } else {
                System.out.println("The battle is lose");
            }
            Main.STATUSES[0] = false;
        }
    }

    private static boolean attackEnemy(Hero valera, Enemy enemy) throws IOException, InterruptedException {
        boolean result = false;
        System.out.print("Do you want to attack enemy (yes/no) ");
        String questionAttack = _StringInput();
        if (questionAttack.equals("yes")) { //Хотите атаковать?

            enemy.setHealth(((enemy.getHealth() + enemy.getResistance())) + (enemy.getArmor() % 2));
            valera.setHealth(((valera.getHealth() + valera.getResistance())) + (valera.getArmor() % 2));

            System.out.print("Do you want to Auto attack enemy (yes/no) ");

            String askForAutoAttack = _StringInput();
            if (askForAutoAttack.equals("yes")) {
                result = _autoFight(valera, enemy);   ////fight

            } else if (askForAutoAttack.equals("no")) {
                result = _manualFight(valera, enemy);  ///fight
            }
        }
        if ((valera.getHealth() - valera.getResistance()) <= 0) {
            valera.setHealth(10);
        } else if ((valera.getHealth() - valera.getResistance()) > 10) {
            valera.setHealth(((valera.getHealth() - valera.getResistance())));
        } else {
            valera.setHealth((int) (valera.getHealth() * 0.5));
            System.out.println("It is your choice");
            Main.STATUSES[0] = false;
            return result;
        }
        return result;
    }

    private static boolean _autoFight(Hero valera, Enemy enemy) throws IOException, InterruptedException {
        while (enemy.getHealth() >= 0) {
            enemy.setHealth(enemy.getHealth() - valera.getAttack());
            System.out.println("Enemy has heath " + enemy.getHealth());  // отладачная информация
            valera.setHealth(valera.getHealth() - enemy.getAttack());
            System.out.println("Hero has heath " + valera.getHealth());  // отладачная информация
            if (enemy.getHealth() <= 0) {
                enemy.dead();

                if (Main.IS_AUTO_SAVE) {
                    System.out.println("After fight saving game");
                    SaveTheGame();
                }
                return true;
            } else if (valera.getHealth() == 0) {
                valera.dead();
                Main.IS_QUIT_GAME = true;   //TODO когда будут готовы камни воскрешения переписать этот фрагмент
                System.out.println("The game is out, you lose");
                quitGameMenu(); // outing the game if dead
            }
        }
        return false;
    }

    private static boolean _manualFight(Hero valera, Enemy enemy) throws IOException, InterruptedException {
        System.out.println("Здоровье противника " + enemy.getHealth());
        while (true) {
            System.out.println("""
                    Fight menu
                    1. Regular attack
                    2. Open inventory
                    3. Use ability
                    HINT: just type number of the clause""");
            switch (_IntegerInput(3)) {
                case 1: {
                    enemy.setHealth(enemy.getHealth() - valera.getAttack());
                    System.out.println("Enemy has heath " + enemy.getHealth());  // отладачная информация
                    valera.setHealth(valera.getHealth() - enemy.getAttack());
                    System.out.println("Hero has heath " + valera.getHealth());  // отладачная информация
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.println("Opening inventory");
                    valera.inventoryCall();
                    break;
                }
                case 3: {
                    boolean isClose = false;
                    System.out.println("Ability list");
                    while (!isClose) {
                        System.out.println();
                        System.out.println("""
                                Fight menu
                                1. Defend magic
                                2. Attack magic
                                3. Exit menu
                                HINT: just type number of the clause""");
                        switch (_IntegerInput(3)) {
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
            if (enemy.getHealth() <= 0) {
                enemy.dead();
                if (Main.IS_AUTO_SAVE) {
                    System.out.println("After fight saving game");
                    SaveTheGame();
                }
            } else if (valera.getHealth() == 0) {
                valera.dead();
                Main.IS_QUIT_GAME = true;   //TODO когда будут готовы камни воскрешения переписать этот фрагмент
                quitGameMenu(); // outing the game if dead
            }
            return true;
        }
    }

//////////////////Fight Category Close///////////////////////////////////////////////////////////////

/////////////////Save and load Category///////////////////////////////////////////////////////////////

    private static void _whatInformationToSave() {
        /**
         * This method save game and hero data
         * @since 0.0.2
         */
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(Main.SAVE_FILE));
            Main.SAVE_FILE.setWritable(true);
            ////Parameters to save
            bf.write(Main.PERSON.getName());  //0
            bf.write(' ');

            bf.write(String.valueOf(Main.PERSON.getHealth()));  ///1
            bf.write(' ');

            bf.write(String.valueOf(Main.PERSON.getArmor())); //2
            bf.write(' ');

            bf.write(String.valueOf(Main.PERSON.getAttack()));  //3
            bf.write(' ');

            if (Main.PERSON.getMagic()) {     ///save magic boolean  //4
                bf.write(String.valueOf(true));
                bf.write(' ');
            } else if (Main.PERSON.getMagic() == false) {
                bf.write(String.valueOf(false));
                bf.write(' ');
            }
            bf.write(String.valueOf(Main.PERSON.getResistance()));  //5
            bf.write(' ');

            bf.write(String.valueOf(Main.PERSON.getMana()));  //6
            bf.write(' ');

            bf.write(String.valueOf(Main.PERSON.getExperience()));  //7
            bf.write(' ');
            bf.write(String.valueOf(Main.PERSON.getClass()).substring(6));

            if (Main.PERSON.getActiveQuest() == null) {   ///Active quest save
                bf.newLine();
                bf.write("null");
            } else if (Main.PERSON.getActiveQuest() != null) {
                bf.newLine();
                bf.write(Main.PERSON.getActiveQuest());
            }

            if (Main.PERSON.getQuestListSimple().isEmpty()) {  ///Quest list save
                bf.newLine();
                bf.write("null");
            } else if (Main.PERSON.getQuestListSimple().size() != 0) {
                String QuestList = String.valueOf(Main.PERSON.getQuestListSimple());
                bf.newLine();
                bf.write(QuestList.substring(1, QuestList.length() - 1));
            }

            if (Main.PERSON.getActiveArmor().isEmpty()) {  ///ARMOR
                bf.newLine();
                bf.write("null");
            } else {
                bf.newLine();
                bf.write(Main.PERSON.getActiveArmor().get(0).getItemName());
                bf.write(' ');
                bf.write(((String.valueOf(Main.PERSON.getActiveArmor().get(0).getArmorDef()))));
                bf.write(' ');
                bf.write(((String.valueOf(Main.PERSON.getActiveArmor().get(0).getTypeOfArmor()))));
            }

            if (Main.PERSON.getActiveWeapon().isEmpty()) {  ///WEAPON
                bf.newLine();
                bf.write("null");
            } else {
                bf.newLine();
                bf.write(Main.PERSON.getActiveWeapon().get(0).getItemName());
                bf.write(' ');
                bf.write((String.valueOf(Main.PERSON.getActiveWeapon().get(0).getAttack())));
                bf.write(' ');
                bf.write(((String.valueOf(Main.PERSON.getActiveWeapon().get(0).getTypeOfWeapon()))));
            }
            bf.newLine();
            bf.write(String.valueOf(Main.IS_AUTO_SAVE));  //запись параметра автосохранения

            bf.newLine();
            bf.write(String.valueOf(MapArea));

            bf.newLine();
            bf.write(String.valueOf(Main.SAVE_FILE));  //Save file path

            /////COORDINATES
            bf.newLine();
            bf.write(String.valueOf(Main.HERO_LOCATION)); // Hero coordinates
            /////COORDINATES

            ///Map
            for (int i = 0; i < MAP.size(); i++) {
                bf.newLine();
                bf.write(String.valueOf(MAP.get(i)).substring(1, String.valueOf(MAP.get(i)).indexOf("]")));
            }
            Main.SAVE_FILE.setWritable(false);
            bf.close();   ////close file stream
        } catch (IOException e) {
            e.getStackTrace();
            System.out.println("There are problems on saving data");
            Main.SAVE_FILE.setWritable(false);
        } finally {
            System.out.println("File saved");
        }
    }

    private static void _deleteWrittenSaveFile() {
        try {
            Main.SAVE_FILE.delete();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("There are problems on saving data");
        }
    }

    private static void SaveTheGame() throws IOException {
        System.out.print("Are you sure? yes/no ");      ///does not work in Test framework
        String askForSave = _StringInput();
        if (askForSave.equals("yes")) {   ///   does not work in Test framework
            if (Main.SAVE_FILE.exists() && Main.SAVE_FILE.length() != 0L) {
                System.out.println("Rewriting save file");
                _deleteWrittenSaveFile();
                _whatInformationToSave();
            } else if (!Main.SAVE_FILE.exists()) {
                _whatInformationToSave();
            }
        } else if (askForSave.equals("no")) {   ///   does not work in Test framework
            System.out.println("Cancel saving");   //// does not work in Test framework
        }
    }

    private static void _LoadGame() {
        /**
         * This method makes load of the game by reading save file, line by line and return Hero object
         * @returns персонажа с параметрами считанными из файла сохранения
         * @since 0.0.2
         */

        try {
            BufferedReader br = new BufferedReader(new FileReader(Main.SAVE_FILE));
            //What parameters to load
            String[] HeroParams = br.readLine().split(" ");  //All hero params
            String activeQuest = br.readLine();
            String questList = br.readLine();
            String[] activeArmor = br.readLine().split(" ");
            String[] activeWeapon = br.readLine().split(" ");

            ///Game options
            String isAutoSaveTheGame = br.readLine();
            String mapArea = br.readLine();
            String gameSaveFile = br.readLine();
            short heroPosition = Short.parseShort(br.readLine());
            ///Game options

            if (HeroParams[8].substring(7).equals("Slave")) {
                Main.PERSON = new Slave();
            } else if (HeroParams[8].substring(7).equals("Peasant")) {
                Main.PERSON = new Peasant();
            } else if (HeroParams[8].substring(7).equals("Knight")) {
                Main.PERSON = new Knight();
            } else {
                throw new RuntimeException("Неправильный параметр героя");
            }

            int doubleMapArea = Integer.parseInt(mapArea) * Integer.parseInt(mapArea);  //mapArea * mapArea
            ArrayList<ArrayList<Integer>> afterLoadMap = new ArrayList<>(doubleMapArea);
            for (short i = 0; i < (doubleMapArea); i++) {
                int defint;
                ArrayList<Integer> emptyBlock = new ArrayList<>(3);
                String[] nextBlock = br.readLine().split(", ");
                for (String str : nextBlock) {
                    defint = Integer.parseInt(str);
                    emptyBlock.add(defint);
                }
                afterLoadMap.add(emptyBlock);

            }
            if (afterLoadMap.get(heroPosition).size() != 4) {
                afterLoadMap.get(heroPosition).add(2);
            }
            ///Hero Params
            if (activeArmor.equals("null") == true) {
                switch (activeArmor[2]) {
                    case "Cloth":
                        Main.PERSON.putOnArmor(new ClothArmor(activeArmor[0],
                                Integer.parseInt(activeArmor[1])));
                        break;
                    case "Iron":
                        Main.PERSON.putOnArmor(new IronArmor(activeArmor[0],
                                Integer.parseInt(activeArmor[1])));
                        break;
                    case "Leather":
                        Main.PERSON.putOnArmor(new LeatherArmor(activeArmor[0],
                                Integer.parseInt(activeArmor[1])));
                        break;
                }
            }
            if (activeWeapon.equals("null") == true) {
                switch (activeWeapon[2]) {
                    case "Bo":
                        Main.PERSON.putOnWeapon(new Bo(activeWeapon[0],
                                Integer.parseInt(activeWeapon[1])));
                        break;
                    case "Cathars":
                        Main.PERSON.putOnWeapon(new Cathars(activeWeapon[0],
                                Integer.parseInt(activeWeapon[1])));
                        break;
                    case "Chakram":
                        Main.PERSON.putOnWeapon(new Chakram(activeWeapon[0],
                                Integer.parseInt(activeWeapon[1])));
                        break;
                    case "Knife":
                        Main.PERSON.putOnWeapon(new Knife(activeWeapon[0],
                                Integer.parseInt(activeWeapon[1])));
                        break;
                    case "Mace":
                        Main.PERSON.putOnWeapon(new Mace(activeWeapon[0],
                                Integer.parseInt(activeWeapon[1])));
                        break;
                    case "Sword":
                        Main.PERSON.putOnWeapon(new Sword(activeWeapon[0],
                                Integer.parseInt(activeWeapon[1])));
                        break;
                }
            }
            if (!activeQuest.equals("null")) {
                Main.PERSON.setActiveQuest(activeQuest);
            }
            if (!questList.equals("null")) {
                Main.PERSON.addToQuestList(questList);
            }
            Main.PERSON.setName(HeroParams[0]);  // name
            Main.PERSON.setHealth(Integer.parseInt(HeroParams[1]));
            Main.PERSON.setArmor(Integer.parseInt(HeroParams[2]));       //Armor
            Main.PERSON.setAttack(Integer.parseInt(HeroParams[3]));
            if (HeroParams[4].equals("true")) {
                Main.PERSON.setMagic(true);
            } else {  ///Magic
                Main.PERSON.setMagic(false);
            }
            Main.PERSON.setResistance(Integer.parseInt(HeroParams[5]));
            Main.PERSON.setMana(Integer.parseInt(HeroParams[6]));
            Main.PERSON.setExperience(Integer.parseInt(HeroParams[7]));

            ///Game params
            MapArea = Integer.parseInt(mapArea);
            MAP = afterLoadMap;
            Main.SAVE_FILE = new File(gameSaveFile);
            Main.IS_AUTO_SAVE = Boolean.parseBoolean(isAutoSaveTheGame);

            ///heroPosition
            Main.HERO_LOCATION = heroPosition;
            br.close();

        } catch (IOException e) {
            e.getStackTrace();
            throw new RuntimeException("Load failed");
        } finally {
            System.out.println("File loaded");
        }
    }


//////////////////Save and Load Category Close///////////////////////////////////////////////////////////////

    /////////////////Map category///////////////////////////////////////////////////////////////////////////////
    private static void createMap(int mapCapacity) {
        ArrayList<Integer> emptyBlock = new ArrayList<>();
        int randint;
        emptyBlock.add(0);  //isNpc
        emptyBlock.add(0);  //isCity
        emptyBlock.add(0);  //isDungeon
        if (mapCapacity < MapArea) {
            System.out.println("Минимальная площадь карты это " + MapArea);
            createMap(new Scanner(System.in).nextInt());
        } else {
            MapArea = mapCapacity;
            ArrayList<Integer> startBlock = new ArrayList<>(4);  /// First block should always be 1,0,0
            startBlock.add(1);
            startBlock.add(0);
            startBlock.add(0);
            MAP.add(startBlock);
            for (int i = 0; i <= (MapArea * MapArea) - 1; i++) {
                ArrayList<Integer> nonEmptyBlock = (ArrayList<Integer>) emptyBlock.clone();
                randint = random.nextInt(0, 150);
//                System.out.println(randint); // отладочная информация

                if (randint > 100 && randint < 150) {
                    nonEmptyBlock.set(0, 1);
                    MAP.add(nonEmptyBlock);
//                    System.out.println(nonEmptyBlock); // отладочная информация

                } else if (randint > 50 && randint < 100) {
                    nonEmptyBlock.set(1, 1);
                    MAP.add(nonEmptyBlock);
//                    System.out.println(nonEmptyBlock); // отладочная информация

                } else if (randint > 0 && randint < 50) {
                    nonEmptyBlock.set(2, 1);
                    MAP.add(nonEmptyBlock);
//                    System.out.println(nonEmptyBlock); // отладочная информация

                } else {
                    MAP.add(emptyBlock);
//                    System.out.println(emptyBlock); // отладочная информация
                }
            }
        }
    }

    private static void viewMapBlocked() {
        char heroSign = 'O';   //местоположение героя относительно других позиций
        int LineFeed = MapArea - 1;  /// 2 5 8 11 14
        int blockIndex = 0;
        char x = 'X';    /// местоположение блока с данными
        for (ArrayList<Integer> block : MAP) {
            if (blockIndex == LineFeed) {
                if (block.size() == 4) {
                    System.out.print(heroSign);
                    System.out.print("\n");
                } else {
                    System.out.print(x);
                    System.out.print("\n");
                    LineFeed += MapArea;
                }
                blockIndex += 1;
            } else {
                if (block.size() == 4) {
                    System.out.print(heroSign);
                    System.out.print(" ");

                } else {
                    System.out.print(x);
                    System.out.print(" ");
                }
                blockIndex += 1;
            }
        }
    }


//    static void viewMapUNBlocked() {
//        int LineFeed = MapArea - 1;  /// 2 5 8 11 14
//        int blockIndex = 0;
//        char x = 'X';    /// местоположение пустого блока с данными
//        char heroSign = 'O';  //местоположение героя относительно других позиций
//        char citySign = '$';   ////isCity
//        char dungSign = '#';  ///isDungeon
//        char npcSign = '?';   ///isNPC
//        for (ArrayList<Integer> block : MAP) {
//            if (blockIndex == LineFeed) {
//                if (block.size() == 4) {
//                    System.out.print(heroSign);
//                    System.out.print("\n");
//                }
//                else if (block.get(0) == 1 && block.size() != 4) {
//                    System.out.print(npcSign);
//                    System.out.print("\n");
//                }
//                else if (block.get(1) == 1) {
//                    System.out.print(citySign);
//                    System.out.print("\n");
//                }
//                else if (block.get(2) == 1) {
//                    System.out.print(dungSign);
//                    System.out.print("\n");
//                } else {
//                    System.out.print(x);
//                    System.out.print("\n");
//                }
//                LineFeed += MapArea;
//                blockIndex += 1;
//
//            } else {
//                if (block.size() == 4) {
//                    System.out.print(heroSign);
//                    System.out.print(" ");
//                } else if (block.get(0) == 1 && block.size() != 4) {  ///isNPC
//                    System.out.print(npcSign);
//                    System.out.print(" ");
//                } else if (block.get(1) == 1) {
//                    System.out.print(citySign);  ///isCity
//                    System.out.print(" ");
//                } else if (block.get(2) == 1) {
//                    System.out.print(dungSign);  ///isDungeon
//                    System.out.print(" ");
//                } else {
//                    System.out.print(x);
//                    System.out.print(" ");
//                }
//                blockIndex += 1;
//            }
//        }
//    }


    static ArrayList<ArrayList<Integer>> getMAP() {
        return MAP;
    }
/////////////////Map category Close///////////////////////////////////////////////////////////////////////////

////////////////OTHER Category//////////////////////////
//    static void getStatistic() {
//        /**
//         * this method provides statistic
//         */
//        System.out.println();
//    }

    private static String _StringInput() {
        String askFor = new Scanner(System.in).nextLine();
        if (askFor.equals("yes") || askFor.equals("no")) {
            return askFor;
        } else {
            System.out.println("Неправильное значение, повторите попытку");
            askFor = _StringInput();
        }
        return askFor;
    }

    private static int _IntegerInput(int maxValue) {
        int askFor;
        try {
            askFor = new Scanner(System.in).nextInt();
            if (askFor <= maxValue && askFor > 0) {
                return askFor;
            } else {
                System.out.println("Неправильное значение, повторите попытку");
                askFor = _IntegerInput(maxValue);
            }
        } catch (InputMismatchException e) {
            System.out.println("Неправильное значение, повторите попытку");
            askFor = _IntegerInput(maxValue);
        }
        return askFor;
    }

    static void TestSave() throws IOException {
        _whatInformationToSave();
    }

    static void TestLoad() {
        _LoadGame();
    }
////////////////OTHER Category//////////////////////////
}