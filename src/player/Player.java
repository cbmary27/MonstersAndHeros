package player;

import java.util.*;
import world.Tile;
import world.Piece;
import entity.hero.Hero;
import utilities.input.Input;
import utilities.error.Error;
import utilities.constants.Constants;
import item.*;


public class Player{

   public Tile currentPos;
   public Piece<String> playerPiece;
   private List<Hero> party = new ArrayList<Hero>();
   public String choice;
   public Input inp = new Input();
   public Error error = new Error();

   public Player()
   {
      currentPos = new Tile();
      playerPiece = new Piece<String>();
      playerPiece.setValueOnTile("P");
   }

   public List<Hero> getParty()
   {
      return this.party;
   }

   public void getInformation()
   {
      while (true)
      {
         display();
         System.out.println("Select whose inventory you want to see or [Q] Quit");
         choice = inp.stringInput();

         if (!choice.equals("Q") && Integer.parseInt(choice) <= party.size())
         {
            Hero hero =  party.get(Integer.parseInt(choice) - 1);
             //party.get(Integer.parseInt(choice) - 1).openInventory();
             hero.openInventory();

             System.out.println("[U] Use a potion");
             System.out.println("[E] Equip a weapon or armor");
             System.out.println("[UE] Unequip a weapon or armor");
             System.out.println("[Q] QUIT");

            choice = inp.stringInput();

            switch(choice)
            {
                  case Constants.USE:
                        System.out.println("Enter the potion number you want to consume");
                        choice = inp.stringInput();
                        Item item = hero.selectItem(choice);
                        hero.usePotion(item);
                        break;

                  case Constants.EQUIP:
                        System.out.println("Enter the weapon/armor number you want to equip");
                        choice = inp.stringInput();
                        Item item1 = hero.selectItem(choice);
                        if (item1.getType().equals(Constants.WEAPON))
                        {
                           hero.equipWeapon(item1);
                        }
                        else if (item1.getType().equals(Constants.ARMOR))
                        {
                           hero.equipArmor(item1);
                        }
                        break;

                  case Constants.UNEQUIP:
                        System.out.println("Enter the weapon/armor number you want to unequip");
                        choice = inp.stringInput();
                        Item item2 = hero.selectItem(choice);
                        if (item2.getType().equals(Constants.WEAPON))
                        {
                           hero.unEquipWeapon(item2);
                        }
                        else if (item2.getType().equals(Constants.ARMOR))
                        {
                           hero.unEquipArmor(item2);
                        }
                        break;

                  case Constants.QUIT:
                        break;

                  default:
                        error.invalidMove();
            }

            if (choice.equals(Constants.QUIT))
            {
               break;
            }
        }
        else
        {
            if (choice.equals(Constants.QUIT))
            {
               break;
            }        
         }
        System.out.println();
      }
   }

   public void addHero(Hero hero)
   {
      party.add(hero);
   }

   public Hero getHero(String index)
   {
      return party.get(Integer.parseInt(index) - 1);
   }

   public void display()
   {
      int i = 1;
      for (Hero hero: party)
      {
         System.out.println("["+i+"] "+hero);
         i++;
      }      
      System.out.println();
   }
}
