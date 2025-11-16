package fileparser;

import java.util.*;

public class EntityDetails
{
    public String name;
    public int mp;
    public int strength;
    public int exp;
    public int dexterity; 
    public int agility;
    public int gold;

    public EntityDetails(List<String> details)
    {
        this.name = details.get(0);
        this.mp = Integer.parseInt(details.get(1));
        this.strength = Integer.parseInt(details.get(2));
        this.agility = Integer.parseInt(details.get(3));
        this.dexterity = Integer.parseInt(details.get(4));
        this.gold = Integer.parseInt(details.get(5));
        this.exp = Integer.parseInt(details.get(6));
    }
}