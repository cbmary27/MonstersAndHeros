package entity.hero;

import java.util.*;
import inventory.Inventory;

public abstract class Hero extends Entity{
    protected int mp;
    protected int strength; //increases when using a weapon
    protected int dexterity; //increases when casting a spell
    protected int agility; //increases chances to dodge a monsters attack
    protected int gold; //basically money to use at the market
    protected Inventory inventory;

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