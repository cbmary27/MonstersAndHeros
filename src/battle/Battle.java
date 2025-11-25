package battle;

import java.util.*;
import entity.*;
import entity.hero.*;
import entity.monsters.*;
import interfaces.Listeners;
import utilities.constants.Constants;
import utilities.error.Error;
import utilities.input.Input;
import menu.BattleMenu;
import item.*;

import stats.BattleStats;

public class Battle implements Listeners{

    private int round;
    private List<Monsters> monsters;
    private List<Hero> heros;
    private Hero currentHero;
    private Monsters target;
    private int damageDealt;
    private boolean dodgeProbability;
    private boolean isBattleDone;
    private boolean isTurnOver;
    private int highestLevel;
    private BattleStats blistener;

    String choice;
    private Input inp;
    MonsterFactory mf;
    private BattleMenu bmenu;

    public Battle()
    {
        addListener();
        mf = new MonsterFactory();
        monsters = new ArrayList<>();
        bmenu = new BattleMenu(); 
        inp = new Input();
        isBattleDone = false;
        isTurnOver = false;
        round = 0;
    }

    public void addListener()
    {
        blistener = new BattleStats();
    }

    public void initializeBattle(List<Hero> party)
    {
        heros = party;

        int i = 0;
        int numOfHeros = party.size();
        highestLevel = getHighestLevel();
        List<String> randMonsters = mf.getMonsters();
        List<String> monsterNames = new ArrayList<>();

        while (i < numOfHeros)
        {
            monsters.add(mf.createMonster(randMonsters.get(i), mf.types.get(i), highestLevel));
            monsterNames.add(randMonsters.get(i));
            i++;
        }

        blistener.monsterEntrance(monsterNames);

        fight();
    }

    public void fight()
    {
        while (!isBattleDone)
        {
            round++;

            blistener.eventNextRound(round);
            blistener.eventHeroTurn();

            for (Hero hero : heros)
            {
                isTurnOver = false;

                if (hero.getHP() == 0)
                {
                    continue;
                }

                if (round != 1)
                {
                    hero.increaseHP();
                    hero.calcMP();
                }

                currentHero = hero;
                target = chooseTarget();

                displayStats();

                while (isTurnOver == false)
                {
                    bmenu.showMenu();
                    bmenu.nextMove(hero.getName());

                    choice = inp.stringInput();

                    switch(choice)
                    {
                        case Constants.ATTACK:
                            heroAttack();
                            target.takeDamage(damageDealt);
                            check();
                            break;

                        case Constants.OPEN:
                            battleInventory();
                            break;

                        case Constants.FORFEIT:
                            isTurnOver = true;
                            isBattleDone = true;
                            blistener.eventForfeitBattle();
                            break;

                        default:
                            Error.invalidChoice();
                            break;
                    }
                }

                if (isBattleDone)
                {
                    break;
                }
            }

            if (!isBattleDone)
            {
                monsterTurn();
            }
            else
            {
                break;
            }
        }
    }

    public void monsterTurn()
    {
        int i = 0;

        blistener.eventMonsterTurn();

        for (Monsters monster: monsters)
        {
            i = (int) (Math.random() * heros.size());

            blistener.eventAttack(monster.getName(), heros.get(i).getName());

            damageDealt = monster.getBaseDamage();
            dodgeProbability = Math.random() < heros.get(i).calcDodge();

            if (dodgeProbability)
            {
                damageDealt = 0;
                dodgedAttack(heros.get(i).getName(), monster.getName());
            }

            heros.get(i).takeDamage(damageDealt);
            blistener.eventEntityDamage(monster.getName(), damageDealt);

            if (isHeroDefeated(heros.get(i)))
            {
                if (checkIfAllHerosDefeated())
                {
                    isBattleDone = true;
                    break;
                }
            }
        }
    }

