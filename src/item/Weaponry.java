package item;

import java.util.*;

public class Weaponry extends Item{

    protected int damage;
    protected int requiredHands;

    public Weaponry(String name, int price, int level, int damage, int requiredHands)
    {
        super(name, price, level);
        this.type = "Weaponry";
        this.damage = damage;
        this.requiredHands = requiredHands;
    }

}