package item;

import java.util.*;
import fileparser.WeaponryDetails;

public class Weaponry extends Item{

    protected int damage;
    protected int requiredHands;

    public Weaponry(String name, int price, int level, int damage, int requiredHands)
    {
        super(name, price, level);
        this.type = "Weaponry";
        this.damage = damage;
        this.requiredHands = requiredHands;
    }

    @Override
    public String toString()
    {
        return type + ": " + name + " | " + price + " | " + requiredLevel + " | " + damage + " | " + requiredHands;
    }

    public WeaponryDetails toDetails() {
        List<String> d = new ArrayList<>();
        d.add(name);
        d.add(String.valueOf(price));
        d.add(String.valueOf(requiredLevel));
        d.add(String.valueOf(damage));
        d.add(String.valueOf(requiredHands));

        return new WeaponryDetails(d);
    }

}