package entity.hero;

import java.util.*;
import inventory.Inventory;
import entity.Entity;

public abstract class Hero extends Entity{
    protected int mp;
    protected int strength; //increases when using a weapon
    protected int dexterity; //increases when casting a spell
    protected int agility; //increases chances to dodge a monsters attack
    protected int gold; //basically money to use at the market
    protected int exp;
    protected Inventory inventory;

    public Hero(String name, int mp, int strength, int dexterity, int agility, int gold, int exp)
    {
        super(name);
        this.mp = mp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.gold = gold;
        this.exp = exp;
    }

    @Override
    public void increaseLevel()
    {

        //calcHP();
        //calcMana();

    }

    public void calcMP()
    {
        //increases when hero levels up
    }
}