/**
 * Filename: MonsterFactory.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-18
 * Description: A factory class to create monsters
 */

package entity.monsters;

import java.util.*;
import fileparser.*;
import utilities.constants.Constants;

public class MonsterFactory{

    FileParser file;
    List<String> defaultDetails;
    public List<String> types;
    public List<String> monsters;

    public MonsterFactory()
    {
        file = FileParser.getInstance();
        types = new ArrayList<>();
        monsters = new ArrayList<>();
        defaultDetails = new ArrayList<>();
    }

    /**
    * To intialize a Monster object according to the parameters passes
    * @param name,type,level name, type, level of the monster to be created
    * @return Mosnter object
    */
    public Monsters createMonster(String name, String type, int level)
    {
        defaultDetails = file.getChosenHeroDetails(name, type); //get the details associated with the monster
        EntityDetails ed = new EntityDetails(defaultDetails, Constants.MONSTER); //use EntityDetails to store the details

        switch(type)
        {
            case Constants.EXOSKELETONS:
            case Constants.SPIRITS:
            case Constants.DRAGONS:
                return new Monsters(ed.name, level, ed.baseDamage, ed.defense, ed.dodgeAbility, type);
            default:
                return null;
        }
    }

    /**
    * To get a list of monsters
    * @return a list of names of monsters
    */
    public List<String> getMonsters()
    {
        String monsterTemp = " ";

        types.add(Constants.EXOSKELETONS);
        types.add(Constants.DRAGONS);
        types.add(Constants.SPIRITS);

        List<String> monsterNames = new ArrayList<>();

        monsterNames = file.get(Constants.EXOSKELETONS);
        monsterTemp = pickRandomMonster(monsterNames);
        monsters.add(monsterTemp);

        monsterNames = file.get(Constants.DRAGONS);
        monsterTemp = pickRandomMonster(monsterNames);
        monsters.add(monsterTemp);

        monsterNames = file.get(Constants.SPIRITS);
        monsterTemp = pickRandomMonster(monsterNames);
        monsters.add(monsterTemp);

        return monsters;
    }

    public void displayMonsters(List<Monsters> monsters)
    {
        int i = 1;
        System.out.println();
        for (Monsters m : monsters)
        {
            System.out.println("[" + i + "] " + m);
            i++;
        }
        System.out.println();
    }

    /**
    * To pick a random monster from the list of names
    * @return the name of the monster picked
    */
    public String pickRandomMonster(List<String> names)
    {
        Random rand = new Random();
        return names.get(rand.nextInt(names.size()));
    }
}