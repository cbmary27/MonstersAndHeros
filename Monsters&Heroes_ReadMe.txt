# CS611 Assignment 4
## MONSTERS AND HEROES 
---------------------------------------------------------------------------


Name: Chris Mary Benson
Email: chris27@bu.edu
ID: U56085268


Github Link: https://github.com/ChrisCodes27/MonstersAndHeros.git


## Files
---------------------------------------------------------------------------


Game.java - Contains the main class where an instance of the GameStarter class is initialized.
GameStarter.java - Displays the menu of games to the player to choose from.
MonstersAndHeros.java - A class specific for the Monster And Heroes game.


Battle.java - Implements the logic for battles between heroes and monsters.


Player.java - A class for Player and its functionalities


Entity.java - Abstract class that serves as a base class for other entities.
Hero.java - A class that consists of attributes specific for a hero.
HeroFactory.java - A factory class for hero to create and initialize objects of type Hero.
Monsters.java - A class that consists of attributes specific for a monster.
MonsterFactory.java - A factory class for monster to create and initialize objects of type Monster.


BattleStats.java - An observer class to record actions during a battle between the heroes and the monsters.
HeroStats.java - An observer class to record actions that affect a hero and its attributes.


Listeners.java - An interface for the listener classes
Equippable.java - An interface for items that are equippable.
ShowMenu.java - An interface for the menu classes to implement
BattleEventListener.java - An interface for the BattleStats class to implement
HeroEventListener.java - An interface for the HeroStats class to implement
takeDamage.java - An interface for entities that are affected by the damage imparted on them.


BattleMenu.java - A class to print statements for Battle
MarketMenu.java - A class to print statements for Market
InventoryMenu.java - A class to print statements for Inventory
GameMenu.java - A class to print statements for Game


fileParser.java - A class to retrieve files and extract details from them.
EntityDetails.java - A class to store details of entities from the files.
PotionDetails.java - A class to store details of potions from the files.
WeaponryDetails.java - A class to store details of weaponry from the files.
ArmorDetails.java - A class to store details of armor from the files.


Market.java - A class that implements the functionalities for the market.
MarketFactory.java - A factory class that creates the item objects to be displayed in the market.


Inventory.java - A class that represents the inventory of a hero. Consists of items.


Item.java - Abstract class that serves as a base class for other item types.
Potion.java - A class that consists of attributes specific for a potion.
Spell.java - A class that consists of attributes specific for a spell.
Weaponry.java - A class that consists of attributes specific for a weapon.
Armor.java - A class that consists of attributes specific for an armor.


Tile.java - Represents the tile on the board. Each tile will have certain characteristics - its position on the board indicated by the row and column and also the value on the tile which is represented by an object of the Piece class.
World.java - A class that can be used to represent the map in Monsters And Heroes.
Piece.java - Represents a piece on a tile on the board. It is of generic type.


Colour.java - A class which contains the ANSI codes for colours.
textStyle.java - A class which contains the ANSI codes for various text styles.
Error.java - A class to print the error messages.
Instructions.java - A class to print the instructions for each game
Constants.java - A class to store values in variables to be used in other classes.
Input.java - A class to get the player input and perform checks.




## Notes
---------------------------------------------------------------------------
(Note: In the output on terminal, made use of colours for the output.)


- Made different utility classes such as colour, error, input, instructions, etc.
- Made use of design patterns - Factory, Singleton (FileParser), and Observer (for battle and hero) design pattern.
- HeroFactory, MonsterFactory and MarketFactory to create and initialize objects of entities/items.
- Made use of the generic type across a few classes, such as the Games class, to allow initialization of multiple players in multiplayer games.
- Made use of interfaces such as Equippable for items that are equippable and other interfaces. 


- Heroes get complimentary weapons at the start of the game.
- Battles consist of heroes choosing who they want to fight against.
- Each market tile on the map is unique (has different items) and each tile has its own market instance meaning that a new market is not generated each time the party steps on the same market tile.




## How to compile and run
---------------------------------------------------------------------------


* unzip Assignment4.zip
* cd MonstersAndHeroes
* mkdir -p out
* javac -d out/ $(find src -name "*.java")
* java -cp out main.Main

Through github link:

*git clone https://github.com/ChrisCodes27/MonstersAndHeros.git
*cd MonstersAndHeros
* javac -d out/ $(find src -name "*.java")
* java -cp out main.Main


## Input/Output Example
---------------------------------------------------------------------------
                      MONSTERS AND HEROES


A long, long time ago, the land of the heros was once peaceful.
The villages thrived, the forests were calm, and the people lived without fear.
But that peace did not last forever.
One fateful night, the sky split with a roar, and from the shadows emerged monsters unlike anything the heroes had ever seen.


What was once a peaceful land slowly fell into darkness.


In a world divided by fear and fury, monsters and heroes clash without end.
Each victory against monsters earns the heroes experience and gold, letting them grow stronger, buy better gear, and sharpen their skills.
When they gain enough experience, they level up—ready to face even greater threats. The battle never stops, and the heroes must keep rising, endlessly pushing back the darkness.




:INSTRUCTIONS:


1. You will first assemble your league which can consist of either 1, 2 or 3 heroes.
2. At the start of the game, each of your heroes in the league will be given a complimentary weapon to fight with.
3. A map will be presented to you, which represents the world that the heroes are in.
   - You can move around the map using the [W] Up [A] Left [S] Down [D] Right keys
   - There are three types of spaces you can land on, the common spaces (*), the market spaces (M), and the inaccessible tiles (X) which the heroes cannot enter into.


:MARKET:
   - Whenever the heroes are on a market tile, enter the M key to enter the market.
   - You can choose which hero is to enter the market.
   - Each hero can [B] Buy four types of items : Potions, Spells, Weapons and Armors
   - To purchase an item, the hero must have enough gold and be of the required level specified by the item's details
   - Weapons and Amrors are equippable items while Potions are consumable items, and spells can be cast on a monster only durimg battles.
   - Each item has a specific amount of uses, once used up, cannot be used any more. These items will have to be repaired at the Market using [R] Repair.
   - If a hero is running short on gold, you can always sell an item from the hero's inventory at the market using [S] Sell


:ITEMS:
> Potions - Using these can increase the attributes of a hero. For eg. Using a health potion increases the hero's HP. Can be used : once
> Spells - These items cause critical damage. So be on the lookout for these and use them sparingly! Can be used : once
> Weapons - These items are used for attacking the monsters. Each weapon has a maximum usage of 10 attacks.
> Armors - These items are used for reducing the damage on the heros, imparted by the monster's attacks. Each armor has a maximum usage of 15 hits.
All items can be repaired at the market once their usage amounts to 0.


