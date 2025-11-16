package fileparser;

import java.util.*;
import java.io.*;

public class FileParser
{
    FileReader fr;
    String tuple;
    List<String> entityDetails; //to store a tuple
    List<String> names;
    BufferedReader br;

    public FileParser()
    {
        entityDetails = new ArrayList<String>();
        names = new ArrayList<String>();
    }

    public List<String> get(String type)
    {
        names.clear();
        //display heros of each type to the user
        //Paladins
        //Paladins.txt Sorcerers.txt Warriors.txt
        tuple = "";
        try (BufferedReader br = new BufferedReader(new FileReader("files/"+type+".txt"))){

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

    public List<String> getChosenHeroDetails(String name, String type)
    {
        entityDetails.clear();
        //display heros of each type to the user
        //Paladins
        //Paladins.txt Sorcerers.txt Warriors.txt
        tuple = "";
        try (BufferedReader br = new BufferedReader(new FileReader("files/"+type+".txt"))){

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
}