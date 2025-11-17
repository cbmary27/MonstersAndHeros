package item;

import java.util.*;
import fileparser.PotionDetails;

public class Potions extends Item{

    protected int increaseAtt;
    protected String affectedAtt;

    public Potions(String name, int price, int level, int increaseAtt, String affectedAtt)
    {
        super(name, price, level);
        this.type = "Potion";
        this.increaseAtt = increaseAtt;
        this.affectedAtt = affectedAtt;
    }

    @Override
    public updateUsage()
    {
        this.usage = 0;
    }

    @Override
    public void effectOfItem()
    {

    }

    @Override
    public String toString()
    {
        return type + ": " + name + " | " + price + " | " + requiredLevel + " | " + increaseAtt + " | " + affectedAtt;
    }

    public PotionDetails toDetails() {
        List<String> d = new ArrayList<>();
        d.add(name);
        d.add(String.valueOf(price));
        d.add(String.valueOf(requiredLevel));
        d.add(String.valueOf(increaseAtt));
        d.add(affectedAtt);

        return new PotionDetails(d);
    }
}