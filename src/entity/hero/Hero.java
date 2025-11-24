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
        equippedWeapons = new ArrayList<>();
        addListener();
    }

    public void addListener()
    {
        hlistener = new HeroStats();
    }

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
        exp = exp + level * (n + 10); //needs to be modified
        hlistener.eventExpGain(name, level * (n + 10));
        checkForLevelUp();
    }

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

    public void usePotion(Item item)
    {
        //item.updateUsage();
        Potions potion = (Potions) item;
        List<String> affectedAttribtues = potion.getAffectedAttribute();

        for (String affectedAttribute : affectedAttribtues)
        {
            switch (affectedAttribute)
            {
                case Constants.HEALTH:
                    hp = increase(hp, potion.getIncreaseAttribute());
                    hlistener.eventAttributeIncrease(Constants.HEALTH, potion.getIncreaseAttribute());
                    break;
                case Constants.AGILITY:
                    agility = increase(agility, potion.getIncreaseAttribute());
                    hlistener.eventAttributeIncrease(Constants.AGILITY, potion.getIncreaseAttribute());
                    break;
                case Constants.DEXTERITY:
                    dexterity = increase(dexterity, potion.getIncreaseAttribute());
                    hlistener.eventAttributeIncrease(Constants.DEXTERITY, potion.getIncreaseAttribute());
                    break;
                case Constants.MANA:
                    mp = increase(mp, potion.getIncreaseAttribute());
                    hlistener.eventAttributeIncrease(Constants.MANA, potion.getIncreaseAttribute());
                    break;
                case Constants.STRENGTH:
                    strength = increase(strength, potion.getIncreaseAttribute());
                    hlistener.eventAttributeIncrease(Constants.STRENGTH, potion.getIncreaseAttribute());
                    break;
            }
        }
        inventory.removeItem(item);
    }

    public int increase(int amt, int incAtt)
    {
        return amt + incAtt;
    }

    public int useSpell(Item item)
    {
        Spells spell = (Spells) item;

        if (mp >= spell.getAffectedMana())
        {
            mp = mp - spell.getAffectedMana();
            return (int) (spell.getDamage() + (dexterity / 10000.0f) * (spell.getDamage()));
        }
        else
        {
            System.out.println("Not enough MP to cast the spell!");
            return 0;
        }
    }

    public int useWeapon(Item item)
    {
        item.updateUsage();
        Weaponry w = (Weaponry) item;
        return (strength + w.getDamage()) * 5/100;
    }

    public int useArmor(Item item)
    {
        Armor a = (Armor) item;
        return a.getDamageReduction();
    }

    @Override
    public void takeDamage(int damageDealt)
    {
        int defense = 0;

        if (equippedArmor != null)
        {
            defense = useArmor(equippedArmor);
        }
        else
        {
            defense = (int) (damageDealt * 0.7);
        }
        
        hp = Math.max( 0, hp - Math.max(0, (damageDealt - defense)));
    }

    public Inventory getInventory()
    {
        return inventory;
    }

    public void openInventory()
    {
        inventory.display();
    }

    public Item selectItem(String choice)
    {
        return inventory.getItem(choice);
    }

    public void equipWeapon(Item item)
    {
        int hands;
        if (item instanceof Equippable)
        {
            Equippable wa = (Equippable) item;
            if (!wa.isItemEquipped())
            {
                hands = inventory.checkAnyWeaponEquipped();
                if (hands == 2)
                {
                    System.out.println("Cannot equip any more weapons!");
                }
                else
                {
                    System.out.println(item.getName() + " is equipped!");
                    wa.equipItem();
                    equippedWeapons.add(item);
                }
            }
        }
    }

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

    public void equipArmor(Item item)
    {
        boolean flag;
        if (item instanceof Equippable)
        {
            Equippable wa = (Equippable) item;
            if (!wa.isItemEquipped())
            {
                flag = inventory.checkAnyArmorEquipped();
                if (flag)
                {
                    System.out.println("You already have an armor equipped!");
                }
                else
                {
                    System.out.println(item.getName() + " is equipped!");
                    wa.equipItem();
                    equippedArmor = item;
                }
            }
        }
    }

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
        " | Strength : " + strength + " | Dexterity : " + dexterity + " | Agility : " + agility + " | Gold : " + gold;
    }
}