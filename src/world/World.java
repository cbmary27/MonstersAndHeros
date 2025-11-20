package world;

import java.util.*;
import utilities.error.Error;
import player.Player;
import utilities.colour.colour;
import utilities.constants.Constants;

public class World
{
    public Tile[][] grid;
    public Tile[][] playerPosition;
    private int rows;
    private int columns;
    public Error error = new Error();

    //public Tile currentPos;

    public World(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        playerPosition = new Tile[rows][columns];
        grid = new Tile[rows][columns];
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
        int numMarkets = (int) ((0.3 * x)) - 1;
        int numCommon = (int) (0.5 * x) + 2;
        int numInaccessible = (int) ((0.2 * x) + 1);

        for (int i = 0; i < numMarkets; i++)
        {
            l.add(Constants.M);
        }

        for (int i = 0; i < numCommon; i++)
        {
            l.add(Constants.C);
        }

        for (int i = 0; i < numInaccessible; i++)
        {
            l.add(Constants.X);
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
                    grid[i][j].tileVal = new Piece<>(Constants.S); //Start Position
                }
                else
                {
                    if (l.get(k).equals(Constants.C))
                    {
                        grid[i][j].tileVal = new Piece<>("*");
                    }

                    else{
                        grid[i][j].tileVal = new Piece<>(l.get(k));
                    }
                    k++;
                }
            }
        }
    }

    public void initializePlayerPosition()
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
                System.out.print("+----");
            }

            System.out.println();

            for (int j = 0; j < columns; j++)
            {
                if (playerPosition[i][j].tileVal.getValueOnTile().equals("0"))
                {
                    switch(grid[i][j].tileVal.getValueOnTile())
                    {
                        case Constants.M:
                            System.out.print("| " + colour.PURPLE_BOLD + grid[i][j].tileVal.getValueOnTile() + colour.RESET + "  ");
                            break;
                        case Constants.X:
                            System.out.print("| " + colour.RED_BOLD + grid[i][j].tileVal.getValueOnTile() + colour.RESET + "  ");
                            break;
                        case Constants.S:
                            System.out.print("| " + grid[i][j].tileVal.getValueOnTile() + "  ");
                            break;
                        case "*":
                            System.out.print("| " + colour.GREEN + grid[i][j].tileVal.getValueOnTile() + colour.RESET + "  ");
                            break;
                    }
                }
                else
                {
                    System.out.print("| " + colour.YELLOW + playerPosition[i][j].tileVal.getValueOnTile() + colour.RESET + "  ");
                }
            }
            System.out.println("|");
        }

        for (int j = 0; j < columns; j++)
        {
            System.out.print("+----");
        }

        System.out.println();
    }

    public boolean isMoveLegal(String ch, Tile pos)
    {
        switch(ch)
        {
            case Constants.W:
                if (pos.getRow() - 1 < 0 || checkIfTileInaccessible(pos.getRow() - 1, pos.getColumn()))
                    return false;
                break;
            case Constants.A:
                if (pos.getColumn() - 1 < 0 || checkIfTileInaccessible(pos.getRow(), pos.getColumn() - 1))
                    return false;
                break;
            case Constants.S:
                if (pos.getRow() + 1 >= rows || checkIfTileInaccessible(pos.getRow() + 1, pos.getColumn()))
                    return false;
                break;
            case Constants.D:
                if (pos.getColumn() + 1 >= columns || checkIfTileInaccessible(pos.getRow(), pos.getColumn() + 1))
                    return false;
                break;
            default:
                return false;
        }

        return true;
    }

    public boolean checkIfTileInaccessible(int i, int j)
    {
        if (grid[i][j].tileVal.getValueOnTile().equals("X"))
        {
            error.inaccessibleSpace();
            return true;
        }
        return false;
    }

    public void makeMove(Player player, String choice)
    {
        playerPosition[player.currentPos.getRow()][player.currentPos.getColumn()].tileVal.setValueOnTile("0");
        switch(choice)
        {
            case Constants.W:
                player.currentPos.setRow(player.currentPos.getRow() - 1);
                break;
            case Constants.A:
                player.currentPos.setColumn(player.currentPos.getColumn() - 1);
                break;
            case Constants.S:
                player.currentPos.setRow(player.currentPos.getRow() + 1);
                break;
            case Constants.D:
                player.currentPos.setColumn(player.currentPos.getColumn() + 1);
                break;
        }

        playerPosition[player.currentPos.getRow()][player.currentPos.getColumn()].tileVal.setValueOnTile(player.playerPiece.getValueOnTile());
    }
}
