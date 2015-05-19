/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lars
 */
public class Spel extends JFrame
{
    private JPanel spelPanel;
    private static final int FRAME_WIDTH = 840;
    private static final int FRAME_HEIGHT = 840;
    
    public Spel()
    {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("A frame with two components");
        setVisible(true);
    }
    
    public void createFrame()
    {
        spelPanel = new JPanel();
        spelPanel.setLayout(new GridLayout(21, 21));
        add(spelPanel);
    }
    
    public static void centreWindow(Window frame) 
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    public void createLevel()
    {
        Level level = new Level();
        Object[][] level1 = level.getLevel1();
        
        for (int i = 0; i < level1[1].length; i++) 
        {
            for (int j = 0; j < level1[0].length; j++) 
            {
                if(level1[i][j] instanceof Muur)
                {
                    Muur muur = new Muur();
                    spelPanel.add(muur);
                }
                else if (level1[i][j] instanceof Speler)
                {
                    Speler speler = new Speler();
                    spelPanel.add(speler);
                }
                else if (level1[i][j] instanceof Gang)
                {
                    Gang gang = new Gang();
                    spelPanel.add(gang);
                }
            }
        }
    }
}
