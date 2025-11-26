/**
 * Filename: HeroEventListener.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-20
 * Description: An interface that lists the methods of an observer for Hero
 */

package interfaces;

import java.util.*;

public interface HeroEventListener
{
    public void eventLevelIncrease(String name, int level);
    public void eventExpGain(String name, int exp);
    public void eventGainedGold(String name, int gold);
    public void eventAttributeIncrease(String attribute, int amt);
}