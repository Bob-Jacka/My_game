package NPC;

import Dictionary.RandomNpcSpeech;
import Items.Items;
import Main.Source;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Trader {
    private final int health = 100;
    private final int attack = 15;
    private final ArrayList<Items> goods = new ArrayList<>(4);


    public Trader() {

    }

    public void traderMenu() {
        System.out.println("""
                What action you need
                1. Show me what you have
                2. Talk
                3. Exit menu
                HINT: just type number of the clause""");
        boolean isClose = false;
        while (!isClose) {
            switch (new Scanner(System.in).nextInt()) {
                case 1:
                    showGoods();
                    break;
                case 2:
                    talk();
                    break;
                case 3:
                    isClose = true;
                    break;
                default:
                    isClose = true;
                    break;

            }
        }
    }

    private void generateGoods() {
        Random random = new Random(100);
        for (int i = 0; i < 4; i++) {
            if (random.nextInt() < 20) {
                Source.publicGenerator(1);
            } else if (random.nextInt() > 20) {
                Source.publicGenerator(2);
            } else if (random.nextInt() > 20 && random.nextInt() < 100) {
                Source.publicGenerator(3);
            }
        }
    }

    ArrayList<Items> getGoods() {
        return goods;
    }

    private void showGoods() {
        System.out.println();
        for (Items item : goods) {
            System.out.println(item);
        }
    }

    private void talk() {
        System.out.println(RandomNpcSpeech.getRandomSpeech());
    }
}
