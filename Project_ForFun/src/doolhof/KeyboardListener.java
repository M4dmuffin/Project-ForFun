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

        if (keycode == KeyEvent.VK_UP)
        {
            piraat.move(BeweegRichting.omhoog);
        }
        if (keycode == KeyEvent.VK_DOWN)
        {
            piraat.move(BeweegRichting.omlaag);
        }
        if (keycode == KeyEvent.VK_LEFT)
        {
            piraat.move(BeweegRichting.links);
        }
        if (keycode == KeyEvent.VK_RIGHT)
        {
            piraat.move(BeweegRichting.rechts);
        }
        if (keycode == KeyEvent.VK_SPACE)
        {
            piraat.schietBazooka();
        }
        
        //cheat - gemaakt voor presentatie
        if(keycode == KeyEvent.VK_B)
        {
           piraat.cheat(BeweegRichting.cheat);  
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
