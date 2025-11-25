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

                switch(ch.toUpperCase())
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

    public void setUpGame()
    {
        int i = 0;
        String choice;
        
        gmenu.assembleParty();
        List<String> heros = hf.getHeros();

        gmenu.numberOfHeros();
      
        choice = inp.getIntInput(1, 3);

        while ( i < Integer.parseInt(choice))
        {
            player.addHero(hf.createHero(heros.get(i), hf.types.get(i)));
            i++;
        }

        System.out.println();

        getComplimentaryWeapons();

        player.getInformation();
    }

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
                if (randomChoice == 1 && checkHPOfParty())
                {
                    battle = new Battle();
                    battle.initializeBattle(player.getParty());
                }
        }
    }

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
                if (choice.equals(Constants.YES))
                {
                    player.display();
                    gmenu.whichHeroMarket();
                    choice = inp.getIntInput(1, player.getParty().size());

                    world.grid[i][j].getMarketInstance();
                    world.grid[i][j].market.enter(player.getHero(choice));

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
            error.notAMarket();
        }
    }

    @Override
    public void restore()
    {
        super.restore();
        world = new World(8, 8);
        player.currentPos.setRow(7);
        player.currentPos.setColumn(7);
    }

    public void getComplimentaryWeapons()
    {
        int i = 0;
        mf.createComplimentaryWeapons();

        gmenu.complimentaryMessage();

        System.out.println();

        for (Hero hero : player.getParty())
        {
            WeaponryDetails compWeapon = mf.weaponryDetails.get(i);
            Item newWeapon = mf.createWeaponry(compWeapon);

            hero.getInventory().addItem(newWeapon);

            System.out.print(hero.getName() + ": ");

            hero.equipWeapon(newWeapon);
            System.out.println();
        }
    }
}