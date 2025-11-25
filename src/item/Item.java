package item;

import java.util.*;
import entity.hero.Hero;

public abstract class Item{

    protected String name;
    protected int price;
    protected int requiredLevel;
    protected String type;
    protected int usage;

    public Item(String name, int price, int level)
    {
        this.name = name;
        this.price = price;
        this.requiredLevel = level;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public int getPrice()
    {
        return this.price;
    }

    public int getUsage()
    {
        return this.usage;
    }

    public void updateUsage()
    {
        this.usage--;
    }

    public boolean checkUsage()
    {
        if (usage <= 0)
        {
            System.out.println("This item needs to be repaired");
            return false;
        }
        return true;
    }

    public String getType()
    {
        return this.type;
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public String toString()
    {
        return type + ": " + name;
    }

    public abstract void applyEffect(Hero hero);
    public abstract void setUsage();
}