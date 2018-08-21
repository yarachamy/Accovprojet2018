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
public class Chameneos extends Thread {

    private Mall mall;
    private IdChameneos id;
    private Colour myColour, otherColour;

    public Chameneos(Mall m, IdChameneos id, Colour c) {
        this.mall = m;
        this.id = id;
        this.myColour = c;
    }

    private void Message(String Message) {
        System.out.println("(" + id.toString() + ") I am " + myColour.toString() + " and " + Message);
    }

    private void EatingHoneysuckleAndTraining() {
        Message("I am Eating Honey suckle and Training");
    }

    private void GoingToTheMall() {
        Message("I am going to the mall");
    }

    private void Mutating() {
        Message("I am going to mute");
        otherColour = mall.Cooperation(id, myColour);
        myColour = myColour.ComplementaryColour(otherColour);
        Message("I have done a mutation");
    }

    public void run() {
        while (true) {
            EatingHoneysuckleAndTraining();
            GoingToTheMall();
            Mutating();
        }

    }
}

