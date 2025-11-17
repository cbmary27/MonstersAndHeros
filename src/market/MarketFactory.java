package market;

import java.util.*;
import fileparser.*;
import item.*;

public class MarketFactory
{
    public FileParser file;
    // public List<String> PotionDetails;
    // public List<String> WeaponDetails;
    // public List<String> ArmorDetails;
    // public List<String> SpellDetails;
    public List<PotionDetails> potionDetails;


    public MarketFactory()
    {
        //potitonDetails = new PotionDetails();
    }

    public void createMarket()
    {
        if (file == null)
        {
            file = new FileParser();
        }

        List<List<String>> p = file.getItemDetails("Potions");

        p = new ArrayList<>();

        for (List<String> item : p)
        {
            potionDetails.add(new PotionDetails(item));
        }

        // WeaponDetails.add(file.getItemDetails("Weaponry"));
        // ArmorDetails.add(file.getItemDetails("Armory"));
        // SpellDetails.add(file.getItemDetails("Spells"));

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
}