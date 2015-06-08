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

    private Speler piraat;

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int keycode = e.getKeyCode();
        switch (keycode)
        {
            case KeyEvent.VK_UP: {piraat.move(BeweegRichting.omhoog);break;}
            case KeyEvent.VK_DOWN: {piraat.move(BeweegRichting.omlaag);break;}
            case KeyEvent.VK_LEFT: {piraat.move(BeweegRichting.links);break;}
            case KeyEvent.VK_RIGHT: {piraat.move(BeweegRichting.rechts);break;}
            case KeyEvent.VK_SPACE: {piraat.schietBazooka();break;}
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }

    public void setSpeler(Speler piraat)
    {
        this.piraat = piraat;
    }
}