:BATTLE:
   - When you land on a common tile, there is a 50% chance that you will enter into a battle with the monsters. So, remember to be well equipped!
   - The number of monsters that appear during the battle equals the number of heros in your league.
   - The heros go first in each round, and a round constitutes of a hero and a monster turn.
   - If there is more than one hero in your league, each hero will be able to choose which target they want to attack during their turn.
   - The monster will attack any of the heroes in your league, so be aware!
   - Each hero has three options during their turn - [A] Attack, [O] Open Invenotry and [F] Forfeit Battle which exits the battle entirely
   - Attack will make use of the hero's equipped weapon to fight the monster. If the hero has two equipped weapons, the hero can choose which weapon is used for the attack.
   - When the hero opens their inventory, they can either [P] Use a Potion, [S] Cast a Spell, [E] Equip a weapon or [UE] Unequip a weapon.
   - Each of the above will consume a hero's turn.
   - The monster or a hero faints if their HP reaches 0.
   - If all heroes win the battle, they gain exp and gold, with increases their chances of levelling up!


:INVENTORY:
   - Using [I] Information, you can view the inventory of each hero.
   - For each hero, you can do [P] Use a Potion [E] Equip a Weapon/Armor [UE] Unequip a weapon/armor
   - You will be able to view the statistics of each player such as Status, EXP, HP, etc as well as the statistics of the items each hero owns.
   - You can move around the map using the [W] Up [A] Left [S] Down [D] Right keys


NOTE - A hero will always need a weapon with them at all times. Thus, they cannot unequip or sell a weapon if they only have a single weapon in their inventory.


       That's all for now! Now, I must take my leave. Begin your adventure and lead us to Victory!


<------------------------------------------------------------------------------------------------------------->




Time to assemble your league!


Paladins: favoured for their strength and dexterity
<> Lunessa <>


Warriors: favoured for their strength and agility
<> Flandal_Steelskin <>


Sorcerers: favoured for their dexterity and agility
<> Selunea <>


How many heros will accompany you on your journey?
Your party can either have 1, 2 or 3 heros!


[INPUT]


<> 2


[OUTPUT]


Now...we don't want your heros out in the wild without a weapon now, do we?
Here's a complimentary weapon to get you started! (and keep you safe from the monsters)


Lunessa: Stick is equipped!


Eunoia_Cyn: Stick is equipped!


[1] Lunessa | HP : 100 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500
[2] Eunoia_Cyn | HP : 100 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500


Select a hero's inventory to view | [Q] Quit
[INPUT]
<> q


[OUTPUT]


+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:
[INPUT]


<> w


[OUTPUT]


Grrrrr......
Uh Oh, What was that?
MONSTERS!!!!!


Monster DocOck has appeared!
Monster Igneel has appeared!


 ----------------------------------
|       BATTLE BEGINS : FIGHT!     |
 ----------------------------------
                                ROUND 1 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 100 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500


Eunoia_Cyn | HP : 100 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500


Lunessa, choose your target!


[1] DocOck | HP : 100 | Level : 1
[2] Igneel | HP : 100 | Level : 1


[INPUT]


<> 1


[OUTPUT]


Lunessa | HP : 100 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500
DocOck | HP : 100 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 10 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking DocOck


Lunessa dealt 40 damage


Eunoia_Cyn, choose your target!


[1] DocOck | HP : 84 | Level : 1
[2] Igneel | HP : 100 | Level : 1


[INPUT]


<> 2


[OUTPUT]




Eunoia_Cyn | HP : 100 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500
Igneel | HP : 100 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 10 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Igneel


Eunoia_Cyn dealt 37 damage




[ MONSTER(S) TURN BEGINS ]


DocOck is attacking Eunoia_Cyn


Eunoia_Cyn dodged DocOck's attack!


DocOck dealt 0 damage


Igneel is attacking Eunoia_Cyn


Eunoia_Cyn dodged Igneel's attack!


Igneel dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 2 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 100 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500


Eunoia_Cyn | HP : 100 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500


Lunessa, choose your target!


[1] DocOck | HP : 84 | Level : 1
[2] Igneel | HP : 77 | Level : 1


[INPUT]


<> 1


[OUTPUT]


Lunessa | HP : 102 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500
DocOck | HP : 84 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a


[1] Weapon: Stick | Uses Left : 9 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking DocOck


DocOck dodged Lunessa's attack!


Eunoia_Cyn, choose your target!


[1] DocOck | HP : 84 | Level : 1
[2] Igneel | HP : 77 | Level : 1


[INPUT]


<> 2


[OUTPUT]


Eunoia_Cyn | HP : 102 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500
Igneel | HP : 77 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 9 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Igneel


Eunoia_Cyn dealt 37 damage




[ MONSTER(S) TURN BEGINS ]


DocOck is attacking Lunessa


Lunessa dodged DocOck's attack!


DocOck dealt 0 damage


Igneel is attacking Lunessa


Lunessa dodged Igneel's attack!


Igneel dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 3 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 102 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500


Eunoia_Cyn | HP : 102 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500


Lunessa, choose your target!


[1] DocOck | HP : 84 | Level : 1
[2] Igneel | HP : 54 | Level : 1


[INPUT]


<> 2


[OUTPUT]


Lunessa | HP : 104 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500
Igneel | HP : 54 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 8 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Igneel


Igneel dodged Lunessa's attack!


Eunoia_Cyn, choose your target!


[1] DocOck | HP : 84 | Level : 1
[2] Igneel | HP : 54 | Level : 1


[INPUT]


<> 1


[OUTPUT]


Eunoia_Cyn | HP : 104 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500
DocOck | HP : 84 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 8 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking DocOck


DocOck dodged Eunoia_Cyn's attack!




[ MONSTER(S) TURN BEGINS ]


DocOck is attacking Lunessa


Lunessa dodged DocOck's attack!


DocOck dealt 0 damage


Igneel is attacking Lunessa


Lunessa dodged Igneel's attack!


Igneel dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 4 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 104 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500


Eunoia_Cyn | HP : 104 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500


Lunessa, choose your target!


[1] DocOck | HP : 84 | Level : 1
[2] Igneel | HP : 54 | Level : 1




[INPUT]


<> 2


[OUTPUT]


Lunessa | HP : 106 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500
Igneel | HP : 54 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 7 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Igneel


Lunessa dealt 40 damage


Eunoia_Cyn, choose your target!


[1] DocOck | HP : 84 | Level : 1
[2] Igneel | HP : 30 | Level : 1




[INPUT]


<> 1


[OUTPUT]


Eunoia_Cyn | HP : 106 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500
DocOck | HP : 84 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 7 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking DocOck


Eunoia_Cyn dealt 37 damage




[ MONSTER(S) TURN BEGINS ]


DocOck is attacking Lunessa


Lunessa dodged DocOck's attack!


DocOck dealt 0 damage


Igneel is attacking Lunessa


Lunessa dodged Igneel's attack!


Igneel dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 5 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 106 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500


Eunoia_Cyn | HP : 106 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500


Lunessa, choose your target!


[1] DocOck | HP : 69 | Level : 1
[2] Igneel | HP : 30 | Level : 1




