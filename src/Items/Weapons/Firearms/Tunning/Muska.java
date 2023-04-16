package Items.Weapons.Firearms.Tunning;
import Items.Items;

public class Muska implements Items{
    public Muska(int destinationPlus, String scopeName) {
        this.destinationPlus = destinationPlus;
        this.scopeName = scopeName;
    }
    private final int destinationPlus;
    private final String scopeName;

    @Override
    public void getParams() {

    }

    @Override
    public String getItemName() {
        return null;
    }
}
