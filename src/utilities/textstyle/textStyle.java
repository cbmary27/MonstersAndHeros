/**
 * Filename: textStyle.java
 * Author: Chris Mary Benson
 * Date: 2025-Nov-19
 * Description: A class that contains ANSI codes for various text styles
 */

package utilities.textstyle;

import java.util.*;

public class textStyle
{
    public static final String RESET = "\u001B[0m";
    
    public static final String BOLD = "\u001B[1m";
    public static final String FAINT = "\u001B[2m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String REVERSE = "\u001B[7m";
    public static final String HIDDEN = "\u001B[8m";
    public static final String STRIKETHROUGH = "\u001B[9m";

    public static final String DOUBLE_UNDERLINE = "\u001B[21m";

    public static final String RESET_BOLD_FAINT = "\u001B[22m";
    public static final String RESET_ITALIC = "\u001B[23m";
    public static final String RESET_UNDERLINE = "\u001B[24m";
    public static final String RESET_REVERSE = "\u001B[27m";
    public static final String RESET_HIDDEN = "\u001B[28m";
    public static final String RESET_STRIKETHROUGH = "\u001B[29m";
}