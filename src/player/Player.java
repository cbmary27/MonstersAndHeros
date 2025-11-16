package player;

import java.util.*;
import map.Tile;
import map.Piece;

public class Player{

   public Tile currentPos;
   public Piece<String> playerPiece;

   public Player()
   {
      currentPos = new Tile();
      playerPiece = new Piece<String>();
      playerPiece.setValueOnTile("P");
   }

   //List<Hero> party = new ArrayList<Hero>();

}
