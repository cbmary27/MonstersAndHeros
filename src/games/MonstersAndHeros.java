package games;

import java.util.*;
import fileparser.FileParser;
import entity.hero.HeroFactory;
import utilities.constants.Constants;
import world.World;
import battle.Battle;

public class MonstersAndHeros extends Games{
    public FileParser file;
    public HeroFactory hf = new HeroFactory();
    public Battle battle;
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
                    case Constants.W:
                    case Constants.A:
                    case Constants.S:
                    case Constants.D:
                        flag = world.isMoveLegal(ch, player.currentPos);
                        if (flag == false)
                        {
                            error.invalidMove();
                            break;
                        }
                        world.makeMove(player, ch);
                        typeOfMove();
                        break;
                    case Constants.M:
                        initializeMarket();
                        break;
                    case Constants.I:
                        player.getInformation();
                        break;
                    case Constants.QUIT:
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

        } while(continueGame.equals(Constants.Y));
    }

    public void setUpGame()
    {
        int i = 0;
        String choice;
        System.out.println();
        System.out.println("Time to assemble your league!");
        System.out.println();

        List<String> heros = hf.getHeros();
        System.out.println();
        System.out.println("How many heros will accompany you on your journey?");
        System.out.println("Your party can either have 1, 2 or 3 heros!");
        choice = inp.stringInput();

        while ( i < Integer.parseInt(choice))
        {
            player.addHero(hf.createHero(heros.get(i), hf.types.get(i)));
            i++;
        }

        System.out.println();

        player.getInformation();
    }

    public void typeOfMove()
    {
        String choice;

        int i = player.currentPos.getRow();
        int j = player.currentPos.getColumn();

        switch(world.grid[i][j].tileVal.getValueOnTile())
        {
            case " ":
                Random random = new Random();
                int randomChoice = random.nextInt(2);
                if (randomChoice == 1)
                {
                    battle = new Battle();
                    battle.fight();
                }
        }
    }

    public void initializeMarket()
    {
        String choice = "";

        int i = player.currentPos.getRow();
        int j = player.currentPos.getColumn();

        if (world.grid[i][j].tileVal.getValueOnTile().equals("M"))
        {
            System.out.println("~ Would you like to buy/sell anything at the market? ~");
            System.out.println("[Y] [N]");

            choice = inp.stringInput().toUpperCase();
            while (true)
            {
                if (choice.equals(Constants.Y))
                {
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
        }
        else
        {
            error.notAMarket();
        }
    }
}