/**
 * Filename: Monsters.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-18
 * Description: A class for monsters and their functionalities, extends the Entity class
 */

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
        return super.toString();
    }

    /**
    * To calculate the HP after the monster takes damage
    * @param damageDealt damage to be taken by the monster during battle
    * @return void method
    */
    @Override
    public void takeDamage(int damageDealt)
    {
        int reduceDefense = (int) (defense * damageDealt / 100); //reducing the defense of the monster from the damageDealt
        hp = Math.max( 0, hp - Math.max(0, (damageDealt - reduceDefense)));
    }

    /**
    * To calculate the skill loss of the monster after an attack
    * @return void method
    */
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