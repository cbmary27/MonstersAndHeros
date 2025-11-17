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