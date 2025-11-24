package item;

import java.util.*;
import fileparser.PotionDetails;
import utilities.constants.Constants;

public class Potions extends Item{

    protected int increaseAtt;
    protected String affectedAtt;

    public Potions(String name, int price, int level, int increaseAtt, String affectedAtt)
    {
        super(name, price, level);
        this.type = "Potion";
        this.increaseAtt = increaseAtt;
        this.affectedAtt = affectedAtt;
    }

    @Override
    public void updateUsage()
    {
        this.usage = 0;
    }

    public List<String> getAffectedAttribute()
    {
        return PotionDetails.affectedAttributesList(affectedAtt);
    }

    public int getIncreaseAttribute()
    {
        return this.increaseAtt;
    }

    @Override
    public String toString()
    {
        return super.toString() + " | Attribute affected : " + affectedAtt + " | Attribute increase : " + increaseAtt;    
    }

    public PotionDetails toDetails() {
        List<String> d = new ArrayList<>();
        d.add(name);
        d.add(String.valueOf(price));
        d.add(String.valueOf(requiredLevel));
        d.add(String.valueOf(increaseAtt));
        d.add(affectedAtt);
        return new PotionDetails(d);
    }
}