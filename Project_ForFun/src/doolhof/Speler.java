/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Lars
 */
public class Speler extends JComponent
{
    public Veld[][] grid;
    
    public Speler()
    {
        grid = new Veld[21][21];
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 40, 40);
    }
}
    

