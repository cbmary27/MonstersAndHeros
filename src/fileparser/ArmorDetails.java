package fileparser;

import java.util.*;

public class ArmorDetails
{
    public String name;
    public int price;
    public int level;
    public int damageReduction;

    public ArmorDetails(List<String> details)
    {
        this.name = details.get(0);
        this.price = Integer.parseInt(details.get(1));
        this.level = Integer.parseInt(details.get(2));
        this.damageReduction = Integer.parseInt(details.get(3));
    }

    @Override
    public String toString()
    {
        return name + " | " + price + " | " + level + " | " + damageReduction;
    }
}