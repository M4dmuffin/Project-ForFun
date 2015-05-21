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
public class KeyboardListener implements KeyListener
{

    public Grid grid;
    public Speler piraat;

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keycode = e.getKeyCode();
        Object buur = grid.getObject(piraat.getVeldX(), piraat.getVeldY());

        if (keycode == KeyEvent.VK_UP)
        {
            if (!(grid.getObject(piraat.getVeldX(), piraat.getVeldY() - 1) instanceof Muur))
            {
                piraat.move(0, -1);
            }

        }
        if (keycode == KeyEvent.VK_DOWN)
        {
            if (!(grid.getObject(piraat.getVeldX(), piraat.getVeldY() + 1) instanceof Muur))
            {
                piraat.move(0, 1);
            }
        }
        if (keycode == KeyEvent.VK_LEFT)
        {
            if (!(grid.getObject(piraat.getVeldX() - 1, piraat.getVeldY()) instanceof Muur))
            {
                piraat.move(-1, 0);
            }
        }
        if (keycode == KeyEvent.VK_RIGHT)
        {
            if (!(grid.getObject(piraat.getVeldX() + 1, piraat.getVeldY()) instanceof Muur))
            {
                piraat.move(1, 0);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }
}
