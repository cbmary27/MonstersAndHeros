package input;

import java.util.*;

public class Input{
    Scanner inp = new Scanner(System.in);

    public int integerInput()
    {
        return inp.nextInt();

    }

    public String stringInput()
    {
        return inp.nextLine();
    }
}