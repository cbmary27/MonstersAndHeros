package market;

import java.util.*;
import utilities.error.Error;
import utilities.input.Input;
import entity.hero.*;
import item.*;
import fileparser.*;
import inventory.Inventory;

public class Market{

    public MarketFactory mf;
    public Input inp;
    public Error error;
    public String choice;

    public Market()
    {
        inp = new Input();
        error = new Error();
    }

    public void enter(Hero hero)
    {
        System.out.println("~ Entering the market! ~");
        System.out.println("What brings you here?");

        while (true) {
            System.out.println("Buy [B] | Sell [S] | Quit [Q]");
            choice = inp.stringInput().toUpperCase();

            switch(choice)
            {
                case "B":
                    System.out.println("Take a look at what we offer!");
                    createMarketFactoryInstance();
                    display(hero);
                    choice = " ";
                    break;

                case "S":
                    System.out.println("Alright! Show me what you got!");
                    createMarketFactoryInstance();
                    sell(hero);
                    choice = " ";
                    break;

                case "Q":
                    System.out.println("Come again soon!");
                    break;

                default:
                    error.invalidMove();
                    break;
            }

            if (choice.equals("Q"))
            {
                break;
            }
            System.out.println("What else can I do for you today?");
        }
    }

    public void display(Hero hero)
    {
        System.out.println("[1] Potions");
        System.out.println("[2] Spells");
        System.out.println("[3] Weapons");
        System.out.println("[4] Armor");
        System.out.println("[Q] Quit");

        System.out.println("What would you like to take a look at?");        
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
            case "Q":
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
            System.out.println("What do you want to sell? or [Q] Quit");
            choice = inp.stringInput();

            if (choice.equals("Q"))
            {
                break;
            }

            System.out.println("That's a very valuable item, thanks!");
            Item sold = hero.getInventory().getItem(choice);
            hero.getInventory().dropItem(choice);

            switch(sold.getType())
            {
                case "Potion":
                    Potions potionItem = (Potions) sold;
                    PotionDetails pd = potionItem.toDetails();
                    hero.increaseGold(potionItem.getPrice()/2);
                    mf.potionDetails.add(pd);
                    break;
                case "Spell":
                    Spells spellItem = (Spells) sold;
                    SpellDetails sd = spellItem.toDetails();
                    hero.increaseGold(spellItem.getPrice()/2);
                    mf.spellDetails.add(sd);
                    break;
                case "Weaponry":
                    Weaponry weaponItem = (Weaponry) sold;
                    WeaponryDetails wd = weaponItem.toDetails();
                    hero.increaseGold(weaponItem.getPrice()/2);
                    mf.weaponryDetails.add(wd);
                    break;
                case "Armor":
                    Armor armorItem = (Armor) sold;
                    ArmorDetails ad = armorItem.toDetails();
                    hero.increaseGold(armorItem.getPrice()/2);
                    mf.armorDetails.add(ad);
                    break;
            }
        }

        System.out.println();
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

            System.out.println("[Q] Quit");
            System.out.println("Which potion do you want to buy?");
            choice = inp.stringInput();

            if (choice.toUpperCase().equals("Q"))
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
                System.out.println(hero.getName()+ " bought " + newPotion.getName() + "!");
                System.out.println();
            }
            else
            {
                System.out.println("Not enough gold or not the required level!");
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

            System.out.println("[Q] Quit");
            System.out.println("Which spell do you want to buy?");
            choice = inp.stringInput();

            if (choice.toUpperCase().equals("Q"))
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
                System.out.println(hero.getName()+ " bought " + newSpell.getName() + "!");
                System.out.println();
            }
            else
            {
                System.out.println("Not enough gold or not the required level!");
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

            System.out.println("[Q] Quit");
            System.out.println("Which weapon do you want to buy?");
            choice = inp.stringInput();

            if (choice.toUpperCase().equals("Q"))
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
                System.out.println(hero.getName()+ " bought " + newWeapon.getName() + "!");
                System.out.println();
            }
            else
            {
                System.out.println("Not enough gold or not the required level!");
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

            System.out.println("[Q] Quit");
            System.out.println("Which armor do you want to buy?");
            choice = inp.stringInput();

            if (choice.toUpperCase().equals("Q"))
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
                System.out.println(hero.getName()+ " bought " + newArmor.getName() + "!");
                System.out.println();
            }
            else
            {
                System.out.println("Not enough gold or not the required level!");
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
}