package entity;

import java.util.*;
import inventory.Inventory;

public abstract class entity{
    protected String name;
    protected int level;
    protected int hp;

    public void setName(String name)
    {
        this.name = name;
    }

    public abstract void increaseLevel();
    public abstract void calcHP();
}




