package Items.OtherItems;

public class ResurrectStone implements OtherItems{

    private String name;
    private int TriesToBroke;
    @Override
    public void getParams() {
        System.out.println(name);
        System.out.println(TriesToBroke);
    }
}
