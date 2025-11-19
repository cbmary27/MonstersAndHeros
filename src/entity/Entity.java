package entity;

import java.util.*;
import inventory.Inventory;
import item.*;

public abstract class Entity{
    protected String name;
    protected int level;
    protected int hp;
    protected int type;
    
    public Entity(String name)
    {
        this.name = name;
        this.level = 1;
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
        this.hp = this.hp * 11 / 10;
    }
}




