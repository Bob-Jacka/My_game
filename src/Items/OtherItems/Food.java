package Items.OtherItems;

public class Food implements OtherItems{
    public Food(String foodName, int healthToRecover, boolean isRotten) {
        this.name = foodName;
        this.healthToRecover = healthToRecover;
        this.isRotten = isRotten;
    }
    private final String name;
    private int healthToRecover;
    private boolean isRotten;

    @Override
    public void getParams() {

    }

    @Override
    public String getItemName() {
        return null;
    }
}
