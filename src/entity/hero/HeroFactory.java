package entity.hero;

import java.util.*;
import fileparser.*;

public class HeroFactory{

    FileParser file;
    List<String> defaultDetails;
 //to make objects of hero types
    public HeroFactory()
    {
        defaultDetails = new ArrayList<String>();
    }

    public Hero createHero(String name, String type)
    {

        if (file == null)
        {
            file = new FileParser();
        }

        defaultDetails = file.getChosenHeroDetails(name, type);
        EntityDetails ed = new EntityDetails(defaultDetails);

        switch(type)
        {
            case "Paladins":
                return new Paladins(ed.name, ed.mp, ed.strength, ed.dexterity, ed.agility, ed.gold, ed. exp);
            case "Sorcerers":
                return new Sorcerers(ed.name, ed.mp, ed.strength, ed.dexterity, ed.agility, ed.gold, ed. exp);
            case "Warriors":
                return new Warriors(ed.name, ed.mp, ed.strength, ed.dexterity, ed.agility, ed.gold, ed. exp);
            default:
                System.out.println("Error");
                return null;
        }
    }
}