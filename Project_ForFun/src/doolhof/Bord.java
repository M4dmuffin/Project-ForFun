/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author HP Pavillion
 */
public class Bord extends JPanel implements ActionListener
{
    private int veldBreedte, veldHoogte;
    private Grid grid;
    private Speler piraat;
    private String winTekst = "";
    private boolean win = false;
    private Font font = new Font("Serif", Font.BOLD, 60);
    private KeyboardListener key;
    private Timer timer;


    public Bord()
    {
        grid = new Grid();
        key = new KeyboardListener();
        veldBreedte = 40;
        veldHoogte = 40;
        piraat = new Speler();
        addKeyListener(key);
        setFocusable(true);
        key.setGrid(grid);
        key.setPiraat(piraat);
        timer = new Timer(25, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (grid.getObject(piraat.getVeldX(), piraat.getVeldY()) instanceof Vriend)
        {
            winTekst = "Winner!";
            win = true;
        }
        repaint();
    }

    @Override
    public void paint(Graphics g)
    {

        super.paint(g);
        if (!win)
        {
            for (int y = 0; y < grid.getAANTAL_KOLOMMEN_LEVEL(); y++)
            {
                for (int x = 0; x < grid.getAANTAL_KOLOMMEN_LEVEL(); x++)
                {
                    if (grid.getVeldLijst()[y][x].getObject() instanceof Vriend)
                    {
//                      g.drawImage(level.getVriend(), x * veldX, y * veldY, null);
                        Vriend vriend = new Vriend();
                        g.drawImage(vriend.getVriend(), x * veldBreedte, y * veldHoogte, null);
                    }
                    if (grid.getVeldLijst()[y][x].getObject() instanceof Gang)
                    {
//                      g.drawImage(level.getGang(), x * veldX, y * veldY, null);
                        Gang gang = new Gang();
                        g.drawImage(gang.getGang(), x * veldBreedte, y * veldHoogte, null);
                    }
                    if (grid.getVeldLijst()[y][x].getObject() instanceof Muur)
                    {
//                      g.drawImage(level.getMuur(), x * veldX, y * veldY, null);
                        Muur muur = new Muur();
                        g.drawImage(muur.getMuur(), x * veldBreedte, y * veldHoogte, null);
                    }
                }
            }
            g.drawImage(piraat.getSpelerImage(), piraat.getVeldX() * 40, piraat.getVeldY() * 40, null);
        }
        if (win)
        {
            g.setColor(Color.YELLOW);
            g.setFont(font);
            g.drawString(winTekst, 250, 300);
        }


    }

    public int getVeldBreedte()
    {
        return veldBreedte;
    }

    public int getVeldHoogte()
    {
        return veldHoogte;
    }
    
    public Grid getGrid() {
        return grid;
    }
    
    public Timer getTimer() {
        return timer;
    }
}
