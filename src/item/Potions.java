package item;

import java.util.*;

public class Potions extends Item{

    protected int increaseAtt;
    protected int affectedAtt;

    public Potions(String name, int price, int level, int affectedAtt, int increaseAtt)
    {
        super(name, price, level);
        this.type = "Potion";
        this.affectedAtt = affectedAtt;
        this.increaseAtt = increaseAtt;
    }

}