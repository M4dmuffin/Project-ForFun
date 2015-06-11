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
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author HP Pavillion
 */
public class Bord extends JPanel implements ActionListener
{

    private int levelCount;
    private Level level;
    private Speler piraat;
    private boolean win, lose;
    private Font winFont, stappenFont, aftitelingFont;
    private KeyboardListener key;
    private Timer mainTimer, spinTimer;
    private ArrayList<Vijand> vijandLijst;
    
    public Bord()
    {
        key = new KeyboardListener();
        addKeyListener(key);
        piraat = new Speler();
        levelCount = 1;
        initBord();
        mainTimer = new Timer(25, this); 
        spinTimer = new Timer(250, this);
        stappenFont = new Font("Serif", Font.BOLD, 40);
        winFont = new Font("Serif", Font.BOLD, 60);
        aftitelingFont = new Font("Playbill", Font.BOLD, 30);
    }

    public void initBord()
    {
        if(level != null)
        {
            if(levelCount > level.getHoeveelheidLevels())
            {
                levelCount = 1;
            }
        }
        level = new Level(levelCount);
        vijandLijst = new ArrayList<>();
        vijandLijst.add(new Spin());
        piraat.reset();
        key.setSpeler(piraat);
        piraat.setLevel(level);
        for (int i = 0; i < vijandLijst.size(); i++)
        {
            vijandLijst.get(i).setSpeler(piraat);
        }
        
        win = false;
        lose = false;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (level.getVriend(piraat.getVeldX(), piraat.getVeldY()) != null)
        {
            levelCount++;
            if (levelCount > level.getHoeveelheidLevels())
            {
                win = true;
            } 
            else
            {
                initBord();
            }
        }
        if(e.getSource() == spinTimer)
        {
            for (int i = 0; i < vijandLijst.size(); i++)
            {
                vijandLijst.get(i).move();
                vijandLijst.get(i).repaint();
                if (vijandLijst.get(i).getVeldX() == piraat.getVeldX() && vijandLijst.get(i).getVeldY() == piraat.getVeldY())
                {
                    lose = true;
                }
            }
        }
        
        repaint();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if (!win && !lose)
        {
            for (int y = 0; y < level.AANTAL_KOL_RIJ(); y++)
            {
                for (int x = 0; x < level.AANTAL_KOL_RIJ(); x++)
                {
                    if (level.getVeldLijst()[y][x].getVriend() != null)
                    {
                        Vriend vriend = level.getVeldLijst()[y][x].getVriend();
                        vriend.paint(g, x, y);
                    }

                    if (level.getVeldLijst()[y][x].getGang() != null)
                    {
                        Gang gang = level.getVeldLijst()[y][x].getGang();
                        gang.Paint(g, x, y);

                        Item item = level.getVeldLijst()[y][x].getGang().getItem();

                        if (item != null)
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
            
            for (int i = 0; i < vijandLijst.size(); i++)
            {
                vijandLijst.get(i).paint(g);
            }
            
            piraat.paint(g);
            paintStappen(g);
        }

        if (win && !lose)
        {
            paintWin(g);
        }
        if (!win && lose)
        {
            paintLose(g);
        }
    }

    public Timer getMainTimer()
    {
        return mainTimer;
    }
    
    public Timer getSpinTimer()
    {
        return spinTimer;
    }

    public int getLevelCount()
    {
        return levelCount;
    }

    private void paintWin(Graphics g)
    {
        g.setColor(Color.RED);
        g.setFont(winFont);
        g.drawString("Congratulations!", 200, 200);
        g.drawString("You Win", 280, 260);
        g.setColor(Color.BLACK);
        g.setFont(aftitelingFont);
        g.drawString("Made by", 365, 700);
        g.drawString("Lars Kruuk", 350, 730);
        g.drawString("&", 390, 760);
        g.drawString("Kevin van Veen", 330, 790);
    }

    private void paintStappen(Graphics g)
    {
        String stappen = Integer.toString(piraat.getStappen());
        g.setFont(stappenFont);
        g.setColor(Color.WHITE);
        g.drawString("Stappen: " + stappen, 300, 30);
    }

    private void paintLose(Graphics g)
    {
        g.setColor(Color.RED);
        g.setFont(winFont);
        g.drawString("Game Over!", 200, 200);
        g.setColor(Color.BLACK);
        g.setFont(aftitelingFont);
        g.drawString("Made by", 365, 700);
        g.drawString("Lars Kruuk", 350, 730);
        g.drawString("&", 390, 760);
        g.drawString("Kevin van Veen", 330, 790);
    }
}
