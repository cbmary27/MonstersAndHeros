package menu;

import java.util.*;
import utilities.colour.colour;
import utilities.constants.Constants;

public class InventoryMenu{

    public void inventoryMenu()
    {
        System.out.print("[P] Use a potion");
        System.out.print("  [E] Equip a weapon or armor");
        System.out.print("  [UE] Unequip a weapon or armor");
        System.out.print("  [Q] QUIT");
        System.out.println();
    }

    public void displayInventoryMessage()
    {
        System.out.println(colour.CYAN_BOLD + "Select a hero's inventory to view | [Q] Quit" + colour.RESET);     
    }

    public void useItem(String itemType)
    {
        System.out.println(colour.CYAN_BOLD);
        switch(itemType)
        {
            case Constants.POTION:
                System.out.println("Enter the potion number you want to consume");
                break;
            case Constants.EQUIP:
                System.out.println("Enter the weapon/armor number you want to equip");
                break;
            case Constants.UNEQUIP:
                System.out.println("Enter the weapon/armor number you want to unequip");
                break;
        }
        System.out.println(colour.RESET);
    }

    public void wrongItemIndex()
    {
        System.out.println("That is the wrong index for this type of item!");
    }

    public void cannotUnequip()
    {
        System.out.println("Cannot unequip. Must always have one weapon in inventory!");
        System.out.println();
    }
}