[INPUT]


<> 2


[OUTPUT]


Lunessa | HP : 108 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500
Igneel | HP : 30 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?
<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 6 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Igneel


Igneel dodged Lunessa's attack!


Eunoia_Cyn, choose your target!


[1] DocOck | HP : 69 | Level : 1
[2] Igneel | HP : 30 | Level : 1


[INPUT]


<> 1




[OUTPUT]


Eunoia_Cyn | HP : 108 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500
DocOck | HP : 69 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?
<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 6 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking DocOck


DocOck dodged Eunoia_Cyn's attack!




[ MONSTER(S) TURN BEGINS ]


DocOck is attacking Lunessa


Lunessa dodged DocOck's attack!


DocOck dealt 0 damage


Igneel is attacking Lunessa


Lunessa dodged Igneel's attack!


Igneel dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 6 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 108 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500


Eunoia_Cyn | HP : 108 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500


Lunessa, choose your target!


[1] DocOck | HP : 69 | Level : 1
[2] Igneel | HP : 30 | Level : 1


[INPUT]


<> 2


[OUTPUT]


Lunessa | HP : 110 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500
Igneel | HP : 30 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 5 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Igneel


Lunessa dealt 40 damage


Eunoia_Cyn, choose your target!


[1] DocOck | HP : 69 | Level : 1
[2] Igneel | HP : 6 | Level : 1


[INPUT]


<> 2


[OUTPUT]


Eunoia_Cyn | HP : 110 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500
Igneel | HP : 6 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 5 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Igneel


Eunoia_Cyn dealt 37 damage


...
Igneel has fainted




[ MONSTER(S) TURN BEGINS ]


DocOck is attacking Lunessa


Lunessa dodged DocOck's attack!


DocOck dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 7 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 110 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500


Eunoia_Cyn | HP : 110 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500


Lunessa, choose your target!


[1] DocOck | HP : 69 | Level : 1


[INPUT]


<> 1


[OUTPUT]


Lunessa | HP : 112 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500
DocOck | HP : 69 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 4 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking DocOck


Lunessa dealt 40 damage


Eunoia_Cyn, choose your target!


[1] DocOck | HP : 53 | Level : 1


[INPUT]


<> 1


[OUTPUT]


Eunoia_Cyn | HP : 112 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500
DocOck | HP : 53 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 4 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking DocOck


Eunoia_Cyn dealt 37 damage




[ MONSTER(S) TURN BEGINS ]


DocOck is attacking Eunoia_Cyn


DocOck dealt 98 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 8 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 112 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500


Eunoia_Cyn | HP : 82 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500


Lunessa, choose your target!


[1] DocOck | HP : 38 | Level : 1


[INPUT]


<> 2


[OUTPUT]


Please enter a valid index!


[INPUT]


<> 1


[OUTPUT]


Lunessa | HP : 114 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500
DocOck | HP : 38 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 3 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking DocOck


DocOck dodged Lunessa's attack!


Eunoia_Cyn, choose your target!


[1] DocOck | HP : 38 | Level : 1


[INPUT]


<> 1


[OUTPUT]


Eunoia_Cyn | HP : 84 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500
DocOck | HP : 38 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 3 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking DocOck


Eunoia_Cyn dealt 37 damage




[ MONSTER(S) TURN BEGINS ]


DocOck is attacking Lunessa


Lunessa dodged DocOck's attack!


DocOck dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 9 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 114 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500


Eunoia_Cyn | HP : 84 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500


Lunessa, choose your target!


[1] DocOck | HP : 23 | Level : 1


[INPUT]


<> 1


[OUTPUT]


Lunessa | HP : 116 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500
DocOck | HP : 23 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 2 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking DocOck


DocOck dodged Lunessa's attack!


Eunoia_Cyn, choose your target!


[1] DocOck | HP : 23 | Level : 1


[INPUT]


<> 1


[OUTPUT]


Eunoia_Cyn | HP : 86 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500
DocOck | HP : 23 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 2 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking DocOck


Eunoia_Cyn dealt 37 damage




[ MONSTER(S) TURN BEGINS ]


DocOck is attacking Eunoia_Cyn


DocOck dealt 98 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 10 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 116 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500


Eunoia_Cyn | HP : 56 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500


Lunessa, choose your target!


[1] DocOck | HP : 8 | Level : 1


[INPUT]


<> 1


[OUTPUT]


Lunessa | HP : 118 | Level : 1 | EXP : 7| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2500
DocOck | HP : 8 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?
<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 1 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking DocOck


The weapon broke!


DocOck dodged Lunessa's attack!


Eunoia_Cyn, choose your target!


[1] DocOck | HP : 8 | Level : 1


[INPUT]


<> 1


[OUTPUT]


Eunoia_Cyn | HP : 58 | Level : 1 | EXP : 6| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2500
DocOck | HP : 8 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a


[OUTPUT]


[1] Weapon: Stick | Uses Left : 1 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking DocOck


The weapon broke!


Eunoia_Cyn dealt 37 damage


...
DocOck has fainted


The Hero(s) have won!


Lunessa gained 100 gold


Lunessa gained 12 EXP


Eunoia_Cyn gained 100 gold


Eunoia_Cyn gained 12 EXP




+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | P  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> a


[OUTPUT]


+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | P  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> m


[OUTPUT]


~ Would you like to buy/sell anything at the market? ~
[Y] [N]


[INPUT]


<> y


[OUTPUT]


[1] Lunessa | HP : 118 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 2600
[2] Eunoia_Cyn | HP : 58 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2600


Who will be going to the market?


[INPUT]


1


[OUTPUT]


 ----------------------------------
|             ~ MARKET ~           |
 ----------------------------------
What brings you here?


Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> r


[OUTPUT]


Sure! Show me the broken goods!


Lunessa's gold : 2600


[1] Weapon: Stick | Uses Left : 0 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes
Which item would you like to repair? or [Q] Quit


[INPUT]


<> 1


[OUTPUT]


...
...
Tada! All brand new!


What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> b


[OUTPUT]


Take a look at what we offer!


Lunessa's gold : 1300


[1] Potions
[2] Spells
[3] Weapons
[4] Armor
[Q] Quit


What would you like to take a look at?


[INPUT]


<> 1


[OUTPUT]


 --------------------
|      Potions       |
 --------------------
[1] Strength_Elixir | Price : 200 | Required Level : 1 |  Attribute Affected : Strength | Attribute Increase : 75


[2] Luck_Elixir | Price : 500 | Required Level : 4 |  Attribute Affected : Agility | Attribute Increase : 65


[3] Mermaid_Tears | Price : 850 | Required Level : 5 |  Attribute Affected : Health/Mana/Strength/Agility | Attribute Increase : 100


[4] Ambrosia | Price : 1000 | Required Level : 8 |  Attribute Affected : Health/Mana/Strength/Dexterity/Agility | Attribute Increase : 150


