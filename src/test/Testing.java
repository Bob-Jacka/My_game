//import Heroes.Slave;
//import Items.Armor.Armor;
//import Items.Items;
//import Items.Weapons.WeaponInterface;
//import Main.GameEngine;
//import jdk.jfr.Label;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//public class Testing {
//    private Slave valera;
//    private WeaponInterface sword;
//    private Armor armor;
//    private Items item1;
//    private Items item2;
//    private String potionName;
//
//    @BeforeEach
//    public void CreateHero1() {
//        valera = new Slave("Valera", true);
//    }
////
////    @Test
////    public void getHero2Params() {
////        Peasant v = valera.levelUpToHero2();
////        v.getParams();
////    }
////
////    @Test
////    public void GetWeaponParam() {
////        sword = new Sword("Hellraiser", 30, 23.5f, 50);
////        sword.getParams();
////    }
////
////    @Test
////    public void CollectingItems() {    ////проверка, что инвентарь работает
////        item1 = new QuestItem("Rakushca", 1);
////        item2 = new QuestItem("Berrie", 20);
////        valera.inventoryPut(item1);
////        valera.inventoryPut(item2);
////        valera.getParams();
////    }
////
////    @Test
////    public void HeroWithWeapon() {  ///проверка того, что суммируется атака с оружием
////        sword = new Sword("Hellraiser", 30, 23.5f, 50);
////        valera.getParams();
////        valera.putOnWeapon(sword);
////        valera.getParams();
////    }
////
////    @Test
////    public void HeroWithArmor() {  ////проверка того, что броня прибавляется герою
////        valera.getParams();
////        ;
////        armor = new Armor("Unpenetrateble_Lats", 50);
////        System.out.println(" ");
////        valera.putOnArmor(armor);
////        valera.getParams();
////    }
////
////    @Test
////    public void HealHeroByHealthPotion() {   ////PROBLEMS
////        valera.hurt();
////        valera.hurt();
////        valera.getParams();
//////        main.Main.Source source = new main.Main.Source();
//////        main.Items healthPotion = source.GeneratePotion();
////        HealthPotion healthPotion = new HealthPotion("Sparrow", 2.5, 1, 40);
////        valera.inventoryPut(healthPotion);
////        valera.healByHealthPotion(healthPotion);
////        valera.getParams();
////    }
////
////    @Test
////    public void LevelUpToHero2() {
////        Peasant valera2 = valera.levelUpToHero2();
////        valera2.getParams();
////    }
////
////    @Label("Проблемы в имени, они суммируются")
////    @Test
////    public void LevelUpToHero3() {
////        Peasant valera2 = valera.levelUpToHero2();
////        Knight valera3 = valera2.levelUpToHero3();
////    }
////
////    @Label("в инвентарь добавляется null, а не sparrow")
////    @Test
////    public void CreateHealthPotion() {
////        HealthPotion potion = new HealthPotion("sparrow", 2.5, 3, 50);
////        valera.inventoryPut(potion);
////        valera.getParams();
////    }
////
////////////////Closed because this methods are protected//////////////////
//////    @Label("Important function")
//////    @Test
//////    public void SaveGame() throws IOException {
//////        main.Main.Source source = new main.Main.Source();
//////        source.SaveGame();
//////    }
//////    @Test
//////    public void DeleteFile() {
//////        main.Main.Source source = new main.Main.Source();
//////        source.deleteWriteSaveFile();
//////    }
//////////////////////////////////////////////////////////////////////////////
////
////
////    @Label("Important")
////    @Test
////    public void LoadGame() throws IOException {
////        source.TestLoad();
////        valera.getParams();
////        valera.getActiveQuest();
////    }
////
//    @Label("Important")
//    @Test
//    public void SavingGame() {
//        GameEngine.TestSave();
//    }
//}
////
//////    @Label("Important")
//////    @Test
//////    public void SavingAndLoadGameWithDifferentParams() throws IOException {
//////        valera.setHealth(valera.getHealth() + 20);
//////        valera.setArmor(valera.getArmor() + 20);
//////        valera.setAttack(valera.getAttack() + 20);
//////        valera.setMagic(false);
//////        valera.setResistance(valera.getResistance() + 20);
//////        HealthPotion potion = new HealthPotion("Sparrow", 2.5, 5, 50);
//////        valera.inventoryPut(potion);
//////        valera.getParams();
//////        Source.SaveTheGame(valera);
//////
//////        System.out.println(" ");
//////
//////        Source.LoadGame("yes", valera);
//////        valera.getParams();
//////    }
////
////    @Test
////    public void GetParams() {
////        HealthPotion potion = new HealthPotion("Sparrow", 2.5, 5, 50);
////        valera.inventoryPut(potion);
////        valera.inventoryPut(potion);
////        valera.getParams();
////    }
////
//////    @Test
//////    public void MapTest1() throws IOException {
//////        Source.viewMapBlocked();
//////    }
//////
//////    @Test
//////    public void MapTest2() throws IOException {
////////        Source.viewMapUNBlocked();
//////    }
////
////    @Test
////    public void getViewExperienceBar() {
////        Source.viewExperienceBar();
////    }
////
////}
