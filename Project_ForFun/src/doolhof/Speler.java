/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doolhof;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author HP Pavillion
 */
public class Speler 
{
    private int veldX, veldY;
    private Image spelerImage;
    private Level level;

    public Speler() 
    {
        veldX = 1; //start x positie speler 
        veldY = 1; //start y positie speler 
        ImageIcon img = new ImageIcon("src/Pics/player.png");
        spelerImage = img.getImage();
    }
    
    public Speler(int x, int y) 
    {
        veldX = x; //start x positie speler 
        veldY = y; //start y positie speler 
        ImageIcon img = new ImageIcon("src/Pics/player.png");
        spelerImage = img.getImage();
    }
    
    public void reset()
    {
        veldX = 1; //start x positie speler 
        veldY = 1; //start y positie speler 
    }
    
    public void move(String richting)
    {
        if(richting.equals("omhoog"))
        {
            int omhoog = veldY - 1;
            if(level.getMuur(veldX, omhoog) == null)
            {
                veldY = omhoog;
            }
        }
        if(richting.equals("omlaag"))
        {
            int omlaag = veldY + 1;
            if(level.getMuur(veldX, omlaag) == null)
            {
                veldY = omlaag;
            }
        }
        if(richting.equals("links"))
        {
            int links = veldX - 1;
            if(level.getMuur(links, veldY) == null)
            {
                veldX = links;
            }
        }
        if(richting.equals("rechts"))
        {
            int rechts = veldX + 1;
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
    
    
}
