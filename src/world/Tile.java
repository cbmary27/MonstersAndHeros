package world;

import java.util.*;
import market.Market;

public class Tile{
    public Piece<String> tileVal; //M, C, X
    private int row;
    private int col;
    public Market market;

    public Tile()
    {}

    public void setRow(int row)
    {
        this.row = row;
    }

    public void setColumn(int column)
    {
        this.col = column;
    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return col;
    }

    public void getMarketInstance()
    {
        if (market == null)
           {market = new Market();}
    }

    public void copy(Tile pos)
    {
        this.row = pos.row;
        this.col = pos.col;
    }

}