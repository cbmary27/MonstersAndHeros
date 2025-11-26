/**
 * Filename: Spells.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-18
 * Description: A class for Spell type of Item, extends Item class
 */

package item;

import java.util.*;
import fileparser.SpellDetails;
import utilities.constants.Constants;
import entity.hero.Hero;


public class Spells extends Item{

    protected int damage;
    protected int affectedMana;
    protected String spellType;

    public Spells(String name, int price, int level, int damage, int affectedMana, String spellType)
    {
        super(name, price, level);
        this.type = Constants.SPELL;
        this.damage = damage;
        this.affectedMana = affectedMana;
        this.spellType  = spellType;
        setUsage();
    }

    public int getAffectedMana()
    {
        return affectedMana;
    }

    public int getDamage()
    {
        return damage;
    }

    public void setUsage()
    {
        usage = 1;
    }

    @Override
    public void updateUsage()
    {
        usage = 0;
    }

    /**
    * To apply the effect of the Spell on the hero's attributes
    * @param hero the hero who has cast the spell
    * @return void method
    */
    @Override
    public void applyEffect(Hero hero)
    {
        if (checkUsage())
        {
            updateUsage();
            
            if (hero.getMP() >= affectedMana)
            {
                hero.setMP(hero.getMP() - affectedMana);
                hero.getDamageFromItem((int) (damage + (hero.getDexterity() / 10000.0f) * damage));
            }
        }
    }

    @Override
    public String toString()
    {
        return super.toString() + " | Damage : " + damage + " | Mana Affected : " + affectedMana + "| Spell Type : " + spellType;
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