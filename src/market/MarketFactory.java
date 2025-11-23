package market;

import java.util.*;
import fileparser.*;
import item.*;
import utilities.constants.Constants;

public class MarketFactory
{
    public FileParser file;
    public List<PotionDetails> potionDetails;
    public List<WeaponryDetails> weaponryDetails;
    public List<ArmorDetails> armorDetails;
    public List<SpellDetails> spellDetails;


    public MarketFactory()
    {
        file = FileParser.getInstance();
        potionDetails = new ArrayList<>();
        weaponryDetails = new ArrayList<>();
        armorDetails = new ArrayList<>();
        spellDetails = new ArrayList<>();
    }

    public void createMarket()
    {
        List<List<String>> p = file.getItemDetails("Potions");
        List<List<String>> w = file.getItemDetails("Weaponry");
        List<List<String>> a = file.getItemDetails("Armory");
        List<List<String>> s = file.getMultipleFileItems(new ArrayList<>(Arrays.asList("Lightning", "Fire", "Ice")), "Spells");

        for (List<String> item : p)
        {
            potionDetails.add(new PotionDetails(item));
        }

        for (List<String> item : w)
        {
            weaponryDetails.add(new WeaponryDetails(item));
        }

        for (List<String> item : a)
        {
            armorDetails.add(new ArmorDetails(item));
        }

        for (List<String> item : s)
        {
            spellDetails.add(new SpellDetails(item));
        }
    }

    public void createComplimentaryWeapons()
    {
        List<List<String>> w = file.getComplimentaryWeaponDetails("Initial");

        for (List<String> item : w)
        {
            weaponryDetails.add(new WeaponryDetails(item));
        }
    }

    public Item createPotion(PotionDetails chosenPotion)
    {
        return new Potions(
                chosenPotion.name,
                chosenPotion.price,
                chosenPotion.level,
                chosenPotion.increaseAtt,
                chosenPotion.affectedAtt );
    }

    public Item createWeaponry(WeaponryDetails chosenWeapon)
    {
        return new Weaponry(
                chosenWeapon.name,
                chosenWeapon.price,
                chosenWeapon.level,
                chosenWeapon.damage,
                chosenWeapon.requiredHands);
    }

    public Item createArmor(ArmorDetails chosenArmor)
    {
        return new Armor(
                chosenArmor.name,
                chosenArmor.price,
                chosenArmor.level,
                chosenArmor.damageReduction);
    }

    public Item createSpell(SpellDetails chosenSpell)
    {
        return new Spells(
                chosenSpell.name,
                chosenSpell.price,
                chosenSpell.level,
                chosenSpell.damage,
                chosenSpell.affectedMana,
                chosenSpell.spellType);
    }
}