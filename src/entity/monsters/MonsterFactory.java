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
        file = new FileParser();
        types = new ArrayList<>();
        monsters = new ArrayList<>();
        defaultDetails = new ArrayList<>();
    }

    public Monsters createMonster(String name, String type, int level)
    {
        defaultDetails = file.getChosenHeroDetails(name, type);
        EntityDetails ed = new EntityDetails(defaultDetails, Constants.MONSTER);

        switch(type)
        {
            // case Constants.EXOSKELETONS:
            //     return new Exoskeletons(ed.name, level, ed.baseDamage, ed.defense, ed.dodgeAbility);
            // case Constants.SPIRITS:
            //     return new Spirits(ed.name, level, ed.baseDamage, ed.defense, ed.dodgeAbility);
            // case Constants.DRAGONS:
            //     return new Dragons(ed.name, level, ed.baseDamage, ed.defense, ed.dodgeAbility);
            case Constants.EXOSKELETONS:
            case Constants.SPIRITS:
            case Constants.DRAGONS:
                return new Monsters(ed.name, level, ed.baseDamage, ed.defense, ed.dodgeAbility, type);
            default:
                return null;
        }
    }

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

    public void displayMonsters()
    {
        int i = 0;
        for (String m : monsters)
        {
            System.out.println("[" + i + "] " + m);
        }
    }

    public String pickRandomMonster(List<String> names)
    {
        Random rand = new Random();
        return names.get(rand.nextInt(names.size()));
    }
}