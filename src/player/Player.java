package player;

import java.util.*;
import world.Tile;
import world.Piece;
import entity.hero.Hero;
import utilities.input.Input;
import utilities.error.Error;

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

   public void getInformation()
   {
      while (true)
      {
         display();
         System.out.println("Select whose inventory you want to see or [Q] Quit");
         choice = inp.stringInput();

         if (!choice.equals("Q") && Integer.parseInt(choice) <= party.size())
         {
            party.get(Integer.parseInt(choice) - 1).getInventory().display();
         }
         else if (choice.equals("Q"))
         {
            break;
         }
         else
         {
            error.invalidMove();
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
