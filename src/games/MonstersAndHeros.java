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
    public Market market;

    public MonstersAndHeros()
    {
        map = new Map(8, 8);
        player.currentPos.row = 7;
        player.currentPos.col = 7;
    }

    @Override
    public void start()
    {
        String ch;
        boolean flag = false;
        i.displayMonstersAndHeros();
        setUpGame();
        map.initializeMap();

        do {
            while (!isGameDone)
            {
                while (flag == false)
                {
                    displayOptions();
                    System.out.println("Enter your move:");
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

                switch(ch.toUpperCase())
                {
                    case "W":
                    case "A":
                    case "S":
                    case "D":
                        flag = map.isMoveLegal(ch, player.currentPos);
                        if (flag == false)
                        {
                            error.invalidMove();
                            break;
                        }
                        map.makeMove(player, ch);
                        typeOfMove();
                        break;
                    case "I":
                        break;
                    case "Q":
                        isGameDone = true;
                        break;
                    default:
                        flag = false;
                        error.invalidMove();
                }

                if (flag)
                {
                    map.printMap();
                }
            }

            restore();
            System.out.println("Do you want to play again?");
            System.out.println("[Y] [N]");
            continue = inp.stringInput().toUpperCase();

        } while(continue.equals("Y"));
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

    public void typeOfMove()
    {
        String choice;

        switch(grid[player.currentPos.getRow()][player.currentPos.getColumn()].tileVal.getValueOnTile())
        {
            case "M":
                System.out.println("~ Would you like to buy/sell anything at the market? ~");
                choice = inp.stringInput().toUpperCase();
                if (choice.equals("Y"))
                {
                    //display the party of heros, player will select which hero has to go to market
                    if (market == null)
                    {
                        market = new Market();
                    }
                    market.enter();
                }
                break;
            case " ":
                randomChoice = random.randint(0,1);
                if (randomChoice == 1)
                {
                    //battle begins
                }
        }
    }
}