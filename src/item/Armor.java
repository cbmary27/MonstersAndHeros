package item;

import java.util.*;
import fileparser.ArmorDetails;

public class Armor extends Item{

    protected int damageReduction;

    public Armor(String name, int price, int level, int damageReduction)
    {
        super(name, price, level);
        this.type = "Armor";
        this.damageReduction = damageReduction;
    }

    @Override
    public String toString()
    {
        return type + ": " + name + " | " + price + " | " + requiredLevel + " | " + damageReduction;
    }

    public ArmorDetails toDetails() {
        List<String> d = new ArrayList<>();
        d.add(name);
        d.add(String.valueOf(price));
        d.add(String.valueOf(requiredLevel));
        d.add(String.valueOf(damageReduction));

        return new ArmorDetails(d);
    }

}