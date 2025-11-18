package item;

import java.util.*;
import fileparser.SpellDetails;

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

    public int getAffectedMana()
    {
        return affectedMana;
    }

    // @Override
    // public void effectOfItem()
    // {

    // }

    @Override
    public String toString()
    {
        return type + ": " + name + " | " + price + " | " + requiredLevel + " | " + damage + " | " + affectedMana + "| " + spellType;
    }

    @Override
    public void updateUsage()
    {
        this.usage = 0;
    }

    public SpellDetails toDetails() {
        List<String> d = new ArrayList<>();
        d.add(name);
        d.add(String.valueOf(price));
        d.add(String.valueOf(requiredLevel));
        d.add(String.valueOf(damage));
        d.add(String.valueOf(affectedMana));
        d.add(spellType);

        return new SpellDetails(d);
    }

}