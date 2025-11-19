package entity.monsters;

import java.util.*;
import entity.Entity;
import interfaces.takeDamage;
import utilities.constants.Constants;

public class Monsters extends Entity implements takeDamage{
    int baseDamage;
    int defense;
    int dodgeAbility;
    int level;
    String type;

    public Monsters(String name, int level, int baseDamage, int defense, int dodgeAbility, String type)
    {
        super(name);
        this.baseDamage = baseDamage;
        this.defense = defense;
        this.dodgeAbility = dodgeAbility;
        this.type = type;
    }

    public int getBaseDamage()
    {
        return baseDamage;
    }

    @Override
    public String toString()
    {
        return name + " | " + level + " | " + baseDamage + " | " + defense + " | " + dodgeAbility;
    }

    // @Override
    // public void increaseLevel()
    // {
    // }

    @Override
    public void takeDamage(int damageDealt)
    {
        if (damageDealt > hp)
        {
            hp = 0;
            return;
        }

        hp = hp - damageDealt + defense;
        skillLoss();
    }

    public void skillLoss()
    {
        switch (type)
        {
            case Constants.EXOSKELETONS:
                defense = defense * 10 / 100;
                break;
            case Constants.DRAGONS:
                baseDamage = baseDamage * 10 / 100;
                break;
            case Constants.SPIRITS:
                dodgeAbility = dodgeAbility * 10 / 100;
                break;
        }
    }

    public int calcDodge()
    {
        return (dodgeAbility * 1 / 100);
    }
}