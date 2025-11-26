/**
 * Filename: Hero.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-15
 * Description: A class for Hero and their functionalites, extends the Entity class
 */

package entity.hero;

import java.util.*;
import inventory.Inventory;
import entity.Entity;
import interfaces.*;
import item.*;
import interfaces.takeDamage;
import utilities.constants.Constants;
import stats.HeroStats;

public class Hero extends Entity implements takeDamage, Listeners{
    protected int mp;
    protected int strength; //increases when using a weapon
    protected int dexterity; //increases when casting a spell
    protected int agility; //increases chances to dodge a monsters attack
    protected int gold; //basically money to use at the market
    protected int exp;
    protected Inventory inventory;
    protected List<Item> equippedWeapons;
    protected Item equippedArmor;
    protected String type;
    protected int itemDamage;
    protected String status;
    HeroStats hlistener;

    public Hero(String name, int mp, int strength, int dexterity, int agility, int gold, int exp, String type)
    {
        super(name, 1);
        this.mp = mp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.gold = gold;
        this.exp = exp;
        this.type = type;
        this.inventory = new Inventory();
        status = Constants.HEALTHY;
        equippedWeapons = new ArrayList<>();
        addListener();
    }

    /**
    * Adding an observer to record hero statistics and display
    * @return void method
    */
    public void addListener()
    {
        hlistener = new HeroStats();
    }

    /**
    * Logic for when a hero levels up
    * @return void method
    */
    public void increaseLevel()
    {
        level++;
        calcHP();
        calcMP();
        calcStrength();
        calcDexterity();
        calcAgility();

        switch(type)
        {
            case Constants.WARRIORS:
                calcStrength();
                calcAgility();
                break;
            case Constants.PALADINS:
                calcDexterity();
                calcAgility();
                break;
            case Constants.SORCERERS:
                calcStrength();
                calcDexterity();
                break;
        }

        hlistener.eventLevelIncrease(name, level);
    }

    public void calcAgility()
    {
        agility = agility + (agility * 5 / 100);
    }

    public void calcStrength()
    {
        strength = strength + (strength * 5 / 100);
    }

    public void calcDexterity()
    {
        dexterity = dexterity + (dexterity * 5 / 100);
    }

    public void calcEXP(int n)
    {
        exp = exp + level * (n + 10);
        hlistener.eventExpGain(name, level * (n + 10));
        checkForLevelUp();
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String state)
    {
        status = state;
    }

    /**
    * Checking whether a hero can level up after EXP gain
    * @return void method
    */
    public void checkForLevelUp()
    {
        if (exp >= (level * 20))
        {
            increaseLevel();
            exp = Math.max(1, exp - (level * 20));
        }
    }

    public void calcMP()
    {
        mp = mp * 11 / 10;
    }

    public double calcDodge()
    {
        return (agility * 0.002);
    }

    public int getItemDamage()
    {
        return itemDamage;
    }

    /**
    * To calculate the gold amount gained by hero after winning a battle
    * @return void method
    */
    public void goldReward(int level)
    {
        gold = gold + (level * 100);
        hlistener.eventGainedGold(name, level * 100);
    }

    public void increaseGold(int price)
    {
        gold = gold + (price * 50);
    }

    public void updateGold(int price)
    {
        gold = gold - price;
    }

    public void setGold(int gold)
    {
        this.gold = gold;
    }

    public int getGold()
    {
        return gold;
    }

    public void setLevel(int gold)
    {
        this.level = level;
    }

    public int getLevel()
    {
        return level;
    }

    public List<Item> getEquippedWeapons()
    {
        return equippedWeapons;
    }

    public Item getEquippedArmor()
    {
        return equippedArmor;
    }

    public void setEquippedArmor(Item item)
    {
        equippedArmor = item;
    }

    public void displayEquippedWeapons()
    {
        int i = 1;

        for (Item item : equippedWeapons)
        {
            System.out.println("[" + i + "] " + item);
            System.out.println();
            i++;
        }
    }

    public int getStrength()
    {
        return this.strength;
    }

    public int getDexterity()
    {
        return this.dexterity;
    }

    public int getMP()
    {
        return this.mp;
    }

    public void setMP(int val)
    {
        this.mp = val;
    }

