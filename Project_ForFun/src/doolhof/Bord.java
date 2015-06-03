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
public class Bord extends JPanel implements ActionListener {

    private int veldBreedte, veldHoogte;
    private Level level;
    private Speler piraat;
    private String winTekst = "";
    private boolean win = false;
    private Font winFont = new Font("Serif", Font.BOLD, 60);
    private Font stappenFont = new Font("Serif", Font.BOLD, 40);
    private KeyboardListener key;
    private Timer timer;
    private int levelCount;

    public Bord() {
        key = new KeyboardListener();
        addKeyListener(key);
        piraat = new Speler();
        levelCount = 1;
        initBord();
        veldBreedte = 40;
        veldHoogte = 40;
        timer = new Timer(25, this);
    }

    public void initBord() {
        level = new Level(levelCount);
        piraat.reset();
        key.setSpeler(piraat);
        piraat.setLevel(level);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (level.getVriend(piraat.getVeldX(), piraat.getVeldY()) != null) {
            levelCount++;
            if (levelCount > level.getHoeveelheidLevels()) {
                win = true;
                winTekst = "Winnaar";
            } else {
                initBord();
            }
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (!win) 
        {
            for (int y = 0; y < level.AANTAL_KOL_RIJ(); y++) 
            {
                for (int x = 0; x < level.AANTAL_KOL_RIJ(); x++) 
                {
                    if (level.getVeldLijst()[y][x].getVriend() != null) 
                    {
                        Vriend vriend = level.getVeldLijst()[y][x].getVriend();
                        vriend.Paint(g, x, y);
                    }

                    if (level.getVeldLijst()[y][x].getGang() != null) 
                    {
                        Gang gang = level.getVeldLijst()[y][x].getGang();
                        gang.Paint(g, x, y);

                        Item item = level.getVeldLijst()[y][x].getGang().getItem();
                        if (item instanceof Helper) 
                        {
                            item.paint(g, x, y);
                        }
                        if (item instanceof ValsSpeler) 
                        {
                            item.paint(g, x, y);
                        }
                        if (item instanceof Bazooka) 
                        {
                            item.paint(g, x, y);
                        }
                    }

                    if (level.getVeldLijst()[y][x].getMuur() != null) 
                    {
                        Muur muur = level.getVeldLijst()[y][x].getMuur();
                        muur.paint(g, x, y);
                    }
                }
            }

            if (piraat.getHelper() != null) 
            {
                if (piraat.getHelper().isGevonden = true) 
                {
                    piraat.getHelper().paintRoute(g);
                }
            }
            piraat.paint(g);
            String stappen = Integer.toString(piraat.getStappen());
            g.setFont(stappenFont);
            g.setColor(Color.white);
            g.drawString("Stappen: " + stappen, 300, 30);
        }

        if (win) 
        {
            g.setColor(Color.RED);
            g.setFont(winFont);
            g.drawString(winTekst, 250, 300);
        }
    }

    public Timer getTimer() 
    {
        return timer;
    }
}
