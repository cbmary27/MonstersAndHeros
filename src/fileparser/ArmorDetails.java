/**
 * Filename: ArmorDetails.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-17
 * Description: A class to store the details of the armor after retrieving from the file
 */

package fileparser;

import java.util.*;

public class ArmorDetails
{
    public String name;
    public int price;
    public int level;
    public int damageReduction;

    public ArmorDetails(List<String> details)
    {
        this.name = details.get(0);
        this.price = Integer.parseInt(details.get(1));
        this.level = Integer.parseInt(details.get(2));
        this.damageReduction = Integer.parseInt(details.get(3));
    }

    @Override
    public String toString()
    {
        return name + " | Price : " + price + " | Required Level : " + level + 
        " | Damage Reduction : " + damageReduction;    
    }
}