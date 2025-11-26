/**
 * Filename: Battle.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-18
 * Description: Implements the logic for battles between heroes and monsters.
 */

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

    /**
    * Adding an observer to record battle statistics and display
    * @return void method
    */
    public void addListener()
    {
        blistener = new BattleStats();
    }

    /**
    * To create monsters according to the heroes in the party and initialize variables/data structures
    * @param party the party of heroes
    * @return void method
    */
    public void initializeBattle(List<Hero> party)
    {
        heros = party;

        int i = 0;
        int numOfHeros = party.size();
        highestLevel = getHighestLevel();
        List<String> randMonsters = mf.getMonsters();
        List<String> monsterNames = new ArrayList<>();

        while (i < numOfHeros) //creating monsters according to the number of heroes in the party and their levels
        {
            monsters.add(mf.createMonster(randMonsters.get(i), mf.types.get(i), highestLevel));
            monsterNames.add(randMonsters.get(i));
            i++;
        }

        blistener.monsterEntrance(monsterNames);

        fight();
    }

    /**
    * Starts off the battle between the heroes and monsters
    * @return void method
    */
    public void fight()
    {
        while (!isBattleDone) //main loop for the battle
        {
            round++;

            blistener.eventNextRound(round);
            blistener.eventHeroTurn();

            for (Hero hero : heros) //Heroes go first in a battle
            {
                isTurnOver = false;

                if (hero.getHP() == 0) //if a hero from the party has fainted, their turn is skipped
                {
                    continue;
                }

                if (round != 1)
                {
                    hero.increaseHP(); //increasing the HP and MP of the hero in the subsequent rounds
                    hero.calcMP();
                }

                currentHero = hero;
                target = chooseTarget(); //allowing the current hero to choose their target

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
                monsterTurn(); //after the monsters have attacked, the monsters turn is next
            }
            else
            {
                break;
            }
            bmenu.endOfRound();
        }
    }

    /**
    * Contains logic for the monsters turn during the battle
    * @return void method
    */
    public void monsterTurn()
    {
        int i = 0;

        blistener.eventMonsterTurn();

        for (Monsters monster: monsters)
        {
            i = (int) (Math.random() * heros.size()); //getting a random hero from the party for the current monster to fight against

            blistener.eventAttack(monster.getName(), heros.get(i).getName());

            damageDealt = monster.getBaseDamage();
            dodgeProbability = Math.random() < heros.get(i).calcDodge(); //calculate the dodge probability of the hero

            if (dodgeProbability) //if dodgeProbability is true, hero can dodge the attack from the monster
            {
                damageDealt = 0;
                dodgedAttack(heros.get(i).getName(), monster.getName());
            }

            heros.get(i).takeDamage(damageDealt); //else, hero takes damage from the monster's attack
            blistener.eventEntityDamage(monster.getName(), damageDealt);

            if (isHeroDefeated(heros.get(i))) //checking if the hero has fainted from the attack
            {
                if (checkIfAllHerosDefeated()) //checking if all heroes in the party have fainted
                {
                    isBattleDone = true;
                    break;
                }
            }
        }
    }

    /**
    * If hero chooses to attack, to calculate the dodge or damage taken for the monster
    * @return void method
    */
    public void heroAttack()
    {
        String choice;
        boolean chosen = true;
        int count = 0;

        currentHero.displayEquippedWeapons();
        Item chosenWeapon = null;

        blistener.eventAttack(currentHero.getName(), target.getName());

        //if hero has equipped two weapons, checking if the weapons are broken, else hero can choose which weapon to attack with
        if (currentHero.getEquippedWeapons().size() == Constants.TWO)
        {
            while (chosen)
            {
                count = 0;

                for(Item item : currentHero.getEquippedWeapons())
                {
                    if (item.getUsage() == 0) //checking if weapons are broken
                    {
                        count++;
                    }
                }

                if (count == Constants.TWO)
                {
                    bmenu.allWeaponsBroken(); //if all weapons are broken, hero cannot attack
                    isTurnOver = false;
                    break;
                }

                bmenu.whichItem(Constants.WEAPON); //else, hero can choose which weapon to attack with
                choice = inp.getIntInput(1, currentHero.getEquippedWeapons().size());
                chosenWeapon = currentHero.getEquippedWeapons().get(Integer.parseInt(choice) - 1);
                if (chosenWeapon.getUsage() == 0) //if the hero chooses a broken weapon
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
            //if hero has a single weapon and checking if it is broken
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

        if (!chosen) //applying the effect of the weapon the hero has chosen to attack with
        {
            chosenWeapon.applyEffect(currentHero);

            damageDealt = currentHero.getItemDamage(); //getting the damage induced by the weapon
                    
            dodgeProbability = Math.random() < target.calcDodge(); //checking whether the monster can dodge the attack or not

            if (dodgeProbability) //if dodgeProbability is true, monster dodges the attack
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

    /**
    * Contains logic for choosing to use an item from the hero's inventory
    * @return void method
    */
    public void battleInventory()
    {
        currentHero.getInventory().display();

        bmenu.battleInventoryDisplay();

        bmenu.menuChoice();

        choice = inp.stringInput();

        //if hero wants to cast a spell
        if (choice.equals(Constants.USESPELL))
        {
            bmenu.whichItem(Constants.SPELL);
            choice = inp.getIntInput(1, currentHero.getInventory().getItems().size());
            Item item = currentHero.selectItem(choice);
            // item.applyEffect(currentHero); 
            if (item.getUsage() == 0) //if the spell cannot be used
            {
                isTurnOver = false;
            }
            else
            {
                item.applyEffect(currentHero);
                damageDealt = currentHero.getItemDamage();
                target.takeDamage(damageDealt); //monster takes the damage from the spell
                target.skillLoss(); //spells result in skill loss of the monster
                if (damageDealt != 0)
                {
                    blistener.eventEntityDamage(currentHero.getName(), damageDealt);
                    blistener.eventCastSpell(currentHero.getName(), target.getName(), item.getName());
                }
                check(); //check if all the monsters have been defeated
                isTurnOver = true;
            }
        }

        else
        {
            currentHero.getInventory().test(choice, currentHero); //if hero has selected another option from the inventory
            isTurnOver = true;
        }
    }

    /**
    * Checks if the current monster being attacked has fainted, subsequently if all monsters are defeated
    * @return void method
    */
    public void check()
    {
        if (isMonsterDefeated())
        {
            monsters.remove(target);

            if (checkIfAllMonstersDefeated())
                {
                    heroWin(); //if all monsters are defeated, the hero(s) have won
                }
        }
    }

    /**
    * Checking if all monsters are defeated
    * @return void method
    */
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

    /**
    * Check if all heroes are defeated
    * @return void method
    */
    public boolean checkIfAllHerosDefeated()
    {
        int count = 0;

        for (Hero hero : heros)
        {
            if (hero.getHP() == 0) //if HP of the hero = 0
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

    /**
    * If all heroes have fainted, then revive them by a small amount
    * @return void method
    */
    public void heroLose()
    {
        for (Hero hero : heros)
        {
            hero.setHP(25);
        }
    }

    /**
    * Logic of heroes have won
    * @return void method
    */
    public void heroWin()
    {
        for (Hero hero : heros)
        {
            if (hero.getHP() == 0) //if some heroes from the party have fainted, then skip those heroes
            {
                continue;
            }
            hero.goldReward(highestLevel); //increase gold of each hero
            hero.calcEXP(heros.size()); //increase the EXP of each hero
        }
    }

    /**
    * For the hero to choose their target during their turn
    * @return void method
    */
    public Monsters chooseTarget()
    {
        bmenu.chooseWhichTarget(currentHero.getName());
        mf.displayMonsters(monsters);
        choice = inp.getIntInput(1, monsters.size());
        return monsters.get(Integer.parseInt(choice) - 1);
    }

    /**
    * If hero/monster dodged an attack
    * @return void method
    */
    public void dodgedAttack(String receiver, String attacker)
    {
        blistener.eventDodgeAttack(receiver, attacker);
    }

    /**
    * To check if the current monster has fainted during an attack
    * @return void method
    */
    public boolean isMonsterDefeated()
    {
        if (target.getHP() == 0)
        {
            blistener.eventEntityFaint(target.getName());
            return true;
        }
        return false;
    }

    /**
    * To check if the current hero has fainted during an attack
    * @return void method
    */
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

    /**
    * To display the stats of the hero and monster
    * @return void method
    */
    public void displayStats()
    {
        System.out.println();
        System.out.println(currentHero);
        System.out.println(target);
    }

    /**
    * To get the highest level of the hero in the party
    * @return void method
    */
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