/**
 * Filename: World.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-15
 * Description: A class to represent the map in the game
 */

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

    /**
    * A method to initialize the map
    * @return void method
    */
    public void initializeMap()
    {
        List<String> l = new ArrayList<String>();
        initializePlayerPosition();

        int k = 0;
        int x = (rows*columns) - 1;

        int numMarkets = (int) ((0.3 * x)); //getting the number of markets, common and inaccessible spaces on a 8x8 map
        int numCommon = (int) (0.5 * x) + 2;
        int numInaccessible = (int) ((0.2 * x) + 2);

        for (int i = 0; i < numMarkets; i++)
        {
            l.add(Constants.MARKET); //adding all these spaces according to their size to a list
        }

        for (int i = 0; i < numCommon; i++)
        {
            l.add(Constants.COMMONTILE);
        }

        for (int i = 0; i < numInaccessible; i++)
        {
            l.add(Constants.NOENTRY);
        }

        Collections.shuffle(l); //shuffling the list

        for (int i = 0; i < rows; i++) //intiializing the map
        {
            for (int j = 0; j < columns; j++)
            {
                grid[i][j] = new Tile();
                grid[i][j].setRow(i);
                grid[i][j].setColumn(j);
            }
        }

        for (int i = rows - 2 ; i >= 0; i--) //setting the map to always have a path for the party of heroes indicated by *
        {
            int j = columns - 1;
            grid[i][j].tileVal = new Piece<>(Constants.BOARDSTAR);
            l.remove(Constants.BOARDSTAR);
        }

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if(i == rows - 1 && j == columns - 1)
                {
                    grid[i][j].tileVal = new Piece<>(Constants.START); //Start Position
                }
                else if (j == columns - 1)
                {
                    continue;
                }
                else
                {
                    if (l.get(k).equals(Constants.COMMONTILE))
                    {
                        grid[i][j].tileVal = new Piece<>(Constants.BOARDSTAR);
                    }
                    else
                    {
                        grid[i][j].tileVal = new Piece<>(l.get(k));
                    }
                    k++;
                }
            }
        }
    }

    /**
    * A method to intialize a matrix to represent the position of the player on the map
    * @return void method
    */
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

    /**
    * A method to display the map to the player
    * @return void method
    */
    public void printMap()
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                System.out.print(Constants.BOARDHEDGE);
            }

            System.out.println();

            for (int j = 0; j < columns; j++)
            {
                if (playerPosition[i][j].tileVal.getValueOnTile().equals("0"))
                {
                    switch(grid[i][j].tileVal.getValueOnTile())
                    {
                        case Constants.MARKET:
                            System.out.print(Constants.BOARDVEDGE + " " + colour.PURPLE_BOLD + grid[i][j].tileVal.getValueOnTile() + colour.RESET + "  ");
                            break;
                        case Constants.NOENTRY:
                            System.out.print(Constants.BOARDVEDGE + " " + colour.RED_BOLD + grid[i][j].tileVal.getValueOnTile() + colour.RESET + "  ");
                            break;
                        case Constants.START:
                            System.out.print(Constants.BOARDVEDGE + " " + colour.CYAN_BOLD + grid[i][j].tileVal.getValueOnTile() + colour.RESET + "  ");
                            break;
                        case Constants.BOARDSTAR:
                            System.out.print(Constants.BOARDVEDGE + " " + colour.GREEN + grid[i][j].tileVal.getValueOnTile() + colour.RESET + "  ");
                            break;
                    }
                }
                else
                {
                    System.out.print(Constants.BOARDVEDGE + " " + colour.YELLOW + playerPosition[i][j].tileVal.getValueOnTile() + colour.RESET + "  ");
                }
            }
            System.out.println(Constants.BOARDVEDGE + " " );
        }

        for (int j = 0; j < columns; j++)
        {
            System.out.print(Constants.BOARDHEDGE);
        }

        System.out.println();
    }

    /**
    * A method to check whether a move inputted by the player is a legal move or not
    * @param ch,pos the move entered and the position of the player on the map
    * @return boolean value to indicate whether the move is legal or not
    */
    public boolean isMoveLegal(String ch, Tile pos)
    {
        switch(ch)
        {
            case Constants.UP:
                if (pos.getRow() - 1 < 0 || checkIfTileInaccessible(pos.getRow() - 1, pos.getColumn()))
                    return false;
                break;
            case Constants.LEFT:
                if (pos.getColumn() - 1 < 0 || checkIfTileInaccessible(pos.getRow(), pos.getColumn() - 1))
                    return false;
                break;
            case Constants.DOWN:
                if (pos.getRow() + 1 >= rows || checkIfTileInaccessible(pos.getRow() + 1, pos.getColumn()))
                    return false;
                break;
            case Constants.RIGHT:
                if (pos.getColumn() + 1 >= columns || checkIfTileInaccessible(pos.getRow(), pos.getColumn() + 1))
                    return false;
                break;
            default:
                return false;
        }

        return true;
    }

    /**
    * A method to check whether a tile is inaccessible or not
    * @param i,j the indices of the tile on the map
    * @return boolean value to indicate whether the tile is inaccessible or not
    */
    public boolean checkIfTileInaccessible(int i, int j)
    {
        if (grid[i][j].tileVal.getValueOnTile().equals(Constants.NOENTRY))
        {
            error.inaccessibleSpace();
            return true;
        }
        return false;
    }

    /**
    * A method to move the player piece on the map according to the inputted move
    * @param player,choice the player making the move and their choice
    * @return void method
    */
    public void makeMove(Player player, String choice)
    {
        playerPosition[player.currentPos.getRow()][player.currentPos.getColumn()].tileVal.setValueOnTile("0");
        switch(choice)
        {
            case Constants.UP:
                player.currentPos.setRow(player.currentPos.getRow() - 1);
                break;
            case Constants.LEFT:
                player.currentPos.setColumn(player.currentPos.getColumn() - 1);
                break;
            case Constants.DOWN:
                player.currentPos.setRow(player.currentPos.getRow() + 1);
                break;
            case Constants.RIGHT:
                player.currentPos.setColumn(player.currentPos.getColumn() + 1);
                break;
        }

        //updating the position of the player in the playerPosition matrix
        playerPosition[player.currentPos.getRow()][player.currentPos.getColumn()].tileVal.setValueOnTile(player.playerPiece.getValueOnTile());
    }
}
