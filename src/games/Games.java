package games;

import java.util.*;
import utilities.*;

public abstract class Games{

    public Error error;
    public Instructions i;
    public Input inp;
    public Map map;
    public Player player;

    public Games()
    {
        error = new Error();
        i = new Instructions();
        inp = new Input();
        player = new Player();
    }

    public checkInput(String input)
    {
        if (ch.equals("W") || ch. equals("S") || ch.equals("A") || ch.equals("D"))
        {
            return true;
        }
        return false;
    }
}