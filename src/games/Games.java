package games;

import java.util.*;
import utilities.error.Error;
import utilities.instructions.Instructions;
import utilities.constants.Constants;
import utilities.input.Input;
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
        switch(input.toUpperCase())
        {
            case Constants.W:
            case Constants.A:
            case Constants.S:
            case Constants.D:
            case Constants.M:
            case Constants.I:
            case Constants.QUIT:
                return true;
            default:
                return false;
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
        System.out.println("[M] - enter Market");
        System.out.println("[I] - Information");
        System.out.println("[Q] - Quit");
    }

    public boolean checkHPOfParty()
    {
        for (Hero hero : player.getParty())
        {
            if (hero.getHP() == 0)
            {
                return false;
            }
        }
        return true;
    }
}