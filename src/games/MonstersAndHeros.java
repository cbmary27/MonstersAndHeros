/**
 * Filename: MonstersAndHeros.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-13
 * Description: The main class for the intialization of the game logic and subsequent actions, extends the Games class
 */

package games;

import java.util.*;
import fileparser.*;
import entity.hero.*;
import market.MarketFactory;
import utilities.constants.Constants;
import menu.GameMenu;
import item.*;
import world.World;
import battle.Battle;

public class MonstersAndHeros extends Games{
    public FileParser file;
    public HeroFactory hf;
    public MarketFactory mf;
    public Battle battle;
    public GameMenu gmenu;

    public MonstersAndHeros()
    {
        hf = new HeroFactory();
        mf = new MarketFactory();
        gmenu = new GameMenu();
        world = new World(8, 8);
        player.currentPos.setRow(7);
        player.currentPos.setColumn(7);
    }

    /**
    * A method to start off the Monsters and Heroes game
    * @return void method
    */
    @Override
    public void start()
    {
        String ch = "";
        boolean flag = false;
        i.displayMonstersAndHeros();

        do {
            setUpGame();
            world.initializeMap();
            world.printMap();

            while (!isGameDone)
            {
                while (flag == false)
                {
                    displayOptions();
                    gmenu.enterMove();
                    ch = inp.stringInput();
                    flag = checkInput(ch);

                    if (flag == false)
                    {
                        error.invalidMove();
                    }
                }

                switch(ch.toUpperCase()) //moving across the map according to the user's choice
                {
                    case Constants.UP:
                    case Constants.LEFT:
                    case Constants.DOWN:
                    case Constants.RIGHT:
                        flag = world.isMoveLegal(ch, player.currentPos);
                        if (flag == false)
                        {
                            error.invalidMove();
                            break;
                        }
                        world.makeMove(player, ch);
                        commonTile();
                        break;
                    case Constants.MARKET:
                        initializeMarket();
                        break;
                    case Constants.INFORMATION:
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
            gmenu.playAgain();
            continueGame = inp.stringInput().toUpperCase();

        } while(continueGame.equals(Constants.YES));
    }

    /**
    * A method to set up the game such as getting the party of heroes for the player
    * @return void method
    */
    public void setUpGame()
    {
        int i = 0;
        String choice;
        
        gmenu.assembleParty();
        List<String> heros = hf.getHeros();

        gmenu.numberOfHeros();
      
        choice = inp.getIntInput(1, 3);

        while ( i < Integer.parseInt(choice)) //getting the party according to the player choice
        {
            player.addHero(hf.createHero(heros.get(i), hf.types.get(i)));
            i++;
        }

        System.out.println();

        getComplimentaryWeapons();

        player.getInformation();
    }

    /**
    * A method for the logic if party ends up on a common tile
    * @return void method
    */
    public void commonTile()
    {
        String choice;

        int i = player.currentPos.getRow();
        int j = player.currentPos.getColumn();

        switch(world.grid[i][j].tileVal.getValueOnTile())
        {
            case Constants.BOARDSTAR:
                Random random = new Random();
                int randomChoice = random.nextInt(2);
                if (randomChoice == 1 && checkHPOfParty()) // a fifty percent chance of a battle starting on a common tile
                {
                    battle = new Battle();
                    battle.initializeBattle(player.getParty());
                }
        }
    }

    /**
    * A method for the logic for intializing a market if the player decided to enter the market
    * @return a void method
    */
    public void initializeMarket()
    {
        String choice = "";

        int i = player.currentPos.getRow();
        int j = player.currentPos.getColumn();

        if (world.grid[i][j].tileVal.getValueOnTile().equals(Constants.MARKET))
        {
            gmenu.initialMarket();

            choice = inp.stringInput().toUpperCase();
            while (true)
            {
                if (choice.equals(Constants.YES)) //if the player wants to enter the market
                {
                    player.display();
                    gmenu.whichHeroMarket();
                    choice = inp.getIntInputIndex(1, player.getParty().size()); //which hero is going to enter the market

                    world.grid[i][j].getMarketInstance();
                    world.grid[i][j].market.enter(player.getHero(choice)); //calling a method from Market class to proceed

                    gmenu.optionMarket();

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
            error.notAMarket(); //if the current tile the player is on is not a market space
        }
    }

    /**
    * A method to restore the variables of the Monsters and Heroes game
    * @return void method
    */
    @Override
    public void restore()
    {
        super.restore();
        world = new World(8, 8);
        player.currentPos.setRow(7);
        player.currentPos.setColumn(7);
    }

    /**
    * A method to get complimentary weapons at the start of the game for each hero in the party
    * @return void method
    */
    public void getComplimentaryWeapons()
    {
        int i = 0;
        mf.createComplimentaryWeapons(); //creating the complimentary weapons by retrieving from the file

        gmenu.complimentaryMessage();

        System.out.println();

        for (Hero hero : player.getParty()) //giving each hero in the party a complimentary weapon
        {
            WeaponryDetails compWeapon = mf.weaponryDetails.get(i);
            Item newWeapon = mf.createWeaponry(compWeapon);

            hero.getInventory().addItem(newWeapon);

            System.out.print(hero.getName() + ": ");

            hero.equipWeapon(newWeapon); //hero equips complimentary weapon
            System.out.println();
        }
    }
}