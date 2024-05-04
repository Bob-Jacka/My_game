package ru.kirill.games;

import Dictionary.*;
import Enemies.Enemy;
import Heroes.Ability;
import Heroes.Hero;
import Heroes.Slave;
import Items.Armor.IronArmor;
import Items.Items;
import Items.OtherItems.Food;
import Items.Potions.HealthPotion;
import Items.Weapons.Firearms.Tunning.Muska;
import Items.Weapons.Firearms.Tunning.OpticalScope;
import Items.Weapons.Firearms.Tunning.muzzleBrake;
import Items.Weapons.MeleeCombatWeapon.Sword;
import Locations.City;
import Locations.Dungeon;
import NPC.Dif_NPC;
import NPC.NPC;
import NPC.StartNPC;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static ru.kirill.games.FileSystem.do_Load;
import static ru.kirill.games.FileSystem.do_Save;

/**
 * Класс, представляющий собой множество игровых методов
 */
public abstract class GameEngine {
    /**
     * Параметр, предназначенный для генерации случайного, как целого числа, булевого числа, дробного числа
     */
    private static final Random random = new Random();

    /**
     * Параметр, предназначенный для задания площади карты
     * <p> Стандартное значение переменно это 3, ниже этого значения нельзя
     */
    static int MapWidth = 3;

    /**
     * Параметр, хранящий в себе карту, размер которой квадрат стороной {@link GameEngine#MapWidth}
     */
    static ArrayList<int[]> MAP = new ArrayList<>(MapWidth * MapWidth);

    /**
     * Просто разделитель между строками
     */
    private static final String LineBreaker = "##################################################";


    /////////////////////Generate Category//////////////////////////////////////////////////////////
    private static Items GeneratePotion() {
        return new HealthPotion(RandomPotion.RandomPotionName[random.nextInt(RandomPotion.RandomPotionName.length)], random.nextDouble(), random.nextInt(4), random.nextInt());
    }

    private static Items GenerateWeapon() {
        return new Sword(RandomWeaponName.RandomWeaponName[random.nextInt(RandomWeaponName.RandomWeaponName.length)], random.nextInt(40), random.nextInt(30), random.nextInt(80));
    }

    private static Items GenerateArmor() {
        return new IronArmor(RandomArmorName.ArmorName[random.nextInt(RandomArmorName.ArmorName.length)], random.nextInt());
    }

    private static Slave CreateHero1() {
        System.out.println(UIText.Localized_Text.latinNumbers());
        System.out.print(UIText.Localized_Text.enterHeroName());
        String name_actual = new Scanner(System.in).next();

        System.out.print(UIText.Localized_Text.isHeroMagician());
        boolean magic = _Accept();

        return new Slave(name_actual, magic);
    }

    private static Enemy GenerateEnemy() {
        System.out.println(IMAGES.Images[random.nextInt(1, 3)]);
        return new Enemy(RandomNpcName.NPCname[random.nextInt(RandomNpcName.NPCname.length)], random.nextBoolean());
    }

    private static Items GenerateOtherItems() {
        return new Food(RandomFoodName.RandomFoodName[random.nextInt(RandomFoodName.RandomFoodName.length)], random.nextInt(50), random.nextBoolean());
    }

    private static Items GenerateTuning(int tunningNum) {
        if (tunningNum == 1) {
            return new Muska(random.nextInt(25), "Muska");
        } else if (tunningNum == 2) {
            return new OpticalScope("Callimator", 50);
        } else if (tunningNum == 3) {
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
            case 4:
                return GenerateTuning(1);
            case 5:
                return GenerateTuning(2);
            case 6:
                return GenerateTuning(3);
            case 7:
                return GenerateOtherItems();
        }
        return null;
    }

    private static Items LootGenerator() {
        int generationRate = random.nextInt(260);
        if (generationRate < 30) {
            GeneratePotion();
        } else if (generationRate < 50) {
            GenerateWeapon();
        } else if (generationRate > 50 && generationRate < 70) {
            GenerateArmor();
        } else if (generationRate > 70 && generationRate < 100) {
            GenerateOtherItems();
        } else if (generationRate > 100 && generationRate < 130) {
            GenerateTuning(1);
        } else if (generationRate > 130 && generationRate < 160) {
            GenerateTuning(2);
        } else if (generationRate > 160 && generationRate < 200) {
            GenerateTuning(3);
        }
        return null;
    }

