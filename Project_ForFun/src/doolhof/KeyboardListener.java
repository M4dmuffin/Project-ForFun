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
public class KeyboardListener implements KeyListener {
    
        public Level level;
        public Speler piraat;

        @Override
        public void keyTyped(KeyEvent e) 
        {
            
        }

        @Override
        public void keyPressed(KeyEvent e) 
        {
            int keycode = e.getKeyCode();

            if (keycode == KeyEvent.VK_UP) {
                if (!level.getLevel_1(piraat.getVeldX(), piraat.getVeldY() - 1).equals("m")) {
                    piraat.move(0, -1);
                }

            }
            if (keycode == KeyEvent.VK_DOWN) {
                if (!level.getLevel_1(piraat.getVeldX(), piraat.getVeldY() + 1).equals("m")) {
                    piraat.move(0, 1);
                }
            }
            if (keycode == KeyEvent.VK_LEFT) {
                if (!level.getLevel_1(piraat.getVeldX() - 1, piraat.getVeldY()).equals("m")) {
                    piraat.move(-1, 0);
                }
            }
            if (keycode == KeyEvent.VK_RIGHT) {
                if (!level.getLevel_1(piraat.getVeldX() + 1, piraat.getVeldY()).equals("m")) {
                    piraat.move(1, 0);
                }
            }

        }

        @Override
        public void keyReleased(KeyEvent e) 
        {
            
        }
        
        

    
}
