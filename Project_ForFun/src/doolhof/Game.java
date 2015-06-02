/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



/**
 *
 * @author HP Pavillion
 */
public class Game{
    
    private JPanel hoofdmenu;
    private JButton reset;
    private JButton start;
    private JFrame frame;
    private Bord speelBord;

    // start het spel
    public void startGame()
    {
        createFrame();
        createPanels();
        createButtons();
        AddPanelsToFrame();
        frame.setVisible(true);
        speelBord.requestFocus();
    }
    
    // maak het frame
    private void createFrame()
    {
        frame = new JFrame();
        frame.setTitle("Doolhof Game");
        frame.setFocusable(true);
        frame.setSize(950,880);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    // maak de buttons
    private void createButtons()
    {
        hoofdmenu.requestFocus();
        ActionListener startAction = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                speelBord.getTimer().start();
                speelBord.requestFocus();
            }
        };
        
        ActionListener resetAction = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                speelBord.initBord();
                speelBord.requestFocus();
            }
        };
        reset = new JButton("Reset");
        start = new JButton("Start");
        reset.setPreferredSize(new Dimension(75,25));
        start.setPreferredSize(new Dimension(75,25));
        start.addActionListener(startAction);
        reset.addActionListener(resetAction);
        hoofdmenu.add(start);
        hoofdmenu.add(reset);
    }
    
    //maak de panels
    private void createPanels()
    {
        hoofdmenu = new JPanel();
        hoofdmenu.setPreferredSize(new Dimension (100,100));
        hoofdmenu.setBackground(Color.red);
        speelBord = new Bord();
        
    }
    
    // voeg panels toe aan frame
    private void AddPanelsToFrame()
    {
        frame.add(hoofdmenu, BorderLayout.WEST);
        frame.add(speelBord, BorderLayout.CENTER);
    }


    
    


    
}
