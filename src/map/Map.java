package map;

import java.util.*;
import utilities.error;

public class Map
{
    public Tile[][] grid;
    private int rows;
    private int columns;
    public Error error = new Error();

    //public Tile currentPos;

    public Map(rows, columns)
    {
        this.rows = rows;
        this.columns = columns;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    public void setColumns(int columns)
    {
        this.columns = columns;
    }

    public int getRows()
    {
        return rows;
    }

    public int getColumns()
    {
        return columns;
    }

    public void initializeMap()
    {
        int x = (rows*columns) - 1;
        int numMarkets = (int) ((0.3 * x) + 1);
        int numCommon = (int) (0.5 * x);
        int numInaccessible = (int) ((0.2 * x) + 1);

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                grid[i][j] = new Tile();
                grid[i][j].setRow(i);
                grid[i][j].setColumn(j);

                if(i == 7 && j == 7)
                {
                    grid[i][j].setVal("S"); //Start Position
                }
                else
                {
                    //figure out shuffling
                }
            }
        }
    }

    public void printBoardState()
    {


    }

    public boolean isMoveLegal(String ch, Tile pos)
    {
        switch(ch)
        {
            case "W":
                if (pos.getRow() - 1 >= 0)
                    return true;
                break;
            case "A":
                if (pos.getColumn() - 1 >= 0)
                    return true;
                break;
            case "S":
                if (pos.getColumn() + 1 < columns)
                    return true;
                break;
            case "D":
                if (pos.getRow() + 1 < rows)
                    return true;
                break;
            default:
                return false;
        }

    }
}
