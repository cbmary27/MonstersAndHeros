package utilities.input;

import java.util.*;

public class Input{
    Scanner inp = new Scanner(System.in);

    public int integerInput()
    {
        System.out.print("<>");
        return inp.nextInt();

    }

    public String stringInput()
    {
        System.out.print("<> ");
        return inp.nextLine();
    }
}