package Dictionary.QuestItems;

import Items.Items;

public class QuestItem implements Items {
    private final String name;
    private int quantity;
    public QuestItem(String name, int quantity) {
        this.name = name;
        this.quantity =quantity;
    }

    @Override
    public void getParams() {
        System.out.println(this.name);
        System.out.println(this.quantity);
    }
    @Override
    public String getItemName() {
        return this.name;
    }
}
