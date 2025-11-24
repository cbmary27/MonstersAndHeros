package interfaces;

import java.util.*;

public interface HeroEventListener
{
    public void eventLevelIncrease(String name, int level);
    public void eventExpGain(String name, int exp);
    public void eventGainedGold(String name, int gold);
    public void eventAttributeIncrease(String attribute, int amt);
}