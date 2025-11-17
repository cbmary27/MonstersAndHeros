package entity.monsters;

import java.util.*;
import entity.Entity;

public abstract class Monsters extends Entity{
    int baseDamage;
    int defense;
    int dodgeAbility;

    public Monsters(String name, int baseDamage, int defense, int dodgeAbility)
    {
        super(name);
        this.baseDamage = baseDamage;
        this.defense = defense;
        this.dodgeAbility = dodgeAbility;
    }
}