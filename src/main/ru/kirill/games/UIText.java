package ru.kirill.games;

import java.util.Locale;
import java.util.Map;

abstract class UIText {

    private static final Map<Integer, String> UITexts = getTextTable();

    /**
     * Идентификатор меню:
     * 9001 / 9002 стартовое меню
     * 1001 корень меню
     * 110 Суб меню
     * 111 вложенное суб меню
     */
    private static final Map<Integer, String> UIMenu = getMenuTable();
    static final String hint_en = "HINT: just type number of the clause";
    static final String hint_ru = "ПОДСКАЗКА: введите номер пункта";
    static final boolean isRussian = Locale.getDefault().getDisplayLanguage().equals("Russian");


    static final class Localized_Text {

        static String latinNumbers() {
            return UITexts.get(1);
        }

        static String enterHeroName() {
            return UITexts.get(2);
        }

        static String isHeroMagician() {
            return UITexts.get(3);
        }

        static String attention() {
            return UITexts.get(4);
        }

        static String outingTheGame() {
            return UITexts.get(6);
        }

        static String yourChoice() {
            return UITexts.get(7);
        }

        static String autoSaveEnabled() {
            return UITexts.get(8);
        }

        static String autoSaveEDisabled() {
            return UITexts.get(9);
        }

        static String enterNewSaveFName() {
            return UITexts.get(10);
        }

        static String inputMapWidth() {
            return UITexts.get(11);
        }

        static String noEnemy() {
            return UITexts.get(12);
        }

        static String mapBorder() {
            return UITexts.get(13);
        }

        static String mForward() {
            return UITexts.get(14);
        }

        static String mLeft() {
            return UITexts.get(15);
        }

        static String mRight() {
            return UITexts.get(16);
        }

        static String mBackward() {
            return UITexts.get(17);
        }

        static String noActWeapon() {
            return UITexts.get(18);
        }

        static String noActArmor() {
            return UITexts.get(19);
        }

        static String notEnoughExp() {
            return UITexts.get(20);
        }

        static String incorrectValue() {
            return UITexts.get(21);
        }

        static String minimumMapSize() {
            return UITexts.get(22);
        }

        static String rewritingSaveF() {
            return UITexts.get(23);
        }

        static String enemyHealth() {
            return UITexts.get(24);
        }

        static String heroHealth() {
            return UITexts.get(25);
        }

        static String openingInventory() {
            return UITexts.get(26);
        }

        static String cantUseMagic() {
            return UITexts.get(27);
        }

        static String youLose() {
            return UITexts.get(28);
        }

        static String attackEnemy() {
            return UITexts.get(29);
        }

        static String autoAttackEnemy() {
            return UITexts.get(30);
        }

        static String won() {
            return UITexts.get(31);
        }

        static String expIs() {
            return UITexts.get(32);
        }

        static String somethingInteresting() {
            return UITexts.get(33);
        }

        static String notInteresting() {
            return UITexts.get(34);
        }

        static String battleMode() {
            return UITexts.get(35);
        }
    }

    private static Map<Integer, String> getTextTable() {
        if (isRussian) {
            textTable_Ru();
        } else {
            textTable_En();
        }
        return UITexts;
    }

    private static void textTable_En() {
        UITexts.put(1, "Only latin letters and no numbers allowed");
        UITexts.put(2, "Enter your hero name: ");
        UITexts.put(3, "Is your hero a magician (yes/no): ");
        UITexts.put(4, """
                Attention, the game option auto save is disabled
                The game will not be saved""");
        UITexts.put(6, "Outing the game");
        UITexts.put(7, "Your choice? (yes/no) - ");
        UITexts.put(8, "Auto save enabled");
        UITexts.put(9, "Auto save disabled");
        UITexts.put(10, "Enter new save File name");
        UITexts.put(11, "Input map width ");
        UITexts.put(12, "You're lucky, there is no enemy ");
        UITexts.put(13, "You have reached the border of the map");
        UITexts.put(14, " moving forward");
        UITexts.put(15, " moving left");
        UITexts.put(16, " moving right");
        UITexts.put(17, " moving backward");
        UITexts.put(18, "There is no active weapon");
        UITexts.put(19, "There is no active armor");
        UITexts.put(20, "You do not have enough experience");
        UITexts.put(21, "Incorrect value, please try again");
        UITexts.put(22, "Minimum map size is ");
        UITexts.put(23, "Rewriting save file");
        UITexts.put(24, "Enemy has heath ");
        UITexts.put(25, "Hero has heath ");
        UITexts.put(26, "Opening inventory");
        UITexts.put(27, "You can not use magic");
        UITexts.put(28, "The game is out, you lose");
        UITexts.put(29, "Do you want to attack enemy?");
        UITexts.put(30, "Do you want to Auto attack enemy?");
        UITexts.put(31, "You're won!");
        UITexts.put(32, "Your experience is ");
        UITexts.put(33, "You find something interesting");
        UITexts.put(34, "There are nothing interesting");
        UITexts.put(35, "You're currently in Battle mode");
    }

