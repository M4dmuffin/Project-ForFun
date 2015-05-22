/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author HP Pavillion
 */
public class Doolhof {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new Doolhof();
    }
    
    public Doolhof()
    {
        JFrame f = new JFrame();
        f.setTitle("Doolhof Game");
        
        JPanel hoofdmenu = new JPanel();
        hoofdmenu.setPreferredSize(new Dimension (100,100));
        
        hoofdmenu.setBackground(Color.red);
        f.add(hoofdmenu, BorderLayout.WEST);
        JButton reset = new JButton("Reset");
        JButton start = new JButton("Start");
        hoofdmenu.add(start);
        hoofdmenu.add(reset);
        MuisListener muis = new MuisListener();
        Bord b = new Bord();
        
        reset.addMouseListener(muis);
        start.addMouseListener(muis);
        
        f.add(b, BorderLayout.CENTER);

        f.setSize(950,880);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        b.requestFocus();
    }
}
