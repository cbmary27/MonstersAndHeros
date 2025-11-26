/**
 * Filename: Market.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-17
 * Description: A class for Market and its functionalities
 */

package market;

import java.util.*;
import utilities.error.Error;
import utilities.input.Input;
import utilities.constants.Constants;
import menu.MarketMenu;
import entity.hero.*;
import item.*;
import fileparser.*;
import inventory.Inventory;

public class Market{

    public MarketFactory mf;
    public Input inp;
    public String choice;
    private MarketMenu menu;
    private Hero customer;

    public Market()
    {
        inp = new Input();
        menu = new MarketMenu();
    }

    /**
    * A method to implement functionalities according to the hero's choice
    * @param hero the hero who entered the market
    * @return void method
    */
    public void enter(Hero hero)
    {
        customer = hero;
        menu.enterMarket();

        while (true) {
            menu.showMenu();
            choice = inp.stringInput().toUpperCase();

            switch(choice)
            {
                case Constants.BUY: //to buy items
                    menu.buy();
                    menu.showGold(customer.getName(), customer.getGold());
                    createMarketFactoryInstance();
                    display();
                    choice = " ";
                    break;

                case Constants.SELL: //to sell items
                    menu.sell();
                    menu.showGold(customer.getName(), customer.getGold());
                    createMarketFactoryInstance();
                    sell();
                    choice = " ";
                    break;

                case Constants.REPAIR: //to repair items if broken
                    menu.repair();
                    menu.showGold(customer.getName(), customer.getGold());
                    repairItem();
                    choice = " ";
                    break;

                case Constants.QUIT:
                    menu.quit();
                    break;

                default:
                    Error.invalidMove();
                    break;
            }

            if (choice.equals(Constants.QUIT))
            {
                break;
            }
            menu.message();
        }
    }

    /**
    * A method to get the players choice for which type of items they want to view
    * @return void method
    */
    public void display()
    {
        menu.displayItems();
        choice = inp.getIntInput(1, 4);

        switch(choice)
        {
            case "1":
                displayPotions();
                break;
            case "2":
                displaySpells();
                break;
            case "3":
                displayWeapons();
                break;
            case "4":
                displayArmor();
                break;
            case Constants.QUIT:
                break;
            default:
                Error.invalidMove();
        }

    }

    /**
    * A method to buy an item of the hero's choice
    * @param item the item chosen by the hero
    * @return void method
    */
    public void buy(Item item)
    {
        customer.getInventory().addItem(item); //add item to hero's inventory
        customer.updateGold(item.getPrice()); //update the gold of the hero
    }

    /**
    * A method to sell items from hero's inventory
    * @return void method
    */
    public void sell()
    {
        String choice;
        
        while (true)
        {
            if (customer.getInventory().getItems().isEmpty())
            {
                customer.getInventory().display();
            }
            else
            {
                customer.getInventory().display(); //display hero's inventory
                menu.sellItem();

                choice = inp.getIntInput(1, customer.getInventory().getItems().size());

                if (choice.equals(Constants.QUIT))
                {
                    break;
                }

                Item sold = customer.getInventory().getItem(choice);

                switch(sold.getType()) //to get the type of item to be sold
                {
                    case Constants.POTION:
                        Potions potionItem = (Potions) sold;
                        PotionDetails pd = potionItem.toDetails();
                        customer.increaseGold(potionItem.getPrice()/2);
                        mf.potionDetails.add(pd);
                        menu.soldItem();
                        customer.getInventory().dropItem(choice);
                        break;

                    case Constants.SPELL:
                        Spells spellItem = (Spells) sold;
                        SpellDetails sd = spellItem.toDetails();
                        customer.increaseGold(spellItem.getPrice()/2);
                        mf.spellDetails.add(sd);
                        menu.soldItem();
                        customer.getInventory().dropItem(choice);
                        break;

                    case Constants.WEAPON:
                        //if hero has only one weapon in inventory and tries to sell it
                        if (customer.getInventory().checkNumberOfWeapons() == 1)
                        {
                            menu.cannotSell();
                            break;
                        }
                        Weaponry weaponItem = (Weaponry) sold;
                        WeaponryDetails wd = weaponItem.toDetails();
                        customer.increaseGold(weaponItem.getPrice()/2);
                        if (customer.getEquippedWeapons().contains(sold))
                        {
                            customer.getEquippedWeapons().remove(sold); //removing weapon from hero's equipped weapons if it was equipped
                        }
                        mf.weaponryDetails.add(wd);
                        menu.soldItem();
                        customer.getInventory().dropItem(choice);
                        break;
                        
                    case Constants.ARMOR:
                        Armor armorItem = (Armor) sold;
                        ArmorDetails ad = armorItem.toDetails();
                        customer.increaseGold(armorItem.getPrice()/2);
                        if (customer.getEquippedArmor().getName() == sold.getName())
                        {
                            customer.setEquippedArmor(null);
                        }
                        mf.armorDetails.add(ad);
                        menu.soldItem();
                        customer.getInventory().dropItem(choice);
                        break;
                }
            }
        }
    }

