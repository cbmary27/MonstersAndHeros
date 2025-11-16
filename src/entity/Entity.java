package entity;

import java.util.*;
import inventory.Inventory;

public abstract class Entity{
    protected String name;
    protected int level;
    protected int hp;

    public Entity(String name)
    {
        this.name = name;
        this.level = 1;
        calcHP();
    }

    public abstract void increaseLevel();
    public void calcHP()
    {
        hp = level * 100;
    }
}




