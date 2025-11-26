/**
 * Filename: Instructions.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-17
 * Description: A class to display the instructions of the game
 */

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
        System.out.println(colour.GREEN + "       That's all for now! Now, I must take my leave. Begin your adventure and lead us to Victory!" + colour.RESET);
        System.out.println();
        System.out.println("<------------------------------------------------------------------------------------------------------------->");
        System.out.println();
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
        System.out.println(colour.RED + ":ITEMS:" + colour.RESET);
        System.out.println("> Potions - Using these can increase the attributes of a hero. For eg. Using a health potion increases the hero's HP. Can be used : once");
        System.out.println("> Spells - These items cause critical damage. So be on the lookout for these and use them sparingly! Can be used : once");
        System.out.println("> Weapons - These items are used for attacking the monsters. Each weapon has a maximum usage of 10 attacks.");
        System.out.println("> Armors - These items are used for reducing the damage on the heros, imparted by the monster's attacks. Each armor has a maximum usage of 15 hits.");
        System.out.println(colour.RED + "All items can be repaired at the market once their usage amounts to 0." + colour.RESET);
        System.out.println();
        System.out.println(colour.BLUE + ":BATTLE:" + colour.RESET);
        System.out.println("   - When you land on a common tile, there is a 50% chance that you will enter into a battle with the monsters. So, remember to be well equipped!");
        System.out.println("   - The number of monsters that appear during the battle equals the number of heros in your league.");
        System.out.println("   - The heros go first in each round, and a round constitutes of a hero and a monster turn.");
        System.out.println("   - If there is more than one hero in your league, each hero will be able to choose which target they want to attack during their turn.");
        System.out.println("   - The monster will attack any of the heroes in your league, so be aware!");
        System.out.println("   - Each hero has three options during their turn - [A] Attack, [O] Open Invenotry and [F] Forfeit Battle which exits the battle entirely");
        System.out.println("   - Attack will make use of the hero's equipped weapon to fight the monster. If the hero has two equipped weapons, the hero can choose which weapon is used for the attack.");
        System.out.println("   - When the hero opens their inventory, they can either [P] Use a Potion, [S] Cast a Spell, [E] Equip a weapon or [UE] Unequip a weapon.");
        System.out.println("   - Each of the above will consume a hero's turn.");
        System.out.println("   - The monster or a hero faints if their HP reaches 0. ");
        System.out.println("   - If all heroes win the battle, they gain exp and gold, with increases their chances of levelling up!");
        System.out.println();
        System.out.println(colour.CYAN + ":INVENTORY:" + colour.RESET);
        System.out.println("   - Using [I] Information, you can view the inventory of each hero.");
        System.out.println("   - For each hero, you can do [P] Use a Potion [E] Equip a Weapon/Armor [UE] Unequip a weapon/armor");
        System.out.println("   - You will be able to view the statistics of each player such as Status, EXP, HP, etc as well as the statistics of the items each hero owns.");
        System.out.println("   - You can move around the map using the " + colour.CYAN_BOLD + "[W] Up [A] Left [S] Down [D] Right" + colour.RESET + " keys");
        System.out.println();

        System.out.println(colour.RED + "NOTE - A hero will always need a weapon with them at all times. Thus, they cannot unequip or sell a weapon if they only have a single weapon in their inventory." + colour.RESET);
        System.out.println();
    }
}