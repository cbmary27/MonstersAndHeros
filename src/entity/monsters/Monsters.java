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
        super(name, level);
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
        return super.toString() +
        " | Base Damage : " + baseDamage + " | Defense : " + defense + " | Dodge Ability : " + dodgeAbility;
    }

    // @Override
    // public void increaseLevel()
    // {
    // }

    @Override
    public void takeDamage(int damageDealt)
    {
        System.out.println(damageDealt);
        hp = Math.max( 0, hp - Math.max(0, (damageDealt - defense)));
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

    public double calcDodge()
    {
        return (dodgeAbility / 100.0);
    }
}