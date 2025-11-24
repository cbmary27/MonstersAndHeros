package entity;

import java.util.*;
import inventory.Inventory;
import item.*;

public abstract class Entity{
    protected String name;
    protected int level;
    protected int hp;
    protected int type;
    
    public Entity(String name, int level)
    {
        this.name = name;
        this.level = level;
        calcHP();
    }

    public int getLevel()
    {
        return this.level;
    }

    public String getName()
    {
        return name;
    }

    public void setHP(int val)
    {
        this.hp = val;
    }

    //public abstract void increaseLevel();

    public void calcHP()
    {
        hp = level * 100;
    }

    public int getHP()
    {
        return this.hp;
    }

    public void increaseHP()
    {
        this.hp = this.hp + 2;
    }

    @Override
    public String toString()
    {
        return name + " | HP : " + hp + " | Level : " + level;
    }
}




