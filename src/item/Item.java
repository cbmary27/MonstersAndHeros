package item;

import java.util.*;

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
        this.usage = (int) (usage * 0.8);
    }

    public String getType()
    {
        return this.type;
    }

    public String getName()
    {
        return this.name;
    }

    //public abstract void effectOfItem();
}