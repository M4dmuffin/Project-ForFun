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
    public Veld[][] velden;
    private Grid grid;
    public int x;
    public int y;
    
    
    public Speler()
    {
        velden = new Veld[21][21];
        velden = grid.bouwGrid();
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 40, 40);
    }
    
    public void move(int direction)
    {
        
    }
}
    

