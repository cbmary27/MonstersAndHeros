/**
 * Filename: Inventory.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-18
 * Description: A class for the implementation of the logic for inventory
 */

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

    /**
    * To display the items in the hero's inventory
    * @return void method
    */
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

    /**
    * To add an item to the inventory
    * @return void method
    */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
    * To remove an item from the inventory
    * @return void method
    */
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

    /**
    * To get an item whose usage = 0
    * @return void method
    */
    public Item getBrokenItem(String index)
    {
        return brokenItems.get(Integer.parseInt(index) - 1);
    }

    /**
    * To check if the weapon in the inventory is equipped
    * @return returns the total number of "hands" currently occupied (holds a weapon)
    */
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

    /**
    * To check if the armor in the inventory is equipped
    * @return a boolean value to indicate whether an armor is equipped or not
    */
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

    /**
    * A started method to open hero's inventory
    * @param hero the hero opening the inventory
    * @return void method
    */
    public void open(Hero hero)
    {
        String choice;

        display();
        menu.inventoryMenu();
        choice = inp.stringInput();

        test(choice, hero);
    }

    /**
    * To check if the weapon in the inventory is equipped
    * @param choice,hero the choice to indicate what to do in the hero's inventory
    * @return void method
    */
    public void test(String choice, Hero hero)
    {
        switch(choice)
        {
            case Constants.USEPOTION: //to use a potion
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

            case Constants.EQUIP: //to equip a weapon/armor
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

            case Constants.UNEQUIP: //to unequip a weapon/armor
                menu.useItem(Constants.UNEQUIP);
                choice = inp.getIntInput(1, items.size());
                Item item2 = hero.selectItem(choice);
                if (check(item2.getType(), Constants.WEAPON))
                {
                    if (hero.getEquippedWeapons().size() == 1) //if only one weapon in hero's inventory, cannot unequip
                    {
                        menu.cannotUnequip();
                        break;
                    }
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

    /**
    * To check if item type from the index selected by player matches the action intended
    * @param type,item
    * @return a boolean value to indicate whether the type matches the action intended or not
    */
    public boolean check(String type, String item)
    {
        if (type.equals(item))
        {
            return true;
        }
        return false;
    }

    /**
    * To check if the usage of any item in the hero's inventory has maxxed out
    * @return void method
    */
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

    /**
    * To display the broken items in the inventory
    * @return void method
    */
    public void displayBrokenItems()
    {
        int i = 1;
        for (Item item : brokenItems)
        {
            System.out.println("[" + i + "] " + item);
            i++;
        }
    }

    /**
    * To check the number of weapons in the hero's inventory
    * @return the number of weapons in the hero's inventory
    */
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