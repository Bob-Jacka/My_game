package Main;

import Dictionary.Levels;
import Heroes.Hero;
import Heroes.Knight;
import Heroes.Peasant;
import Heroes.Slave;
import Heroes.classes.*;

import java.io.File;

/**
 * <p>
 * Класс, представляющий собой абстрактную оболочку игрока в игре.
 * Предоставляет доступ через интерфейс к своим параметрам
 * <p>Параметры:
 * <p>{@link #IS_AUTO_SAVE} - параметр автосохранения ({@link Player#set_IsAutoSave}),
 * <p>{@link #PERSON} - параметр персонажа ({@link Player#set_Person}),
 * <p>{@link #SAVE_FILE} - параметр файла сохранения игры ({@link Player#set_SaveFile}),
 * <p>{@link #FLAGS} - флаги состояния персонажа ({@link Player#set_Flag}),
 * <p>{@link #HERO_LOCATION} - параметр позиции персонажа на карте ({@link Player#set_HeroLocation})
 */
public abstract class Player {
    /**
     * Параметр, необходимый для автосохранения
     * <p>Если параметр выставлен в значение true - автосохранение включено
     * <p>Если параметр выставлен в значение false - автосохранение выключено
     */
    private static boolean IS_AUTO_SAVE;
    /**
     * Параметр, сохраняющий в себя класс персонажа, по стандарту изначально равен {@link Slave}
     */
    private static Hero PERSON = new Slave();

    /**
     * Параметр, определяющий директорию в которую будет произведено сохранение
     */
    private static SaveFile SAVE_FILE = new SaveFile("saveHeroParams");

    /**
     * <p>Переменная предназначенная для отслеживание статуса героя в игре
     * Значения:
     * <p>0 - isInBattle,
     * <p>1 - nearNPC,
     * <p>2 - isInCity,
     * <p>3 - isInDungeon,
     * <p>4 - action menu
     */
    private static final boolean[] FLAGS = new boolean[]
            {false,
                    false,
                    false,
                    false,
                    false
            };

    /**
     * Параметр, определяющий местоположение героя на карте
     */
    private static short HERO_LOCATION = 0;

    /**
     * <p>Метод предназначен для создания героя после загрузки
     * <p>1 - Slave,
     * <p>2 - Peasant,
     * <p>3 - Knight,
     * <p>4 - Healer,
     * <p>5 - Hunter,
     * <p>6 - Necromancer,
     * <p>7 - Tank,
     * <p>8 - Warrior
     *
     * @param heroNumber Номер героя для создания
     */
    static void set_Person(int heroNumber) {
        if (heroNumber == Levels.Slave) PERSON = new Slave();

        else if (heroNumber == Levels.Peasant) PERSON = new Peasant();

        else if (heroNumber == Levels.Knight) PERSON = new Knight();

        else if (heroNumber == Levels.Healer) PERSON = new Healer();

        else if (heroNumber == Levels.Hunter) PERSON = new Hunter();

        else if (heroNumber == Levels.Necromancer) PERSON = new Necromancer();

        else if (heroNumber == Levels.Tank) PERSON = new Tank();

        else if (heroNumber == Levels.Warrior) PERSON = new Warrior();
    }

    /**
     * Метод меняет значение флага у класса Player
     * <p>0 - isInBattle,
     * <p>1 - nearNPC,
     * <p>2 - isInCity,
     * <p>3 - isInDungeon,
     * <p>4 - action menu
     *
     * @param flag_Num Номер флага для изменение в {@link Player#FLAGS}
     * @param value    Значение флага для изменения в {@link Player#FLAGS}
     */
    public static void set_Flag(int flag_Num, boolean value) {
        FLAGS[flag_Num] = value;
    }

    /**
     * <p>0 - isInBattle,
     * <p>1 - nearNPC,
     * <p>2 - isInCity,
     * <p>3 - isInDungeon,
     * <p>4 - action menu
     *
     * @param flag_Num номер флага в {@link Player#FLAGS}
     * @return Значение флага по номеру flag_Num в {@link Player#FLAGS}
     */
    public static boolean get_Flag(int flag_Num) {
        return FLAGS[flag_Num];
    }

    /**
     * Метод предназначенный для получения доступа к {@link Player#SAVE_FILE}
     *
     * @return актуальный файл сохранения
     */
    static File get_SaveFile() {
        return SAVE_FILE;
    }

    /**
     * Метод предназначенный для получения доступа к {@link Player#SAVE_FILE}
     * и перезаписи его на newSaveFile
     *
     * @param newSaveFile путь нового файла сохранения
     */
    static void set_SaveFile(String newSaveFile) {
        SAVE_FILE = new SaveFile(newSaveFile);
    }

    /**
     * Метод предназначен для установки позиции героя на карте
     *
     * @param newValue новое значение позиции героя
     */
    static void set_HeroLocation(short newValue) {
        HERO_LOCATION = newValue;
    }

    /**
     * Метод предназначен для получения позиции героя на карте
     *
     * @return позицию героя на карте
     */
    static short get_HeroLocation() {
        return HERO_LOCATION;
    }

    /**
     * Метод предназначен для установки низкоуровневого параметра {@link Player#IS_AUTO_SAVE}
     *
     * @param newValue значение для установки в переменную {@link Player#IS_AUTO_SAVE}
     */
    static void set_IsAutoSave(boolean newValue) {
        IS_AUTO_SAVE = newValue;
    }

    /**
     * Метод предназначен для получения низкоуровневого параметра {@link Player#IS_AUTO_SAVE}
     *
     * @return Значение {@link Player#IS_AUTO_SAVE}
     */
    static boolean get_IsAutoSave() {
        return IS_AUTO_SAVE;
    }

    /**
     * Метод предназначен для установки персонажа
     *
     * @param newHero объект типа {@link Hero}
     */
    static void set_Person(Hero newHero) {
        PERSON = newHero;
    }

    /**
     * Метод предназначен для получения доступа к персонажу
     *
     * @return - объект типа {@link Hero}
     */
    static Hero get_Person() {
        return PERSON;
    }
}