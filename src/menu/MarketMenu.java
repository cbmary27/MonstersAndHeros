package menu;

import java.util.*;
import interfaces.ShowMenu;

public class MarketMenu implements ShowMenu
{
    public void enterMarket()
    {
        System.out.println("~ Entering the market! ~");
        System.out.println("What brings you here?");
        System.out.println();

    }

    public void showMenu()
    {
        System.out.println("Buy [B] | Sell [S] | Quit [Q]");
        System.out.println();
    }

    public void buy()
    {
        System.out.println("Take a look at what we offer!");
        System.out.println();
    }

    public void sell()
    {
        System.out.println("Alright! Show me what you got!");
        System.out.println();
    }

    public void quit()
    {
        System.out.println("Come again soon!");
        System.out.println();
    }

    public void buyItem(String itemType)
    {
        System.out.println("[Q] Quit");
        System.out.println("Which " + itemType + " do you want to buy?");
    }

    public void boughtItem(String name, String itemType)
    {
        System.out.println(name + " bought " + itemType + "!");
        System.out.println();
    }

    public void sellItem()
    {
        System.out.println("What do you want to sell? or [Q] Quit");
        System.out.println();
    }

    public void soldItem()
    {
        System.out.println("That's a very valuable item, thanks!");
        System.out.println();
    }

    public void displayItems()
    {
        System.out.println("[1] Potions");
        System.out.println("[2] Spells");
        System.out.println("[3] Weapons");
        System.out.println("[4] Armor");
        System.out.println("[Q] Quit");
        System.out.println();

        System.out.println("What would you like to take a look at?"); 
    }

    public void cannotBuy()
    {
        System.out.println("Not enough gold or not the required level!");
        System.out.println();
    }

    public void message()
    {
        System.out.println("What else can I do for you today?");
    }

    public void title(String itemType)
    {
        System.out.println();
        System.out.println(" --------------------");
        System.out.println("|      " + itemType + "s" + "     |");
        System.out.println(" --------------------");
    }

    public void showGold(String name, int gold)
    {
        System.out.println(name + "'s gold : " + gold);
        System.out.println();
    }

}