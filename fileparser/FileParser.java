import java.util.*;

public class FileParser
{
    FileReader fr;
    String tuple;
    List<String> EntityDetails; //to store a tuple
    List<String> names;
    BufferedReader br;

    public FileParser()
    {
        EntityDetails = new ArrayList<String>();
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

}