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
    private Level level1;
    private Speler piraat;
    private String winTekst = "";
    private boolean win = false;
    private Font font = new Font("Serif", Font.BOLD, 60);
    private KeyboardListener key;
    private Timer timer;

    public Bord()
    {
        initBord();
        veldBreedte = 40;
        veldHoogte = 40;
        timer = new Timer(25, this);   
    }
    
    public void initBord()
    {
        level1 = new Level();
        piraat = new Speler();
        key = new KeyboardListener();
        addKeyListener(key);
        key.setGrid(level1);
        key.setPiraat(piraat);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (level1.getVriend(piraat.getVeldX(), piraat.getVeldY()) != null)
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
            for (int y = 0; y < level1.getAANTAL_KOLOMMEN_LEVEL(); y++)
            {
                for (int x = 0; x < level1.getAANTAL_KOLOMMEN_LEVEL(); x++)
                {
                    if (level1.getVeldLijst()[y][x].getVriend() != null)
                    {
                        Vriend vriend = new Vriend();
                        g.drawImage(vriend.getVriend(), x * veldBreedte, y * veldHoogte, null);
                    }
                    if (level1.getVeldLijst()[y][x].getGang() != null)
                    {
                        Gang gang = new Gang();
                        g.drawImage(gang.getGang(), x * veldBreedte, y * veldHoogte, null);
                    }
                    if (level1.getVeldLijst()[y][x].getMuur() != null)
                    {
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
    
    public Level getGrid() {
        return level1;
    }
    
    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    
    
}
