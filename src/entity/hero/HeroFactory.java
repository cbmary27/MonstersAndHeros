package entity.hero;

import java.util.*;
import fileparser.*;

public class HeroFactory{

    FileParser file;
    List<String> defaultDetails;
    public List<String> types;

    public HeroFactory()
    {
        defaultDetails = new ArrayList<String>();
        types = new ArrayList<>();
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

    public List<String> getHeros()
    {
        String heroTemp = " ";

        types.add("Paladins");
        types.add("Warriors");
        types.add("Sorcerers");

        List<String> heros = new ArrayList<>();
        List<String> heroNames = new ArrayList<>();

        file = new FileParser();

        System.out.println("Paladins: favoured for their strength and dexterity");

        heroNames = file.get("Paladins");

        heroTemp = pickRandomHero(heroNames);
        displayHero(heroTemp);
        heros.add(heroTemp);

        System.out.println();
        System.out.println("Warriors: favoured for their strength and agility");

        heroNames = file.get("Warriors");

        heroTemp = pickRandomHero(heroNames);
        displayHero(heroTemp);
        heros.add(heroTemp);

        System.out.println();
        System.out.println("Sorcerers: favoured for their dexterity and agility");

        heroNames = file.get("Sorcerers");
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