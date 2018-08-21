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
public class Simulation {

    static Colour[] TheColours = {
        Colour.YELLOW,
        Colour.BLUE,
        Colour.RED,
        Colour.BLUE,
        Colour.YELLOW,
        Colour.BLUE
    };
    static Chameneos[] TheChameneos = new Chameneos[TheColours.length];

    public static void main(String args[]) {
        try {
            Mall myMall = new Mall();
            for (int i = 0; i < TheColours.length; i++) {
                TheChameneos[i] = new Chameneos(myMall, new IdChameneos(i), TheColours[i]);
            }
            for (int i = 0; i < TheColours.length; i++) {
                TheChameneos[i].start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
