package Enemies;

public class Orc extends Enemy {

    private final int WeaponCoef = 10;
    private final int HealthCoef = 10;
    private final boolean magic = false;

    public Orc() {
        System.out.println("main.Enemies.Orc constructor");
    }


    //@Override
    //public int attack() {
    //System.out.println(this.getName()+"Attacking");
    //}
//    public void defendingMagick() {
//        if (this.magic) {
//            int armor = this.getArmor();
//            super.armor += 10;}
//        else {
//            System.out.println("Magic is not allowed");
//            }
//    }
//
//    public void attackMagick() {
//        if (this.magic) {
//            super.attack += 10;}
//        else {
//            System.out.println("Magic is not allowed");
//            }
//
//    }
}
