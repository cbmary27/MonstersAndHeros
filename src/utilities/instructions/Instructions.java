package utilities.instructions;

import java.util.*;
import utilities.colour.colour;

public class Instructions{
    
    public void displayMonstersAndHeros()
    {
        System.out.println("MONSTERS AND HEROS");
        System.out.println();
        System.out.println("A long, long time ago, the land of the heros was once peaceful.");
        System.out.println("The villages thrived, the forests were calm, and the people lived without fear.");
        System.out.println("But that peace did not last forever.");
        System.out.println("One fateful night, the sky split with a roar, and from the shadows emerged monsters unlike anything the heroes had ever seen.");
        System.out.println();
        System.out.println("What was once a peaceful land slowly fell into darkness.");
        System.out.println();
        System.out.println("In a world divided by fear and fury, monsters and heroes clash without end.");
        System.out.println("Each victory against monsters earns the heroes experience and gold, letting them grow stronger, buy better gear, and sharpen their skills.");
        System.out.println("When they gain enough experience, they level up—ready to face even greater threats. The battle never stops, and the heroes must keep rising, endlessly pushing back the darkness.");
        System.out.println();
        displayInstructions();
    }

    public void displayInstructions()
    {
        System.out.println(colour.WHITE_BOLD);
        System.out.println(":INSTRUCTIONS:");
        System.out.println();
        System.out.println("1. You will first assemble your league which can consist of either 1, 2 or 3 heroes.");
        System.out.println("2. At the start of the game, each of your heroes in the league will be given a complimentary weapon to fight with.");
        System.out.println("3. A map will be presented to you, which represents the world that the heroes are in.");
        System.out.println("   - You can move around the map using the " +colour.CYAN_BOLD + "[W] Up [A] Left [S] Down [D] Right" + colour.WHITE_BOLD + " keys");
        System.out.println("   - There are three types of spaces you can land on, the common spaces (*), the market spaces (M), and the inaccessible tiles (X) which the heroes cannot enter into.");
        System.out.println();
        System.out.println(colour.YELLOW + ":MARKET:" + colour.RESET);
        System.out.println("   - Whenever the heroes are on a market tile, enter the M key to enter the market.");
        System.out.println("   - You can choose which hero is to enter the market.");
        System.out.println("   - Each hero can [B] Buy four types of items : Potions, Spells, Weapons and Armors");
        System.out.println("   - To purchase an item, the hero must have enough gold and be of the required level specified by the item's details");
        System.out.println("   - Weapons and Amrors are equippable items while Potions are consumable items, and spells can be cast on a monster only durimg battles.");
        System.out.println("   - Each item has a specific amount of uses, once used up, cannot be used any more. These items will have to be repaired at the Market using [R] Repair.");
        System.out.println("   - If a hero is running short on gold, you can always sell an item from the hero's inventory at the market using [S] Sell");
        System.out.println();
        System.out.println(colour.BLUE + ":BATTLE:" + colour.RESET);
        System.out.println("   - When you land on a common tile, there is a 50% chance that you will enter into a battle with the monsters. So, remember to be well equipped!");
        System.out.println("   - You can move around the map using the " +colour.CYAN_BOLD + "[W] Up [A] Left [S] Down [D] Right" + colour.RESET + " keys");
        System.out.println("   - You can move around the map using the " +colour.CYAN_BOLD + "[W] Up [A] Left [S] Down [D] Right" + colour.RESET + " keys");
        System.out.println();
        System.out.println(colour.CYAN + ":INVENTORY:" + colour.RESET);
        System.out.println("   - When you land on a common tile, there is a 50% chance that you will enter into a battle with the monsters. So, remember to be well equipped!");
        System.out.println("   - You can move around the map using the " +colour.CYAN_BOLD + "[W] Up [A] Left [S] Down [D] Right" + colour.RESET + " keys");
        System.out.println("   - You can move around the map using the " +colour.CYAN_BOLD + "[W] Up [A] Left [S] Down [D] Right" + colour.RESET + " keys");




    }
}