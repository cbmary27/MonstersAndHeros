/**
 * Filename: GameStarter.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-14
 * Description: A class for initialzing an object of a game
 */

package main;

import java.util.*;

import utilities.input.Input;
import games.*;

public class GameStarter{

    public void loadGame()
    {
        Games obj = new MonstersAndHeros();
        obj.start();
        //System.out.println("Choose your Heros!");
    }
}