/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import javax.swing.JFrame;

/**
 *
 * @author Lars
 */
public class Doolhof {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Spel spel = new Spel();
        spel.createFrame();
        spel.createLevel();
        spel.centreWindow(spel);
        
        spel.requestFocus();
        EventListener e = new EventListener();
        spel.addKeyListener(e);
        
        
        
        
    }
}
