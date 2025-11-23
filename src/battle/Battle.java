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
        round = 0;
    }

    public void addListener()
    {
        blistener = new BattleStats();
    }

    public void initializeBattle(List<Hero> party)
    {
        heros = party;

        blistener.monsterEntrance();

        int i = 0;
        int numOfHeros = party.size();
        highestLevel = getHighestLevel();
        List<String> randMonsters = mf.getMonsters();

        while (i < numOfHeros)
        {
            monsters.add(mf.createMonster(randMonsters.get(i), mf.types.get(i), highestLevel));
            i++;
        }

        fight();
    }

    public void fight()
    {
        while (!isBattleDone)
        {
            round++;

            for (Hero hero : heros)
            {
                if (hero.getHP() == 0)
                {
                    continue;
                }

                if (round != 1)
                {
                    hero.increaseHP();
                    hero.calcMP();
                }

                target = chooseTarget();
                currentHero = hero;

                displayStats();

                bmenu.showMenu();
                bmenu.nextMove(hero.getName());

                choice = inp.stringInput();

                switch(choice)
                {
                    case Constants.ATTACK:
                        heroAttack();
                        target.takeDamage(damageDealt);
                        check();
                        //nextHeroTurn();
                        break;

                    case Constants.OPEN: //open inventory
                        battleInventory();
                        //nextHeroTurn();
                        break;

                    case Constants.FORFEIT:
                        isBattleDone = true;
                        blistener.eventForfeitBattle();
                        break;

                    default:
                        Error.invalidChoice();
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

            if (isHeroDefeated())
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

        currentHero.displayEquippedWeapons();
        Item chosenWeapon = null;

        blistener.eventAttack(currentHero.getName(), target.getName());

        if (currentHero.getEquippedWeapons().size() == Constants.TWO)
        {
            bmenu.whichItem(Constants.WEAPON);
            choice = inp.stringInput();
            chosenWeapon = currentHero.getEquippedWeapons().get(Integer.parseInt(choice) - 1);
        }

        damageDealt = currentHero.useWeapon(currentHero.getEquippedWeapons().get(0));
                
        dodgeProbability = Math.random() < target.calcDodge();

        if (dodgeProbability)
        {
            damageDealt = 0;
            dodgedAttack(target.getName(), currentHero.getName());
            return;
        }

        blistener.eventEntityDamage(currentHero.getName(), damageDealt);
    }

    public void battleInventory()
    {
        currentHero.getInventory().display();

        bmenu.battleInventoryDisplay();

        if (!currentHero.getInventory().getItems().isEmpty())
        {
            bmenu.menuChoice();

            choice = inp.stringInput();

            switch(choice)
            {
                case Constants.USEPOTION:
                    bmenu.whichItem(Constants.POTION);
                    choice = inp.stringInput();
                    Item item = currentHero.selectItem(choice);
                    currentHero.usePotion(item);
                    break;

                case Constants.USESPELL:
                    bmenu.whichItem(Constants.SPELL);
                    choice = inp.stringInput();
                    Item item3 = currentHero.selectItem(choice);
                    damageDealt = currentHero.useSpell(item3);
                    target.takeDamage(damageDealt);
                    target.skillLoss();

                    if (damageDealt != 0)
                    {
                        blistener.eventEntityDamage(currentHero.getName(), damageDealt);
                        blistener.eventCastSpell(currentHero.getName(), target.getName(), item3.getName());
                    }
                    check();
                    break;

                case Constants.EQUIP:
                    bmenu.whichItemEquip(Constants.EQUIP);
                    choice = inp.stringInput();
                    Item item1 = currentHero.selectItem(choice);
                    if (item1.getType().equals(Constants.WEAPON))
                    {
                        currentHero.equipWeapon(item1);
                    }
                    else if (item1.getType().equals(Constants.ARMOR))
                    {
                        currentHero.equipArmor(item1);
                    }
                    break;

                case Constants.UNEQUIP:
                    bmenu.whichItemEquip(Constants.UNEQUIP);
                    choice = inp.stringInput();
                    Item item2 = currentHero.selectItem(choice);
                    if (item2.getType().equals(Constants.WEAPON))
                    {
                        currentHero.unEquipWeapon(item2);
                    }
                    else if (item2.getType().equals(Constants.ARMOR))
                    {
                        currentHero.unEquipArmor(item2);
                    }
                    break;
                
                case Constants.QUIT:
                    break;

                default:
                    Error.invalidChoice();
                    break;
            }
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
            hero.increaseGold(highestLevel);
            hero.calcEXP(heros.size());
        }
    }

    public Monsters chooseTarget()
    {
        bmenu.chooseWhichTarget();
        mf.displayMonsters(monsters);
        choice = inp.stringInput();
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

    public boolean isHeroDefeated()
    {
        if (currentHero.getHP() == 0)
        {
            blistener.eventEntityFaint(currentHero.getName());
            return true;
        }
        return false;
    }

    public void displayStats()
    {
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