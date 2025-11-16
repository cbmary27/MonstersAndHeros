package map;

import java.util.*;

public class Tile{
    private String tileVal; //M, C, X
    private int row;
    private int col;

    public void setRow(int row)
    {
        this.row = row;
    }

    public void setColumn(int column)
    {
        this.col = col;
    }

    public int getRow(int row)
    {
        return row;
    }

    public int getColumn(int row)
    {
        return col;
    }

    public void setVal(String val)
    {
        this.tileVal = val;
    }

    public String getVal()
    {
        return tileVal;
    }

}