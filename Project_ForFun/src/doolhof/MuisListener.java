/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

/**
 *
 * @author HP Pavillion
 */
public class MuisListener implements MouseListener {

    private Bord bord;
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        bord.getTimer().start();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
