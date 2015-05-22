/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author HP Pavillion
 */
public class Game {
    
    private JPanel hoofdmenu;
    private JButton reset;
    private JButton start;
    private JFrame f;
    private Bord b;

    public void startGame()
    {
        createFrame();
        createPanels();
        createButtons();
        AddPanelsToFrame();
        f.setVisible(true);
        b.requestFocus();
    }
    
    public void createFrame()
    {
        f = new JFrame();
        f.setTitle("Doolhof Game");
        f.setFocusable(true);
        f.setSize(950,880);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void createButtons()
    {
        reset = new JButton("Reset");
        start = new JButton("Start");
        hoofdmenu.add(start);
        hoofdmenu.add(reset);
    }
    
    public void createPanels()
    {
        hoofdmenu = new JPanel();
        hoofdmenu.setPreferredSize(new Dimension (100,100));
        hoofdmenu.setBackground(Color.red);
        b = new Bord();
    }
    
    public void AddPanelsToFrame()
    {
        f.add(hoofdmenu, BorderLayout.WEST);
        f.add(b, BorderLayout.CENTER);
    }
    
 


    
}
