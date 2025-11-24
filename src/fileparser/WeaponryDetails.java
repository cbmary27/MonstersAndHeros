package fileparser;

import java.util.*;

public class WeaponryDetails
{
    public String name;
    public int price;
    public int level;
    public int damage;
    public int requiredHands; 

    public WeaponryDetails(List<String> details)
    {
        this.name = details.get(0);
        this.price = Integer.parseInt(details.get(1));
        this.level = Integer.parseInt(details.get(2));
        this.damage = Integer.parseInt(details.get(3));
        this.requiredHands =  Integer.parseInt(details.get(4));
    }

    @Override
    public String toString()
    {
        return name + " | Price : " + price + " | Required Level : " + level + 
        " | Damage : " + damage + " |  Required Hands : " + requiredHands;
    }
}