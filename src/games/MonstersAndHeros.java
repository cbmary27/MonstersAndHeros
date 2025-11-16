package games;

import java.util.*;
import utilities.*;
//import instructions.Instructions;
import map.Map;
import player.Player;
import fileparser.FileParser;
//import input.Input;
import entity.hero.HeroFactory;

public class MonstersAndHeros extends Games{
    public FileParser file;
    public HeroFactory hf = new HeroFactory();

    public MonstersAndHeros()
    {
        map = new Map(8, 8);
        player.currentPos.row = 7;
        player.currentPos.col = 7;
    }

    public void start()
    {
        String ch;
        boolean flag = false;
        i.displayMonstersAndHeros();
        setUpGame();
        map.initializeMap();
        //player can start moving here
        System.out.println("Enter your move: (W/A/S/D)");
        ch = inp.stringInput();

        while (flag == false)
        {
            System.out.println("Enter your move: (W/A/S/D)");
            ch = inp.stringInput();
            flag = checkInput(ch);

            if (flag == false)
            {
                error.invalidMove();
            }
            else
            {
                flag = map.isMoveLegal(ch, player.currentPos);
                if (flag == false)
                {
                    error.invalidMove();
                }
            }
        }


        switch(ch)
        {

        }

    }

    public void setUpGame()
    {
        int choice;
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