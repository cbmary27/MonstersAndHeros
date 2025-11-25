package item;

import java.util.*;
import fileparser.WeaponryDetails;
import interfaces.Equippable;
import entity.hero.Hero;


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
        setUsage();
    }

    public void equipItem()
    {
        if (usage != 0)
        {
            equipped = true;
        }
        else
        {
            System.out.println("Weapon is broken, cannot be equipped!");
            System.out.println();
        }
    }

    public void unequipItem()
    {
        equipped = false;
    }

    public int getDamage()
    {
        return damage;
    }

    public int getRequiredHands()
    {
        return requiredHands;
    }

    public void setUsage()
    {
        usage = 10;
    }


    @Override
    public boolean isItemEquipped()
    {
        return equipped;
    }

    @Override
    public void applyEffect(Hero hero)
    {
        if (checkUsage())
        {
            updateUsage();
            hero.getDamageFromItem((hero.getStrength() + damage) * 5/100);
            if (usage == 0)
            {
                System.out.println("The weapon broke!");
                System.out.println();
            }
        }
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
        return super.toString() + " | Damage Induced : " + damage + " | Required Hands : " + requiredHands + " | Equipped : " + e;
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