[Q] Quit


Which Potion do you want to buy?


[INPUT]


<> 1


[OUTPUT]


Lunessa bought Strength_Elixir!


What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> b


[OUTPUT]


Take a look at what we offer!


Lunessa's gold : 1100


[1] Potions
[2] Spells
[3] Weapons
[4] Armor
[Q] Quit


What would you like to take a look at?


[INPUT]


<> 3


[OUTPUT]


 --------------------
|      Weapons       |
 --------------------
[1] Bow | Price : 300 | Required Level : 2 | Damage : 500 |  Required Hands : 2


[2] Scythe | Price : 1000 | Required Level : 4 | Damage : 1100 |  Required Hands : 2


[3] Axe | Price : 550 | Required Level : 3 | Damage : 850 |  Required Hands : 1


[4] Dagger | Price : 200 | Required Level : 1 | Damage : 250 |  Required Hands : 1


[Q] Quit


Which Weapon do you want to buy?


[INPUT]


<> 4


[OUTPUT]


Lunessa bought Dagger!


What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> q


[OUTPUT]


Come again soon!


Do you want to visit the market again?
[Y] [N]


[INPUT]


<> y


[OUTPUT]


[1] Lunessa | HP : 118 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900
[2] Eunoia_Cyn | HP : 58 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2600


Who will be going to the market?


[INPUT]


2


[OUTPUT]


 ----------------------------------
|             ~ MARKET ~           |
 ----------------------------------
What brings you here?


Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> b


[OUTPUT]


Take a look at what we offer!


Eunoia_Cyn's gold : 2600


[1] Potions
[2] Spells
[3] Weapons
[4] Armor
[Q] Quit


What would you like to take a look at?


[INPUT]


<> 4


[OUTPUT]


 --------------------
|      Armors       |
 --------------------
[1] Breastplate | Price : 350 | Required Level : 3 | Damage Reduction : 600


[2] Wizard_Shield | Price : 1200 | Required Level : 10 | Damage Reduction : 1500


[3] Guardian_Angel | Price : 1000 | Required Level : 10 | Damage Reduction : 1000


[Q] Quit


Which Armor do you want to buy?


[INPUT]


<> q


[OUTPUT]


What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> b


[OUTPUT]


Take a look at what we offer!


Eunoia_Cyn's gold : 2600


[1] Potions
[2] Spells
[3] Weapons
[4] Armor
[Q] Quit


What would you like to take a look at?


[INPUT]


<> 2


[OUTPUT]


 --------------------
|      Spells       |
 --------------------
[1] Heat_Wave | Price : 450 | Required Level : 2 | Damage : 300 |  MP Affected : 150 | Spell Type : Fire


[2] Lava_Comet | Price : 800 | Required Level : 7 | Damage : 600 |  MP Affected : 550 | Spell Type : Fire


[3] Arctic_Storm | Price : 700 | Required Level : 6 | Damage : 500 |  MP Affected : 300 | Spell Type : Ice


[Q] Quit


Which Spell do you want to buy?


[INPUT]


<> q


[OUTPUT]


What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> b


[OUTPUT]


Take a look at what we offer!


Eunoia_Cyn's gold : 2600


[1] Potions
[2] Spells
[3] Weapons
[4] Armor
[Q] Quit


What would you like to take a look at?


[INPUT]


<> 1


[OUTPUT]


 --------------------
|      Potions       |
 --------------------
[1] Luck_Elixir | Price : 500 | Required Level : 4 |  Attribute Affected : Agility | Attribute Increase : 65


[2] Mermaid_Tears | Price : 850 | Required Level : 5 |  Attribute Affected : Health/Mana/Strength/Agility | Attribute Increase : 100


[3] Ambrosia | Price : 1000 | Required Level : 8 |  Attribute Affected : Health/Mana/Strength/Dexterity/Agility | Attribute Increase : 150


[Q] Quit


Which Potion do you want to buy?


[INPUT]


<> q


[OUTPUT]


What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> q


[OUTPUT]


Come again soon!


Do you want to visit the market again?
[Y] [N]


[INPUT]


<> y




[OUTPUT]


[1] Lunessa | HP : 118 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900
[2] Eunoia_Cyn | HP : 58 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 2600


Who will be going to the market?


[INPUT]


2


[OUTPUT]


 ----------------------------------
|             ~ MARKET ~           |
 ----------------------------------
What brings you here?


Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> r


[OUTPUT]


Sure! Show me the broken goods!


Eunoia_Cyn's gold : 2600


[1] Weapon: Stick | Uses Left : 0 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes
Which item would you like to repair? or [Q] Quit


[INPUT]


<> 1


[OUTPUT]


...
...
Tada! All brand new!


What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> q


[OUTPUT]


Come again soon!


Do you want to visit the market again?
[Y] [N]


[INPUT]


<> n


[OUTPUT]


+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | P  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> a


[OUTPUT]


+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | P  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> a


[OUTPUT]
+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | P  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> w


[OUTPUT]


+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | P  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> a


[OUTPUT]


+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | P  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> w


[OUTPUT]


+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | P  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> w


[OUTPUT]


Grrrrr......
Uh Oh, What was that?
MONSTERS!!!!!


Monster Aasterinian has appeared!
Monster Igneel has appeared!


 ----------------------------------
|       BATTLE BEGINS : FIGHT!     |
 ----------------------------------
                                ROUND 1 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 118 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900


Eunoia_Cyn | HP : 58 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300


Lunessa, choose your target!


[1] Aasterinian | HP : 100 | Level : 1
[2] Igneel | HP : 100 | Level : 1


[INPUT]


<> 2


Lunessa | HP : 118 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900
Igneel | HP : 100 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> o
[1] Weapon: Stick | Uses Left : 10 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes
[2] Potion: Strength_Elixir | Uses Left : 1 | Attribute affected : Strength | Attribute increase : 75
[3] Weapon: Dagger | Uses Left : 10 | Damage Induced : 250 | Required Hands : 1 | Equipped : No




[P] Use a Potion  [S] Cast a Spell  [E] Equip a Weapon/Armor  [UE] Unequip a Weapon/Armor


What would you like to do?


[INPUT]


<> e


Enter the weapon/armor number you want to equip


[INPUT]


<> 3
This weapon requires to be held with two hands!


Dagger is equipped!
Eunoia_Cyn, choose your target!


[1] Aasterinian | HP : 100 | Level : 1
[2] Igneel | HP : 100 | Level : 1




[INPUT]


<> 2


Eunoia_Cyn | HP : 58 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300
Igneel | HP : 100 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 10 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Igneel


Igneel dodged Eunoia_Cyn's attack!




[ MONSTER(S) TURN BEGINS ]


Aasterinian is attacking Eunoia_Cyn


Eunoia_Cyn dodged Aasterinian's attack!


Aasterinian dealt 0 damage


Igneel is attacking Eunoia_Cyn


Eunoia_Cyn dodged Igneel's attack!


