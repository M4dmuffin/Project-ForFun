/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author HP Pavillion
 */
public class Game
{

    private JPanel hoofdmenu;
    private JButton start, reset, quit, help;
    private JFrame frame;
    private Bord speelBord;
    JLabel helpLabel;

    // start het spel
    public void startGame()
    {
        createFrame();
        createPanels();
        createButtons();
        createLabels();
        addPanelsToFrame();
        frame.setVisible(true);
        speelBord.requestFocus();
    }

    // maak het frame
    private void createFrame()
    {
        frame = new JFrame();
        frame.setTitle("A-Maze-ing Game");
        frame.setFocusable(true);
        frame.setSize(950, 880);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // maak de buttons
    private void createButtons()
    {
        ImageIcon startButton = new ImageIcon("src/Pics/start.png");
        ImageIcon resetButton = new ImageIcon("src/Pics/reset.png");
        ImageIcon helpButton = new ImageIcon("src/Pics/help.png");
        ImageIcon quitButton = new ImageIcon("src/Pics/quit.png");
        
        hoofdmenu.requestFocus();
        ActionListener startAction = new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                speelBord.getTimer().start();
                speelBord.requestFocus();
            }
        };

        ActionListener resetAction = new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                speelBord.initBord();
                speelBord.requestFocus();
            }
        };
        
         ActionListener helpAction = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {                    
                hoofdmenu.add(helpLabel);
                hoofdmenu.revalidate();
                hoofdmenu.repaint();  
            }
        };
        
        ActionListener quitAction = new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        };
        
        
        start = new JButton("Start", startButton);
        reset = new JButton("Reset", resetButton);
        help = new JButton("Help", helpButton);
        quit = new JButton("Quit", quitButton);
        
        start.setPreferredSize(new Dimension(75, 25));
        reset.setPreferredSize(new Dimension(75, 25));
        help.setPreferredSize(new Dimension(75, 25));
        quit.setPreferredSize(new Dimension(75, 25));
        
        start.addActionListener(startAction);
        reset.addActionListener(resetAction);
        help.addActionListener(helpAction);
        quit.addActionListener(quitAction);
        
        hoofdmenu.add(start);
        hoofdmenu.add(reset);
        hoofdmenu.add(help);
        hoofdmenu.add(quit);
    }

    //maak de panels
    private void createPanels()
    {
        hoofdmenu = new JPanel();
        hoofdmenu.setPreferredSize(new Dimension(100, 100));
        hoofdmenu.setBackground(new Color(123, 104, 238));
        speelBord = new Bord();
        
    }

    // voeg panels toe aan frame
    private void addPanelsToFrame()
    {
        frame.add(hoofdmenu, BorderLayout.WEST);
        frame.add(speelBord, BorderLayout.CENTER);
    }
    
    private void createLabels()
    {
        helpLabel = new JLabel();
        helpLabel.setText("<html>Omhoog = ↑<br>Omlaag = ↓<br>Links = ←<br>Rechts = →<br>Schieten = spatie</html>");
        helpLabel.setBounds(20, 20, 200, 50);
    }
}
