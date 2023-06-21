package Locations;

import Main.Player;

public class City {
    private final int cityNam;
    private final String cityName;

    public City(String cityName, int cityNam) {
        this.cityName = cityName;
        this.cityNam = cityNam;
    }

    public final void enterTheCity() {
        System.out.println("Вы вошли в Город " + cityName);
        Player.set_Flag(2, true);
    }

    public final void exitTheCity() {
        System.out.println("Вы вышли из города");
        Player.set_Flag(2, false);
    }

    public final int getCityNam() {
        return this.cityNam;
    }
}
