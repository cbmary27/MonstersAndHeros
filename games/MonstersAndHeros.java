package games;

import java.util.*;
import instructions.Instructions;

public class MonsterAndHeros extends Games{
    Instructions i;
    Input inp;
    Player player;
    Map map;
    FileParser file;

    public MonsterAndHeros()
    {
        i = new Instructions();
        inp = new Input();
        player = new Player();
        map = new Map();
    }

    public void start()
    {
        i.displayMonstersAndHeros();
        setUpGame();
    }

    public void setUpGame()
    {
        String choice;
        System.out.println("Time to assemble your league!");
        getHeros();
        System.out.println("How many heros will accompany you on your journey?");
        choice = inp.integerInput();
        //display heros from file parser
        //call party of heros to create the objects
        //store in list of player
    }

    public void getHeros()
    {
        List<String> heroNames = new ArrayList<>();
        file = new FileParser();

        System.out.println("Paladins:");

        heroNames = file.get("Paladins");
        displayHerosMenu(heroNames);

        System.out.println();
        System.out.println("Warriors:");

        heroNames = file.get("Warriors");

        displayHerosMenu(heroNames);

        System.out.println();
        System.out.println("Sorcerors:");

        heroNames = file.get("Sorcerers");
        displayHerosMenu(heroNames);

        //display 3 heros and their strengths/weaknesses
    
    }

    public void displayHerosMenu(List<String> names)
    {
        System.out.println();
        for (String name: names)
        {
            System.out.println(name);
        }

    }
}