package item;

import java.util.*;

public abstract class Item{

    protected String name;
    protected int price;
    protected int requiredLevel;
    protected String type;

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
}