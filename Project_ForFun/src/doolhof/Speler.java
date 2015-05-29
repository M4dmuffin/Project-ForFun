/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author HP Pavillion
 */
public class Speler extends JPanel
{
    private int veldX, veldY;
    private Image spelerImage;
    private Level level;
    private int richting;
    

    public Speler() 
    {
        veldX = 1; //start x positie speler 
        veldY = 1; //start y positie speler 
        richting = 2;
        setImage();  
    }

    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(getSpelerImage(), veldX * 40, veldY * 40, null);
    }
       
    public void reset()
    {
        veldX = 1; 
        veldY = 1; 
    }
    
    public void move(BeweegRichting richting)
    {
        if(richting.equals(BeweegRichting.omhoog))
        {
            int omhoog = veldY - 1;
            this.richting = 0;
            setImage();
            if(level.getMuur(veldX, omhoog) == null)
            {
                veldY = omhoog;
            }
        }
        if(richting.equals(BeweegRichting.omlaag))
        {
            int omlaag = veldY + 1;
            this.richting = 2;
            setImage();
            if(level.getMuur(veldX, omlaag) == null)
            {
                veldY = omlaag;
            }
        }
        if(richting.equals(BeweegRichting.links))
        {
            int links = veldX - 1;
            this.richting = 3;
            setImage();
            if(level.getMuur(links, veldY) == null)
            {
                veldX = links;
            }
        }
        if(richting.equals(BeweegRichting.rechts))
        {
            int rechts = veldX + 1;
            this.richting = 1;
            setImage();
            if(level.getMuur(rechts, veldY) == null)
            {
                veldX = rechts;
            }
        }
    }
    
    public Image getSpelerImage() 
    {
        return spelerImage;
    }
    
    public int getVeldX() 
    {
        return veldX;
    }

    public int getVeldY() 
    {
        return veldY;
    }
    
    public void setLevel(Level level)
    {
        this.level = level;
    }
    
    public void setImage()
    {
        if(richting == 0)
        {
            ImageIcon img = new ImageIcon("src/Pics/playerHoog.png");
            spelerImage = img.getImage();
        }
        if(richting == 1)
        {
            ImageIcon img = new ImageIcon("src/Pics/playerRechts.png");
            spelerImage = img.getImage();
        }
        if(richting == 2)
        {
            ImageIcon img = new ImageIcon("src/Pics/player.png");
            spelerImage = img.getImage();
        }
        if(richting == 3)
        {
            ImageIcon img = new ImageIcon("src/Pics/playerLinks.png");
            spelerImage = img.getImage();
        }
    }
    
    
}
