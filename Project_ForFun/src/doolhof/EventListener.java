/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author HP Pavillion
 */
public class EventListener implements KeyListener
{
    
    
    @Override
    public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    switch( keyCode ) { 
        case KeyEvent.VK_UP:
            System.out.println("up");
            break;
        case KeyEvent.VK_DOWN:
            System.out.println("down");
            break;
        case KeyEvent.VK_LEFT:
            System.out.println("left");
            break;
        case KeyEvent.VK_RIGHT :
            System.out.println("right");
            break;
     }
}

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
}
