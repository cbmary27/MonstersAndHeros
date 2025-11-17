package item;

import java.util.*;

public class Armor extends Item{

    protected int damageReduction;

    public Armor(String name, int price, int level, int damageReduction)
    {
        super(name, price, level);
        this.type = "Armor";
        this.damageReduction = damageReduction;
    }

}