/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Lars
 */
public class Spel extends JFrame
{

    private JPanel spelPanel;
    private JPanel menuPanel;
    private static final int FRAME_WIDTH = 840;
    private static final int FRAME_HEIGHT = 840;
    private static final int SPELPANEL_WIDTH = 740;
    private static final int SPELPANEL_HEIGHT = 740;
    private static final int MENUPANEL_WIDTH = 100;
    private static final int MENUPANEL_HEIGHT = 100;
    
    public Spel()
    {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("A-Maze-ing Game");
        
        
    }
    
    public void createFrame()
    {
        spelPanel = new JPanel();
        spelPanel.setBackground(Color.yellow);
        spelPanel.setPreferredSize(new Dimension (SPELPANEL_WIDTH,SPELPANEL_HEIGHT));
        spelPanel.setLayout(new GridLayout(21, 21));
        
        menuPanel = new JPanel();
        menuPanel.setBackground(Color.blue);
        JButton resetButton = new JButton("Reset Level");
        resetButton.addMouseListener(new ClickListener());
        menuPanel.add(resetButton);
        menuPanel.setPreferredSize(new Dimension (MENUPANEL_WIDTH,MENUPANEL_HEIGHT));
        
        add(menuPanel, BorderLayout.NORTH);
        add(spelPanel, BorderLayout.CENTER);
    
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
