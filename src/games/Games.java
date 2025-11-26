/**
 * Filename: Games.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-14
 * Description: An abstract class for Games
 */

package games;

import java.util.*;
import utilities.error.Error;
import utilities.instructions.Instructions;
import utilities.constants.Constants;
import utilities.input.Input;
import menu.GameMenu;
import player.Player;
import entity.hero.*;
import world.World;

public abstract class Games{

    public Error error;
    public Instructions i;
    public Input inp;
    public World world;
    public Player player;
    public boolean isGameDone;
    public String continueGame;
    public GameMenu gmenu;

    public Games()
    {
        gmenu = new GameMenu();
        error = new Error();
        i = new Instructions();
        inp = new Input();
        player = new Player();
        isGameDone = false;
    }

    public abstract void start();

    /**
    * A method to check the input of the player for moving across the map
    * @param input the input of the player
    * @return a boolean value to indicate whether its a valid move or not
    */
    public boolean checkInput(String input)
    {
        switch(input.toUpperCase())
        {
            case Constants.UP:
            case Constants.LEFT:
            case Constants.DOWN:
            case Constants.RIGHT:
            case Constants.MARKET:
            case Constants.INFORMATION:
            case Constants.QUIT:
                return true;
            default:
                return false;
        }
    }

    /**
    * A method to restore game details if the player wants to play again
    * @return void method
    */
    public void restore()
    {
        player.getParty().clear();
        isGameDone = false;
    }

    public void displayOptions()
    {
        gmenu.showMenu();
    }
}