    private static void textTable_Ru() {
        UITexts.put(1, "Разрешены только латинские буквы");
        UITexts.put(2, "Введите имя героя:");
        UITexts.put(3, "Ваш герой магик? (yes/no): ");
        UITexts.put(4, """
                Внимание, авто сохранение игры выключено
                Игра не будет сохранена""");
        UITexts.put(6, "Выход из игры");
        UITexts.put(7, "Ваше решение? (yes/no) - ");
        UITexts.put(8, "Авто сохранение включено");
        UITexts.put(9, "Авто сохранение выключено");
        UITexts.put(10, "Введите имя нового файла сохранения");
        UITexts.put(11, "Укажите величину карты ");
        UITexts.put(12, "Вы счастливчик, здесь нет врагов ");
        UITexts.put(13, "Вы достигли конца карты");
        UITexts.put(14, " двигается вперёд");
        UITexts.put(15, " двигается влево");
        UITexts.put(16, " двигается вправо");
        UITexts.put(17, " двигается назад");
        UITexts.put(18, "Активного оружия нет");
        UITexts.put(19, "Активной брони нет");
        UITexts.put(20, "Вам не хватает опыта для повышения");
        UITexts.put(21, "Неправильное значение, повторите попытку");
        UITexts.put(22, "Минимальная площадь карты это ");
        UITexts.put(23, "Перезапись сохранённого файла");
        UITexts.put(24, "Здоровье противника ");
        UITexts.put(25, "Здоровье героя ");
        UITexts.put(26, "Открытие инвентаря");
        UITexts.put(27, "Вы не можете использовать магию");
        UITexts.put(28, "Игра окончена, вы проиграли");
        UITexts.put(29, "Вы хотите атаковать противника?");
        UITexts.put(30, "Вы хотите использовать авто атаку?");
        UITexts.put(31, "Вы выиграли!");
        UITexts.put(32, "Ваш опыт ");
        UITexts.put(33, "Вы нашли что-то интересное");
        UITexts.put(34, "Здесь нет ничего интересного");
        UITexts.put(35, "Вы находитесь в режиме битвы");
    }


    /////////////////////////////MENU TABLES
    static final class Localized_Menu {

        static String SaveFileExist() {
            return UIMenu.get(9001);
        }

        static String SaveFileNotExist() {
            return UIMenu.get(9002);
        }

        static String MainGameMenu1() {
            return UIMenu.get(1001);
        }

        static String MainGameMenu2() {
            return UIMenu.get(1002);
        }

        static String movingMenu() {
            return UIMenu.get(110);
        }

        static String heroMenu() {
            return UIMenu.get(120);
        }

        static String paramsMenu() {
            return UIMenu.get(121);
        }

        static String abilityMenu() {
            return UIMenu.get(122);
        }

        static String questMenu() {
            return UIMenu.get(123);
        }

        static String inventoryMenu() {
            return UIMenu.get(130);
        }

        static String saveAndLoadMenu() {
            return UIMenu.get(140);
        }

        static String loadMenu() {
            return UIMenu.get(141);
        }

        static String _configureGameOptionsMenu() {
            return UIMenu.get(150);
        }

        static String getActionMenu() {
            return UIMenu.get(160);
        }

        static String npcMenu() {
            return UIMenu.get(161);
        }

        static String cityMenu() {
            return UIMenu.get(162);
        }

        static String dungeonMenu() {
            return UIMenu.get(163);
        }

        static String _manualFight() {
            return UIMenu.get(170);
        }
    }

    private static Map<Integer, String> getMenuTable() {
        if (isRussian) {
            menuTable_Ru();
        } else {
            menuTable_En();
        }
        return UIMenu;
    }

