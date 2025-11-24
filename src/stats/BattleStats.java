package stats;

import java.util.*;
import interfaces.BattleEventListener;
import utilities.colour.colour;

public class BattleStats implements BattleEventListener
{
    @Override
    public void monsterEntrance(List<String> monsterNames)
    {
        System.out.println();
        System.out.println("Grrrrr......");
        System.out.println("Uh Oh, What was that?");
        System.out.println("MONSTERS!!!!!");
        System.out.println();
        for (String m : monsterNames)
        {
            System.out.println("Monster " + m + " has appeared!");
        }
        System.out.println();
        System.out.println(" ----------------------------------");
        System.out.println("|       BATTLE BEGINS : FIGHT!     |");
        System.out.println(" ----------------------------------");    
    }

    @Override
    public void eventEntityDamage(String name, int damage)
    {
        System.out.println(name + " dealt " + damage + " damage");
        System.out.println();
    }

    @Override
    public void eventHeroWin()
    {
        System.out.println("The Hero(s) have won!");
        System.out.println();
    }

    @Override
    public void eventMonsterWin()
    {
        System.out.println("The Monster(s) have won");
        System.out.println();
    }

    @Override
    public void eventEntityFaint(String name)
    {
        System.out.println("...");
        System.out.println(name + " has fainted");
        System.out.println();
    }

    @Override
    public void eventDodgeAttack(String receiver, String attacker)
    {
        System.out.println(receiver + " dodged " + attacker + "'s attack!");
        System.out.println();
    }

    @Override
    public void eventAttack(String attacker, String target)
    {
        System.out.println(attacker + " is attacking " + target);
        System.out.println();
    }

    @Override
    public void eventCastSpell(String name, String target, String itemName)
    {
        System.out.println(name + " cast a " + itemName + " spell on " + target);
        System.out.println("Critical Damage!");
        System.out.println();
    }

    @Override
    public void eventForfeitBattle()
    {
        System.out.println("The heroes have forfeited the battle!");
        System.out.println();
    }

    @Override
    public void eventUsedItem(String name, String itemName)
    {
        System.out.println(name + " has used " + itemName);
    }

}