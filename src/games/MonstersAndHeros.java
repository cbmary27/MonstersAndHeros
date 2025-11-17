package games;

import java.util.*;
import fileparser.FileParser;
import entity.hero.HeroFactory;
import world.World;

public class MonstersAndHeros extends Games{
    public FileParser file;
    public HeroFactory hf = new HeroFactory();
    //public Market market;

    public MonstersAndHeros()
    {
        world = new World(8, 8);
        player.currentPos.setRow(7);
        player.currentPos.setColumn(7);
    }

    @Override
    public void start()
    {
        String ch = "";
        boolean flag = false;
        i.displayMonstersAndHeros();
        setUpGame();
        world.initializeMap();
        world.printMap();

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
                }

                switch(ch.toUpperCase())
                {
                    case "W":
                    case "A":
                    case "S":
                    case "D":
                        flag = world.isMoveLegal(ch, player.currentPos);
                        if (flag == false)
                        {
                            error.invalidMove();
                            break;
                        }
                        world.makeMove(player, ch);
                        typeOfMove();
                        break;
                    case "I":
                        player.getInformation();
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
                    world.printMap();
                }
                flag = false;
            }

            restore();
            System.out.println("Do you want to play again?");
            System.out.println("[Y] [N]");
            continueGame = inp.stringInput().toUpperCase();

        } while(continueGame.equals("Y"));
    }

    public void setUpGame()
    {
        String choice;
        System.out.println("Time to assemble your league!");
        //getHeros();
        System.out.println("How many heros will accompany you on your journey?");
        System.out.println("Your party can either have 1, 2 or 3 heros!");
        choice = inp.stringInput();

        player.addHero(hf.createHero("Eunoia_Cyn", "Warriors"));
        player.addHero(hf.createHero("Amaryllis_Astra", "Paladins"));

        player.getInformation();
    }

    // public void getHeros()
    // {
    //     List<String> heroNames = new ArrayList<>();
    //     file = new FileParser();

    //     System.out.println("Paladins: favoured for their strength and dexterity");

    //     heroNames = file.get("Paladins");
    //     displayHerosMenu(heroNames);

    //     System.out.println();
    //     System.out.println("Warriors: favoured for their strength and agility");

    //     heroNames = file.get("Warriors");

    //     displayHerosMenu(heroNames);

    //     System.out.println();
    //     System.out.println("Sorcerors: favoured for their dexterity and agility");

    //     heroNames = file.get("Sorcerers");
    //     displayHerosMenu(heroNames);

    //     //display 3 heros and their strengths/weaknesses
    
    // }

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

        int i = player.currentPos.getRow();
        int j = player.currentPos.getColumn();

        switch(world.grid[i][j].tileVal.getValueOnTile())
        {
            case "M":
                System.out.println("~ Would you like to buy/sell anything at the market? ~");
                System.out.println("[Y] [N]");

                choice = inp.stringInput().toUpperCase();
                while (true)
                {
                    if (choice.equals("Y"))
                    {
                        //display the party of heros, player will select which hero has to go to market
                        player.display();
                        System.out.println("Who will be going to the market?");
                        choice = inp.stringInput();

                        world.grid[i][j].getMarketInstance();
                        world.grid[i][j].market.enter(player.getHero(choice));

                        System.out.println("Do you want to visit the market again?");
                        System.out.println("[Y] [N]");
                        choice = inp.stringInput();
                    }
                    else
                    {
                        break;
                    }
                }
                break;
            case " ":
                Random random = new Random();
                int randomChoice = random.nextInt(2);
                if (randomChoice == 1)
                {
                    //battle begins
                }
        }
    }
}