    public void heroAttack()
    {
        String choice;
        boolean chosen = true;
        int count = 0;

        currentHero.displayEquippedWeapons();
        Item chosenWeapon = null;

        blistener.eventAttack(currentHero.getName(), target.getName());

        if (currentHero.getEquippedWeapons().size() == Constants.TWO)
        {
            while (chosen)
            {
                count = 0;

                for(Item item : currentHero.getEquippedWeapons())
                {
                    if (item.getUsage() == 0)
                    {
                        count++;
                    }
                }

                if (count == Constants.TWO)
                {
                    bmenu.allWeaponsBroken();
                    isTurnOver = false;
                    break;
                }

                bmenu.whichItem(Constants.WEAPON);
                choice = inp.getIntInput(1, currentHero.getEquippedWeapons().size());
                chosenWeapon = currentHero.getEquippedWeapons().get(Integer.parseInt(choice) - 1);
                if (chosenWeapon.getUsage() == 0)
                {
                    bmenu.weaponBroken();
                }
                else
                {
                    chosen = false;
                }
            }
        }
        else
        {
            chosenWeapon = currentHero.getEquippedWeapons().get(0);
            if (chosenWeapon.getUsage() == 0)
            {
                chosen = true;
                bmenu.weaponBroken();
                isTurnOver = false;
            }
            else
            {
                chosen = false;
            }
        }

        if (!chosen)
        {
            System.out.println("Hey");

            chosenWeapon.applyEffect(currentHero);

            damageDealt = currentHero.getItemDamage();
                    
            dodgeProbability = Math.random() < target.calcDodge();

            if (dodgeProbability)
            {
                damageDealt = 0;
                dodgedAttack(target.getName(), currentHero.getName());
                isTurnOver = true;
                return;
            }

            if (damageDealt != 0)
            {
                blistener.eventEntityDamage(currentHero.getName(), damageDealt);
            }

            isTurnOver = true;
        }
    }

    public void battleInventory()
    {
        currentHero.getInventory().display();

        bmenu.battleInventoryDisplay();

        bmenu.menuChoice();

        choice = inp.stringInput();

        if (choice.equals(Constants.USESPELL))
        {
            bmenu.whichItem(Constants.SPELL);
            choice = inp.getIntInput(1, currentHero.getInventory().getItems().size());
            Item item = currentHero.selectItem(choice);
            item.applyEffect(currentHero);
            if (item.getUsage() == 0)
            {
                isTurnOver = false;
            }
            else
            {
                item.applyEffect(currentHero);
                damageDealt = currentHero.getItemDamage();
                target.takeDamage(damageDealt);
                target.skillLoss();
                if (damageDealt != 0)
                {
                    blistener.eventEntityDamage(currentHero.getName(), damageDealt);
                    blistener.eventCastSpell(currentHero.getName(), target.getName(), item.getName());
                }
                check();
                isTurnOver = true;
            }
        }

        else
        {
            currentHero.getInventory().test(choice, currentHero);
            isTurnOver = true;
        }
    }

    public void check()
    {
        if (isMonsterDefeated())
        {
            monsters.remove(target);

            if (checkIfAllMonstersDefeated())
                {
                    heroWin();
                }
        }
    }

    public boolean checkIfAllMonstersDefeated()
    {
        if (monsters.isEmpty())
        {
            isBattleDone = true;
            blistener.eventHeroWin();
            return true;
        }
        return false;
    }

    public boolean checkIfAllHerosDefeated()
    {
        int count = 0;

        for (Hero hero : heros)
        {
            if (hero.getHP() == 0)
            {
                count++;
            }
        }

        if (count == heros.size())
        {
            heroLose();
            blistener.eventMonsterWin();
            return true;
        }

        return false;
    }

    public void heroLose()
    {
        for (Hero hero : heros)
        {
            hero.setHP(25);
        }
    }

    public void heroWin()
    {
        for (Hero hero : heros)
        {
            if (hero.getHP() == 0)
            {
                continue;
            }
            hero.goldReward(highestLevel);
            hero.calcEXP(heros.size());
        }
    }

    public Monsters chooseTarget()
    {
        bmenu.chooseWhichTarget(currentHero.getName());
        mf.displayMonsters(monsters);
        choice = inp.getIntInput(1, monsters.size());
        return monsters.get(Integer.parseInt(choice) - 1);
    }

    public void dodgedAttack(String receiver, String attacker)
    {
        blistener.eventDodgeAttack(receiver, attacker);
    }

    public boolean isMonsterDefeated()
    {
        if (target.getHP() == 0)
        {
            blistener.eventEntityFaint(target.getName());
            return true;
        }
        return false;
    }

    public boolean isHeroDefeated(Hero hero)
    {
        if (hero.getHP() == 0)
        {
            hero.setStatus(Constants.FAINTED);
            blistener.eventEntityFaint(hero.getName());
            return true;
        }
        return false;
    }

    public void displayStats()
    {
        System.out.println();
        System.out.println(currentHero);
        System.out.println(target);
    }

    public int getHighestLevel()
    {
        int maxLevel = 0;

        for (Hero hero : heros)
        {
            if (maxLevel < hero.getLevel())
            {
                maxLevel = hero.getLevel();
            }
        }
        return maxLevel;
    }
}