Igneel dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 2 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 118 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900


Eunoia_Cyn | HP : 58 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300


Lunessa, choose your target!


[1] Aasterinian | HP : 100 | Level : 1
[2] Igneel | HP : 100 | Level : 1




[INPUT]




<> 1


Lunessa | HP : 120 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900
Aasterinian | HP : 100 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 10 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


[2] Weapon: Dagger | Uses Left : 10 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Aasterinian




Which weapon do you want to use?


[INPUT]


<> 2
Lunessa dealt 50 damage


Eunoia_Cyn, choose your target!


[1] Aasterinian | HP : 75 | Level : 1
[2] Igneel | HP : 100 | Level : 1




[INPUT]




<> 1


Eunoia_Cyn | HP : 60 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300
Aasterinian | HP : 75 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 9 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Aasterinian


Aasterinian dodged Eunoia_Cyn's attack!




[ MONSTER(S) TURN BEGINS ]


Aasterinian is attacking Eunoia_Cyn


Eunoia_Cyn dodged Aasterinian's attack!


Aasterinian dealt 0 damage


Igneel is attacking Eunoia_Cyn


Eunoia_Cyn dodged Igneel's attack!


Igneel dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 3 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 120 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900


Eunoia_Cyn | HP : 60 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300


Lunessa, choose your target!


[1] Aasterinian | HP : 75 | Level : 1
[2] Igneel | HP : 100 | Level : 1


[INPUT]


<> 1


Lunessa | HP : 122 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900
Aasterinian | HP : 75 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 10 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


[2] Weapon: Dagger | Uses Left : 9 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Aasterinian




Which weapon do you want to use?


[INPUT]


<> 2
Lunessa dealt 50 damage


Eunoia_Cyn, choose your target!


[1] Aasterinian | HP : 50 | Level : 1
[2] Igneel | HP : 100 | Level : 1


[INPUT]


<> 1


Eunoia_Cyn | HP : 62 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300
Aasterinian | HP : 50 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 8 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Aasterinian


Eunoia_Cyn dealt 37 damage




[ MONSTER(S) TURN BEGINS ]


Aasterinian is attacking Lunessa


Aasterinian dealt 45 damage


Igneel is attacking Eunoia_Cyn


Eunoia_Cyn dodged Igneel's attack!


Igneel dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 4 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 108 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900


Eunoia_Cyn | HP : 62 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300


Lunessa, choose your target!


[1] Aasterinian | HP : 31 | Level : 1
[2] Igneel | HP : 100 | Level : 1


[INPUT]


<> 2


Lunessa | HP : 110 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900
Igneel | HP : 100 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 10 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


[2] Weapon: Dagger | Uses Left : 8 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Igneel




Which weapon do you want to use?


[INPUT]


<> 2
Lunessa dealt 50 damage


Eunoia_Cyn, choose your target!


[1] Aasterinian | HP : 31 | Level : 1
[2] Igneel | HP : 70 | Level : 1


[INPUT]


<> 2


Eunoia_Cyn | HP : 64 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300
Igneel | HP : 70 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 7 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Igneel


Igneel dodged Eunoia_Cyn's attack!




[ MONSTER(S) TURN BEGINS ]


Aasterinian is attacking Eunoia_Cyn


Eunoia_Cyn dodged Aasterinian's attack!


Aasterinian dealt 0 damage


Igneel is attacking Lunessa


Igneel dealt 130 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 5 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 71 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900


Eunoia_Cyn | HP : 64 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300


Lunessa, choose your target!


[1] Aasterinian | HP : 31 | Level : 1
[2] Igneel | HP : 70 | Level : 1


[INPUT]


<> 1


Lunessa | HP : 73 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900
Aasterinian | HP : 31 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 10 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


[2] Weapon: Dagger | Uses Left : 7 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Aasterinian




Which weapon do you want to use?


[INPUT]


<> 2
Aasterinian dodged Lunessa's attack!


Eunoia_Cyn, choose your target!


[1] Aasterinian | HP : 31 | Level : 1
[2] Igneel | HP : 70 | Level : 1


[INPUT]


<> 1


Eunoia_Cyn | HP : 66 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300
Aasterinian | HP : 31 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 6 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Aasterinian


Aasterinian dodged Eunoia_Cyn's attack!




[ MONSTER(S) TURN BEGINS ]


Aasterinian is attacking Lunessa


Lunessa dodged Aasterinian's attack!


Aasterinian dealt 0 damage


Igneel is attacking Eunoia_Cyn


Eunoia_Cyn dodged Igneel's attack!


Igneel dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 6 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 73 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900


Eunoia_Cyn | HP : 66 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300


Lunessa, choose your target!


[1] Aasterinian | HP : 31 | Level : 1
[2] Igneel | HP : 70 | Level : 1


[INPUT]


<> 2


Lunessa | HP : 75 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900
Igneel | HP : 70 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 10 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


[2] Weapon: Dagger | Uses Left : 6 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Igneel




Which weapon do you want to use?


[INPUT]


<> 2
Lunessa dealt 50 damage


Eunoia_Cyn, choose your target!


[1] Aasterinian | HP : 31 | Level : 1
[2] Igneel | HP : 40 | Level : 1


[INPUT]


<> 2


Eunoia_Cyn | HP : 68 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300
Igneel | HP : 40 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 5 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Igneel


Eunoia_Cyn dealt 37 damage




[ MONSTER(S) TURN BEGINS ]


Aasterinian is attacking Lunessa


Lunessa dodged Aasterinian's attack!


Aasterinian dealt 0 damage


Igneel is attacking Eunoia_Cyn


Igneel dealt 130 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 7 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 75 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900


Eunoia_Cyn | HP : 29 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300


Lunessa, choose your target!


[1] Aasterinian | HP : 31 | Level : 1
[2] Igneel | HP : 17 | Level : 1


[INPUT]


<> 1


Lunessa | HP : 77 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900
Aasterinian | HP : 31 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 10 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


[2] Weapon: Dagger | Uses Left : 5 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Aasterinian




Which weapon do you want to use?


[INPUT]


<> 2
Lunessa dealt 50 damage


Eunoia_Cyn, choose your target!


[1] Aasterinian | HP : 6 | Level : 1
[2] Igneel | HP : 17 | Level : 1


[INPUT]


<> 2


Eunoia_Cyn | HP : 31 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300
Igneel | HP : 17 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> o
[1] Weapon: Stick | Uses Left : 4 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes




[P] Use a Potion  [S] Cast a Spell  [E] Equip a Weapon/Armor  [UE] Unequip a Weapon/Armor


What would you like to do?


[INPUT]


<> s


Which spell do you want to cast?


[INPUT]


1
Eunoia_Cyn dealt 37 damage


Eunoia_Cyn cast a Stick spell on Igneel


Critical Damage!


...
Igneel has fainted




[ MONSTER(S) TURN BEGINS ]


