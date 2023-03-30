import Dictionary.FoodName;
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

import java.util.Random;
import java.util.Scanner;

public class Source {

    Random random = new Random(50);
    int IntegerValue = random.nextInt(5, 90);
    Double DoubleValue = random.nextDouble(1.0, 5.0);


    public Items GeneratePotion() {
//        Random random = new Random();
        int generationRate = random.nextInt(90);
        if (generationRate > 70) {
            return new HealthPotion("HealthPotion", DoubleValue, 1, IntegerValue);
        } else if (generationRate < 70) {
            return new ManaPotion("HealthPotion", DoubleValue, 1, IntegerValue);
        }
        else {
            System.out.println("There is no potions");
            return null;
        }

    }

    public Items GenerateWeapon() {
//        Random random = new Random();
        int generationRate = random.nextInt(90);
        if (generationRate > 75) {
            return new Sword("Sword", 15, 20, 50);
        } else {
            return new Sword("Sword", 40, 15, 50);
        }
    }


    public Items GenerateArmor() {
//        Random random = new Random();
        int generationRate = random.nextInt(90);
        if (generationRate > 85) {
            return new IronArmor("lats", 80);
        } else if (generationRate > 60 && generationRate < 85) {
            return new LeatherArmor("lats", 80);
        }
        else {
            System.out.println("There is nothing interesting");
            return null;
        }
    }

    public Hero1 CreateHero1() {
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

    public void enterNewLocation() {
        System.out.println("You've entering new location");
    }

    public void attackEnemy() {
        System.out.println("Do you really want to attack enemy (yes/no) ");
        Scanner questionAttack = new Scanner(System.in);
        String askAttack = questionAttack.next();
        if (questionAttack.next().equals("yes")) {
//            Hero1.attack();
        }
    }

    public Enemy generateEnemy() {
        int genEn = random.nextInt(1, 50);
        if (genEn > 50) {
            System.out.println("An enemy appeared ");
            return new Enemy();
        } else {
            System.out.printf("You're lucky, there is no enemy ");
        }
        return null;
    }

    public Items GenerateOtherItems() {
//        Random random = new Random();
        int generationRate = random.nextInt(90);
        if (generationRate > 85) {
            return new Food(FoodName.borch, 30, false);
        } else if (generationRate > 60 && generationRate < 85) {
            return new Food(FoodName.hlebyshek, 20, false);
        } else if (generationRate > 40 && generationRate < 60) {
            return new ResurrectStone("Valhalla", 3);
        } else if (generationRate > 80 && generationRate < 85) {
            return new ResurrectStone("Valhalaaaa", 4);
        } else {
            System.out.println("There is nothing interesting");
            return null;
        }
    }
    public Items GenerateTunning() {
        int generationRate = random.nextInt(90);
        if (generationRate > 50) {
            return new Muska(20, "Muska");
        } else if (generationRate > 50 && generationRate < 80) {
            return new OpticalScope("Callimator", 50);
        } else if (generationRate == 50){
            return new muzzleBrake( 100);
        } else return null;
    }

}



