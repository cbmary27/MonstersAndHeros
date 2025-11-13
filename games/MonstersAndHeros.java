package games;

import java.util.*;
import instructions.Instructions;

public class MonsterAndHeros extends Games{
    Instructions i;

    public void start()
    {
        i.displayMonstersAndHeros();
        setUpGame();

    }

    public void setUpGame()
    {
        System.out.println("Time to assemble your league!");
        displayHerosMenu();
        System.out.println("How many heros will accompany you on your journey?");
    }

    public void displayHerosMenu()
    {
        //display 3 heros and their strengths/weaknesses
    
    }
}