Aasterinian is attacking Lunessa


Lunessa dodged Aasterinian's attack!


Aasterinian dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 8 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 77 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900


Eunoia_Cyn | HP : 31 | Level : 1 | EXP : 18| Status : Healthy | Strength : 700 | Dexterity : 600 | Agility : 400| Gold : 1300


Lunessa, choose your target!


[1] Aasterinian | HP : 6 | Level : 1


[INPUT]


<> 1


Lunessa | HP : 79 | Level : 1 | EXP : 19| Status : Healthy | Strength : 750 | Dexterity : 700 | Agility : 330| Gold : 900
Aasterinian | HP : 6 | Level : 1


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 10 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


[2] Weapon: Dagger | Uses Left : 4 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Aasterinian




Which weapon do you want to use?


[INPUT]


<> 2
Lunessa dealt 50 damage


...
Aasterinian has fainted


The Hero(s) have won!


Lunessa gained 100 gold


Lunessa gained 12 EXP


Lunessa grew to level 2!


Eunoia_Cyn gained 100 gold


Eunoia_Cyn gained 12 EXP


Eunoia_Cyn grew to level 2!














+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | P  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> i
[1] Lunessa | HP : 200 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 1000
[2] Eunoia_Cyn | HP : 200 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 1400


Select a hero's inventory to view | [Q] Quit


[INPUT]


<> q
+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | P  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> a
+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | P  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> m
~ Would you like to buy/sell anything at the market? ~
[Y] [N]


[INPUT]


<> y
[1] Lunessa | HP : 200 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 1000
[2] Eunoia_Cyn | HP : 200 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 1400


Who will be going to the market?


[INPUT]


2


 ----------------------------------
|             ~ MARKET ~           |
 ----------------------------------
What brings you here?


Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> b


Take a look at what we offer!


Eunoia_Cyn's gold : 1400


[1] Potions
[2] Spells
[3] Weapons
[4] Armor
[Q] Quit


What would you like to take a look at?


[INPUT]


<> 3


 --------------------
|      Weapons       |
 --------------------
[1] Bow | Price : 300 | Required Level : 2 | Damage : 500 |  Required Hands : 2


[2] Scythe | Price : 1000 | Required Level : 4 | Damage : 1100 |  Required Hands : 2


[3] TSwords | Price : 1400 | Required Level : 5 | Damage : 1600 |  Required Hands : 2


[4] Dagger | Price : 200 | Required Level : 1 | Damage : 250 |  Required Hands : 1


[Q] Quit


Which Weapon do you want to buy?


[INPUT]


<> 1


Eunoia_Cyn bought Bow!


What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> b


Take a look at what we offer!


Eunoia_Cyn's gold : 1100


[1] Potions
[2] Spells
[3] Weapons
[4] Armor
[Q] Quit


What would you like to take a look at?


[INPUT]


<> 2


 --------------------
|      Spells       |
 --------------------
[1] Lightning_Dagger | Price : 400 | Required Level : 1 | Damage : 500 |  MP Affected : 150 | Spell Type : Lightning


[2] Thunder_Blast | Price : 750 | Required Level : 4 | Damage : 350 |  MP Affected : 400 | Spell Type : Lightning


[3] Electric_Arrows | Price : 550 | Required Level : 5 | Damage : 400 |  MP Affected : 200 | Spell Type : Lightning


[4] Spark_Needles | Price : 500 | Required Level : 2 | Damage : 300 |  MP Affected : 200 | Spell Type : Lightning


[5] Flame_Tornado | Price : 700 | Required Level : 4 | Damage : 500 |  MP Affected : 300 | Spell Type : Fire


[6] Lava_Comet | Price : 800 | Required Level : 7 | Damage : 600 |  MP Affected : 550 | Spell Type : Fire


[7] Hell_Storm | Price : 600 | Required Level : 3 | Damage : 340 |  MP Affected : 600 | Spell Type : Fire


[8] Snow_Cannon | Price : 500 | Required Level : 2 | Damage : 200 |  MP Affected : 250 | Spell Type : Ice


[9] Ice_Blade | Price : 250 | Required Level : 1 | Damage : 340 |  MP Affected : 100 | Spell Type : Ice


[10] Arctic_Storm | Price : 700 | Required Level : 6 | Damage : 500 |  MP Affected : 300 | Spell Type : Ice


[Q] Quit


Which Spell do you want to buy?


[INPUT]


<> 8


Eunoia_Cyn bought Snow_Cannon!


What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> b


Take a look at what we offer!


Eunoia_Cyn's gold : 600


[1] Potions
[2] Spells
[3] Weapons
[4] Armor
[Q] Quit


What would you like to take a look at?


[INPUT]


<> 4


 --------------------
|      Armors       |
 --------------------
[1] Platinum_Shield | Price : 150 | Required Level : 1 | Damage Reduction : 200


[2] Breastplate | Price : 350 | Required Level : 3 | Damage Reduction : 600


[3] Full_Body_Armor | Price : 1000 | Required Level : 8 | Damage Reduction : 1100


[4] Wizard_Shield | Price : 1200 | Required Level : 10 | Damage Reduction : 1500


[Q] Quit


Which Armor do you want to buy?


[INPUT]


<> 3
Not enough gold or not the required level!


[1] Platinum_Shield | Price : 150 | Required Level : 1 | Damage Reduction : 200


[2] Breastplate | Price : 350 | Required Level : 3 | Damage Reduction : 600


[3] Full_Body_Armor | Price : 1000 | Required Level : 8 | Damage Reduction : 1100


[4] Wizard_Shield | Price : 1200 | Required Level : 10 | Damage Reduction : 1500


[Q] Quit


Which Armor do you want to buy?


[INPUT]


<> q
What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> q
Come again soon!


Do you want to visit the market again?
[Y] [N]


[INPUT]


<> n
+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | P  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:
<> m


[INPUT]


~ Would you like to buy/sell anything at the market? ~
[Y] [N]


[INPUT]


<> y
[1] Lunessa | HP : 200 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 1000
[2] Eunoia_Cyn | HP : 200 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600


Who will be going to the market?


[INPUT]


1


 ----------------------------------
|             ~ MARKET ~           |
 ----------------------------------
What brings you here?


Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> b


Take a look at what we offer!


Lunessa's gold : 1000


[1] Potions
[2] Spells
[3] Weapons
[4] Armor
[Q] Quit


What would you like to take a look at?


[INPUT]


<> 1


 --------------------
|      Potions       |
 --------------------
[1] Strength_Elixir | Price : 200 | Required Level : 1 |  Attribute Affected : Strength | Attribute Increase : 75


[2] Luck_Elixir | Price : 500 | Required Level : 4 |  Attribute Affected : Agility | Attribute Increase : 65


[Q] Quit


Which Potion do you want to buy?


[INPUT]


<> 1


Lunessa bought Strength_Elixir!


What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


<>
Invalid Move! Must be (W/A/S/D)
What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> b


