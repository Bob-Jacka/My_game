package Locations;

import Main.Main;

public class Dungeon {
    private String dungeonName;

    public Dungeon(String dungeonName) {
        this.dungeonName = dungeonName;
    }

    public void enterTheDungeon() {
        System.out.println("Вы вошли в подземелье");
        Main.STATUSES[3] = true;
    }

    public void exitTheDungeon() {
        System.out.println("Вы вышли из подземелья");
        Main.STATUSES[3] = false;
    }
}
