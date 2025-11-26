/**
 * Filename: Equippable.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-20
 * Description: An interface for items that are equippable
 */

package interfaces;

import java.util.*;

public interface Equippable
{
    public void equipItem();
    public void unequipItem();
    public boolean isItemEquipped();
}