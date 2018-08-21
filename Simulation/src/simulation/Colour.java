/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulation;

/**
 *
 * @author Yara
 */

public class Colour {

    public int internalColour;
    private static final int blueInt = 0;
    private static final int redInt = 1;
    private static final int yellowInt = 2;
    public static final Colour BLUE = new Colour(blueInt);
    public static final Colour RED = new Colour(redInt);
    public static final Colour YELLOW = new Colour(yellowInt);

    private Colour(int value) {
        internalColour = value % 3;
    }

    public Colour ComplementaryColour(Colour C) {
        if (internalColour == C.internalColour) {
            return new Colour(internalColour);
        } else {
            return new Colour(3 - internalColour - C.internalColour);
        }
    }

    public String toString() {
        if (internalColour == blueInt) {
            return "blue";
        } else if (internalColour == redInt) {
            return "red";
        } else {
            return "yellow";
        }
    }

}
