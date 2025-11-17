package fileparser;

import java.util.*;
import java.io.*;

public class FileParser
{
    FileReader fr;
    String filePath;
    String tuple;
    List<String> entityDetails; //to store a tuple
    List<String> names;
    BufferedReader br;

    public FileParser()
    {
        filePath = "Legends_Monsters_and_Heroes/";
        entityDetails = new ArrayList<String>();
        names = new ArrayList<String>();
    }

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

    public List<String> getChosenHeroDetails(String name, String type)
    {
        entityDetails.clear();
        //display heros of each type to the user
        //Paladins
        //Paladins.txt Sorcerers.txt Warriors.txt
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
                if (rand.nextBoolean())
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
}