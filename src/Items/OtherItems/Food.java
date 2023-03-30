package Items.OtherItems;

import Dictionary.FoodName;

public class Food implements OtherItems{
    public Food(FoodName foodName, int healthToRecover, boolean isRotten) {
        this.name = foodName;
        this.healthToRecover = healthToRecover;
        this.isRotten = isRotten;
    }
    private final FoodName name;
    private int healthToRecover;
    private boolean isRotten;

    @Override
    public void getParams() {

    }

    @Override
    public String getName() {
        return null;
    }
}
