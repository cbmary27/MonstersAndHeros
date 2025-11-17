package fileparser;

import java.util.*;

public class PotionDetails
{
    public String name;
    public int price;
    public int level;
    public int increaseAtt;
    public int affectedAtt; 

    public PotionDetails(List<String> details)
    {
        this.name = details.get(0);
        this.price = Integer.parseInt(details.get(1));
        this.level = Integer.parseInt(details.get(2));
        this.increaseAtt = Integer.parseInt(details.get(3));
        this.affectedAtt = Integer.parseInt(details.get(4));
    }

    public String toString()
    {
        return name + " | " + price + " | " + level + " | " + increaseAtt + " | " + affectedAtt;
    }
}