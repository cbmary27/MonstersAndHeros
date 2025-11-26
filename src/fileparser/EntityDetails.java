/**
 * Filename: EntityDetails.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-14
 * Description: A class to store the details of the entity (hero/monster) after retrieving from the file
 */

package fileparser;

import java.util.*;
import utilities.constants.Constants;

public class EntityDetails
{
    public String name;
    public int mp;
    public int strength;
    public int exp;
    public int dexterity; 
    public int agility;
    public int gold;

    public int level;
    public int baseDamage;
    public int defense;
    public int dodgeAbility;

    public EntityDetails(List<String> details, String entityType)
    {
        this.name = details.get(0);

        if (entityType.equals(Constants.HERO))
        {
            this.mp = Integer.parseInt(details.get(1));
            this.strength = Integer.parseInt(details.get(2));
            this.agility = Integer.parseInt(details.get(3));
            this.dexterity = Integer.parseInt(details.get(4));
            this.gold = Integer.parseInt(details.get(5));
            this.exp = Integer.parseInt(details.get(6));
        }
        else if (entityType.equals(Constants.MONSTER))
        {
            this.level = Integer.parseInt(details.get(1));
            this.baseDamage = Integer.parseInt(details.get(2));
            this.defense = Integer.parseInt(details.get(3));
            this.dodgeAbility = Integer.parseInt(details.get(4));
        }
    }
}