    ////NPC Menu////////////////////////////////////////////////////////////
    private static StartNPC GenerateStartNPC() {
        StartNPC startNPC = new StartNPC(RandomNpcName.NPCname[random.nextInt(RandomNpcName.NPCname.length)]);  ///встреча с нпс
        if (Player.get_Person().getActiveQuest() == null) {
            startNPC.takeQuest(Player.get_Person());
        } else startNPC.setIsQuestTaken(true);
        return startNPC;
    }

    private static Dif_NPC GenerateNpc() {
        return new Dif_NPC(RandomNpcName.NPCname[random.nextInt(RandomNpcName.NPCname.length)],
                Quest.Quests[random.nextInt(1)]);
    }

    private static City GenerateCity() {
        return new City(RandomCityName.RandomCityName[random.nextInt(RandomCityName.RandomCityName.length)], random.nextInt(1, 4));
    }

    private static Dungeon GenerateDungeon() {
        return new Dungeon(RandomDungeonName.RandomDungeonName[random.nextInt(RandomDungeonName.RandomDungeonName.length)]);
    }
/////////////////////Generate Category Close/////////////////////////////////////////////////////////


/////////////////Menu Category////////////////////////////////////////////////////////////////////////

    private static void _quitGame() {
        if (Player.get_IsAutoSave()) {
            SaveTheGame();
        } else if (Player.get_IsAutoSave() == false) {
            System.out.println(UIText.Localized_Text.attention());
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
        System.out.println(LineBreaker);
        System.out.println(UIText.Localized_Text.outingTheGame());
        Main.IS_QUIT_GAME = true;
    }

    private static void _configureOptionsMenu() {
        boolean isClose = false;
        System.out.println(LineBreaker);
        System.out.println(UIText.Localized_Menu._configureGameOptionsMenu());
        System.out.println();
        while (!isClose) {
            switch (_IntegerInput(3)) {
                case 1:
                    // enable auto save
                    if (!Player.get_IsAutoSave()) {
                        System.out.println(UIText.Localized_Text.autoSaveEnabled());
                        Player.set_IsAutoSave(true);
                        isClose = true;
                        break;
                    } else {
                        System.out.println(UIText.Localized_Text.autoSaveEDisabled());
                        Player.set_IsAutoSave(false);
                        isClose = true;
                        break;
                    }
                    // change save file name
                case 2:
                    System.out.println(UIText.Localized_Text.enterNewSaveFName());
                    System.out.print(SaveFile.getSaveDirectory());
                    String newSaveFileName = new Scanner(System.in).nextLine();
                    Player.set_SaveFile(newSaveFileName);
                    isClose = true;
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
    }

    /**
     * This method is built for moving hero
     * Also contains chance of activating battle mode
     */
    private static void movingMenu() {
        boolean isClose = false;
        while (!isClose) {
            System.out.println(LineBreaker);
            System.out.println(UIText.Localized_Menu.movingMenu());
            System.out.println();
            Random rand = new Random();
            int randint = rand.nextInt(1, 100);
            //    System.out.println("вероятность встречи с врагом " + randint); // для отладки удалить позже
            switch (_IntegerInput(6)) {
                case 1:
                    if (randint < 25) {
                        _fight();
                        isClose = true;
                    } else {
                        System.out.println(UIText.Localized_Text.noEnemy());
                    }
                    moving(1);
                    break;
                case 2:
                    if (randint < 8) {
                        _fight();
                        isClose = true;
                    } else {
                        System.out.println(UIText.Localized_Text.noEnemy());
                    }
                    moving(4);
                    break;
                case 3:
                    if (randint < 8) {
                        _fight();
                        isClose = true;
                    } else {
                        System.out.println(UIText.Localized_Text.noEnemy());
                    }
                    moving(2);
                    break;
                case 4:
                    if (randint < 5) {
                        _fight();
                        isClose = true;
                    } else {
                        System.out.println(UIText.Localized_Text.noEnemy());
                    }
                    moving(3);
                    break;
                case 5:
                    viewMapBlocked();
                    break;
                case 6:
                    isClose = true;
                    break;
            }
        }
    }

    private static void moving(int direction) {
        switch (direction) {
            case 1:  //forward
                if (Player.get_HeroLocation() + 1 >= MAP.size()) {
                    System.out.println(UIText.Localized_Text.mapBorder());
                } else {
                    System.out.println(Player.get_Person().getName() + UIText.Localized_Text.mForward());
                    _changeHeroCoordinates(1);
                }
                break;
            case 2:  //left
                if (Player.get_HeroLocation() + (-MapWidth) <= 0) {
                    System.out.println(UIText.Localized_Text.mapBorder());
                } else {
                    System.out.println(Player.get_Person().getName() + UIText.Localized_Text.mLeft());
                    _changeHeroCoordinates(-MapWidth);
                }
                break;
            case 3:  //right
                if (Player.get_HeroLocation() + MapWidth >= MAP.size()) {
                    System.out.println(UIText.Localized_Text.mapBorder());
                } else {
                    System.out.println(Player.get_Person().getName() + UIText.Localized_Text.mRight());
                    _changeHeroCoordinates(MapWidth);
                }
                break;
            case 4:  //backward
                if (Player.get_HeroLocation() + 1 <= MAP.size()) {
                    System.out.println(UIText.Localized_Text.mapBorder());
                } else {
                    System.out.println(Player.get_Person().getName() + UIText.Localized_Text.mBackward());
                    _changeHeroCoordinates(-1);
                }
                break;
        }
    }

    /**
     * Метод изменяет позицию героя. В случае достижения границы карты перемещение не будет совершено
     *
     * @param howManyPointsToGo параметр, показывающий на сколько клеток будет перемещён герой
     * @throws ArrayIndexOutOfBoundsException в случае если файл сохранения повреждён и позиция героя не
     *                                        соответствует действительности
     * @since 0.1.1
     */
    private static void _changeHeroCoordinates(int howManyPointsToGo) {
        try {
            MAP.get(Player.get_HeroLocation())[3] = 0;  /// берём текущий массив в котором герой и убираем его
            Player.set_HeroLocation((short) (Player.get_HeroLocation() + howManyPointsToGo));  /// двигаем позицию
            MAP.get(Player.get_HeroLocation())[3] = 1;  //берём следующий массив и ставим героя
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getStackTrace();
            System.out.println("Save file is wrong");
            if (Player.get_IsAutoSave()) {
                System.out.println("Emergency saving");
                SaveTheGame();
            }
            System.exit(1);
        }
    }

    private static void getActionMenu() {
        if (MAP.get(Player.get_HeroLocation())[0] == 1 && Player.get_HeroLocation() != 0) {
            Dif_NPC npc = GenerateNpc();
            npcMenu(npc);
        } else if (Player.get_HeroLocation() == 0) {
            StartNPC startNPC = GenerateStartNPC();
            npcMenu(startNPC);
        } else if ((MAP.get(Player.get_HeroLocation())[1] == 1)) {
            City city = GenerateCity();
            cityMenu(city);
        } else if ((MAP.get(Player.get_HeroLocation())[2] == 1)) {
            Dungeon dungeon = GenerateDungeon();
            dungeonMenu(dungeon);
        }
    }

    private static void npcMenu(NPC npc) {
        System.out.println(LineBreaker);
        System.out.println(UIText.Localized_Menu.npcMenu());
        boolean isClose = false;
        while (!isClose) {
            switch (_IntegerInput(4)) {
                case 1:
                    npc.talk();
                    isClose = true;
                    break;
                case 2:
                    npc.takeQuest(Player.get_Person());
                    isClose = true;
                    break;
//                case 3:
//                    npc.passT(Player.get_Person());
//                    isClose = true;
//                    break;
                case 4:
                    isClose = true;
                    break;
            }
        }
    }

    private static void cityMenu(City city) {
        System.out.println(LineBreaker);
        System.out.println(UIText.Localized_Menu.cityMenu());
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
                case 4:
                    isClose = true;
                    break;
            }
        }
    }

    private static void dungeonMenu(Dungeon dungeon) {
        System.out.println(LineBreaker);
        System.out.println(UIText.Localized_Menu.dungeonMenu());
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
            System.out.println(LineBreaker);
            System.out.println(UIText.Localized_Menu.paramsMenu());
            switch (_IntegerInput(4)) {
                case 1:
                    System.out.println(LineBreaker);
                    person.getParams();
                    break;
                case 2:
                    if (person.getActiveWeapon().isEmpty()) {
                        System.out.println(UIText.Localized_Text.noActWeapon());
                    } else {
                        System.out.println(LineBreaker);
                        person.getActiveWeapon().get(0).getParams();
                    }
                    break;
                case 3:
                    if (person.getActiveArmor().isEmpty()) {
                        System.out.println(UIText.Localized_Text.noActArmor());
                    } else {
                        System.out.println(LineBreaker);
                        person.getActiveArmor().get(0).getParams();
                    }
                    break;
                case 4:
                    isClose = true;
                    break;
            }
        }
    }

