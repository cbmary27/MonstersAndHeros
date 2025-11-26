/**
 * Filename: Player.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-20
 * Description: A class for Player and its functionalities
 */

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

   /**
    * A method to get the information of the party of heroes to display to the player
    * @return void method
    */
   public void getInformation()
   {
      while (true)
      {
         menu.lineBreak();
         display();
         menu.displayInventoryMessage();
         choice = inp.getIntInput(1, party.size());

         if (choice.equals(Constants.QUIT))
         {
            break;
         }
       
         Hero hero =  party.get(Integer.parseInt(choice) - 1);
         hero.openInventory(); //opens the hero's inventory
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
