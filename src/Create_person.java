import java.util.Scanner;
@Deprecated
public class Create_person {
    Create_person() {
        System.out.println("Please, enter some parameters");
    }
    Scanner health = new Scanner(System.in);
    Scanner name = new Scanner(System.in);
    Scanner armor = new Scanner(System.in);
    Scanner attack = new Scanner(System.in);
    Scanner magic = new Scanner(System.in);

    String name_actual = name.next();
    int health_actual = health.nextInt();
    int armor1_actual = armor.nextInt();
    int attack1_actual = attack.nextInt();
    boolean magic_actual = magic.nextBoolean();



    //Heroes.Hero valera = new Heroes.Hero(this.health1, this.name1, this.armor1, this.attack1, this.magic1);
}
