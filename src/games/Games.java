package games;

import java.util.*;
import utilities.*;

public abstract class Games{

    public Error error;
    public Instructions i;
    public Input inp;
    public Map map;
    public Player player;
    public boolean isGameDone;
    public String continue;

    public Games()
    {
        error = new Error();
        i = new Instructions();
        inp = new Input();
        player = new Player();
        isGameDone = false;
    }

    public abstract void start();

    public boolean checkInput(String input)
    {
        switch(ch)
        {
            switch(ch.toUpperCase())
            {
                case "W":
                case "A":
                case "S":
                case "D":
                case "I":
                case "Q":
                    return true;
                default:
                    return false;
            }
        }
    }

    public void restore()
    {

    }

    public void displayOptions()
    {
        System.out.println("[W] - move up");
        System.out.println("[A] - move left");
        System.out.println("[S] - move right");
        System.out.println("[D] - move down");
        System.out.println("[I] - Information");
        System.out.println("[Q] - Quit");
    }
}