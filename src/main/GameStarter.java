package main;

import java.util.*;

import input.Input;
import games.*;

public class GameStarter{

    public void loadGame()
    {
        Games obj = new MonsterAndHeros;
        obj.start();
        //System.out.println("Choose your Heros!");
    }
}