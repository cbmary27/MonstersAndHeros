package entity.hero;

import java.util.*;
import fileparser.*;
import utilities.constants.Constants;

public class HeroFactory{

    FileParser file;
    List<String> defaultDetails;
    public List<String> types;

    public HeroFactory()
    {
        file = FileParser.getInstance();
        defaultDetails = new ArrayList<String>();
        types = new ArrayList<>();
    }

    public Hero createHero(String name, String type)
    {
        defaultDetails = file.getChosenHeroDetails(name, type);
        EntityDetails ed = new EntityDetails(defaultDetails, Constants.HERO);

        switch(type)
        {
            // case Constants.PALADINS:
            //     return new Paladins(ed.name, ed.mp, ed.strength, ed.dexterity, ed.agility, ed.gold, ed. exp);
            // case Constants.SORCERERS:
            //     return new Sorcerers(ed.name, ed.mp, ed.strength, ed.dexterity, ed.agility, ed.gold, ed. exp);
            // case Constants.WARRIORS:
            //     return new Warriors(ed.name, ed.mp, ed.strength, ed.dexterity, ed.agility, ed.gold, ed. exp);

            case Constants.PALADINS:
            case Constants.SORCERERS:
            case Constants.WARRIORS:
                return new Hero(ed.name, ed.mp, ed.strength, ed.dexterity, ed.agility, ed.gold, ed. exp, type);
            default:
                return null;
        }
    }

    public List<String> getHeros()
    {
        String heroTemp = " ";

        types.add(Constants.PALADINS);
        types.add(Constants.WARRIORS);
        types.add(Constants.SORCERERS);

        List<String> heros = new ArrayList<>();
        List<String> heroNames = new ArrayList<>();

        System.out.println("Paladins: favoured for their strength and dexterity");

        heroNames = file.get(Constants.PALADINS);

        heroTemp = pickRandomHero(heroNames);
        displayHero(heroTemp);
        heros.add(heroTemp);

        System.out.println();
        System.out.println("Warriors: favoured for their strength and agility");

        heroNames = file.get(Constants.WARRIORS);

        heroTemp = pickRandomHero(heroNames);
        displayHero(heroTemp);
        heros.add(heroTemp);

        System.out.println();
        System.out.println("Sorcerers: favoured for their dexterity and agility");

        heroNames = file.get(Constants.SORCERERS);
        heroTemp = pickRandomHero(heroNames);
        displayHero(heroTemp);
        heros.add(heroTemp);

        return heros;
    }

    public void displayHero(String name)
    {
        System.out.println("<>" + name + "<>");
    }

    public String pickRandomHero(List<String> names)
    {
        Random rand = new Random();
        return names.get(rand.nextInt(names.size()));
    }
}