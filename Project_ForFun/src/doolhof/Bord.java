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
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author HP Pavillion
 */
public class Bord extends JPanel implements ActionListener
{
    private int veldBreedte, veldHoogte;
    private Level level;
    private Speler piraat;
    private String winTekst = "";
    private boolean win = false;
    private Font font = new Font("Serif", Font.BOLD, 60);
    private KeyboardListener key;
    private Timer timer;
    private int levelCount;

    public Bord()
    {
        key = new KeyboardListener();
        addKeyListener(key);
        piraat = new Speler();
        levelCount = 1;
        initBord();
        veldBreedte = 40;
        veldHoogte = 40;
        timer = new Timer(25, this);   
    }
    
    public void initBord()
    {
        level = new Level(levelCount);
        piraat.reset();
        key.setSpeler(piraat);
        piraat.setLevel(level);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (level.getVriend(piraat.getVeldX(), piraat.getVeldY()) != null)
        {
            levelCount++;
            if (levelCount > 3)
            {
                win = true;
                winTekst = "Winnaar";
            }
            else
            {
                initBord();
            }
        }
              
        repaint();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if (!win)
        {
            for (int y = 0; y < level.getAANTAL_KOLOMMEN_LEVEL(); y++)
            {
                for (int x = 0; x < level.getAANTAL_KOLOMMEN_LEVEL(); x++)
                {
                    if (level.getVeldLijst()[y][x].getVriend() != null)
                    {   
                        g.drawImage(level.getVeldLijst()[y][x].getVriend().getImageVriend(), x * veldBreedte, y * veldHoogte, null);
                    }
                    if (level.getVeldLijst()[y][x].getGang() != null)
                    {
                        Item item = level.getVeldLijst()[y][x].getGang().getItem();
                        g.drawImage(level.getVeldLijst()[y][x].getGang().getImageGang(), x * veldBreedte, y * veldHoogte, null);
                        if(item instanceof Helper)
                        {
                            g.drawImage(level.getVeldLijst()[y][x].getGang().getItem().getItemImage(), x * veldBreedte, y * veldHoogte, null);
                        }
                        if(item instanceof ValsSpeler)
                        {
                            g.drawImage(level.getVeldLijst()[y][x].getGang().getItem().getItemImage(), x * veldBreedte, y * veldHoogte, null);
                        }
                        if(item instanceof Bazooka)
                        {
                            g.drawImage(level.getVeldLijst()[y][x].getGang().getItem().getItemImage(), x * veldBreedte, y * veldHoogte, null);
                        }
                    }
                    if (level.getVeldLijst()[y][x].getMuur() != null)
                    {
                        g.drawImage(level.getVeldLijst()[y][x].getMuur().getImageMuur(), x * veldBreedte, y * veldHoogte, null);
                    }
                }
            }
            piraat.paint(g);
            //g.drawImage(piraat.getSpelerImage(), piraat.getVeldX() * 40, piraat.getVeldY() * 40, null);
        }
        if (win)
        {
            g.setColor(Color.RED);
            g.setFont(font);
            g.drawString(winTekst, 250, 300);
        }
    }
    
    public Timer getTimer() 
    {
        return timer;
    }

    
    
    
}
