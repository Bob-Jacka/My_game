package SourceFile;

import NPC.StartNPC;

public class Main {
    public static void main(String[] args) {
        //Start game
        Source source = new Source();
        source.CreateHero1();

        source.GenerateStartNPC();
        StartNPC.class.getMethods();


//    SourceFile.Source source = new SourceFile.Source();
//    source.CreateHero1();
//    source.GeneratePotion();
//    System.out.println(HealthPotion.getHealthToRecover());
////    System.out.println(HealthPotion.getPotionParam());



    }
}