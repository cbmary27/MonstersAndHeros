package player;

import java.util.*;
import world.Tile;
import world.Piece;
import entity.hero.Hero;
import utilities.input.Input;
import utilities.error.Error;
import utilities.constants.Constants;
import menu.InventoryMenu;
import item.*;


public class Player{

   public Tile currentPos;
   public Piece<String> playerPiece;
   private List<Hero> party = new ArrayList<Hero>();
   public String choice;
   public Input inp = new Input();
   public Error error = new Error();
   public InventoryMenu menu;

   public Player()
   {
      currentPos = new Tile();
      playerPiece = new Piece<String>();
      playerPiece.setValueOnTile(Constants.PARTY);
      menu = new InventoryMenu();
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
         menu.displayInventoryMessage();
         choice = inp.stringInput();

         if (!choice.equals(Constants.QUIT) && Integer.parseInt(choice) <= party.size())
         {
            Hero hero =  party.get(Integer.parseInt(choice) - 1);
            hero.openInventory();
            menu.inventoryMenu();
            choice = inp.stringInput();

            switch(choice)
            {
                  case Constants.USE:
                        menu.useItem(Constants.POTION);
                        choice = inp.stringInput();
                        Item item = hero.selectItem(choice);
                        hero.usePotion(item);
                        break;

                  case Constants.EQUIP:
                        menu.useItem(Constants.EQUIP);
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
                        menu.useItem(Constants.UNEQUIP);
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
