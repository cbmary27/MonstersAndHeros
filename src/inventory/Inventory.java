package inventory;

import java.util.*;
import item.*;

public class Inventory
{
    List<Item> items;

    public Inventory()
    {
        items = new ArrayList<>();
    }

    public void open()
    {

    }

    public void display()
    {
        int i = 1;
        if (items.size() != 0)
        {
            for (Item item : items)
            {
                System.out.println("["+i+"] " + item);
            }
        }
        else
        {
            System.out.println("Inventory is empty!");
        }
        
        System.out.println("[U] Use a potion");
        System.out.println("[E] Equip a weapon");


    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public void dropItem(String index)
    {
        items.remove(Integer.parseInt(index) - 1);
    }

    public Item getItem(String index)
    {
        return items.get(Integer.parseInt(index) - 1);
    }

    public void useItem(String index)
    {
        Item item = getItem(index);
        item.updateUsage();
        
        if (item.getUsage() <= 0)
        {
            System.out.println("You have completely used up " + item.getName() + "! You can replenish this item at the market!");
        }
    }
}