    /**
    * To calculate the attribute increase of a hero after an item is consumed
    * @param amt,incAtt the amount by which the attribute has to increase
    * @return void method
    */
    public void increaseAttribute(int amt, String incAtt)
    {
        switch(incAtt)
        {
            case Constants.HEALTH:
                hp = hp + amt;
                setStatus(Constants.HEALTHY);
                hlistener.eventAttributeIncrease(Constants.HEALTH, amt);
                break;
            case Constants.AGILITY:
                agility = agility + amt;
                hlistener.eventAttributeIncrease(Constants.AGILITY, amt);
                break;
            case Constants.DEXTERITY:
                dexterity = dexterity + amt;
                hlistener.eventAttributeIncrease(Constants.DEXTERITY, amt);
                break;
            case Constants.MANA:
                mp = mp + amt;
                hlistener.eventAttributeIncrease(Constants.MANA, amt);
                break;
            case Constants.STRENGTH:
                strength = strength + amt;
                hlistener.eventAttributeIncrease(Constants.STRENGTH, amt);
                break;
        }
    }

    public void getDamageFromItem(int damage)
    {
        itemDamage = damage;
    }

    /**
    * To calculate the damage reduction from the hero wearing an armor
    * @param item the armor worn by hero
    * @return damage reduction of armor
    */
    public int useArmor(Item item)
    {
        Armor a = (Armor) item;
        return a.getDamageReduction();
    }

    /**
    * Logic for a hero taking damage from a monster
    * @param damageDealt the damage induced by a monster's attack
    * @return void method
    */
    @Override
    public void takeDamage(int damageDealt)
    {
        int defense = 0;

        if (equippedArmor != null) //checking if hero has worn an armor, which increase defense
        {
            defense = useArmor(equippedArmor);
        }
        else
        {
            defense = (int) (damageDealt * 0.7);
        }
        
        hp = Math.max( 0, hp - Math.max(0, (damageDealt - defense))); //calculating HP of hero after damage
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public void openInventory()
    {
        inventory.open(this);
    }

    public Item selectItem(String choice)
    {
        return inventory.getItem(choice);
    }

    /**
    * Logic for the hero to equip a weapon
    * @param item the weapon to be equipped by the hero
    * @return void method
    */
    public void equipWeapon(Item item)
    {
        int hands;
        if (item instanceof Equippable)
        {
            Equippable wa = (Equippable) item;
            Weaponry w = (Weaponry) item;
            if (!wa.isItemEquipped()) //checking if weapon is already equipped
            {
                hands = inventory.checkAnyWeaponEquipped(); //checking if any other weapon is equipped
                if (hands == 2) //if weapon currently equipped required two hands or hero has equipped two weapons
                {
                    System.out.println("Cannot equip any more weapons!");
                    System.out.println();
                }
                else
                {
                    if (hands + w.getRequiredHands() > 2)
                    {
                        System.out.println("This weapon requires to be held with two hands!");
                        System.out.println();
                    }
                    else
                    {
                        System.out.println(item.getName() + " is equipped!");
                        wa.equipItem(); //else, hero can equip the weapon
                        equippedWeapons.add(item);
                    }
                }
            }
        }
    }

    /**
    * Logic for the hero to unequip a weapon
    * @param item the weapon to unequip
    * @return void method
    */
    public void unEquipWeapon(Item item)
    {
        if (item instanceof Equippable)
        {
            Equippable wa = (Equippable) item;
            if (wa.isItemEquipped())
            {
                    System.out.println(item.getName() + " is unequipped");
                    wa.unequipItem();
                    equippedWeapons.remove(item);
            }
        }
    }

    /**
    * Logic for the hero to equip an armor
    * @param item the armor to be equipped
    * @return void method
    */
    public void equipArmor(Item item)
    {
        boolean flag;
        if (item instanceof Equippable)
        {
            Equippable wa = (Equippable) item;
            if (!wa.isItemEquipped()) //checking if the armor is already equipped
            {
                flag = inventory.checkAnyArmorEquipped(); //checking if any other armor is already equipped
                if (flag)
                {
                    System.out.println("You already have an armor equipped!");
                }
                else
                {
                    System.out.println(item.getName() + " is equipped!");
                    wa.equipItem(); //else, hero can equip the weapon
                    equippedArmor = item;
                }
            }
        }
    }

    /**
    * Logic for the hero to unequip an armor
    * @param item the armor to be unequipped
    * @return void method
    */
    public void unEquipArmor(Item item)
    {
        if (item instanceof Equippable)
        {
            Equippable wa = (Equippable) item;
            if (wa.isItemEquipped())
            {
                System.out.println(item.getName() + " is unequipped!");
                wa.unequipItem();
                equippedArmor = null;
            }
        }
    }

    @Override
    public String toString()
    {
        return super.toString() + " | EXP : " + exp +
         "| Status : " + status + " | Strength : " + strength + " | Dexterity : " + dexterity + " | Agility : " + agility + 
          "| Gold : " + gold;
    }
}