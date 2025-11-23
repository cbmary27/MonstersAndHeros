package menu;

import java.util.*;
import interfaces.ShowMenu;

public class GameMenu implements ShowMenu
{
    @Override
    public void showMenu()
    {
        System.out.println("[W] - move up");
        System.out.println("[A] - move left");
        System.out.println("[S] - move right");
        System.out.println("[D] - move down");
        System.out.println("[M] - enter Market");
        System.out.println("[I] - Information");
        System.out.println("[Q] - Quit");
    }

    public void enterMove()
    {
        System.out.println("Enter your move:");
    }

    public void playAgain()
    {
        System.out.println();
        System.out.println("Do you want to play again?");
        System.out.println("[Y] [N]");
    }

    public void assembleParty()
    {
        System.out.println();
        System.out.println("Time to assemble your league!");
        System.out.println();
    }

    public void numberOfHeros()
    {
        System.out.println();
        System.out.println("How many heros will accompany you on your journey?");
        System.out.println("Your party can either have 1, 2 or 3 heros!");
    }

    public void initialMarket()
    {
        System.out.println("~ Would you like to buy/sell anything at the market? ~");
        System.out.println("[Y] [N]");
    }

    public void whichHeroMarket()
    {
        System.out.println();
        System.out.println("Who will be going to the market?");
    }

    public void optionMarket()
    {
        System.out.println("Do you want to visit the market again?");
        System.out.println("[Y] [N]");
    }

    public void complimentaryMessage()
    {
        System.out.println("Now...we don't want your heros out in the wild without a weapon now, do we?");
        System.out.println("Here's a complimentary weapon to get you started! (and keep you safe from the monsters)");
    }

}