    private static void menuTable_Ru() {
        UIMenu.put(150, """
                Что вы можете делать
                1. Изменить параметр автосохранения
                2. Change save path
                3. Выйти из меню
                """ + hint_ru);

        UIMenu.put(110, """
                Какое направление вам необходимо?
                1. Двигаться вперёд
                2. Двигаться налево
                3. Двигаться направо
                4. Двигаться назад
                5. Открыть карту
                                    
                6. Выйти из меню
                """ + hint_ru);

        UIMenu.put(161, """
                NPC меню
                1. Поговорить
                2. Взять задание
                3. Выполнить задание
                4. Выйти из меню
                """ + hint_ru);

        UIMenu.put(162, """
                Меню локаций
                1. Зайти в город
                2. Выйти из города
                3. Открыть карту
                4. Выйти из меню
                """ + hint_ru);

        UIMenu.put(163, """
                Меню подземелий
                1. Войти в подземелие
                2. Выйти из подземелия
                3. Выйти из меню
                """ + hint_ru);

        UIMenu.put(121, """
                1. Параметры героя
                2. Параметры оружия
                3. Параметры брони
                4. Выйти из меню
                """ + hint_ru);

        UIMenu.put(120, """
                Действия с героем
                1. Посмотреть параметры
                2. Способности
                3. Меню заданий
                4. Выйти из меню
                """ + hint_ru);

        UIMenu.put(122, """
                Действия героя
                1. Посмотреть способности
                2. Повышение уровня
                3. Выйти из меню
                """ + hint_ru);

        UIMenu.put(123, """
                Действия с заданиями
                1. Get active quest
                2. Get quest list
                3. Exit menu
                """ + hint_ru);

        UIMenu.put(140, """
                Вам необходимо сохранение или загрузка
                1. Сохранить игру
                2. Меню загрузки
                3. Выйти
                """ + hint_ru);

        UIMenu.put(141, """
                Меню загрузки
                1. Посмотреть файлы сохранения
                2. Загрузить игру
                3. Выйти из меню
                """ + hint_ru);

        UIMenu.put(130, """
                Меню инвентаря
                1. Открыть инвентарь
                2. Надеть броню
                3. Надеть оружие
                4. Снять броню
                5. Снять оружие
                6. Выйти из меню
                """ + hint_ru);

        UIMenu.put(9001, """
                Добро пожаловать в игру
                1. Продолжить игру
                2. Новая игра
                3. Настройки
                4. Выход
                """ + hint_ru);

        UIMenu.put(9002, """
                Добро пожаловать в игру
                1. Новая игра
                2. Настройки
                3. Выход
                """ + hint_ru);

        UIMenu.put(1001, """
                Что вы можете делать
                1. Перемещение
                2. Меню героя
                3. Инвентарь
                4. Сохранить или загрузить игру
                5. Настройки
                                    
                6. Выйти из игры""");

        UIMenu.put(1002, """
                 7. Меню действий
                """ + hint_ru);

        UIMenu.put(170, """
                Меню боя
                1. Обычная атака
                2. Открыть инвентарь
                3. Использовать способность
                """ + hint_ru);
    }

    private static void menuTable_En() {
        UIMenu.put(150, """
                What you can do
                1. Change auto save parameter
                2. Change save path
                3. Exit menu
                """ + hint_en);
        UIMenu.put(110, """
                 What direction you need?
                 1. Move forward
                 2. Move left
                 3. Move right
                 4. Move backward
                 5. Open map
                                     
                 6. Exit menu
                """ + hint_en);
        UIMenu.put(161, """
                NPC menu
                1. Talk
                2. Take quest
                3. Pass quest
                4. Exit menu
                """ + hint_en);
        UIMenu.put(162, """
                Location menu
                1. Enter city
                2. Exit the city
                3. Open map
                4. Exit menu
                """ + hint_en);
        UIMenu.put(163, """
                Dungeon menu
                1. Enter the dungeon
                2. Exit the dungeon
                3. Exit menu
                """ + hint_en);
        UIMenu.put(121, """
                1. Hero params
                2. Weapon params
                3. Armor params
                4. Exit menu
                """ + hint_en);
        UIMenu.put(120, """
                Here are hero actions
                1. Get params
                2. Abilities
                3. Quest menu
                4. Exit menu
                """ + hint_en);
        UIMenu.put(122, """
                Here are hero actions
                1. See abilities
                2. Level Up
                3. Exit menu
                """ + hint_en);
        UIMenu.put(123, """
                Here are quest actions
                1. Get active quest
                2. Get quest list
                3. Exit menu
                """ + hint_en);

        UIMenu.put(140, """
                Do you need save or load
                1. Save the game
                2. Load menu
                3. Exit menu
                """ + hint_en);

        UIMenu.put(141, """
                Load menu
                1. See save files
                2. Load the game
                3. Exit menu
                """ + hint_en);

        UIMenu.put(130, """
                Inventory menu
                1. Open inventory
                2. Put on armor
                3. Put on weapon
                4. Take off armor
                5. Take off weapon
                6. Exit menu
                """ + hint_en);

        UIMenu.put(9001, """
                Welcome to the game
                1. Continue the game
                2. New game
                3. Settings
                4. Exit the game
                """ + hint_en);

        UIMenu.put(9002, """
                Welcome to the game
                1. New game
                2. Settings
                3. Exit the game
                """ + hint_en);
        UIMenu.put(1001, """
                What you can do
                1. Move
                2. Hero menu
                3. Inventory
                4. Save or load the game
                5. Settings
                                    
                6. Exit the game""");
        UIMenu.put(1002, """
                7. Action menu
                """ + hint_en);

        UIMenu.put(170, """
                Fight menu
                1. Regular attack
                2. Open inventory
                3. Use ability
                """ + hint_en);
    }
}
