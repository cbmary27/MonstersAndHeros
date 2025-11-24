package stats;

import java.util.*;
import interfaces.HeroEventListener;
import utilities.colour.colour;

public class HeroStats implements HeroEventListener
{
    @Override
    public void eventLevelIncrease(String name, int level)
    {
        System.out.println(name + " grew to level " + level + "!");
        System.out.println();
    }

    @Override
    public void eventExpGain(String name, int exp)
    {
        System.out.println(name + " gained " + exp + " EXP");
        System.out.println();
    }

    @Override
    public void eventGainedGold(String name, int gold)
    {
        System.out.println(name + " gained " + gold + " gold");
        System.out.println();
    }

    @Override
    public void eventAttributeIncrease(String attribute, int amt)
    {
        System.out.println(attribute + " increased by " + amt + "points");
    }

}
