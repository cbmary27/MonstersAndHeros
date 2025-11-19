package battle;

import java.util.*;
import entity.*;
import entity.hero.*;
import entity.monsters.*;
import utilities.constants.Constants;
import utilities.error.Error;
import utilities.input.Input;
import item.*;

public class Battle{

    private int round;
    private List<Monsters> monsters;
    private List<Hero> heros;
    private Hero currentHero;
    private Monsters target;
    private int damageDealt;
    private boolean dodgeProbability;
    private boolean isBattleDone;
    private int highestLevel;

    String choice;
    private Input inp;
    MonsterFactory mf;

    public Battle()
    {
        mf = new MonsterFactory();
        monsters = new ArrayList<>(); 
        inp = new Input();
        isBattleDone = false;
        round = 0;
    }

    public void initializeBattle(List<Hero> party)
    {
        heros = party;

        System.out.println("Grrrrr......");
        System.out.println("Uh Oh, What was that?");
        System.out.println("MONSTERS!!!!!");

        int i = 0;
        int numOfHeros = party.size();
        highestLevel = getHighestLevel();
        List<String> randMonsters = mf.getMonsters();

        //calcNumOfRounds(highestLevel);

        while (i < numOfHeros)
        {
            monsters.add(mf.createMonster(randMonsters.get(i), mf.types.get(i), highestLevel));
            i++;
        }

        for (Monsters m : monsters)
        {
            System.out.println(m);
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

                System.out.println("Alright " + hero.getName() + ", what's your move?");
                switch(choice)
                {
                    case "A":
                        heroAttack();
                        target.takeDamage(damageDealt);
                        if (isMonsterDefeated())
                        {
                            monsters.remove(target);

                            if (checkIfAllMonstersDefeated())
                            {
                                isBattleDone = true;
                                heroWin();
                            }
                        }
                        break;

                    case "O": //open inventory
                        battleInventory();
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
            damageDealt = monster.getBaseDamage();
            dodgeProbability = Math.random() * 10 / 100 < heros.get(i).calcDodge();

            if (dodgeProbability)
            {
                damageDealt = 0;
                dodgedAttack(heros.get(i).getName(), monster.getName());
            }

            heros.get(i).takeDamage(damageDealt);

            if (isHeroDefeated())
            {
                isBattleDone = true;
                if (checkIfAllHerosDefeated())
                {
                    isBattleDone = true;
                }
            }

            i++;
        }
    }

    public void heroAttack()
    {
        String choice;

        currentHero.displayEquippedWeapons();
        Item chosenWeapon = null;

        if (currentHero.getEquippedWeapons().size() == Constants.TWO)
        {
            System.out.println("Which weapon do you want to use?");
            choice = inp.stringInput();
            chosenWeapon = currentHero.getEquippedWeapons().get(Integer.parseInt(choice) - 1);
        }

        damageDealt = currentHero.useWeapon(chosenWeapon);
        dodgeProbability = Math.random() * 10 / 100 < target.calcDodge();

        if (dodgeProbability)
        {
            damageDealt = 0;
            dodgedAttack(target.getName(), currentHero.getName());
        }    
    }

    public void displayStats()
    {
        System.out.println();
    }

    public void battleInventory()
    {
        currentHero.getInventory().display();

        switch(choice)
        {
            case "P":
                System.out.println("Which potion do you want to consume?");
                choice = inp.stringInput();
                Item item = currentHero.selectItem(choice);
                currentHero.usePotion(item);
                break;

            case "S":
                System.out.println("Which spell do you want to cast?");
                choice = inp.stringInput();
                Item item3 = currentHero.selectItem(choice);
                damageDealt = currentHero.useSpell(item3);
                target.takeDamage(damageDealt);
                break;

            case Constants.EQUIP:
                System.out.println("Enter the weapon/armor number you want to equip");
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
                System.out.println("Enter the weapon/armor number you want to unequip");
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

            default:
                Error.invalidChoice();
                break;
        }
    }

    public boolean checkIfAllMonstersDefeated()
    {
        if (monsters.isEmpty())
        {
            System.out.println(" All Monsters have been defeated ! ");

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
            return true;
        }

        return false;
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
            hero.expGain(heros.size());
        }
    }

    public Monsters chooseTarget()
    {
        System.out.println("Choose your target!");
        mf.displayMonsters();
        choice = inp.stringInput();
        return monsters.get(Integer.parseInt(choice));
    }

    public void dodgedAttack(String receiver, String attacker)
    {
        System.out.println(receiver + " dodged " + attacker + " 's attack !" );
    }

    public boolean isMonsterDefeated()
    {
        if (target.getHP() == 0)
        {
            return true;
        }
        return false;
    }

    public boolean isHeroDefeated()
    {
        if (currentHero.getHP() == 0)
        {
            return true;
        }
        return false;
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

    // public void calcNumOfRounds(int highestLevel)
    // {
    //     if (highestLevel >= Constants.ONE && highestLevel <= Constants.THREE)
    //     {
    //         rounds = Constants.ONE;
    //     }
    //     else if (highestLevel > Constants.THREE && highestLevel <= Constants.FIVE)
    //     {
    //         rounds = Constants.TWO;
    //     }
    //     else
    //     {
    //         rounds = Constants.THREE;
    //     }
    // }    
}