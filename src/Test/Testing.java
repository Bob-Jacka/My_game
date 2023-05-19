package Test;

import Dictionary.Quest;
import Dictionary.QuestItems.QuestItem;
import Enemies.Enemy;
import Heroes.Hero1;
import Heroes.Hero2;
import Heroes.Hero3;
import Items.Armor.Armor;
import Items.Items;
import Items.Potions.HealthPotion;
import Items.Weapons.MeleeCombatWeapon.Sword;
import Items.Weapons.WeaponInterface;
import Main.Main;
import Main.Source;
import jdk.jfr.Label;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

public class Testing {
    private Hero1 valera;
    private WeaponInterface sword;
    private Armor armor;
    private Items item1;
    private Items item2;
    private Source source;
    private String potionName;

    @Before
    public void CreateHero1() {
        valera = new Hero1("Valera", true);
        Source source = new Source();
    }

    @Test
    public void GetWeaponParam() {
        sword = new Sword("Hellraiser", 30, 23.5f, 50);
        sword.getParams();
    }

    @Test
    public void CollectingItems() {    ////проверка, что инвентарь работает
        item1 = new QuestItem("Rakushca", 1);
        item2 = new QuestItem("Berrie", 20);
        valera.inventoryPut(item1);
        valera.inventoryPut(item2);
        valera.getParams();
    }

    @Test
    public void HeroWithWeapon() {  ///проверка того, что суммируется атака с оружием
        sword = new Sword("Hellraiser", 30, 23.5f, 50);
        valera.getParams();
        valera.putOnWeapon(sword);
        valera.getParams();
    }
    @Test
    public void HeroWithArmor() {  ////проверка того, что броня прибавляется герою
        valera.getParams();;
        armor = new Armor("Unpenetrateble_Lats", 50);
        System.out.println(" ");
        valera.putOnArmor(armor);
        valera.getParams();
    }
    @Test
    public void HealHeroByHealthPotion() {   ////PROBLEMS
        valera.hurt();
        valera.hurt();
        valera.getParams();
//        Main.Source source = new Main.Source();
//        Items healthPotion = source.GeneratePotion();
        HealthPotion healthPotion = new HealthPotion("Sparrow", 2.5, 1, 40);
        valera.inventoryPut(healthPotion);
        valera.healByHealthPotion(healthPotion);
        valera.getParams();
    }

    @Test
    public void LevelUpToHero2() {
        Hero2 valera2 = valera.levelUpToHero2();
        valera2.getParams();
    }
    @Label("Проблемы в имени, они суммируются")
    @Test
    public void LevelUpToHero3() {
        Hero2 valera2 = valera.levelUpToHero2();
        Hero3 valera3 = valera2.levelUpToHero3();
    }

    @Label("в инвентарь добавляется null, а не sparrow")
    @Test
    public void CreateHealthPotion() {
        HealthPotion potion = new HealthPotion("sparrow", 2.5, 3, 50);
        valera.inventoryPut(potion);
        valera.getParams();
    }

////////////Closed because this methods are protected//////////////////
//    @Label("Important function")
//    @Test
//    public void SaveGame() throws IOException {
//        Main.Source source = new Main.Source();
//        source.SaveGame();
//    }
//    @Test
//    public void DeleteFile() {
//        Main.Source source = new Main.Source();
//        source.deleteWriteSaveFile();
//    }
//////////////////////////////////////////////////////////////////////////



    @Label("Important")
    @Test
    public void LoadGame() throws IOException {
        Source.TestLoad(valera);
//        valera.getParams();
//        valera.getActiveQuest();
//        System.out.println(Main.isAutoSave);
//        Main.forwardCoordinates = 1;
//        Main.rightCoordinates = 5;
//        Main.leftCoordinates = 10;
//        Main.backwardCoordinates = 15;
        System.out.println(Main.forwardCoordinates);
        System.out.println(Main.rightCoordinates);
        System.out.println(Main.backwardCoordinates);
        System.out.println(Main.leftCoordinates);
    }
    @Label("Important")
    @Test
    public void SavingGame() throws IOException {
//        valera.setActiveQuest(Quest.Quest1);
//        Main.forwardCoordinates = 1;
//        Main.rightCoordinates = 5;
//        Main.leftCoordinates = 10;
//        Main.backwardCoordinates = 15;
        Source.TestSave(valera);
    }

//    @Label("Important")
//    @Test
//    public void SavingAndLoadGameWithDifferentParams() throws IOException {
//        valera.setHealth(valera.getHealth() + 20);
//        valera.setArmor(valera.getArmor() + 20);
//        valera.setAttack(valera.getAttack() + 20);
//        valera.setMagic(false);
//        valera.setResistance(valera.getResistance() + 20);
//        HealthPotion potion = new HealthPotion("Sparrow", 2.5, 5, 50);
//        valera.inventoryPut(potion);
//        valera.getParams();
//        Source.SaveTheGame(valera);
//
//        System.out.println(" ");
//
//        Source.LoadGame("yes", valera);
//        valera.getParams();
//    }

    @Test
    public void GetParams() {
        HealthPotion potion = new HealthPotion("Sparrow", 2.5, 5, 50);
        valera.inventoryPut(potion);
        valera.inventoryPut(potion);
        valera.getParams();
    }

//    @Test
//    public void attacking() throws IOException {
//        Enemy enemy = source.generateEnemy();
//        Source.attackEnemy(valera, enemy);
//        enemy.getParams();
//    }


}
