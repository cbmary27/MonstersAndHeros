package menu;

import java.util.*;
import interfaces.ShowMenu;
import utilities.colour.colour;

public class MarketMenu implements ShowMenu
{
    public void enterMarket()
    {
        System.out.println();
        System.out.println(" ----------------------------------");
        System.out.println("|             ~ MARKET ~           |");
        System.out.println(" ----------------------------------");  
        System.out.println(colour.YELLOW + "What brings you here?" + colour.RESET);
        System.out.println();
    }

    public void showMenu()
    {
        System.out.println(colour.YELLOW + "Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]" + colour.RESET);
        System.out.println();
    }

    public void buy()
    {
        System.out.println(colour.YELLOW + "Take a look at what we offer!" + colour.RESET);
        System.out.println();
    }

    public void sell()
    {
        System.out.println(colour.YELLOW + "Alright! Show me what you got!" + colour.RESET );
        System.out.println();
    }

    public void repair()
    {
        System.out.println(colour.YELLOW + "Sure! Show me the broken goods!" + colour.RESET);
        System.out.println();
    }

    public void noBrokenItems()
    {
        System.out.println(colour.YELLOW + "Seems like you have no items to repair!" + colour.RESET);
        System.out.println();
    }

    public void whichBrokenItem()
    {
        System.out.println(colour.YELLOW + "Which item would you like to repair? or [Q] Quit" + colour.RESET);
    }

    public void quit()
    {
        System.out.println(colour.YELLOW + "Come again soon!" + colour.RESET);
        System.out.println();
    }

    public void buyItem(String itemType)
    {
        System.out.println("[Q] Quit");
        System.out.println();
        System.out.println(colour.YELLOW + "Which " + itemType + " do you want to buy?" + colour.RESET);
    }

    public void boughtItem(String name, String itemType)
    {
        System.out.println();
        System.out.println(colour.YELLOW  + name + " bought " + itemType + "!" + colour.RESET);
        System.out.println();
    }

    public void sellItem()
    {
        System.out.println(colour.YELLOW + "What do you want to sell? or [Q] Quit" + colour.RESET);
        System.out.println();
    }

    public void repairItem()
    {
        System.out.println(colour.YELLOW + "What do you want to repair? or [Q] Quit" + colour.RESET);
        System.out.println();
    }

    public void soldItem()
    {
        System.out.println(colour.YELLOW + "That's a very valuable item, thanks!" + colour.RESET);
        System.out.println();
    }

    public void repairedItem()
    {
        System.out.println("...");
        System.out.println("...");
        System.out.println(colour.YELLOW + "Tada! All brand new!" + colour.RESET);
        System.out.println();
    }

    public void displayItems()
    {
        System.out.println(colour.YELLOW + "[1] Potions");
        System.out.println("[2] Spells");
        System.out.println("[3] Weapons");
        System.out.println("[4] Armor");
        System.out.println("[Q] Quit");
        System.out.println();

        System.out.println("What would you like to take a look at?" + colour.RESET); 
    }

    public void cannotBuy()
    {
        System.out.println(colour.YELLOW + "Not enough gold or not the required level!" + colour.RESET);
        System.out.println();
    }

    public void cannotSell()
    {
        System.out.println(colour.YELLOW + "Ah, looks like you have only one weapon! Better hold on to that!" + colour.RESET);
        System.out.println();
    }

    public void message()
    {
        System.out.println(colour.YELLOW + "What else can I do for you today?" + colour.RESET);
    }

    public void title(String itemType)
    {
        System.out.println();
        System.out.println(" --------------------");
        System.out.println("|      " + itemType + "s" + "      1|");
        System.out.println(" --------------------");
    }

    public void showGold(String name, int gold)
    {
        System.out.println(name + "'s gold : " + colour.GREEN_BOLD + gold + colour.RESET);
        System.out.println();
    }

}