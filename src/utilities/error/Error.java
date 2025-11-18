package utilities.error;

public class Error{

    public void invalidMove()
    {
        System.out.println("Invalid Move! Must be (W/A/S/D)");
    }

    public void inaccessibleSpace()
    {
        System.out.println("You cannot enter this area!");
    }

    public void useEquip()
    {
        System.out.println("You cannot use or equip this when not in battle!");
    }

    public void notAMarket()
    {
        System.out.println("This is not a market!");
    }

}
