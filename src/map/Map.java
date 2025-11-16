package map;

import java.util.*;
import utilities.error;

public class Map
{
    public Tile[][] grid;
    public Tile[][] playerPosition;
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
    { //player should not be blocked by "X" in the map. add conditions for that
        List<String> l = new ArrayList<String>();
        initializePlayerPosition();

        int k = 0;
        int x = (rows*columns) - 1;
        int numMarkets = (int) ((0.3 * x) + 1);
        int numCommon = (int) (0.5 * x);
        int numInaccessible = (int) ((0.2 * x) + 1);

        for (int i = 0; i < numMarkets; i++)
        {
            l.add("M");
        }

        for (int i = 0; i < numCommon; i++)
        {
            l.add("C");
        }

        for (int i = 0; i < numInaccessible; i++)
        {
            l.add("X");
        }

        Collections.shuffle(l);

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                grid[i][j] = new Tile();
                grid[i][j].setRow(i);
                grid[i][j].setColumn(j);

                if(i == 7 && j == 7)
                {
                    grid[i][j].tileVal = new Piece<>("S"); //Start Position
                }
                else
                {
                    if (l.get(k).equals("C"))
                    {
                        grid[i][j].tileVal = new Piece<>(" "); //Start Position
                    }

                    else{
                        grid[i][j].tileVal = new Piece<>(l.get(k)); //Start Position
                    }
                    k++;
                }
            }
        }
    }

    public void intializePlayerPosition()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                playerPosition[i][j] = new Tile();
                playerPosition[i][j].setRow(i);
                playerPosition[i][j].setColumn(j);
                playerPosition[i][j].tileVal = new Piece<>("0");
            }
        }

    }

    public void printMap()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.print("*---");
            }

            System.out.println();

            for (int j = 0; j < columns; j++)
            {
                if (!playerPosition[i][j].getVal().equals("0"))
                {
                    System.out.print("|" + grid[i][j].tilePiece.getValueOnTile() + " ");
                }
                else
                {
                    System.out.print("|" + playerPosition[i][j].tileVal.getValueOnTile() + " ");
                }
            }

            System.out.println("|");
        }

        for (int j = 0; j < columns; j++)
        {
            System.out.print("*---");
        }
    }

    public boolean isMoveLegal(String ch, Tile pos)
    {
        switch(ch)
        {
            case "W":
                if (pos.getRow() - 1 >= 0)
                    break;
            case "A":
                if (pos.getColumn() - 1 >= 0)
                    break;
            case "S":
                if (pos.getColumn() + 1 < columns)
                    break;
            case "D":
                if (pos.getRow() + 1 < rows)
                    break;
            default:
                return false;
        }

        if (grid[pos.getRow()][pos.getColumn()].tileVal.getValueOnTile().equals("X"))
        {
            error.inaccessibleSpace();
            return false;
        }

    }

    public void makeMove(Player player, String choice)
    {
        playerPosition[currentPos.getRow()][currentPos.getColumn()];
        switch(ch)
        {
            case "W":
                player.currentPos.setRow(player.currentPos.getRow() - 1);
                break;
            case "A":
                player.currentPos.setColumn(player.currentPos.getColumn() - 1);
                break;
            case "S":
                player.currentPos.setColumn(player.currentPos.getColumn() + 1);
                break;
            case "D":
                player.currentPos.setRow(player.currentPos.getColumn() + 1);
                break;
            default:
                return false;
        }

        playerPosition[currentPos.getRow()][currentPos.getColumn()].tileVal.setValueOnTile(player.playerPiece.getValueOnTile());
    }
}
