/**
 * Filename: HeroFactory.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-15
 * Description: A factory class to create heroes
 */

package entity.hero;

import java.util.*;
import fileparser.*;
import utilities.constants.Constants;
import utilities.colour.colour;

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

    /**
    * To intialize a Hero object according to the parameters passes
    * @param name,type name and type of the hero to be created
    * @return Hero object
    */
    public Hero createHero(String name, String type)
    {
        defaultDetails = file.getChosenHeroDetails(name, type); //getting the details of the hero from the file using the file parser functionality
        EntityDetails ed = new EntityDetails(defaultDetails, Constants.HERO); //recording the details in an EntityDetails object

        switch(type)
        {
            case Constants.PALADINS:
            case Constants.SORCERERS:
            case Constants.WARRIORS:
                return new Hero(ed.name, ed.mp, ed.strength, ed.dexterity, ed.agility, ed.gold, ed.exp, type); //initializing a hero object using EntityDetails
            default:
                return null;
        }
    }

    /**
    * To get a list of heroes to display to the user
    * @return the list of hero names to be displayed
    */
    public List<String> getHeros()
    {
        String heroTemp = " ";

        types.add(Constants.PALADINS);
        types.add(Constants.WARRIORS);
        types.add(Constants.SORCERERS);

        List<String> heros = new ArrayList<>();
        List<String> heroNames = new ArrayList<>();

        System.out.println(colour.GREEN + "Paladins: favoured for their strength and dexterity" + colour.RESET);

        heroNames = file.get(Constants.PALADINS);

        heroTemp = pickRandomHero(heroNames);
        displayHero(heroTemp);
        heros.add(heroTemp);

        System.out.println();
        System.out.println(colour.YELLOW + "Warriors: favoured for their strength and agility" + colour.RESET);

        heroNames = file.get(Constants.WARRIORS);

        heroTemp = pickRandomHero(heroNames);
        displayHero(heroTemp);
        heros.add(heroTemp);

        System.out.println();
        System.out.println(colour.PURPLE + "Sorcerers: favoured for their dexterity and agility" + colour.RESET);

        heroNames = file.get(Constants.SORCERERS);
        heroTemp = pickRandomHero(heroNames);
        displayHero(heroTemp);
        heros.add(heroTemp);

        return heros;
    }

    public void displayHero(String name)
    {
        System.out.println("<> " + name + " <>");
    }

    /**
    * To pick a random hero to be generated using a list of hero names
    * @return the name picked
    */
    public String pickRandomHero(List<String> names)
    {
        Random rand = new Random();
        return names.get(rand.nextInt(names.size()));
    }
}