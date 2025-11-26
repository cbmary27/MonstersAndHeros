/**
 * Filename: Piece.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-15
 * Description: A class represent the piece on the board or tile
 */

package world;

import java.util.*;

public class Piece<T> {
    private T valueOnTile;

    /**
     * Default constructor.
     * Initializes the piece with no value on the tile
     */
    public Piece() {
        this.valueOnTile = null;
    }

    /**
     * Parameterized constructor.
     * Initializes the piece with a specific value on the tile
     * @param value The value to assign to this piece.
     */
    public Piece(T value) {
        this.valueOnTile = value;
    }

    /**
     * Retrieves the current value stored on the tile.
     * @return The value on the tile, or if none is set.
     */
    public T getValueOnTile() {
        return valueOnTile;
    }

    /**
     * Sets or updates the value stored on the tile.
     * @param val The new value to assign to this piece.
     */
    public void setValueOnTile(T val) {
        this.valueOnTile = val;
    }
}