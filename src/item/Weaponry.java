package item;

import java.util.*;
import fileparser.WeaponryDetails;
import interfaces.Equippable;

public class Weaponry extends Item implements Equippable{

    protected int damage;
    protected int requiredHands;
    protected boolean equipped;

    public Weaponry(String name, int price, int level, int damage, int requiredHands)
    {
        super(name, price, level);
        this.type = "Weapon";
        this.damage = damage;
        this.requiredHands = requiredHands;
        this.equipped = false;
    }

    // @Override
    // public void effectOfItem()
    // {

    // }

    public void equipItem()
    {
        equipped = true;
    }

    public void unequipItem()
    {
        equipped = false;
    }

    public int getRequiredHands()
    {
        return requiredHands;
    }

    @Override
    public boolean isItemEquipped()
    {
        return equipped;
    }


    @Override
    public String toString()
    {
        String e;
        if (equipped == true)
        {
            e = "Yes";
        }
        else
        {
            e = "No";
        }
        return type + ": " + name + " | Price " + price + " | Damage Induced " + damage + " | Required Hands" + requiredHands + " | Equipped " + e;
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