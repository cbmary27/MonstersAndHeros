/**
 * Filename: HeroStats.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-20
 * Description: An observer class for Hero that displays actions that affect a hero or its attributes
 */

package stats;

import java.util.*;
import interfaces.HeroEventListener;
import utilities.colour.colour;

public class HeroStats implements HeroEventListener
{
    @Override
    public void eventLevelIncrease(String name, int level)
    {
        System.out.println(colour.GREEN_BOLD + name + " grew to level " + level + "!" + colour.RESET);
        System.out.println();
    }

    @Override
    public void eventExpGain(String name, int exp)
    {
        System.out.println(colour.GREEN_BOLD + name + " gained " + exp + " EXP" + colour.RESET);
        System.out.println();
    }

    @Override
    public void eventGainedGold(String name, int gold)
    {
        System.out.println(colour.GREEN_BOLD + name + " gained " + gold + " gold" + colour.RESET);
        System.out.println();
    }

    @Override
    public void eventAttributeIncrease(String attribute, int amt)
    {
        System.out.println(colour.GREEN_BOLD + attribute + " increased by " + amt + " points" + colour.RESET);
        System.out.println();
    }

}
