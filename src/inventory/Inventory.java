package inventory;

import java.util.*;
import item.*;
import utilities.constants.Constants;
import utilities.error.Error;
import utilities.input.Input;
import interfaces.Equippable;
import menu.InventoryMenu;
import entity.hero.Hero;

public class Inventory
{
    List<Item> items;
    public InventoryMenu menu;
    List<Item> brokenItems;
    Input inp;

    public Inventory()
    {
        items = new ArrayList<>();
        menu = new InventoryMenu();
        inp = new Input();
        brokenItems = new ArrayList<>();
    }

    public List<Item> getItems()
    {
        return items;
    }

    public List<Item> getBrokenItems()
    {
        return brokenItems;
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

    public Item getBrokenItem(String index)
    {
        return brokenItems.get(Integer.parseInt(index) - 1);
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

    public void open(Hero hero)
    {
        String choice;

        display();
        menu.inventoryMenu();
        choice = inp.stringInput();

        test(choice, hero);
    }

    public void test(String choice, Hero hero)
    {
        switch(choice)
        {
            case Constants.USEPOTION:
                menu.useItem(Constants.POTION);
                choice = inp.getIntInput(1, items.size());
                Item item = getItem(choice);
                if (check(item.getType(), Constants.POTION))
                {
                    item.applyEffect(hero);
                }
                else
                {
                    menu.wrongItemIndex();
                }
                break;

            case Constants.EQUIP:
                menu.useItem(Constants.EQUIP);
                choice = inp.getIntInput(1, items.size());
                Item item1 = getItem(choice);
                if (check(item1.getType(), Constants.WEAPON))
                {
                    hero.equipWeapon(item1);
                }
                else if (check(item1.getType(),Constants.ARMOR))
                {
                    hero.equipArmor(item1);
                }
                else
                {
                    menu.wrongItemIndex();
                }
                break;

            case Constants.UNEQUIP:
                menu.useItem(Constants.UNEQUIP);
                choice = inp.getIntInput(1, items.size());
                Item item2 = hero.selectItem(choice);
                if (check(item2.getType(), Constants.WEAPON))
                {
                    hero.unEquipWeapon(item2);
                }
                else if (check(item2.getType(),Constants.ARMOR))
                {
                    hero.unEquipArmor(item2);
                }
                else
                {
                    menu.wrongItemIndex();
                }
                break;

            case Constants.QUIT:
                break;

            default:
                Error.invalidMove();
                break;
        }
    }

    public boolean check(String type, String item)
    {
        if (type.equals(item))
        {
            return true;
        }
        return false;
    }

    public void checkForBrokenItems()
    {
        brokenItems.clear();
        for (Item item : items)
        {
            if (item.getUsage() == 0)
            {
                brokenItems.add(item);
            }
        }
    }

    public void displayBrokenItems()
    {
        int i = 1;
        for (Item item : brokenItems)
        {
            System.out.println("[" + i + "] " + item);
            i++;
        }
    }

    public int checkNumberOfWeapons()
    {
        int count = 0;
        System.out.println(items.size());

        for (Item item : items)
        {
            if (item.getType().equals(Constants.WEAPON))
            {
                count++;
            }
        }
        return count;
    }
}