Take a look at what we offer!


Lunessa's gold : 800


[1] Potions
[2] Spells
[3] Weapons
[4] Armor
[Q] Quit


What would you like to take a look at?


[INPUT]


<> 2


 --------------------
|      Spells       |
 --------------------
[1] Lightning_Dagger | Price : 400 | Required Level : 1 | Damage : 500 |  MP Affected : 150 | Spell Type : Lightning


[2] Thunder_Blast | Price : 750 | Required Level : 4 | Damage : 350 |  MP Affected : 400 | Spell Type : Lightning


[3] Electric_Arrows | Price : 550 | Required Level : 5 | Damage : 400 |  MP Affected : 200 | Spell Type : Lightning


[4] Spark_Needles | Price : 500 | Required Level : 2 | Damage : 300 |  MP Affected : 200 | Spell Type : Lightning


[5] Flame_Tornado | Price : 700 | Required Level : 4 | Damage : 500 |  MP Affected : 300 | Spell Type : Fire


[6] Lava_Comet | Price : 800 | Required Level : 7 | Damage : 600 |  MP Affected : 550 | Spell Type : Fire


[7] Hell_Storm | Price : 600 | Required Level : 3 | Damage : 340 |  MP Affected : 600 | Spell Type : Fire


[8] Ice_Blade | Price : 250 | Required Level : 1 | Damage : 340 |  MP Affected : 100 | Spell Type : Ice


[9] Arctic_Storm | Price : 700 | Required Level : 6 | Damage : 500 |  MP Affected : 300 | Spell Type : Ice


[Q] Quit


Which Spell do you want to buy?


[INPUT]


<> 4


Lunessa bought Spark_Needles!


What else can I do for you today?
Buy [B] | Sell [S] | Repair Item [R] | Quit [Q]


[INPUT]


<> q
Come again soon!


Do you want to visit the market again?
[Y] [N]


[INPUT]


<> n
+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | P  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> a
+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | *  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | P  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> w


Grrrrr......
Uh Oh, What was that?
MONSTERS!!!!!


Monster Cyrrollalee has appeared!
Monster Natsunomeryu has appeared!


 ----------------------------------
|       BATTLE BEGINS : FIGHT!     |
 ----------------------------------
                                ROUND 1 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 200 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 300


Eunoia_Cyn | HP : 200 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600


Lunessa, choose your target!


[1] Cyrrollalee | HP : 200 | Level : 2
[2] Natsunomeryu | HP : 200 | Level : 2


[INPUT]


<> 2


Lunessa | HP : 200 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 300
Natsunomeryu | HP : 200 | Level : 2


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 10 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


[2] Weapon: Dagger | Uses Left : 3 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Natsunomeryu




Which weapon do you want to use?


[INPUT]


<> 1
Lunessa dealt 41 damage


Eunoia_Cyn, choose your target!


[1] Cyrrollalee | HP : 200 | Level : 2
[2] Natsunomeryu | HP : 167 | Level : 2


[INPUT]




<> 1


Eunoia_Cyn | HP : 200 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600
Cyrrollalee | HP : 200 | Level : 2


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 3 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Cyrrollalee


Cyrrollalee dodged Eunoia_Cyn's attack!




[ MONSTER(S) TURN BEGINS ]


Cyrrollalee is attacking Lunessa


Cyrrollalee dealt 85 damage


Natsunomeryu is attacking Lunessa


Natsunomeryu dealt 95 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 2 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 145 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 300


Eunoia_Cyn | HP : 200 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600


Lunessa, choose your target!


[1] Cyrrollalee | HP : 200 | Level : 2
[2] Natsunomeryu | HP : 167 | Level : 2


[INPUT]


<> 1


Lunessa | HP : 147 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 300
Cyrrollalee | HP : 200 | Level : 2


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 9 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


[2] Weapon: Dagger | Uses Left : 3 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Cyrrollalee




Which weapon do you want to use?


[INPUT]


<> 2
Lunessa dealt 51 damage


Eunoia_Cyn, choose your target!


[1] Cyrrollalee | HP : 189 | Level : 2
[2] Natsunomeryu | HP : 167 | Level : 2


[INPUT]


<> 1


Eunoia_Cyn | HP : 202 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600
Cyrrollalee | HP : 189 | Level : 2


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 2 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Cyrrollalee


Cyrrollalee dodged Eunoia_Cyn's attack!




[ MONSTER(S) TURN BEGINS ]


Cyrrollalee is attacking Eunoia_Cyn


Cyrrollalee dealt 85 damage


Natsunomeryu is attacking Lunessa


Lunessa dodged Natsunomeryu's attack!


Natsunomeryu dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 3 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 147 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 300


Eunoia_Cyn | HP : 176 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600


Lunessa, choose your target!


[1] Cyrrollalee | HP : 189 | Level : 2
[2] Natsunomeryu | HP : 167 | Level : 2


[INPUT]


<> 2


Lunessa | HP : 149 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 300
Natsunomeryu | HP : 167 | Level : 2


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]
<> a
[1] Weapon: Stick | Uses Left : 9 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


[2] Weapon: Dagger | Uses Left : 2 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Natsunomeryu




Which weapon do you want to use?


[INPUT]


<> 2
Lunessa dealt 51 damage


Eunoia_Cyn, choose your target!


[1] Cyrrollalee | HP : 189 | Level : 2
[2] Natsunomeryu | HP : 126 | Level : 2


[INPUT]


<> 2


Eunoia_Cyn | HP : 178 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600
Natsunomeryu | HP : 126 | Level : 2


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 1 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Natsunomeryu


The weapon broke!


Eunoia_Cyn dealt 41 damage




[ MONSTER(S) TURN BEGINS ]


Cyrrollalee is attacking Lunessa


Lunessa dodged Cyrrollalee's attack!


Cyrrollalee dealt 0 damage


Natsunomeryu is attacking Eunoia_Cyn


Eunoia_Cyn dodged Natsunomeryu's attack!


Natsunomeryu dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 4 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 149 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 300


Eunoia_Cyn | HP : 178 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600


Lunessa, choose your target!


[1] Cyrrollalee | HP : 189 | Level : 2
[2] Natsunomeryu | HP : 93 | Level : 2


[INPUT]


<> 2


Lunessa | HP : 151 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 300
Natsunomeryu | HP : 93 | Level : 2


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]
<> a
[1] Weapon: Stick | Uses Left : 9 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


[2] Weapon: Dagger | Uses Left : 1 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Natsunomeryu




Which weapon do you want to use?


[INPUT]


<> 2
The weapon broke!


Natsunomeryu dodged Lunessa's attack!


Eunoia_Cyn, choose your target!


[1] Cyrrollalee | HP : 189 | Level : 2
[2] Natsunomeryu | HP : 93 | Level : 2


[INPUT]


<> 1


Eunoia_Cyn | HP : 180 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600
Cyrrollalee | HP : 189 | Level : 2


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 0 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Cyrrollalee


