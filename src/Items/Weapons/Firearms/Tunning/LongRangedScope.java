package Items.Weapons.Firearms.Tunning;

import Items.Items;

public class LongRangedScope implements Items {

    public LongRangedScope(String scopeName, int destinationPlus) {
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
