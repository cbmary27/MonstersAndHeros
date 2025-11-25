package menu;

import java.util.*;
import utilities.constants.Constants;
import utilities.colour.colour;
import interfaces.ShowMenu;

public class BattleMenu implements ShowMenu
{
    @Override
    public void showMenu()
    {
        System.out.println(colour.WHITE_BOLD);
        System.out.print("[A] Attack   ");
        System.out.print("[O] Open Inventory   ");
        System.out.print("[F] Forfeit Battle");
        System.out.println(colour.RESET);
    }

    public void nextMove(String name)
    {
        System.out.println(colour.WHITE_BOLD);
        System.out.println("Alright " + name + ", what's your move?" + colour.RESET);
    }

    public void menuChoice()
    {
        System.out.println(colour.WHITE_BOLD);
        System.out.println("What would you like to do?" + colour.RESET);
    }

    public void battleInventoryDisplay()
    {
        System.out.println(colour.WHITE_BOLD);
        System.out.print("[P] Use a Potion  ");
        System.out.print("[S] Cast a Spell  ");
        System.out.print("[E] Equip a Weapon/Armor  ");
        System.out.print("[UE] Unequip a Weapon/Armor" + colour.RESET);
        System.out.println();
    }

    public void whichItem(String itemType)
    {
        System.out.println(colour.WHITE_BOLD);
        switch(itemType)
        {
            case Constants.POTION:
                System.out.print("Which potion do you want to consume?");
                break;
            case Constants.SPELL:
                System.out.print("Which spell do you want to cast?");
                break;
            case Constants.WEAPON:
                System.out.print("Which weapon do you want to use?");
                break;
            case Constants.ARMOR:
                System.out.print("Which armor do you want to equip?");
                break;
        }
        System.out.println(colour.RESET);
    }

    public void whichItemEquip(String itemType)
    {
        switch (itemType)
        {
            case Constants.EQUIP:
                System.out.println(colour.WHITE_BOLD + "Which weapon/armor do you want to equip?" + colour.RESET);
                break;
            case Constants.UNEQUIP:
                System.out.println(colour.WHITE_BOLD + "Which weapon/armor do you want to unequip?" + colour.RESET);
                break;
        }
    }

    public void chooseWhichTarget(String name)
    {
        System.out.println(colour.WHITE_BOLD + name + ", choose your target!" + colour.RESET);
    }

    public void weaponBroken()
    {
        System.out.println(colour.WHITE_BOLD + "This weapon is broken!" + colour.RESET);
    }

    public void allWeaponsBroken()
    {
        System.out.println(colour.WHITE_BOLD + "All weapons are broken, you cannot attack!" + colour.RESET);
    }
}