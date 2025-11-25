package item;

import java.util.*;
import fileparser.ArmorDetails;
import interfaces.Equippable;
import entity.hero.Hero;


public class Armor extends Item implements Equippable{

    protected int damageReduction;
    protected boolean equipped;

    public Armor(String name, int price, int level, int damageReduction)
    {
        super(name, price, level);
        this.type = "Armor";
        this.damageReduction = damageReduction;
        this.equipped = false;
        setUsage();
    }

    public int getDamageReduction()
    {
        return damageReduction;
    }

    @Override
    public void setUsage()
    {
        usage = 15;
    }

    @Override
    public void applyEffect(Hero hero)
    {
        
    }

    @Override
    public void equipItem()
    {
        equipped = true;
    }

    @Override
    public void unequipItem()
    {
        equipped = false;
    }

    @Override
    public boolean isItemEquipped()
    {
        return equipped;
    }

    @Override
    public String toString()
    {
        String e;
        if (equipped == true)
        {
            e = "Yes";
        }
        else
        {
            e = "No";
        }
        return super.toString() + " | Damage Reduction : " + damageReduction + " | Equipped : " + e;
    }

    public ArmorDetails toDetails() {
        List<String> d = new ArrayList<>();
        d.add(name);
        d.add(String.valueOf(price));
        d.add(String.valueOf(requiredLevel));
        d.add(String.valueOf(damageReduction));

        return new ArmorDetails(d);
    }

}