package utilities.input;

import java.util.*;
import utilities.constants.Constants;

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
        return inp.nextLine().trim().toUpperCase();
    }

    public String getIntInput(int min, int max) {

        while (true)
        {
            System.out.print("<> ");
            String input = inp.nextLine().trim();
            input = input.toUpperCase();

            if (input.equals(Constants.QUIT))
            {
                return input;
            }

            if (!input.matches("\\d+"))
            {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            int value = Integer.parseInt(input);

            if (value < min || value > max)
            {
                System.out.println("Please enter a valid index!");
                continue;
            }

            return input;
        }
    }

    public String getIntInputIndex(int min, int max) {

        while (true)
        {
            String input = inp.nextLine().trim();
            input = input.toUpperCase();

            if (!input.matches("\\d+"))
            {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            int value = Integer.parseInt(input);

            if (value < min || value > max)
            {
                System.out.println("Please enter a valid index!");
                continue;
            }

            return input;
        }
    }

}