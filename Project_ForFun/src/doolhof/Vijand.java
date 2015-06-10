/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Lars
 */
public class Vijand extends JPanel
{
    protected int veldX, veldY;
    protected Speler speler;
    
    public void move()
    {
        
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
    }

    public void setSpeler(Speler speler)
    {
        this.speler = speler;
    }

    public int getVeldX()
    {
        return veldX;
    }

    public int getVeldY()
    {
        return veldY;
    }
}