    private static void heroMenu() {
        boolean isClose = false;
        while (!isClose) {
            System.out.println(LineBreaker);
            System.out.println(UIText.Localized_Menu.heroMenu());
            switch (_IntegerInput(4)) {
                case 1:
                    paramsMenu(Player.get_Person());
                    isClose = true;
                    break;
                case 2:
                    abilityMenu();
                    isClose = true;
                    break;
                case 3:
                    questMenu();
                    isClose = true;
                    break;
                case 4:
                    isClose = true;
                    break;
            }
        }
    }

    private static void abilityMenu() {
        boolean isClose = false;
        while (!isClose) {
            System.out.println(LineBreaker);
            System.out.println(UIText.Localized_Menu.abilityMenu());
            switch (_IntegerInput(3)) {
                case 1:
                    seeAbilities();
                    isClose = true;
                    break;
                case 2:
                    if (Player.get_Person().getExperience() >= 1000) {
                        //TODO сделать повышение уровня
                    } else {
                        viewExperienceBar();
                        System.out.println(UIText.Localized_Text.notEnoughExp());
                    }
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
            System.out.println(LineBreaker);
            System.out.println(UIText.Localized_Menu.questMenu());
            switch (_IntegerInput(3)) {
                case 1:
                    System.out.println(Player.get_Person().getActiveQuest());
                    isClose = true;
                    break;
                case 2:
                    Player.get_Person().getQuestsList();
                    isClose = true;
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
    }

    private static void saveAndLoadMenu() {
        boolean isClose = false;
        while (!isClose) {
            System.out.println(LineBreaker);
            System.out.println(UIText.Localized_Menu.saveAndLoadMenu());
            switch (_IntegerInput(3)) {
                case 1:
                    SaveTheGame();
                    isClose = true;
                    break;
                case 2:
                    loadMenu();
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
    }

    private static void loadMenu() {
        boolean isClose = false;
        while (!isClose) {
            System.out.println(LineBreaker);
            System.out.println(UIText.Localized_Menu.loadMenu());
            System.out.println();
            switch (_IntegerInput(3)) {
                case 1:
                    System.out.println(Arrays.toString(Player.get_SaveFileDirectory()));
                    isClose = true;
                    break;
                case 2:
                    LoadFilesMenu();
                    isClose = true;
                    break;
                case 3:
                    isClose = true;
                    break;
            }
        }
    }

    /**
     * Метод загрузки файлов сохранения
     * Принцип действия: Смотрит в деректорию с сохранёнными файлами и построчно выводит их на экран
     *
     * @since 0.2.0
     */
    private static void LoadFilesMenu() {
        if (Player.get_SaveFileDirectory().length != 0) {
            final Map<Integer, File> ftl = new HashMap<>(5);
            int index = 1;
            System.out.println(LineBreaker);
            for (File file : Player.get_SaveFileDirectory()) {
                System.out.println(index + ". " + String.valueOf(file).substring(SaveFile.getSaveDirectoryLength()));
                ftl.put(index, file);
                index++;
            }
            System.out.print("HINT: just type number of the file to load ");
            do_Load(ftl.get(_IntegerInput(index)));
        } else {
            System.out.println("Файлов сохранения нет");
        }
    }

    private static void inventoryMenu() {
        boolean isClose = false;
        while (!isClose) {
            System.out.println(LineBreaker);
            System.out.println(UIText.Localized_Menu.inventoryMenu());
            System.out.println();
            switch (_IntegerInput(6)) {
                case 1:
                    Player.get_Person().inventoryCall();
                    break;
//                case 2:
//                    Player.get_Person().putOnArmor();
//                    break;
//                case 3:
//                    Player.get_Person().putOnWeapon();
//                    break;
//                case 4:
//                    Player.get_Person().takeOffArmor();
//                    break;
//                case 5:
//                    Player.get_Person().takeOffWeapon();
//                    break;
                case 6:
                    isClose = true;
                    break;
            }
        }
    }

    /**
     * Метод представляющий из себя стартовый лаунчер игры
     * Принимает Файл сохранения и если файл не пустой предлагает его загрузить
     * Если же файл сохранения не существует или файл пустой, то предлагает создать новую игру
     *
     * @since 0.1.0
     */
    static void gameLauncherMenu() {
        System.out.println(IMAGES.Images[0]);
        System.out.println(LineBreaker);
        if (Player.get_SaveFileDirectory().length != 0 ||
                Player.get_SaveFile().exists() && Player.get_SaveFile().length() != 0L) {
            SaveFileExists();
        } else SaveFileNotExists();
    }

    private static void SaveFileExists() {
        boolean LauncherClose = false;
        while (!LauncherClose) {
            System.out.println(UIText.Localized_Menu.SaveFileExist());
            switch (_IntegerInput(4)) {
                case 1:
                    LoadFilesMenu();
                    LauncherClose = true;
                    break;
                case 2:
                    System.out.println("New game");
                    System.out.print("Want to create hero - ");
                    boolean askForCreateHero = _Accept();
                    if (askForCreateHero) {
                        pre_start_creation();
                        LauncherClose = true;
                    } else {
                        System.exit(0);
                    }
                    break;
                case 3:
                    _configureOptionsMenu();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void SaveFileNotExists() {
        boolean LauncherClose = false;
        while (!LauncherClose) {
            System.out.println(UIText.Localized_Menu.SaveFileNotExist());
            switch (_IntegerInput(3)) {
                case 1:
                    System.out.println("New game");
                    System.out.print("Want to create hero - ");
                    boolean askForCreateHero = _Accept();
                    if (askForCreateHero) {
                        pre_start_creation();
                        LauncherClose = true;
                    } else {
                        System.exit(0);
                    }
                    break;
                case 2:
                    _configureOptionsMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    /**
     * <p> Метод, который в зависимости от флага №4, распечатывает два меню
     * <p> Если флаг равен false - то меню будет без пункта с actionMenu
     * <p> Если флаг равен true - то меню будет с пунктом actionMenu
     */
    static void mainMenu() {
        Player.set_Flag(4, MAP.get(Player.get_HeroLocation())[0] == 1
                || MAP.get(Player.get_HeroLocation())[1] == 1
                || MAP.get(Player.get_HeroLocation())[2] == 1);  // Проверяем есть ли доп активность
        System.out.println(LineBreaker);
        System.out.println(UIText.Localized_Menu.MainGameMenu1());
        if (Player.get_Flag(4)) {
            System.out.println(UIText.Localized_Menu.MainGameMenu2());
        }
        switch (_IntegerInput(7)) {
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
                saveAndLoadMenu();
                break;
            case 5:
                _configureOptionsMenu();
                break;
            case 6:
                _quitGame();
                break;
            case 7:
                if (Player.get_Flag(4)) {
                    getActionMenu();
                } else {
                    System.out.println(UIText.Localized_Text.incorrectValue());
                }
                break;
        }
    }
//////////////////Menu Category Close///////////////////////////////////////////////////////

    //////////////////Fight Category//////////////////////////////////////////////////////////////
    private static void _fight() {
        Enemy enemy = GenerateEnemy();
        int enemyHealth = enemy.getHealth();
        Player.set_Flag(0, true); ///enter fight mode
        System.out.println(UIText.Localized_Text.battleMode());
        final boolean attackEnemyBoolean = attackEnemy(Player.get_Person(), enemy); //сама битва
        while (Player.get_Flag(0)) {
            if (attackEnemyBoolean) {  //true - win, false - lose
                System.out.println(UIText.Localized_Text.won());
                Items loot = LootGenerator();
                Player.get_Person().setExperience(Player.get_Person().getExperience() + enemyHealth / 2); ///начисление опыта
                System.out.println(UIText.Localized_Text.expIs() + Player.get_Person().getExperience());
                if (loot != null) {
                    System.out.println(UIText.Localized_Text.somethingInteresting());
                    Player.get_Person().inventoryPut(loot);
                } else {
                    System.out.println(UIText.Localized_Text.notInteresting());
                }
            } else {
                System.out.println(UIText.Localized_Text.youLose());
            }
            Player.set_Flag(0, false);
        }
    }

    private static boolean attackEnemy(Hero valera, Enemy enemy) {
        boolean result = false;
        System.out.println(UIText.Localized_Text.attackEnemy());
        boolean questionAttack = _Accept();
        if (questionAttack) { //Хотите атаковать?

            enemy.setHealth(((enemy.getHealth() + enemy.getResistance())) + (enemy.getArmor() % 2));
            valera.setHealth(((valera.getHealth() + valera.getResistance())) + (valera.getArmor() % 2));

            System.out.println(UIText.Localized_Text.autoAttackEnemy());

            final boolean askForAutoAttack = _Accept();
            if (askForAutoAttack) {
                result = _autoFight(valera, enemy);   ////fight

            } else if (askForAutoAttack == false) {
                result = _manualFight(valera, enemy);  ///fight
            }
        } else {
            valera.setHealth((int) (valera.getHealth() * 0.5));
            Player.set_Flag(0, false);
            return false;
        }
        if ((valera.getHealth() - valera.getResistance()) <= 0) {
            valera.setHealth(10);
        } else if ((valera.getHealth() - valera.getResistance()) > 10) {
            valera.setHealth(((valera.getHealth() - valera.getResistance())));
        }
        return result;
    }

    /**
     * Метод представляет из себя ветку авто битвы
     *
     * @return Значение окончания битвы
     * @since 0.1.1
     */
    private static boolean _autoFight(Hero valera, Enemy enemy) {
        while (enemy.getHealth() >= 0) {
            enemy.setHealth(enemy.getHealth() - valera.getAttack());
            System.out.println(UIText.Localized_Text.enemyHealth() + enemy.getHealth());  // отладачная информация
            valera.setHealth(valera.getHealth() - enemy.getAttack());
            System.out.println(UIText.Localized_Text.heroHealth() + valera.getHealth());  // отладачная информация
            if (enemy.getHealth() <= 0) {
                enemy.dead();

                if (Player.get_IsAutoSave()) {
                    SaveTheGame();
                }
                return true;

            } else if (valera.getHealth() <= 0) {
//                if (valera.get) {
//
//                }
                valera.dead();
                //TODO когда будут готовы камни воскрешения переписать этот фрагмент
                System.out.println(UIText.Localized_Text.youLose());
                _quitGame(); // outing the game if dead
            }
        }
        return false;
    }

    /**
     * Метод представляет из себя ветку пошаговой битвы
     *
     * @return Значение окончания битвы
     * @since 0.1.1
     */
    private static boolean _manualFight(Hero valera, Enemy enemy) {
        System.out.println(UIText.Localized_Text.enemyHealth() + enemy.getHealth());
        boolean isFightOver = false;
        while (!isFightOver) {
            System.out.println(UIText.Localized_Menu._manualFight());
            switch (_IntegerInput(3)) {
                case 1: {
                    enemy.setHealth(enemy.getHealth() - valera.getAttack());
                    System.out.println(UIText.Localized_Text.enemyHealth() + enemy.getHealth());  // отладачная информация
                    valera.setHealth(valera.getHealth() - enemy.getAttack());
                    System.out.println(UIText.Localized_Text.heroHealth() + valera.getHealth());  // отладачная информация
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.println(UIText.Localized_Text.openingInventory());
                    valera.inventoryCall();
                    System.out.println();
                    break;
                }
                case 3: {
                    if (Player.get_Person().getMagic()) {
                        getAbilityAndInvokeIt();
                    } else System.out.println(UIText.Localized_Text.cantUseMagic());
                    break;
                }
            }

            if (enemy.getHealth() <= 0) {
                enemy.dead();
                isFightOver = true;
                if (Player.get_IsAutoSave()) {
                    SaveTheGame();
                }
            } else if (valera.getHealth() == 0) {
                valera.dead();
                isFightOver = true;
                //TODO когда будут готовы камни воскрешения переписать этот фрагмент
                _quitGame(); // outing the game if dead
            }
        }
        return true;
    }

//////////////////Fight Category Close///////////////////////////////////////////////////////////////

/////////////////Save and load Category///////////////////////////////////////////////////////////////

    private static void _deleteWrittenSaveFile() {
        try {
            Player.get_SaveFile().delete();
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("There are problems on deleting data");
        }
    }

    private static void SaveTheGame() {
        boolean askForSave = _Accept();
        if (askForSave) {
            if (Player.get_SaveFile() != null && Player.get_SaveFile().length() != 0L) {
                System.out.println(UIText.Localized_Text.rewritingSaveF());
                _deleteWrittenSaveFile();
                do_Save();
            } else if (Player.get_SaveFile() == null) {
                Player.set_SaveFile("standardSaveFileName");
                do_Save();
            } else System.out.println("There are problems with saving");
        } else if (askForSave == false) {
            System.out.println("Cancel saving");
        }
    }


    /////////////////Map category///////////////////////////////////////////////////////////////////////////////

    /**
     * <p>Метод создаёт карту площадью mapCapacity на основании рандома
     * <p> Минимальная площадь карты указана в MapArea
     *
     * @param mapCapacity Площадь карты
     * @since 0.1.0
     */
    private static void do_createMap(int mapCapacity) {
        int[] emptyBlock = new int[]{0, 0, 0, 0};  //isNpc  //isCity   //isDungeon   //isPerson
        int randint;

        if (mapCapacity < MapWidth) {
            System.out.println(UIText.Localized_Text.minimumMapSize() + MapWidth);
            do_createMap(new Scanner(System.in).nextInt());
        } else {
            MapWidth = mapCapacity;
            final int[] startBlock = new int[]{1, 0, 0, 0};  /// First block should always be 1,0,0,0
            MAP.add(startBlock);
            for (int i = 0; i <= (MapWidth * MapWidth) - 1; i++) {
                int[] nonEmptyBlock = emptyBlock.clone();
                randint = random.nextInt(0, 300);
//                System.out.println(randint); // отладочная информация

                if (randint > 100 && randint < 150) {
                    nonEmptyBlock[0] = 1;
                    MAP.add(nonEmptyBlock);
//                    System.out.println(nonEmptyBlock); // отладочная информация

                } else if (randint > 50 && randint < 100) {
                    nonEmptyBlock[1] = 1;
                    MAP.add(nonEmptyBlock);
//                    System.out.println(nonEmptyBlock); // отладочная информация

                } else if (randint > 0 && randint < 50) {
                    nonEmptyBlock[2] = 1;
                    MAP.add(nonEmptyBlock);
//                    System.out.println(nonEmptyBlock); // отладочная информация

                } else {
                    MAP.add(emptyBlock);
//                    System.out.println(emptyBlock); // отладочная информация
                }
            }
        }
    }

    /**
     * Метод предоставляет интерфейс просмотра карты без знаков нпс или города
     */
    private static void viewMapBlocked() {
        final char heroSign = 'O';   //местоположение героя относительно других позиций
        final char unknownBlock = 'X';    /// местоположение блока с данными
        int LineFeed = MapWidth - 1;  /// 2 5 8 11 14
        int blockIndex = 0;
        for (int[] block : MAP) {
            if (blockIndex == LineFeed) {
                if (block[3] == 1) {
                    System.out.print(heroSign);
                    System.out.print("\n");
                } else {
                    System.out.print(unknownBlock);
                    System.out.print("\n");
                    LineFeed += MapWidth;
                }
                blockIndex++;
            } else {
                if (block[3] == 1) {
                    System.out.print(heroSign);
                    System.out.print(" ");

                } else {
                    System.out.print(unknownBlock);
                    System.out.print(" ");
                }
                blockIndex++;
            }
        }
    }

    /**
     * Метод предоставляет интерфейс просмотра карты со знаками нпс или городами
     */
//    static void viewMapUNBlocked() {
//        int LineFeed = MapArea - 1;  /// 2 5 8 11 14
//        int blockIndex = 0;
//        char x = 'X';    /// местоположение пустого блока с данными
//        char heroSign = 'O';  //местоположение героя относительно других позиций
//        char citySign = '$';   ////isCity
//        char dungSign = '#';  ///isDungeon
//        char npcSign = '?';   ///isNPC
//        for (int[] block : MAP) {
//            if (blockIndex == LineFeed) {
//                if (block.length == 4) {
//                    System.out.print(heroSign);
//                    System.out.print("\n");
//                }
//                else if (block[0] == 1 && block.length != 4) {
//                    System.out.print(npcSign);
//                    System.out.print("\n");
//                }
//                else if (block[1] == 1) {
//                    System.out.print(citySign);
//                    System.out.print("\n");
//                }
//                else if (block[2] == 1) {
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
//                if (block.length == 4) {
//                    System.out.print(heroSign);
//                    System.out.print(" ");
//                } else if (block[0] == 1 && block.length != 4) {  ///isNPC
//                    System.out.print(npcSign);
//                    System.out.print(" ");
//                } else if (block[1] == 1) {
//                    System.out.print(citySign);  ///isCity
//                    System.out.print(" ");
//                } else if (block[2] == 1) {
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
/////////////////Map category Close///////////////////////////////////////////////////////////////////////////

////////////////OTHER Category//////////////////////////

    /**
     * Метод предоставляет интерфейс ввода двух строк yes/no
     *
     * @return Строка, которая равна yes/no
     * @since 0.1.2
     */
    private static String _StringInput() {
        String askFor = new Scanner(System.in).nextLine();
        if (askFor.equals("yes") || askFor.equals("no")) {
            return askFor;
        } else {
            System.out.println(UIText.Localized_Text.incorrectValue());
            askFor = _StringInput();
        }
        return askFor;
    }

    /**
     * Метод предоставляет интерфейс ввода чисел не больше, чем maxValue
     *
     * @param maxValue параметр максимально возможного числа для ввода
     * @return Число не больше, чем maxValue
     * @since 0.1.2
     */
    private static int _IntegerInput(int maxValue) {
        int askFor;
        try {
            askFor = new Scanner(System.in).nextInt();
            if (askFor <= maxValue && askFor >= 1) {
                return askFor;
            } else {
                System.out.println(UIText.Localized_Text.incorrectValue());
                askFor = _IntegerInput(maxValue);
            }
        } catch (InputMismatchException e) {
            System.out.println(UIText.Localized_Text.incorrectValue());
            askFor = _IntegerInput(maxValue);
        }
        return askFor;
    }

    private static void viewExperienceBar() {
        final StringBuilder sb = new StringBuilder(Player.get_Person().getExperience() + " |");
        int experience = Player.get_Person().getExperience();
        for (int i = 0; i < 10; i++) {
            experience = experience - 100;
            if (experience >= 0) {
                sb.append('X');  // прогресс достигнут
            } else {
                sb.append('-');  // прогресс не достигнут
            }
        }
        sb.append("|");
        System.out.println(sb);
    }

    /**
     * Метод, предназначенный для стартового создания героя, карты и задания стартовой позиции
     */
    private static void pre_start_creation() {
        Player.set_Person(CreateHero1());  //создание героя
        System.out.print(UIText.Localized_Text.inputMapWidth());    /// создание карты
        do_createMap(new Scanner(System.in).nextInt());
        Player.set_HeroLocation((short) 0);
        MAP.get(0)[3] = 1;  //Задание стартовой позиции героя
        if (Player.get_Person() != null) {
            GenerateStartNPC();
        }
    }

    static boolean _Accept() {
        System.out.println(LineBreaker);
        System.out.print(UIText.Localized_Text.yourChoice());
        return _StringInput().equals("yes");
    }

    private static void getAbilityAndInvokeIt() {
        final Method[] methods = Player.get_Person().getClass().getMethods();
        final Map<Integer, Method> abilityMap = new HashMap<>(6);
        int index = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Ability.class)) {
                index++;
                abilityMap.put(index, method);
                System.out.println(index + ". " + method.getName());
            }
        }
        try {
            System.out.println(UIText.isRussian ? UIText.hint_ru : UIText.hint_en);
            abilityMap.get(_IntegerInput(index)).invoke(Player.get_Person());
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println("Problems in invoking methods");
        }
    }

    private static void seeAbilities() {
        final Method[] abilities = Player.get_Person().getClass().getMethods();
        int index = 0;
        for (Method method : abilities) {
            if (method.isAnnotationPresent(Ability.class)) {
                index++;
                System.out.println(index + ". " + method.getName());
            }
        }
        System.out.println(LineBreaker);
    }

    public static void TestSave() {
        do_Save();
    }

    public static void TestLoad() {
        do_Load(Player.get_SaveFile());
    }
////////////////OTHER Category//////////////////////////
}