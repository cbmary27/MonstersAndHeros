package item;

import java.util.*;

public class Spells extends Item{

    protected int damage;
    protected int affectedMana;
    protected String spellType;

    public Spells(String name, int price, int level, int damage, int affectedMana, String spellType)
    {
        super(name, price, level);
        this.type = "Spell";
        this.damage = damage;
        this.affectedMana = affectedMana;
        this.spellType  = spellType;
    }

}