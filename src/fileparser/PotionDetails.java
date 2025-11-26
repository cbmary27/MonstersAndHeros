/**
 * Filename: PotionDetails.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-17
 * Description: A class to store the details of potions after retrieving from the file
 */

package fileparser;

import java.util.*;
import java.util.stream.Collectors;

public class PotionDetails
{
    public String name;
    public int price;
    public int level;
    public int increaseAtt;
    public String affectedAtt; 

    public PotionDetails(List<String> details)
    {
        this.name = details.get(0);
        this.price = Integer.parseInt(details.get(1));
        this.level = Integer.parseInt(details.get(2));
        this.increaseAtt = Integer.parseInt(details.get(3));
        this.affectedAtt = details.get(4);
    }

    @Override
    public String toString()
    {
        return name + " | Price : " + price + " | Required Level : " + level + 
        " |  Attribute Affected : " + affectedAtt + " | Attribute Increase : " + increaseAtt;    
    }

    public static List<String> affectedAttributesList(String affectedAtt)
    {
        return Arrays.stream(affectedAtt.split("/")).map(String::trim).collect(Collectors.toList());
    }
}