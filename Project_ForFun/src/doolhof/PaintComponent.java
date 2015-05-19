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
public class PaintComponent extends JComponent
{
    String color;
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Level level = new Level();
        Object[][] level1 = level.getLevel1();
        
        for (int i = 0; i < level1[1].length; i++) 
        {
            for (int j = 0; j < level1[0].length; j++) 
            {
                if(level1[i][j] instanceof Muur)
                {
                    g.setColor(Color.RED);
                }
                else if (level1[i][j] instanceof Speler)
                {
                    g.setColor(Color.BLACK);
                }
                else if (level1[i][j] instanceof Gang)
                {
                    g.setColor(Color.WHITE);
                }
            }
        }
        g.fillRect(0, 0, 50, 50);
    }
}
