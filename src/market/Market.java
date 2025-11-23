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
    public Error error;
    public String choice;
    private MarketMenu menu;

    public Market()
    {
        inp = new Input();
        error = new Error();
        menu = new MarketMenu();
    }

    public void enter(Hero hero)
    {
        menu.enterMarket();

        while (true) {
            menu.showMenu();
            choice = inp.stringInput().toUpperCase();

            switch(choice)
            {
                case Constants.BUY:
                    menu.buy();
                    createMarketFactoryInstance();
                    display(hero);
                    choice = " ";
                    break;

                case Constants.SELL:
                    menu.sell();
                    createMarketFactoryInstance();
                    sell(hero);
                    choice = " ";
                    break;

                case Constants.QUIT:
                    menu.quit();
                    break;

                default:
                    error.invalidMove();
                    break;
            }

            if (choice.equals(Constants.QUIT))
            {
                break;
            }
            menu.message();
        }
    }

    public void display(Hero hero)
    {
        menu.displayItems();
        choice = inp.stringInput();

        switch(choice)
        {
            case "1":
                displayPotions(hero);
                break;
            case "2":
                displaySpells(hero);
                break;
            case "3":
                displayWeapons(hero);
                break;
            case "4":
                displayArmor(hero);
                break;
            case Constants.QUIT:
                break;
            default:
                error.invalidMove();
        }

    }

    public void buy(Item item, Hero hero)
    {
        hero.getInventory().addItem(item);
        hero.updateGold(item.getPrice());
    }

    public void sell(Hero hero)
    {
        String choice;

        while (true)
        {
            hero.getInventory().display();
            menu.sellItem();
            choice = inp.stringInput();

            if (choice.equals(Constants.QUIT))
            {
                break;
            }

            menu.soldItem();

            Item sold = hero.getInventory().getItem(choice);
            hero.getInventory().dropItem(choice);

            switch(sold.getType())
            {
                case Constants.POTION:
                    Potions potionItem = (Potions) sold;
                    PotionDetails pd = potionItem.toDetails();
                    hero.increaseGold(potionItem.getPrice()/2);
                    mf.potionDetails.add(pd);
                    break;

                case Constants.SPELL:
                    Spells spellItem = (Spells) sold;
                    SpellDetails sd = spellItem.toDetails();
                    hero.increaseGold(spellItem.getPrice()/2);
                    mf.spellDetails.add(sd);
                    break;

                case Constants.WEAPONRY:
                    Weaponry weaponItem = (Weaponry) sold;
                    WeaponryDetails wd = weaponItem.toDetails();
                    hero.increaseGold(weaponItem.getPrice()/2);
                    mf.weaponryDetails.add(wd);
                    break;
                    
                case Constants.ARMOR:
                    Armor armorItem = (Armor) sold;
                    ArmorDetails ad = armorItem.toDetails();
                    hero.increaseGold(armorItem.getPrice()/2);
                    mf.armorDetails.add(ad);
                    break;
            }
        }
    }

    public void displayPotions(Hero hero)
    {
        int i = 1;
        boolean flag = false;

        while (flag == false)
        {
            i = 1;
            for (PotionDetails p : mf.potionDetails)
            {
                System.out.print("["+ i + "]");
                System.out.println(p);
                i++;
                System.out.println();
            }

            menu.buyItem(Constants.POTION);

            choice = inp.stringInput();

            boolean check = checkQuit(choice);

            if (check)
            {
                break;
            }

            PotionDetails chosenPotion = mf.potionDetails.get(Integer.parseInt(choice)- 1);

            if (chosenPotion.price <= hero.getGold() && chosenPotion.level <= hero.getLevel())
            {
                flag = true;
                Item newPotion = mf.createPotion(chosenPotion);
                mf.potionDetails.remove(chosenPotion);
                buy(newPotion, hero);

                menu.boughtItem(hero.getName(), newPotion.getName());
            }
            else
            {
                menu.cannotBuy();
                flag = false;
            }
        }
    }

    public void displaySpells(Hero hero)
    {
        int i = 1;
        boolean flag = false;

        while (flag == false)
        {
            i = 1;
            for (SpellDetails p : mf.spellDetails)
            {
                System.out.print("["+ i + "]");
                System.out.println(p);
                i++;
                System.out.println();
            }

            menu.buyItem(Constants.SPELL);

            choice = inp.stringInput();

            boolean check = checkQuit(choice);

            if (check)
            {
                break;
            }

            SpellDetails chosenSpell = mf.spellDetails.get(Integer.parseInt(choice)- 1);

            if (chosenSpell.price <= hero.getGold() && chosenSpell.level <= hero.getLevel())
            {
                flag = true;
                Item newSpell = mf.createSpell(chosenSpell);
                mf.potionDetails.remove(chosenSpell);
                buy(newSpell, hero);

                menu.boughtItem(hero.getName(), newSpell.getName());
            }
            else
            {
                menu.cannotBuy();
                flag = false;
            }
        }
    }

    public void displayWeapons(Hero hero)
    {
        int i = 1;
        boolean flag = false;

        while (flag == false)
        {
            i = 1;
            for (WeaponryDetails p : mf.weaponryDetails)
            {
                System.out.print("["+ i + "]");
                System.out.println(p);
                i++;
                System.out.println();
            }

            menu.buyItem(Constants.WEAPON);

            choice = inp.stringInput();

            boolean check = checkQuit(choice);

            if (check)
            {
                break;
            }

            WeaponryDetails chosenWeapon = mf.weaponryDetails.get(Integer.parseInt(choice)- 1);

            if (chosenWeapon.price <= hero.getGold() && chosenWeapon.level <= hero.getLevel())
            {
                flag = true;
                Item newWeapon = mf.createWeaponry(chosenWeapon);
                mf.weaponryDetails.remove(chosenWeapon);
                buy(newWeapon, hero);

                menu.boughtItem(hero.getName(), newWeapon.getName());
            }
            else
            {
                menu.cannotBuy();
                flag = false;
            }
        }

    }

    public void displayArmor(Hero hero)
    {
        int i = 1;
        boolean flag = false;

        while (flag == false)
        {
            i = 1;
            for (ArmorDetails p : mf.armorDetails)
            {
                System.out.print("["+ i + "]");
                System.out.println(p);
                i++;
                System.out.println();
            }

            menu.buyItem(Constants.ARMOR);

            choice = inp.stringInput();

            boolean check = checkQuit(choice);

            if (check)
            {
                break;
            }

            ArmorDetails chosenArmor = mf.armorDetails.get(Integer.parseInt(choice)- 1);

            if (chosenArmor.price <= hero.getGold() && chosenArmor.level <= hero.getLevel())
            {
                flag = true;
                Item newArmor = mf.createArmor(chosenArmor);
                mf.armorDetails.remove(chosenArmor);
                buy(newArmor, hero);

                menu.boughtItem(hero.getName(), newArmor.getName());
            }
            else
            {
                menu.cannotBuy();
                flag = false;
            }
        }

    }

    public void createMarketFactoryInstance()
    {
        if (mf == null)
            {
                mf = new MarketFactory();
                mf.createMarket();
            }
    }

    public boolean checkQuit(String choice)
    {
        if (choice.toUpperCase().equals(Constants.QUIT))
        {
            return false;
        }
        return true;
    }
}