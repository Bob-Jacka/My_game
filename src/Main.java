import Enemies.Orc;
import Heroes.Hero1;
import Heroes.Hero2;
import Heroes.Hero3;
import Heroes.classes.*;
import Items.Potions.HealthPotion;

import java.util.Random;

public class Main {
    public static void main(String[] args) {



        Source source = new Source();
        Hero1 x = new Hero1("Valera", true);
        Hero2 y = x.levelUpToHero2();
        x.getParams();
        System.out.println();
        System.out.println();
        y.getParams();




//    Source source = new Source();
//    source.CreateHero1();
//    source.GeneratePotion();
//    System.out.println(HealthPotion.getHealthToRecover());
////    System.out.println(HealthPotion.getPotionParam());



    }
}