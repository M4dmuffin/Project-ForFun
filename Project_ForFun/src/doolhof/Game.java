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

    public void startGame()
    {
        createFrame();
        createPanels();
        createButtons();
        AddPanelsToFrame();
        frame.setVisible(true);
        speelBord.requestFocus();
    }
    
    private void createFrame()
    {
        frame = new JFrame();
        frame.setTitle("Doolhof Game");
        frame.setFocusable(true);
        frame.setSize(950,880);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
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
        start.addActionListener(startAction);
        reset.addActionListener(resetAction);
        hoofdmenu.add(start);
        hoofdmenu.add(reset);
    }
    
    private void createPanels()
    {
        hoofdmenu = new JPanel();
        hoofdmenu.setPreferredSize(new Dimension (100,100));
        hoofdmenu.setBackground(Color.red);
        speelBord = new Bord();
        
    }
    
    private void AddPanelsToFrame()
    {
        frame.add(hoofdmenu, BorderLayout.WEST);
        frame.add(speelBord, BorderLayout.CENTER);
    }


    
    


    
}
