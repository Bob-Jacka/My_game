package Items.OtherItems;

public class ResurrectStone implements OtherItems{
    public ResurrectStone(String name, int TriesToBroke) {
        this.name = name;
        this.TriesToBroke = TriesToBroke;
    }
    private final String name;
    private final int TriesToBroke;
    @Override
    public void getParams() {
        System.out.println(name);
        System.out.println(TriesToBroke);
    }

    @Override
    public String getName() {
        return name;
    }
}
