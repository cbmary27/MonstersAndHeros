package fileparser;

import java.util.*;

public class SpellDetails
{
    public String name;
    public int price;
    public int level;
    public int damage;
    public int affectedMana;
    public String spellType;

    public SpellDetails(List<String> details)
    {
        this.name = details.get(0);
        this.price = Integer.parseInt(details.get(1));
        this.level = Integer.parseInt(details.get(2));
        this.damage = Integer.parseInt(details.get(3));
        this.affectedMana =  Integer.parseInt(details.get(4));
        this.spellType = details.get(5);
    }

    @Override
    public String toString()
    {
        return name + " | " + price + " | " + level + " | " + damage + " | " + affectedMana + "|" + spellType;
    }
}