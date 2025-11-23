package menu;

import java.util.*;
import utilities.constants.Constants;
import interfaces.ShowMenu;

public class BattleMenu implements ShowMenu
{
    public void showMenu()
    {
        System.out.println();
        System.out.print("[A] Attack   ");
        System.out.print("[O] Open Inventory   ");
        System.out.print("[F] Forfeit Battle");
        System.out.println();
    }

    public void nextMove(String name)
    {
        System.out.println("Alright " + name + ", what's your move?");
    }

    public void menuChoice()
    {
        System.out.println();
        System.out.println("What would you like to do?");
    }

    public void battleInventoryDisplay()
    {
        System.out.println();
        System.out.print("[P] Use a Potion  ");
        System.out.print("[S] Cast a Spell  ");
        System.out.print("[E] Equip a Weapon/Armor  ");
        System.out.print("[UE] Unequip a Weapon/Armor");
        System.out.println();
    }

    public void whichItem(String itemType)
    {
        switch(itemType)
        {
            case Constants.POTION:
                System.out.println("Which potion do you want to consume?");
                break;
            case Constants.SPELL:
                System.out.println("Which spell do you want to cast?");
                break;
            case Constants.WEAPON:
                System.out.println("Which weapon do you want to use?");
                break;
            case Constants.ARMOR:
                System.out.println("Which armor do you want to equip?");
                break;
        }
    }

    public void whichItemEquip(String itemType)
    {
        switch (itemType)
        {
            case Constants.EQUIP:
                System.out.println("Which weapon/armor do you want to equip?");
                break;
            case Constants.UNEQUIP:
                System.out.println("Which weapon/armor do you want to unequip?");
                break;
        }
    }

    public void chooseWhichTarget()
    {
        System.out.println("Choose your target!");
    }
}