    /**
    * A method to repair a broken item from the hero's inventory
    * @return void method
    */
    public void repairItem()
    {
        String choice;
        
        customer.getInventory().checkForBrokenItems();

        List<Item> brokenItems = customer.getInventory().getBrokenItems();

        if (brokenItems.size() == 0) //checking if there are any broken items in hero's inventory
        {
            menu.noBrokenItems();
        }
        else
        {   
            customer.getInventory().displayBrokenItems(); //displaying broken items

            menu.whichBrokenItem();

            choice = inp.getIntInput(1, customer.getInventory().getBrokenItems().size());

            if (!choice.equals(Constants.QUIT))
            {
                Item repaired = customer.getInventory().getBrokenItem(choice);

                if (customer.getGold() < repaired.getPrice()/2) //if hero does not have enough gold to repair item
                {
                    menu.cannotBuy();
                }
                else
                {
                    customer.updateGold(repaired.getPrice()/2);
                    repaired.setUsage(); //updating the usage of the item
                    customer.getInventory().getBrokenItems().remove(repaired); //remove item from list of broken items

                    menu.repairedItem();
                }
            }
        }
    }

    /**
    * A method to display potions
    * @return void method
    */
    public void displayPotions()
    {
        int i = 1;
        boolean flag = false;

        menu.title(Constants.POTION);

        while (flag == false)
        {
            i = 1;
            for (PotionDetails p : mf.potionDetails)
            {
                System.out.print("["+ i + "] ");
                System.out.println(p);
                i++;
                System.out.println();
            }

            menu.buyItem(Constants.POTION);

            choice = inp.getIntInput(1, mf.potionDetails.size());

            boolean check = checkQuit(choice);

            if (check)
            {
                break;
            }

            PotionDetails chosenPotion = mf.potionDetails.get(Integer.parseInt(choice)- 1);

            if (chosenPotion.price <= customer.getGold() && chosenPotion.level <= customer.getLevel())
            {
                flag = true;
                Item newPotion = mf.createPotion(chosenPotion);
                mf.potionDetails.remove(chosenPotion);
                buy(newPotion);

                menu.boughtItem(customer.getName(), newPotion.getName());
            }
            else
            {
                menu.cannotBuy();
                flag = false;
            }
        }
    }

    /**
    * A method to display spells
    * @return void method
    */
    public void displaySpells()
    {
        int i = 1;
        boolean flag = false;

        menu.title(Constants.SPELL);

        while (flag == false)
        {
            i = 1;

            for (SpellDetails p : mf.spellDetails)
            {
                System.out.print("["+ i + "] ");
                System.out.println(p);
                i++;
                System.out.println();
            }

            menu.buyItem(Constants.SPELL);

            choice = inp.getIntInput(1, mf.spellDetails.size());

            boolean check = checkQuit(choice);

            if (check)
            {
                break;
            }

            SpellDetails chosenSpell = mf.spellDetails.get(Integer.parseInt(choice)- 1);

            if (chosenSpell.price <= customer.getGold() && chosenSpell.level <= customer.getLevel())
            {
                flag = true;
                Item newSpell = mf.createSpell(chosenSpell);
                mf.spellDetails.remove(chosenSpell);
                buy(newSpell);

                menu.boughtItem(customer.getName(), newSpell.getName());
            }
            else
            {
                menu.cannotBuy();
                flag = false;
            }
        }
    }

    /**
    * A method to display weapons
    * @return void method
    */
    public void displayWeapons()
    {
        int i = 1;
        boolean flag = false;

        menu.title(Constants.WEAPON);

        while (flag == false)
        {
            i = 1;
            for (WeaponryDetails p : mf.weaponryDetails)
            {
                System.out.print("["+ i + "] ");
                System.out.println(p);
                i++;
                System.out.println();
            }

            menu.buyItem(Constants.WEAPON);

            choice = inp.getIntInput(1, mf.weaponryDetails.size());

            boolean check = checkQuit(choice);

            if (check)
            {
                break;
            }

            WeaponryDetails chosenWeapon = mf.weaponryDetails.get(Integer.parseInt(choice)- 1);

            if (chosenWeapon.price <= customer.getGold() && chosenWeapon.level <= customer.getLevel())
            {
                flag = true;
                Item newWeapon = mf.createWeaponry(chosenWeapon);
                mf.weaponryDetails.remove(chosenWeapon);
                buy(newWeapon);

                menu.boughtItem(customer.getName(), newWeapon.getName());
            }
            else
            {
                menu.cannotBuy();
                flag = false;
            }
        }
    }

    /**
    * A method to display armors
    * @return void method
    */
    public void displayArmor()
    {
        int i = 1;
        boolean flag = false;

        menu.title(Constants.ARMOR);

        while (flag == false)
        {
            i = 1;
            for (ArmorDetails p : mf.armorDetails)
            {
                System.out.print("["+ i + "] ");
                System.out.println(p);
                i++;
                System.out.println();
            }

            menu.buyItem(Constants.ARMOR);

            choice = inp.getIntInput(1, mf.armorDetails.size());

            boolean check = checkQuit(choice);

            if (check)
            {
                break;
            }

            ArmorDetails chosenArmor = mf.armorDetails.get(Integer.parseInt(choice)- 1);

            if (chosenArmor.price <= customer.getGold() && chosenArmor.level <= customer.getLevel())
            {
                flag = true;
                Item newArmor = mf.createArmor(chosenArmor);
                mf.armorDetails.remove(chosenArmor);
                buy(newArmor);

                menu.boughtItem(customer.getName(), newArmor.getName());
            }
            else
            {
                menu.cannotBuy();
                flag = false;
            }
        }
    }

    /**
    * A method to create a market factory instance
    * @return void method
    */
    public void createMarketFactoryInstance()
    {
        if (mf == null)
            {
                mf = new MarketFactory();
                mf.createMarket(); //to get items from the market
            }
    }

    public boolean checkQuit(String choice)
    {
        if (choice.toUpperCase().equals(Constants.QUIT))
        {
            return true;
        }
        return false;
    }
}