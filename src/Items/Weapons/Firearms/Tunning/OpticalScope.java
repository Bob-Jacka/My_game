package Items.Weapons.Firearms.Tunning;


import Items.Items;

public class OpticalScope implements Items {
    public OpticalScope(String scopeName, int destinationPlus) {
        this.destinationPlus = destinationPlus;
        this.scopeName = scopeName;
    }
    private final int destinationPlus;
    private final String scopeName;

    @Override
    public void getParams() {

    }

    @Override
    public String getName() {
        return null;
    }
}
