/**
 * Filename: FileParser.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-14
 * Description: A class to implement the logic to retrieve details from the text files
 */

package fileparser;

import java.util.*;
import java.io.*;
import utilities.constants.Constants;

public class FileParser
{
    private static FileParser fileParser;

    FileReader fr;
    String filePath;
    String tuple;
    List<String> entityDetails; //to store a tuple
    List<String> names;
    BufferedReader br;

    public FileParser()
    {
        filePath = Constants.filePath;
        entityDetails = new ArrayList<String>();
        names = new ArrayList<String>();
    }

    /**
    * A static method to get an instance of FileParser
    */
    public static FileParser getInstance()
    {
        if (fileParser == null)
        {
            fileParser = new FileParser();
        }
        return fileParser;
    }

    /**
    * A method to get a list of names of items/entities from the files by the type
    * @param type the type of item/entity
    * @return a list of names of the item/entity
    */
    public List<String> get(String type)
    {
        names.clear();
        tuple = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath+type+".txt"))){

        br.readLine();
        tuple = br.readLine();

        while (tuple != null)
        {
            String[] details = tuple.split("\\s+");
            names.add(details[0]);
            tuple = br.readLine();
        } }
        catch (IOException io)
        {
            io.printStackTrace();
        }

        return names;

    }

    /**
    * A method to get the details of the of heros chosen for the player
    * @param name,type the name and type of the hero for whom the details are to be retrieved
    * @return a list of details of the hero
    */
    public List<String> getChosenHeroDetails(String name, String type)
    {
        entityDetails.clear();
        tuple = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath+type+".txt"))){

        br.readLine();
        tuple = br.readLine();

        while (tuple != null)
        {
            String[] details = tuple.split("\\s+");
            if (name.equals(details[0]))
            {
                for (String detail: details)
                {
                    entityDetails.add(detail);
                }
                return entityDetails;
            }

            tuple = br.readLine();
        } }
        catch (IOException io)
        {
            io.printStackTrace();
        }

        return entityDetails;
    }

    /**
    * A method to get the details of spell items
    * @param type the type of spell item whose details are required
    * @return a list of details of the spell
    */
    public List<List<String>> getItemDetails(String type)
    {
        Random rand = new Random();
        List<List<String>> itemDetails = new ArrayList<>();

        tuple = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath+type+".txt"))){

        br.readLine();
        tuple = br.readLine();

        while (tuple != null)
        {
            if (rand.nextBoolean())
            {
                tuple = br.readLine();
                continue;
            }

            String[] details = tuple.split("\\s+");

            List<String> i = Arrays.asList(details);
            itemDetails.add(new ArrayList<>(i));

            tuple = br.readLine();
        } }
        catch (IOException io)
        {
            io.printStackTrace();
        }

        return itemDetails;
    }

     /**
    * A method to get the item details from multiple files
    * @param fileType,type the files required as well the type of the item
    * @return a list of details from the files
    */
    public List<List<String>> getMultipleFileItems(List<String> fileType, String type)
    {
        List<List<String>> itemDetails = new ArrayList<>();
        for (String ft : fileType)
        {
            Random rand = new Random();

            tuple = "";
            try (BufferedReader br = new BufferedReader(new FileReader(filePath + ft + type + ".txt"))){

            br.readLine();
            tuple = br.readLine();

            while (tuple != null)
            {
                if (rand.nextBoolean()) //choosing items randomly
                {
                    tuple = br.readLine();
                    continue;
                }

                String[] details = tuple.split("\\s+");

                List<String> i = new ArrayList<>(Arrays.asList(details));
                i.add(ft);
                itemDetails.add(new ArrayList<>(i));

                tuple = br.readLine();
            } }
            catch (IOException io)
            {
                io.printStackTrace();
            }
        }
        return itemDetails;
    }

    /**
    * A method to get the details of complimentary weapons for the heroes
    * @param type the file type
    * @return a list of details of the complimentary weapons
    */
    public List<List<String>> getComplimentaryWeaponDetails(String type)
    {
        List<List<String>> itemDetails = new ArrayList<>();

        tuple = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath+type+".txt"))){

        br.readLine();
        tuple = br.readLine();

        while (tuple != null)
        {
            String[] details = tuple.split("\\s+");

            List<String> i = Arrays.asList(details);
            itemDetails.add(new ArrayList<>(i));

            tuple = br.readLine();
        }
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }

        return itemDetails;
    }
}