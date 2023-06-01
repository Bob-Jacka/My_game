package Locations;

import Main.Main;

public class City {
    private final String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public void enterTheCity() {
        System.out.println("Вы вошли в Город" + cityName);
        Main.STATUSES[2] = true;
    }

    public void exitTheCity() {
        System.out.println("Вы вышли из города");
        Main.STATUSES[2] = false;
    }
}
