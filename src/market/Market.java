package market;

import java.util.*;
import utilities.error.Error;
import utilities.input.Input;
import entity.hero.*;
import item.*;
import fileparser.PotionDetails;
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
                    if (mf == null)
                    {
                        mf = new MarketFactory();
                        mf.createMarket();
                    }
                    display(hero);
                    break;

                case "S":
                    System.out.println("Alright! Show me what you got!");
                    sell(hero.getInventory());
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

    public void sell(Inventory inventory)
    {
        
    }

    public void displayPotions(Hero hero)
    {
        int i = 1;
        boolean flag = false;

        while (flag == false)
        {
            for (PotionDetails p : mf.potionDetails)
            {
                System.out.println("["+ i + "]");
                System.out.print(p);
                i++;
            }
            System.out.println("[Q] Quit");
            System.out.println("Which potion do you want to buy?");
            choice = inp.stringInput();

            if (choice.toUpperCase().equals("Q"))
            {
                break;
            }

            PotionDetails chosenPotion = mf.potionDetails.get(Integer.parseInt(choice)- 1);

            if (chosenPotion.price <= hero.getGold() || chosenPotion.level > hero.getLevel())
            {
                flag = true;
                Item newPotion = mf.createPotion(chosenPotion);
                mf.potionDetails.remove(chosenPotion);
                buy(newPotion, hero);
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

    }

    public void displayWeapons(Hero hero)
    {

    }

    public void displayArmor(Hero hero)
    {

    }
}