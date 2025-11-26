/**
 * Filename: Item.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-18
 * Description: An abstract class for Item
 */


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

    /**
    * To check if an item is maxxed out or not
    * @return a boolean value to indicate whether the item is maxxed out or not
    */
    public boolean checkUsage()
    {
        if (usage <= 0)
        {
            System.out.println("This item needs to be repaired");
            System.out.println();
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
        return type + ": " + name + " | Uses Left : " + usage;
    }

    public abstract void applyEffect(Hero hero);
    public abstract void setUsage();
}