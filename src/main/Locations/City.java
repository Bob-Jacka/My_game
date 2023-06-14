package Locations;

import Main.Player;

public class City {
    private final String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public void enterTheCity() {
        System.out.println("Вы вошли в Город" + cityName);
        Player.set_Flag(2, true);
    }

    public void exitTheCity() {
        System.out.println("Вы вышли из города");
        Player.set_Flag(2, false);
    }
}
