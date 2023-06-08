package Locations;

import Main.Player;

public class Dungeon {
    private String dungeonName;

    public Dungeon(String dungeonName) {
        this.dungeonName = dungeonName;
    }

    public void enterTheDungeon() {
        System.out.println("Вы вошли в подземелье");
        Player.STATUSES[3] = true;
    }

    public void exitTheDungeon() {
        System.out.println("Вы вышли из подземелья");
        Player.STATUSES[3] = false;
    }
}
