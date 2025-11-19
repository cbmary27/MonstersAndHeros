package utilities.error;

public class Error{

    public static void invalidMove()
    {
        System.out.println("Invalid Move! Must be (W/A/S/D)");
    }

    public static void invalidChoice()
    {
        System.out.println("Invalid Choice!");
    }

    public static void inaccessibleSpace()
    {
        System.out.println("You cannot enter this area!");
    }

    public static void useEquip()
    {
        System.out.println("You cannot use or equip this when not in battle!");
    }

    public static void notAMarket()
    {
        System.out.println("This is not a market!");
    }

}
