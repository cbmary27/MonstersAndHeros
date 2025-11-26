/**
 * Filename: Input.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-17
 * Description: A class to take the input of the player
 */

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

    /**
    * A method to get the string input of the player
    * @return string input
    */
    public String stringInput()
    {
        System.out.print("<> ");
        return inp.nextLine().trim().toUpperCase();
    }

    /**
    * A method to get input of the player meant for integer operations and checking if the input is valid
    * @param min,max the range of values required
    * @return string input
    */
    public String getIntInput(int min, int max) {

        while (true)
        {
            System.out.print("<> ");
            String input = inp.nextLine().trim();
            input = input.toUpperCase();

            if (input.equals(Constants.QUIT)) //can be quit
            {
                return input;
            }

            if (!input.matches("\\d+")) //checking if it is a digit
            {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            int value = Integer.parseInt(input);

            if (value < min || value > max) //checkng if it falls within the range of values required
            {
                System.out.println("Please enter a valid index!");
                continue;
            }

            return input;
        }
    }

    /**
    * A method to get input of the player meant for integer operations and checking if the input is valid
    * whithout the quit option
    * @param min,max the range of values required
    * @return string input
    */
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