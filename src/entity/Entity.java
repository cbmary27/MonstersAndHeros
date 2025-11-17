package entity;

import java.util.*;
import inventory.Inventory;

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

    public String getName()
    {
        return name;
    }

    public abstract void increaseLevel();
    public void calcHP()
    {
        hp = level * 100;
    }
}




