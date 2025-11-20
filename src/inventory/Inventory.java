package inventory;

import java.util.*;
import item.*;
import utilities.constants.Constants;
import interfaces.Equippable;

public class Inventory
{
    List<Item> items;

    public Inventory()
    {
        items = new ArrayList<>();
    }

    public List<Item> getItems()
    {
        return items;
    }

    public void display()
    {
        int i = 1;
        if (items.size() != 0)
        {
            for (Item item : items)
            {
                System.out.println("["+i+"] " + item);
                i++;
            }
        }
        else
        {
            System.out.println("Inventory is empty!");
        }
        System.out.println();
    }

    public void addItem(Item item)
    {
        items.add(item);
    }

    public void dropItem(String index)
    {
        items.remove(Integer.parseInt(index) - 1);
    }

    public void removeItem(Item item)
    {
        items.remove(item);
    }

    public Item getItem(String index)
    {
        return items.get(Integer.parseInt(index) - 1);
    }

    public int checkAnyWeaponEquipped()
    {
        int hands = 0;
        for (Item item : items)
        {
            if (item.getType().equals(Constants.WEAPON))
            {
                Weaponry w = (Weaponry) item;
                int temp = w.getRequiredHands();

                Equippable wa = (Equippable) item;
                if (wa.isItemEquipped())
                {
                    hands = hands + temp;
                }
            }
        }
        return hands;
    }

    public boolean checkAnyArmorEquipped()
    {
        for (Item item : items)
        {
            if (item.getType().equals(Constants.ARMOR))
            {
                Equippable wa = (Equippable) item;
                if (wa.isItemEquipped())
                {
                    return true;
                }
            }
        }
        return false;
    }
}