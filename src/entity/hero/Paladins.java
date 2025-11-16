package entity.hero;

import java.util.*;
import fileparser.EntityDetails;

public class Paladins extends Hero{

    public Paladins(String name, int mp, int strength, int dexterity, int agility, int gold, int exp)
    {
        super(name, mp, strength, dexterity, agility, gold, exp);
    }

    @Override
    public void increaseLevel()
    {

        //calcHP();
        //calcMana();

    }

    @Override
    public void calcHP()
    {
        //if hero takes potion, then HP increases
        //can increase when hero levels up

    }

    @Override
    public void calcMP()
    {
        //increases when hero levels up
    }
}