This weapon is broken!


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> o
[1] Weapon: Stick | Uses Left : 0 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes
[2] Weapon: Bow | Uses Left : 10 | Damage Induced : 500 | Required Hands : 2 | Equipped : No
[3] Spell: Snow_Cannon | Uses Left : 1 | Damage : 200 | Mana Affected : 250| Spell Type : Ice




[P] Use a Potion  [S] Cast a Spell  [E] Equip a Weapon/Armor  [UE] Unequip a Weapon/Armor


What would you like to do?


[INPUT]


<> 3
Invalid Move! Must be (W/A/S/D)


[ MONSTER(S) TURN BEGINS ]


Cyrrollalee is attacking Lunessa


Lunessa dodged Cyrrollalee's attack!


Cyrrollalee dealt 0 damage


Natsunomeryu is attacking Lunessa


Lunessa dodged Natsunomeryu's attack!


Natsunomeryu dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 5 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 151 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 300


Eunoia_Cyn | HP : 180 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600


Lunessa, choose your target!


[1] Cyrrollalee | HP : 189 | Level : 2
[2] Natsunomeryu | HP : 93 | Level : 2


[INPUT]


<> 1


Lunessa | HP : 153 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 300
Cyrrollalee | HP : 189 | Level : 2


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> a
[1] Weapon: Stick | Uses Left : 9 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


[2] Weapon: Dagger | Uses Left : 0 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes


Lunessa is attacking Cyrrollalee




Which weapon do you want to use?


[INPUT]


<> 1
Lunessa dealt 41 damage


Eunoia_Cyn, choose your target!


[1] Cyrrollalee | HP : 180 | Level : 2
[2] Natsunomeryu | HP : 93 | Level : 2


[INPUT]


<> 1


Eunoia_Cyn | HP : 182 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600
Cyrrollalee | HP : 180 | Level : 2


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]


<> o
[1] Weapon: Stick | Uses Left : 0 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes
[2] Weapon: Bow | Uses Left : 10 | Damage Induced : 500 | Required Hands : 2 | Equipped : No
[3] Spell: Snow_Cannon | Uses Left : 1 | Damage : 200 | Mana Affected : 250| Spell Type : Ice




[P] Use a Potion  [S] Cast a Spell  [E] Equip a Weapon/Armor  [UE] Unequip a Weapon/Armor


What would you like to do?


[INPUT]


<> s


Which spell do you want to cast?


[INPUT]


3
Eunoia_Cyn dealt 212 damage


Eunoia_Cyn cast a Snow_Cannon spell on Cyrrollalee


Critical Damage!




[ MONSTER(S) TURN BEGINS ]


Cyrrollalee is attacking Eunoia_Cyn


Eunoia_Cyn dodged Cyrrollalee's attack!


Cyrrollalee dealt 0 damage


Natsunomeryu is attacking Lunessa


Lunessa dodged Natsunomeryu's attack!


Natsunomeryu dealt 0 damage


 < ---------------------------------------------------------------------------------- >
                                ROUND 6 COMMENCE


[ HERO(S) TURN BEGINS ]


Lunessa | HP : 153 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 300


Eunoia_Cyn | HP : 182 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600


Lunessa, choose your target!


[1] Cyrrollalee | HP : 137 | Level : 2
[2] Natsunomeryu | HP : 93 | Level : 2


[INPUT]


<> 2


Lunessa | HP : 155 | Level : 2 | EXP : 1| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 300
Natsunomeryu | HP : 93 | Level : 2


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Lunessa, what's your move?


[INPUT]


<> o
[1] Weapon: Stick | Uses Left : 8 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes
[2] Potion: Strength_Elixir | Uses Left : 1 | Attribute affected : Strength | Attribute increase : 75
[3] Weapon: Dagger | Uses Left : 0 | Damage Induced : 250 | Required Hands : 1 | Equipped : Yes
[4] Potion: Strength_Elixir | Uses Left : 1 | Attribute affected : Strength | Attribute increase : 75
[5] Spell: Spark_Needles | Uses Left : 1 | Damage : 300 | Mana Affected : 200| Spell Type : Lightning




[P] Use a Potion  [S] Cast a Spell  [E] Equip a Weapon/Armor  [UE] Unequip a Weapon/Armor


What would you like to do?


[INPUT]


<> s


Which spell do you want to cast?


[INPUT]


5
Lunessa dealt 323 damage


Lunessa cast a Spark_Needles spell on Natsunomeryu


Critical Damage!


...
Natsunomeryu has fainted


Eunoia_Cyn, choose your target!


[1] Cyrrollalee | HP : 137 | Level : 2


[INPUT]


<> 1


Eunoia_Cyn | HP : 184 | Level : 2 | EXP : 1| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 600
Cyrrollalee | HP : 137 | Level : 2


[A] Attack   [O] Open Inventory   [F] Forfeit Battle


Alright Eunoia_Cyn, what's your move?


[INPUT]
<> a
[1] Weapon: Stick | Uses Left : 0 | Damage Induced : 50 | Required Hands : 1 | Equipped : Yes


Eunoia_Cyn is attacking Cyrrollalee


This weapon is broken!
...
Cyrrollalee has fainted


The Hero(s) have won!


Lunessa gained 200 gold


Lunessa gained 24 EXP


Eunoia_Cyn gained 200 gold


Eunoia_Cyn gained 24 EXP




+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | P  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]


<> i
[1] Lunessa | HP : 155 | Level : 2 | EXP : 25| Status : Healthy | Strength : 787 | Dexterity : 771 | Agility : 363| Gold : 500
[2] Eunoia_Cyn | HP : 184 | Level : 2 | EXP : 25| Status : Healthy | Strength : 771 | Dexterity : 630 | Agility : 441| Gold : 800


Select a hero's inventory to view | [Q] Quit


[INPUT]


<> q
+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | P  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----
[W] - move up
[A] - move left
[S] - move right
[D] - move down
[M] - enter Market
[I] - Information
[Q] - Quit


Enter your move:


[INPUT]
<> q
+----+----+----+----+----+----+----+----
| X  | *  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | *  | *  | M  | M  | *  |
+----+----+----+----+----+----+----+----
| X  | P  | M  | X  | *  | *  | X  | *  |
+----+----+----+----+----+----+----+----
| M  | *  | M  | *  | M  | *  | *  | *  |
+----+----+----+----+----+----+----+----
| M  | M  | M  | M  | M  | M  | X  | *  |
+----+----+----+----+----+----+----+----
| *  | M  | *  | M  | *  | X  | X  | *  |
+----+----+----+----+----+----+----+----
| X  | X  | *  | *  | *  | *  | M  | *  |
+----+----+----+----+----+----+----+----
| *  | *  | *  | X  | M  | X  | *  | S  |
+----+----+----+----+----+----+----+----


Do you want to play again?
[Y] [N]


[INPUT]


<> n